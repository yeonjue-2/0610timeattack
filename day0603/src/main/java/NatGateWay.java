public class NatGateWay extends GateWay{
    Long id;
    Class subnet;


    public NatGateWay() {};

    public NatGateWay(Long id, Class subnet) {
        this.id = id;
        this.subnet = subnet;
    }
}
