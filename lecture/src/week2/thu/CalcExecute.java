package week2.thu;

public class CalcExecute {
    public static void main(String[] args) {
        int result;
        Calc calc = Calc.getInstance();
        calc.plus(3, 5);
        result = calc.getResult();
        System.out.println(result);

        System.out.println(Calc.PI);
    }
}
