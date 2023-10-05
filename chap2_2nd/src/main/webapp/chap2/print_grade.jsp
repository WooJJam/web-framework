<%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/10/05
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("utf-8");
  int total = Integer.parseInt(request.getParameter("middle")) + Integer.parseInt(request.getParameter("final")) + Integer.parseInt(request.getParameter("report"))+Integer.parseInt(request.getParameter("attendance"));

  String next_page = (total >= 60) ? "success.jsp":"fail.jsp";
%>

<jsp:forward page="<%=next_page%>">
  <jsp:param name="total" value="30"/>
</jsp:forward>
