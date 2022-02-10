<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Product-list</title>
</head>
<body>
<h1> Product list </h1>
<br>
<a href="/product/all/desc">Sort by decreasing cost</a>
<br>
<a href="/product/all/asc">Sort by ascending cost</a>
<br>
<a href="/product/all">No sorting</a>
<br>
<ul>
<c:forEach var="product" items="${products}">
  <c:url var="viewUrl" value="/product/${product.id}"/>
  <li>
     <a href="${viewUrl}">View</a>
     <br>
     Product title: ${product.title}
     <br>
     Product cost: ${product.cost}
     <br>
     Manufacture date: ${product.date}
     <br>
     Manufacturer id: ${product.manufacturer_id}
     <br>
     <br>
  </li>
  </c:forEach>
  </ul>
  <c:url var="createUrl" value="/product/create"/>
  <a href="${createUrl}">CREATE</a>

</body>
</html>