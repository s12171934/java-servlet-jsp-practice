public class Main {

    public static void main(String[] args) {
        //System.out.println(solution("111111111111100","211111110304111111115"));

    }
    public static String solution(String X, String Y) {
        String answer = "";
        int[] x = new int[10];
        int[] y = new int[10];
        int[] xy = new int[10];

        for(int i = 0; i < X.split("").length; i++){
            x[Integer.parseInt(X.split("")[i])] += 1;
        }

        for(int i = 0; i < Y.split("").length; i++){
            y[Integer.parseInt(Y.split("")[i])] += 1;
        }

        for(int i = 0; i < 10; i++){
            if(x[i] >= y[i]){
                xy[i] = y[i];
            } else{
                xy[i] = x[i];
            }
        }

        for(int i = 9; i >= 0; i--){
            if(xy[i] == 0){

                continue;
            }
            for(int j = 1; j <= xy[i]; j++){
                answer += i;
            }

        }
        if (answer.equals("")){
            answer = "-1";
        } else if(Integer.parseInt(answer) == 0){
            answer = "0";
        }
        return answer;
    }
}
