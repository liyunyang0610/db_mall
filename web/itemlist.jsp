<%@ page import="com.zr.mall.mall.entity.Items" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.03.14.0014
  Time: 下午 02:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table border="1px" >
        <tr>

            <td>name</td>
            <td>city</td>
            <td>price</td>
            <td>picture</td>
            <td>操作</td>
        </tr>

        <c:forEach var="items" items="${itemsList}">
            <tr>
                <td>${items.name}</td>
                <td>${items.city}</td>
                <td>${items.price}</td>
                <td><img src="image/${items.picture}" width="100px" height="100px" alt="${items.name}"></td>
                <td><a href="ItemServlet?method=detail&id=${items.id}">查看</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
