package week2.thu;

import java.util.*;

public class Account {

    Scanner sc = new Scanner(System.in);
    private String accountNum;
    private String accountName;
    private int money;

    public String getAccountNum() {
        return accountNum;
    }

    public Account createAccount(){

        System.out.println("-------");
        System.out.println("계좌생성");
        System.out.println("-------");
        System.out.print("계좌번호 : ");
        this.accountNum = sc.nextLine();
        System.out.print("계좌주 : ");
        this.accountName = sc.nextLine();
        System.out.print("초기입금액 : ");
        this.money = Integer.parseInt(sc.nextLine());
        System.out.println("결과 : 계좌가 생성되었습니다.");
        return this;
    }

    public void showAccount(){
        System.out.println(this.accountNum + "\t\t" + this.accountName + "\t\t" + this.money);
    }

    public void inputMoney(){
        System.out.print("예금액 : ");
        this.money += Integer.parseInt(sc.nextLine());
        System.out.println("결과 : 예금이 성공되었습니다.");
    }

    public void outputMoney() {
        System.out.print("출금액 : ");
        this.money -= Integer.parseInt(sc.nextLine());
        System.out.println("결과 : 출금이 성공되었습니다.");
    }
}
