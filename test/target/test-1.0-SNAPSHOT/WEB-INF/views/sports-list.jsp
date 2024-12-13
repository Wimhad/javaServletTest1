<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Sports Inventory</title>
    <link rel="stylesheet" href="../../static/styleInventory.css">
</head>
<body>
<h1>Sports Inventory</h1>
<ul>
    <c:forEach var="item" items="${inventory}">
        <li><a href="sports/details?id=${item.id}">${item.name}</a></li>
    </c:forEach>
</ul>
</body>
</html>
