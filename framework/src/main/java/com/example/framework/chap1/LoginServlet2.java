package com.example.framework.chap1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="loginServlet2", urlPatterns = "/login2")
public class LoginServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>아이디: ").append(request.getParameter("user_id"));
        sb.append("<br>비밀번호: ").append(request.getParameter("user_pw"));
        sb.append("</body></html>");
        out.println(sb.toString());
    }
}
