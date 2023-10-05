<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.chap2_2nd.ex3.Contact" %><%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/10/05
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dao" class="com.example.chap2_2nd.ex3.ContactDAO" scope="application"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div align="center">
    <h1>주소록</h1>
    <hr>
    <a href="addr_form.html">주소추가</a>
    <p>
    <table border="1">
    <tr>
      <th>이름</th>
      <th>전화번호</th>
      <th>이메일</th>
      <th>성별</th>

      <%
        ArrayList<Contact> clist = dao.getList();
        for(Contact item : clist) {
      %>

      <tr>
        <td><%=item.getName()%></td>
        <td><%=item.getPhone()%></td>
        <td><%=item.getEmail()%></td>
        <td><%=item.getGender()%></td>
     </tr>
    <%
      }
    %>
    </tr>
  </table>
  </div>
</body>
</html>
