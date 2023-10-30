package week3.mon;

public class SmartPhone extends CellPhone{
    String network;

    public SmartPhone(String network,String model,String color){
        this.network = network;
        this.model = model;
        this.color = color;
    }
    void showNetwork(){
        System.out.println("네트워크 종류 : " + network);
    }


}
