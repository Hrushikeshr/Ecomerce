<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>EShopper</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">

<%@include file="./base.jsp"%>
</head>

<body>

	<%@include file="./navbar.jsp"%>



	<!-- Page Header Start -->
	<div class="container-fluid bg-secondary mb-5">
		<div
			class="d-flex flex-column align-items-center justify-content-center"
			style="min-height: 300px">
			<h1 class="font-weight-semi-bold text-uppercase mb-3">Order Confirm</h1>
			<div class="d-inline-flex">
				<p class="m-0">
					<a href="">Home</a>
				</p>
				<p class="m-0 px-2">-</p>
				<p class="m-0">Ordered</p>
			</div>
		</div>
	</div>
	<!-- Page Header End -->
	
	  <!-- Cart Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                        	<th>Order Id</th>
                            <th>Products</th>
                            <th>Price</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    <c:forEach items="${getProduct}" var="product" varStatus="status">
                        <tr>
                        	<td class="align-middle">${product.id }</td>
                            <td class="align-middle"><img src="<c:url value="${product.url }"/>" alt="image no found" style="width: 50px;"> ${product.name}</td>
                            <td class="align-middle">${product.price }</td>
                            <td class="align-middle">Confirm</td>
                            
                        </tr> 
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- Cart End -->



	<%@include file="./footer.jsp"%>
</body>

</html>