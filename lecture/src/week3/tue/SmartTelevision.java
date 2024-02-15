package week3.tue;

import week3.mon.SmartPhone;

public class SmartTelevision extends Television implements Searchable{
    private int volume;
    @Override
    public void turnOn() {
        super.turnOn();
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }

    @Override
    public void setVolume(int volume) {
        if(volume > MAX_VOLUME){
            this.volume = MAX_VOLUME;
        } else if(volume < MIN_VOLUME){
            this.volume = MIN_VOLUME;

        } else {
            this.volume = volume;
        }
        System.out.println("TV의 볼륨은 : " + this.volume + " 입니다.");
    }

    @Override
    public void search(String url) {
        System.out.println(url + "을 검색합니다.");
    }
}
