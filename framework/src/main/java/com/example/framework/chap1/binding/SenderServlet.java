package com.example.framework.chap1.binding;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "senderServlet", urlPatterns = "/sender")
public class SenderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.setAttribute("address","경북 경산시");
        request.setAttribute("zip",38541);
        RequestDispatcher dispatch = request.getRequestDispatcher("receiver");
        dispatch.forward(request,response);
    }
}
