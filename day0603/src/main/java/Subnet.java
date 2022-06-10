public class Subnet extends VPC{
    Long id;
    String region;
    Long ip;
    Class RouteTable;

    public Subnet() {};

    public Subnet(Long id, String region, Long ip, Class RouteTable) {
        this.id = id;
        this.region = region;
        this.ip = ip;
        this.RouteTable = RouteTable;
    }

    public String transfer(String msg) {
        return msg;
    }
}
