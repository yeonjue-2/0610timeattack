from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.test


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/detail/<idx>')
def detail(idx):
    article_list = list(db.articles.find_one({'idx': int(idx)}, {'_id': False}))
    return render_template("detail.html", article_list=article_list)

@app.route('/articleList', methods=['GET'])
def get_article_list():

    article_list = list(db.articles.find({}, {'_id': False}).sort([("read_count", -1)]))

    # for article in article_list:
    # 	article['read_count'] = article['read_count'].strftime('%Y.%m.%d %H:%M:%S')

    return jsonify({"article_list": article_list})

# Create
@app.route('/article', methods=['POST'])
def create_article():
    title_receive = request.form['title_give']
    content_receive = request.form['content_give']
    pw_receive = request.form['pw_give']
    read_count_receive = request.form['read_count_give']

    doc = {
        'title': title_receive,
        'content': content_receive,
        'pw': pw_receive,
        'read_count': read_count_receive,
        'reg_date': datetime.now()
    }

    db.articles.insert_one(doc)

    return jsonify({'result': 'success', 'msg': '포스팅 저장'})


# Read
@app.route('/article', methods=['GET'])
def read_article():
    article = list(db.articles.find_one({'idx': int(idx)}, {'_id': False}))
    return jsonify({"article": article})

# Update
@app.route('/article', methods=['PUT'])
def update_article():
    #
    return {"result": "success"}

# Delete
@app.route('/article', methods=['DELETE'])
def delete_article():
    idx = request.args.get('idx')
    db.articles.delete_one({'idx': int(idx)})
    return {"result": "success"}




if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5005, debug=True)