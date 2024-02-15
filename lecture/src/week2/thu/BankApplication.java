package week2.thu;

import java.util.*;

public class BankApplication {
    public static void main(String[] args) {

        HashMap<String,Account> accountHashMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        Set<String> keyset = accountHashMap.keySet();

        while(true){
            System.out.println("--------------------------------------------------");
            System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
            System.out.println("--------------------------------------------------");
            System.out.print("선택 > ");
            int num = Integer.parseInt(sc.nextLine());
            if(num == 1){
                Account account = new Account();
                accountHashMap.put(account.createAccount().getAccountNum(),account);
            } else if(num == 2){
                System.out.println("-------");
                System.out.println("계좌목록");
                System.out.println("-------");
                for(String key : keyset) {
                    accountHashMap.get(key).showAccount();
                }
            } else if(num == 3){
                System.out.println("---");
                System.out.println("예금");
                System.out.println("---");
                System.out.print("계좌번호 : ");
                String findAccount = sc.nextLine();
                accountHashMap.get(findAccount).inputMoney();

            } else if(num == 4){
                System.out.println("---");
                System.out.println("출금");
                System.out.println("---");
                System.out.print("계좌번호 : ");
                String findAccount = sc.nextLine();
                accountHashMap.get(findAccount).outputMoney();

            } else if(num == 5){
                break;
            } else {
                System.out.println("잘못된 번호입니다. 다시 입력하십시오.");
            }
        }
    }

}
