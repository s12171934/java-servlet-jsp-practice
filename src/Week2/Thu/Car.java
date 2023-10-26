package Week2.Thu;

public class Car {
    String model;
    static int year = 2023;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    static public void setYear(int newYear){
        year = newYear;
    }
}
