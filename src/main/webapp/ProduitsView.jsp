<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>

<div class="container">
<div class="card">
<div class="card-header">
Recherche des Produits
</div>
<div class="card-body">
<form action="chercher.do" method="post" >
<input type="text" name="motCle" value="${modele.motCle}">
<button type="submit" class="btn btn-primary">Chercher</button>
</form>
<table class="table table-striped">
<tr>
<th>ID</th> <th>Nom</th> <th>Prix</th>
</tr>
<c:forEach items="${modele.produits}" var="p">
<tr>
<td>${p.id}</td>
<td>${p.libelle}</td>
<td>${p.prix}</td>
</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</body>
</html>