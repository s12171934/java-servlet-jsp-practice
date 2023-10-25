package Week2.Self;

import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) {

        int[] goals = makeGoals();
        int[] myNum = makeMyNum();
        checkScore(goals,myNum);

    }

    static int[] makeGoals(){
        int[] goals = {50,51,52,53,54,55,56};
        for(int i = 0; i < goals.length; i++){
            do{
                goals[i] = (int)(Math.random() * 45 + 1);
            } while(checkSameNum(goals));
        }

        return goals;
    }

    static boolean checkSameNum(int[] arr){
        for(int i = 0; i < arr.length -1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    static int[] makeMyNum(){
        Scanner sc = new Scanner(System.in);
        String myNumInput;
        int[] myNum = new int[6];
        while(true) {
            System.out.println("#######################################################################");
            System.out.println("1 ~ 45 의 숫자 중 6개를 중복없이 입력하시오. 각 숫자의 구분은 \" \"으로 하십시오.");
            System.out.print("#######################################################################\n>> ");
            myNumInput = sc.nextLine();
            if(myNumInput.split(" ").length == 6) {
                for (int i = 0; i < 6; i++) {
                    myNum[i] = Integer.parseInt(myNumInput.split(" ")[i]);
                }
            } else{
                System.out.println("입력한 숫자가 6개가 아닙니다. 다시 입력하십시오.");
                continue;
            }
            if(checkSameNum(myNum)){
                System.out.println("중복된 숫자가 존재합니다. 다시 입력하십시오.");
            } else{
                break;
            }
        }
        return myNum;
    }

    static void checkScore(int[] goals,int[] myNum){
        int count = 0;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(myNum[i] == goals[j]){
                    count += 1;
                }
            }
        }

        if(count == 6){
            System.out.println("1등!");
        } else if(count == 5){
            for(int i : myNum){
                if(i == goals[6]){
                    System.out.println("2등!");
                    return;
                }
            }
            System.out.println("3등!");
        } else if(count == 4){
            System.out.println("4등!");
        } else if(count == 5){
            System.out.println("5등!");
        } else {
            System.out.println("꽝!");
        }
    }
}
