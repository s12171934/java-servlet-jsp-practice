package com.example.calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

@WebServlet(value = "/calc")
public class Calc2Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String result;

        try{
            ArrayList<String> midArr = makeInorder(req.getParameter("exp"));
            ArrayList<String> backArr = parsePostorder(midArr);
            result = calculatePostorder(backArr);
        } catch (Exception e){
            result = "올바른 표현식이 아닙니다.";
        }

        ServletContext sc = req.getServletContext();
        sc.setAttribute("result",result);
        resp.sendRedirect("/calc2.jsp");
    }

    private boolean isNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public ArrayList<String> makeInorder(String exp){
        exp = exp.replace(" ", "");
        ArrayList<String> midArr = new ArrayList<>();
        String addList = "";

        boolean minus = true;
        for(String s : exp.split("")){
            if(isNumber(s)){
                addList += s;
                minus = false;
            } else {
                if(!addList.isEmpty()){
                    midArr.add(addList);
                    addList = "";
                } else if(minus && s.equals("-")){ // 음수 처리
                    addList += s;
                }
                if(s.equals("(")) minus = true; // 음수 처리
                midArr.add(s);
            }
        }
        if(!addList.isEmpty())midArr.add(addList);

        return midArr;
    }

    public ArrayList<String> parsePostorder(ArrayList<String> midArr) throws Exception{
        ArrayList<String> backArr = new ArrayList<>();
        Stack<String> temp = new Stack<>();

        for(String s : midArr){
            //1. 숫자 확인
            if(isNumber(s)){
                backArr.add(s);
                continue;
            }
            //2. 스택 초기값 확인
            if(temp.isEmpty()){
                temp.push(s);
                continue;
            }
            //3. 스택 최상단 값이 *, / 일때 출력 후 스택삽입
            if(!s.equals("(") && (temp.peek().equals("*") || temp.peek().equals("/"))){
                backArr.add(temp.pop());
            }
            //4. 스택에 + / - 삽입 할때, ( 이전 모두 출력
            if(!(temp.isEmpty() || temp.peek().equals("(")) && (s.equals("+") || s.equals("-") || s.equals(")"))){
                backArr.add(temp.pop());
            }
            //5. "(" 없애기
            if(s.equals(")")){
                temp.pop();
            } else{
                temp.push(s);
            }
        }
        //6. 스택에 남아 있는지 연산자 확인
        if(!temp.isEmpty()) backArr.add(temp.pop());

        return backArr;
    }

    public String calculatePostorder(ArrayList<String> backArr) throws Exception{
        String result;
        Stack<String> temp = new Stack<>();

        for(String s : backArr){
            //1. 숫자 확인
            if(isNumber(s)){
                temp.push(s);
                continue;
            }

            //2. 나누어 떨어지지 않는 경우를 위해 실수로 계산
            double num2 = Double.parseDouble(temp.pop());
            double num1 = Double.parseDouble(temp.pop());
            switch (s){
                case "+":temp.push(String.valueOf(num1 + num2));break;
                case "-":temp.push(String.valueOf(num1 - num2));break;
                case "*":temp.push(String.valueOf(num1 * num2));break;
                case "/":temp.push(String.valueOf(num1 / num2));break;
            }
        }
        //3. 실수 중 정수는 소숫점 제외하고 출력
        double resultD = Double.parseDouble(temp.pop());
        if(resultD % 1 == 0){
            result = String.valueOf((int)resultD);
        } else{
            result = String.valueOf(resultD);
        }

        return result;
    }
}
