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
        String exp = req.getParameter("exp");
        exp = exp.replace(" ", "");
        ArrayList<String> midArr = new ArrayList<>();
        ArrayList<String> backArr = new ArrayList<>();

        Stack<String> temp = new Stack<>();
        String addList = "";
        String result;
        ServletContext sc = req.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/calc2.jsp");

        //String 숫자와 기호 분리
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
                    continue;
                }
                if(s.equals("("))minus = true; // 음수 처리
                midArr.add(s);
            }
        }
        if(!addList.isEmpty())midArr.add(addList);

        //중위 표기법 -> 후위 표기법
        try{
            for(String s : midArr){
                //1.숫자 확인
                if(isNumber(s)){
                    backArr.add(s);
                    continue;
                }
                //2.스택 초기값 확인
                if(temp.isEmpty()){
                    temp.push(s);
                    continue;
                }
                //3.닫는 괄호 확인 시 여는 괄호 까지 출력
                if(s.equals(")")){
                    while(!temp.peek().equals("(")){
                        backArr.add(temp.pop());
                    }
                    temp.pop();
                    continue;
                }
                //4.스택 최상단 값이 *, / 일때 출력 후 스택삽입
                if(!s.equals("(") && (temp.peek().equals("*") || temp.peek().equals("/"))){
                    backArr.add(temp.pop());
                }
                temp.push(s);
            }
            while(!temp.isEmpty()){
                backArr.add(temp.pop());
            }

            // 후위 표기법 계산
            for(String s : backArr){
                if(isNumber(s)){
                    temp.push(s);
                    continue;
                }

                //나누기를 위해 실수형으로 계산
                double num2 = Double.parseDouble(temp.pop());
                double num1 = Double.parseDouble(temp.pop());
                switch (s){
                    case "+":temp.push(String.valueOf(num1 + num2));break;
                    case "-":temp.push(String.valueOf(num1 - num2));break;
                    case "*":temp.push(String.valueOf(num1 * num2));break;
                    case "/":temp.push(String.valueOf(num1 / num2));break;
                }
            }
            //실수 중 정수는 소숫점 제외하고 출력
            double resultD = Double.parseDouble(temp.pop());
            if(resultD % 1 == 0){
                result = String.valueOf((int)resultD);
            } else{
                result = String.valueOf(resultD);
            }
        } catch (Exception e){
            result = "올바른 표현식이 아닙니다.";
        }

        req.setAttribute("result",result);
        rd.forward(req,resp);
    }

    private boolean isNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
