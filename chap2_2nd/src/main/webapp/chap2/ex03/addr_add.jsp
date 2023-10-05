<%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/10/05
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="contact" class="com.example.chap2_2nd.ex3.Contact" scope="request"/>
<jsp:setProperty name="contact" property="*"/>
<jsp:useBean id="dao" class="com.example.chap2_2nd.ex3.ContactDAO" scope="application"/>
<%dao.add(contact);%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div align="center">
    <h1>등록 내용</h1>
      <p>
          이름: <%=contact.getName()%> <br>
          전화번호: <%=contact.getPhone()%> <br>
          이메일: <%=contact.getEmail()%> <br>
          성별: <%=contact.getGender()%> <br>
      <hr>
      <a href="addr_list.jsp">목록보기</a>

  </div>
</body>
</html>
