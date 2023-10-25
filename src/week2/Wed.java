package week2;

import java.util.Scanner;

public class Wed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("##################################");
            System.out.println("1. 더하기 \n2. 빼기 \n3. 곱하기 \n4. 나누기 \n5. 나머지 \nq. 종료");
            System.out.print("##################################\n>> ");
            String op = sc.nextLine();
            int a = 0;
            int b = 0;

            if(!op.equals("q")) {
                System.out.print("피연산자1 > ");
                a = Integer.parseInt(sc.nextLine());
                System.out.print("피연산자2 > ");
                b = Integer.parseInt(sc.nextLine());
            }


            switch(op){
                case "1" :
                    plus(a,b);
                    break;
                case "2" :
                    minus(a,b);
                    break;
                case "3" :
                    multiply(a,b);
                    break;
                case "4" :
                    divide(a,b);
                    break;
                case "5" :
                    modulo(a,b);
                    break;
                case "q" :
                    return; //main 메서드 종료

            }

        }




    }

    private static void plus(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    private static void minus(int a, int b) {
        System.out.println(a + " - " + b + " = " + (a - b));
    }

    private static void multiply(int a, int b) {
        System.out.println(a + " * " + b + " = " + (a * b));
    }

    private static void divide(int a, int b) {
        System.out.println(a + " / " + b + " = " + (a / b));
    }

    private static void modulo(int a, int b) {
        System.out.println(a + " % " + b + " = " + (a % b));
    }
}
