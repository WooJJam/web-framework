package com.example.framework.chap1.subject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "arithmeticCalc", urlPatterns = "/chap1/op")
public class ArithmeticCalc extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double first = Double.parseDouble(request.getParameter("first"));
        double second = Double.parseDouble(request.getParameter("second"));
        String op = request.getParameter("op");
        double result;

        result = getResult(op, first, second);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>계산 결과: "+first+op+second+" = " + result+"</h1>");
        out.println("<h1><a href = /chap1/op.html>다시 계산</a></h1>");

    }

    private static double getResult(String op, double first, double second) {
        double result;
        if (op.equals("+")) result = first + second;
        else if(op.equals("-")) result = first - second;
        else if(op.equals("*")) result = first * second;
        else result = first / second;
        return result;
    }
}
