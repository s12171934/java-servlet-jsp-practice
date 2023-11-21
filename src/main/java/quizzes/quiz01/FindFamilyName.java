package quizzes.quiz01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

@WebServlet(value = "/quizzes/quiz01/find-family-name")
public class FindFamilyName extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset = UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        // names 에 각각의 성만 저장
        String str = req.getParameter("names").replace(" ","");
        String[] names = str.split(",");
        for(int i = 0; i < names.length; i++){
            names[i] = names[i].split("")[0];
        }

        // 성을 key값으로 value에 나온 횟수 저장
        HashMap<String,Integer> familyName = new HashMap<>();
        for(String name : names){
            familyName.put(name, familyName.getOrDefault(name,0)+1);
        }

        // 나온 성의 최대 횟수 찾기
        int max = 0;
        for(int n : familyName.values()){
            if(max < n)max = n;
        }
        int finalMax = max;
        // 최대 횟수 성을 Array 저장 후 정렬, 0번 인덱스가 출력값
        String result = String.valueOf(Arrays.stream(familyName.keySet().toArray(new String[0])).filter(s -> familyName.get(s) == finalMax).sorted().toArray()[0]);
        out.println(result + "씨가 가장 많습니다.");
    }
}
