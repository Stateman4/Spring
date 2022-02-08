<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Product</title>
</head>
<body>
<h2> Product title: ${product.title} </h2>
<h2> Product cost: ${product.cost} </h2>
<h2> Date manufacture: ${product.date} </h2>
<h2> ID manufacturer: ${product.manufacturer_id} </h2>
<br>
<a href="/product/all">BACK</a>
<br>
<c:url var="deleteUrl" value="/product/delete">
   <c:param name="id" value="${product.id}"/>
</c:url>
<a href="${deleteUrl}">DELETE</a>
</body>
</html>