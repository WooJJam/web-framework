<%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/09/26
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include_action</title>
</head>
<body>
<h2>include_action.jsp에서 footer.jsp 호출</h2>
<hr>
include_action.jsp에서 호출한 메시지 입니다. <br>
<jsp:include page="footer.jsp">
  <jsp:param name ="email" value="jaemin5548@naver.com"/>
  <jsp:param name="tel" value="01028187305"/>
</jsp:include>

</body>
</html>
