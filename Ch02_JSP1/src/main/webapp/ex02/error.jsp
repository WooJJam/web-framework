<%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/09/26
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <div align="center">
        <h2>처리중 문제가 발생!</h2>
        <hr>
        <table>
            <tr bgcolor="pink"><td> 관리자에게 문의해 주세요..<br> 빠른시일내 복구하겟씁니다..
                <hr>
                <%= exception %>
                <hr></td></tr>
        </table>
    </div>
</body>
</html>
