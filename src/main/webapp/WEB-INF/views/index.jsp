<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Database</title>
</head>
<body>
	
<form action="add" method="post">
<table>

<tr>
<td><label>Customer Number</label></td>
<td><input type="text" name="custno"/></td>
</tr>
<tr>
<td><label>Customer Name</label></td>
<td><input type="text" name="custname"/></td>
</tr>
<tr>
<td><input type="submit" value="Add Customer" ></td>
</tr>

</table>
</form>

	
<table border="1">
<tr>
<td>Customer Number</td>
<td>Customer Name</td>
<td>Customer Created Time</td>
</tr>
<c:forEach items="${custList}" var="customer"> 
<tr>
<td><input type="text" name="custno" value="${customer.custno}"/></td>
<td>${customer.custname}</td>
<td>${customer.createdAt}</td>
<td><form action="updateCustomer" method="post">
						<input type="hidden" id="custno" name="custno"
							value="${customer.custno}" />
						<button type="submit">Update</button>
					</form></td>
				<td><form action="delete" method="post">
						<input type="hidden" id="custno" name="custno"
							value="${customer.custno}" />
						<button type="submit">Delete</button>
					</form></td>
			</tr>
			<br />
</c:forEach>
</table>
</body>
</html>