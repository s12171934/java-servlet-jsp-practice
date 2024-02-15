import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        HashMap<Integer,Integer> rec = new HashMap<>();
        for(String record : records){
            String[] recordSplit = record.split(" ");
            int time = 1439 - (Integer.parseInt(recordSplit[0].split(":")[0]) * 60 + Integer.parseInt(recordSplit[0].split(":")[1]));
            int number = Integer.parseInt(recordSplit[1]);
            rec.putIfAbsent(number, 0);
            if(recordSplit[2].equals("OUT")) {
                time *= -1;
            }
            rec.put(number,rec.get(number) + time);
        }
        List<Integer> key = new ArrayList<>(List.copyOf(rec.keySet()));
        Collections.sort(key);
        int[] answer = new int[key.size()];
        for(int i = 0; i < key.size(); i++){
            answer[i] = fees[1] + Math.max(0,(int)(Math.ceil((rec.get(key.get(i)) - fees[0]) % (double)fees[2])) + ((rec.get(key.get(i)) - fees[0]) / fees[2]) * fees[3]);
        }
        return answer;
    }
}