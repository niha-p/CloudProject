<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
window.location.hash = '#container';</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Columbia Buy n Sell</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="container text-center" id="container">
		<c:set var="search_text" value="${requestScope.search}"></c:set>
		<script type="text/javascript">
		document.getElementsByName("sb").value="$(search_text)";
		</script>
		<c:set var="pid" value="${requestScope.pid}"></c:set>
		<c:set var="names" value="${requestScope.names}"></c:set>
		<c:set var="descriptions" value="${requestScope.descriptions}"></c:set>
		<c:set var="image1" value="${requestScope.image1}"></c:set>
		<c:set var="prices" value="${requestScope.prices}"></c:set>
		<div class="w3-responsive">
		<table class="w3-table w3-bordered w3-striped">
		<tr>
		<td style="font-family:Open sans, Helvetica, Arial; font-size: 15px;">
		Showing ${requestScope.number} results for "${search_text}"
		<select>
		<option>PRICE</option>
		<option>LOCATION</option>
		<option>HGKGKJ</option>
		</select>
		</td>
		</tr>
		<c:forEach items="${names}" varStatus="i">
		<c:set var="urltext" value="/CloudProject/ProductServlet?pid=${pid[i.index]}"></c:set>
		<tr> 
		<td style="float:left; width:25%; font-family:Open sans, Helvetica, Arial; font-size: 15px;">
			<a href="${urltext}">
			<img src="<c:out value="${image1[i.index]}"></c:out>" alt="" style="width:100%">
			</a>
			<br>
			
		</td>
		<td style="float:right; width:75%; font-family:Open sans, Helvetica, Arial; font-size: 15px;">
			<br>
			<a href="${urltext}" style="color:black; text-decoration:none;">
			<c:out value="${names[i.index]}"></c:out><br>
			</a>
			<c:out value="${descriptions[i.index]}"></c:out><br>
			Price:<c:out value="${prices[i.index]}"></c:out><br>
		</td>
		
		</tr>
		</c:forEach>
	
		</table>
		</div>
		
	</div>
	
	<jsp:include page="footer.jsp" />

</body>
</html>