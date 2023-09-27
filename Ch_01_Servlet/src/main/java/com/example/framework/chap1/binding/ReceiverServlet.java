package com.example.framework.chap1.binding;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "receiverServlet", urlPatterns = "/receiver")
public class ReceiverServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("주소 : " + request.getAttribute("address"));
        System.out.println("우편번호 : " + request.getAttribute("zip"));
    }
}
