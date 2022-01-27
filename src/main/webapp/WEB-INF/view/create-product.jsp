<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Create product</title>
</head>
<body>
<form:form action="create" modelAttribute="product">
 <form:hidden path="id" value="${product.id}"/>
    Title: <form:textarea path="title"/>
    <br>
    cost: <form:input type="number" path="cost"/>
   <br>
   <input type="submit" value="Save"/>
</form:form>

</body>
</html>