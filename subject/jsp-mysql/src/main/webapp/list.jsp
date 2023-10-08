<%@ page import="java.util.List" %>
<%@ page import="exam.NewsVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>뉴스 게시판</title>
</head>
<body>
    <div align="center">
        <h2>뉴스 게시판</h2>
        <hr>
        <table border="1">
            <tr>
                <td>제목</td>
                <td>기자</td>
                <td>등록일</td>
                <td>조회수</td>
            </tr>
            <%
                request.setCharacterEncoding("utf-8");
                @SuppressWarnings("unchecked")
                List<NewsVO> newsList = (List<NewsVO>) request.getAttribute("newsList");
                for (NewsVO news:newsList) {
            %>
           <tr>
               <td><a href="/exam/read.do?id=<%=news.getId()%>"><%=news.getTitle()%></a></td>
               <td><%=news.getWriter()%> </a></td>
               <td><%=news.getRegdate()%></td>
               <td><%=news.getReadcnt()%></td>
           </tr>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>
