<%@page import="com.ShopNest.product.Cart"%>
<%@page import="com.ShopNest.product.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>ShopIT Cart</title>
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		
		<%	Cart c=(Cart)session.getAttribute("cart"); 
			List itemsList=c.getItems();
		%>
			
		
		
		<header>
			<h1>ShopIT Cart</h1>
			<nav>
			  <ul>
			    <li>
			    	 <a href="home.jsp" cursor="pointer"><button><b>Back</b></button></a>
			    </li>
			  </ul>
			</nav>

		</header>
		
	
		
		<main>
			<%
				for(int i=0; i<itemsList.size(); i++) {
					String p=((Product)(itemsList.get(i))).getPname();
			%>
			<section class="product">
				<h2><%= p %></h2>
				<p><%= ((Product)(itemsList.get(i))).getPprice() %></p>
				<span class="price"></span>
			</section>
			<%
				  }                              
			%>
			
			
		</main>
		
		<br>
		<table>
				<tfoot>
		            <tr>
		                <td colspan="3">Total:</td>
		           
		                <td><h1><%= c.getTotal() %></h1></td>
		            </tr>
		        </tfoot>
 
		</table>
		
	</body>
</html>
