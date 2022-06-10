public class RouteTable {
    Long id;
    Class gateway;

    public RouteTable() {};

    public RouteTable(Long id, Class gateway) {
        this.id = id;
        this.gateway = gateway;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGateWay(Class gateway) {
        this.gateway = gateway;
    }


    public void addSubnet(Class subnet) {

    }
}
