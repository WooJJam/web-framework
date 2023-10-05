<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/10/05
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="center">
        <h2>계산</h2>
        <p>
            <%= session.getAttribute("id")%>님이 선택한 상품 목록
        <hr>
        <%
            @SuppressWarnings("unchecked")
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");

            for (String item: list) {
                out.println(item+"<br>");
            }
        %>
    </div>
</body>
</html>
