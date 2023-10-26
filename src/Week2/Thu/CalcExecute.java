package Week2.Thu;

public class CalcExecute {
    public static void main(String[] args) {
        int result;
        Calc calc = new Calc();
        calc.plus(3, 5);
        result = calc.getResult();
        System.out.println(result);

        System.out.println(Calc.getPI());
    }
}
