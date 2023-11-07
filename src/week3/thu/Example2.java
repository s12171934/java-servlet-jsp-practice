package week3.thu;

import java.util.ArrayList;

public class Example2 {
    public static void main(String[] args) {
        ArrayList<String> members1 = new ArrayList<>();
        members1.add("손");
        members1.add("이");
        members1.add("황");

        ArrayList<String> members2 = new ArrayList<>();

        for(String member : members1){
            members2.add(member);
        }

        ArrayList<String> members3 = (ArrayList<String>) members1.clone();

        ArrayList<String> members4 = new ArrayList<>();

        members4.addAll(members1);

        for(int i = 0; i < members1.size(); i++){
            System.out.println(members1.get(i)+members2.get(i)+members3.get(i)+members4.get(i));
        }



    }
}

