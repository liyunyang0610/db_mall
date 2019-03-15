<%@ page import="com.zr.mall.mall.entity.Items" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.03.14.0014
  Time: 下午 05:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <tr>

        <td>name</td>
        <td>city</td>
        <td>price</td>
        <td>number</td>
        <td>picture</td>
        <td>操作</td>
    </tr>

    <tr>
        <td>${items.name}</td>
        <td>${items.city}</td>
        <td>${items.price}</td>
        <td>${items.number}</td>
        <td><img src="image/${items.picture}" width="100px" height="100px" alt="${items.name}"></td>
        <td><a href="ItemServlet?method=car&id=${items.id}">加入购物车</a></td>
    </tr>

</body>
</html>
