<%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/10/05
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>60점 미만입니다.</h1>
<p>
  학번: <%=request.getParameter("id")%>
  이름: <%=request.getParameter("name")%>
  중간시험: <%=request.getParameter("middle")%>
  기말시험: <%=request.getParameter("final")%>
  리포트: <%=request.getParameter("report")%>
  출석: <%=request.getParameter("attendance")%>
</p>
</body>
</html>
