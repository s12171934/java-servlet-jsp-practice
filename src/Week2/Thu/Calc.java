package Week2.Thu;

public class Calc {
    static final double PI = 3.14159;
    private int result;

    private static Calc instance = new Calc();

    private Calc(){
    }

    public static Calc getInstance(){
        return instance;
    }

    public int getResult() {
        return result;
    }

    public void plus(int a, int b){
        this.result = a + b;
    }

    public void minus(int a, int b){
        this.result = a - b;
    }

    public void multiply(int a, int b){
        this.result = a * b;
    }

    public void divide(int a, int b){
        this.result = a / b;
    }

    public void modular(int a, int b){
        this.result = a % b;
    }
}
