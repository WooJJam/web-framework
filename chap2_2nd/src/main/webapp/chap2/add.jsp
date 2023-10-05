<%@ page import="java.util.Collection" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: woojjam
  Date: 2023/10/05
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    @SuppressWarnings("unchecked")
    ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
    if(list==null) {
        list = new ArrayList<>();
        session.setAttribute("list",list);
    }

    String product = request.getParameter("product");
    list.add(product);
%>

<script>
    alert("추가된 상품: <%=product%>")
    history.go(-1)
</script>

