<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.Product" %>
<%@ page contentType = "text/html; character=utf-8" language = "java" %>

<html>
<body>
<h2>Array products:</h2>
<ul>
<% if(((ArrayList<Product>)request.getAttribute("products")).size() > 0) %>
<% for(Product value: (ArrayList<Product>) ((ArrayList<Product>)request.getAttribute("products"))) { %>
<li> id:<%=value.getId()%>; product title:<%=value.getTitle()%>; product cost:<%=value.getCost()%></li>
<% }%>
</ul>

</body>
</html>
