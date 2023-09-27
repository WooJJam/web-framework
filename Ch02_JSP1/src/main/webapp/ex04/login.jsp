<%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/09/27
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="lginfo" class="com.example.ch02_jsp1.LoginBean"/>
<jsp:setProperty name="lginfo" property="*"/>
<html>
<head>
    <title></title>
</head>
<body>
  <div align="center">
  <h2>로그인 예제</h2>
  <hr>
  <%
    if(lginfo.checkUser()==true)
      out.println("로그인 성공!!");
    else
      out.println("로그인 실패");
  %>
  <hr>
<%--  사용자 아이디: <jsp:getProperty property="login" name="lginfo"/> <br>--%>
    사용자 아이디: ${lginfo.login} <br>
  사용자 패스워드: ${lginfo.passwd}
  </div>
</body>
</html>