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


@app.route('/post', methods=['POST'])
def save_post():
    title_receive = request.form['title_give']
    content_receive = request.form['content_give']
    pw_receive = request.form["pw_give"]

    today = datetime.now()
    date = today.strftime('%Y-%m-%d')

    doc = {
        'title': title_receive,
        'content': content_receive,
        'pw': pw_receive,
        'date': date
    }

    db.posts.insert_one(doc)


return jsonify{"result": "success"}


@app.route('/post', methods=['GET'])
def get_post():
    posts = list(db.posts.find({}, {'_id': False}))

    return jsonify({'result': 'success', 'posts': posts})


@app.route('/post', methods=['DELETE'])
def delete_post():
    idx = request.args.get('idx')
    db.test.delete_one({'idx': int(idx)})
    return {"result": "success"}


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5003)