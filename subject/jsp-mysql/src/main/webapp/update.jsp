<%@ page import="exam.NewsBodyVO" %><%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/10/08
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="newsBody" class="exam.NewsBodyVO" scope="request"/>
<jsp:setProperty name="newsBody" property="*"/>
<html>
<head>
    <title>기사 수정</title>


    <style>
        input, textarea
        {
            margin: 10px;
        }
    </style>

</head>
<body>
<div >
  <h1>기사 수정</h1>
    <hr>
  <form action="/exam/update.do" method="POST">
    <%
      request.setCharacterEncoding("utf-8");
      NewsBodyVO news = (NewsBodyVO) request.getAttribute("news");
    %>
      <div style="margin:10px">
            기자: <input type="text" name="writer" value="<%=news.getWriter()%>"> <br>
            제목: <input type="text" name="title" value="<%=news.getTitle()%>"> <br>
            내용: <textarea name="body" rows="5" cols="40" ><%=news.getBody()%></textarea> <br>
          <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
      </div>
      <input type="submit" value="수정">
      <input type="reset" value="취소">
  </form>
</div>
</body>
</html>
