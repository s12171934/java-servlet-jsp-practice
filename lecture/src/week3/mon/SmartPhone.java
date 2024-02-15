package week3.mon;

public class SmartPhone extends CellPhone{
    String network;

    public SmartPhone(String network,String model,String color){
        super(model, color);
        this.network = network;
        //  super(); Error : Call to 'super()' must be first statement in constructor body
    }
    void showNetwork(){
        System.out.println("네트워크 종류 : " + network);
    }

    void powerOn() { System.out.println("스마트폰 전원을 켭니다."); }

}
