<%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/09/27
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  지금 보이는 화면은 Page_control_end.jsp에서 출력한 내용
  <hr>
이름: <%= request.getParameter("username")%><br>
전화번호: <%= request.getParameter("tel")%>>
</body>
</html>
