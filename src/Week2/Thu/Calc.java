package Week2.Thu;

public class Calc {
    private static final double PI = 3.14159;
    private int result;

    public static double getPI(){
        return PI;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
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
