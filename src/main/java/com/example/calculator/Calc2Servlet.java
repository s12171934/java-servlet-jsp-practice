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
        String result = "";
        ServletContext sc = req.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/calc2.jsp");

        //String 숫자와 기호 분리
        for(String s : exp.split("")){
            if(isNumber(s)){
                addList += s;
            } else {
                if(!addList.isEmpty()){
                    midArr.add(addList);
                    addList = "";
                }
                midArr.add(s);
            }
        }
        if(!addList.isEmpty())midArr.add(addList);

        //중위 표기법 -> 후위 표기법
        try{
            for(String s : midArr){
                if(isNumber(s)){
                    backArr.add(s);
                } else{
                    if(temp.isEmpty()){
                        temp.push(s);
                    } else{
                        if(s.equals("(")){
                            temp.push(s);
                        } else if(s.equals(")")){
                            while(!temp.peek().equals("(")){
                                backArr.add(temp.peek());
                                temp.pop();
                            }
                            temp.pop();
                        } else{
                            if(temp.peek().equals("*") || temp.peek().equals("/")){
                                backArr.add(temp.peek());
                                temp.pop();
                            }
                            temp.push(s);
                        }
                    }
                }
            }
            while(!temp.isEmpty()){
                backArr.add(temp.peek());
                temp.pop();
            }

            // 후위 표기법 계산
            for(String s : backArr){
                if(isNumber(s)){
                    temp.push(s);
                } else {
                    //나누기를 위해 실수형으로 계산
                    double num2 = Double.parseDouble(temp.peek());
                    temp.pop();
                    double num1 = Double.parseDouble(temp.peek());
                    temp.pop();

                    switch (s){
                        case "+":temp.push(String.valueOf(num1 + num2));break;
                        case "-":temp.push(String.valueOf(num1 - num2));break;
                        case "*":temp.push(String.valueOf(num1 * num2));break;
                        case "/":temp.push(String.valueOf(num1 / num2));break;
                    }
                }
            }
            //실수 중 정수는 소숫점 제외하고 출력
            double resultD = Double.parseDouble(temp.peek());
            if(resultD % 1 == 0){
                result = String.valueOf((int)resultD);
            } else{
                result = String.valueOf(resultD);
            }
        } catch (Exception e){
            result = "올바른 표현식이 아닙니다.";
            req.setAttribute("result",result);
            rd.forward(req,resp);
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
