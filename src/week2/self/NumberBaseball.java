package week2.self;

import java.util.Scanner;

public class NumberBaseball {

    public static void main(String[] args) {
        int[] ans;
        int[] goals = randomNum();
        int[] result;
        int count = 0;
        System.out.println("랜덤숫자 생성완료, 게임을 시작합니다.");
        while(true){
            count += 1;
            ans = answerNum();
            result = playBall(ans,goals);
            if(result[0] == 4){
                System.out.println("정답! : " + ans[0] + ans[1] + ans[2] + ans[3]);
                break;
            }
            System.out.println("결과는 S:" + result[0] + " B:" + result[1] + "입니다.");
        }




    }

    static int[] randomNum(){
        int[] num;
        int num1 = (int)(Math.random() * 10 + 1);
        int num2;
        int num3;
        int num4;

        while(true){
            num2 = (int)(Math.random() * 10 + 1);
            if(num2 != num1){
                break;
            }
        }
        while(true){
            num3 = (int)(Math.random() * 10 + 1);
            if(num3 != num1 && num3 != num2){
                break;
            }
        }

        while(true){
            num4 = (int)(Math.random() * 10 + 1);
            if(num4 != num1 && num4 != num2 && num4 != num3){
                break;
            }
        }

        num = new int[]{num1,num2,num3,num4};
        return num;
    }

    static int[] answerNum(){
        Scanner sc = new Scanner(System.in);
        int[] num = new int[]{0,0,0,0};
        System.out.print("숫자를 입력해주십시오. : ");
        String numStr = sc.nextLine();
        for(int i = 0; i <= 3; i++){
            num[i] = Integer.parseInt(numStr.split("")[i]);
        }
        return num;

    }

    static int[] playBall(int[] ans,int[] goals){
        int[] strikeBall = new int[]{0,0};
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                if(ans[i] == goals[j]){
                    if(i == j){
                        strikeBall[0] += 1;
                    } else{
                        strikeBall[1] += 1;
                    }
                }
            }
        }
        return strikeBall;
    }
}
