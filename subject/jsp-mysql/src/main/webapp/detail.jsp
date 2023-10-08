<%@ page import="exam.NewsBodyVO" %><%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/10/08
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>뉴스 기사</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    NewsBodyVO news = (NewsBodyVO) request.getAttribute("news");
%>
    <div>
        <h1><%=news.getTitle()%></h1><hr>
    </div>
    <div>
        기자: <%=news.getWriter()%> <br><br>
        기사 내용: <br>
        <%=news.getBody()%>
    </div>
<a href="/exam/update.do?id=<%=request.getParameter("id")%>">[기사 수정]</a>
<a href="/exam/list.do">[목록 보기]</a>
</body>
</html>
