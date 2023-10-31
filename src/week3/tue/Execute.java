package week3.tue;

import week3.mon.SmartPhone;

public class Execute {
    public static void main(String[] args) {
        RemoteControl rc = new SmartTelevision();
        Searchable s = new SmartTelevision();

        s.search("www.naver.com");
        rc.turnOn();
        rc.turnOff();
        rc.setVolume(50);
        ((SmartTelevision)rc).search("www.naver.com");
    }
}
