package week3.mon;

public class SmartPhoneExecute {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone("Wi-Fi","Iphone 15","Blue");
        SmartPhone apple = smartPhone;
        apple.showNetwork();

//        ClassCastException 발생
//        CellPhone cellPhone = new CellPhone("Iphone 15","Blue");
//        SmartPhone apple2 = (SmartPhone) cellPhone;
//        apple2.showNetwork();

    }
}
