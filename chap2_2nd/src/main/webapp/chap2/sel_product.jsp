<%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/10/05
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>

<%
    request.setCharacterEncoding("utf-8");
    String usernmae = request.getParameter("id");
    session.setAttribute("id",usernmae);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h2>상품선택</h2>
    <hr>
    <h2> <%= session.getAttribute("id")%>님 환영합니다!</h2>
    <hr>
    <form action="add.jsp" method="POST">
        <select name="product">
            <option value="사과" selected>사과
            <option value="옥수수"> 옥수수
            <option value="바나나">바나나
            <option value="수박">수박
        </select>
        <input type="submit" value="추가">
    </form>
    <div><a href="checkout.jsp">계산</a></div>
  <hr>
</div>
</body>
</html>
