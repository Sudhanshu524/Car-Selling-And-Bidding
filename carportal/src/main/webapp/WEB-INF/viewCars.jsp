<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="vc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sc" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">

<title>Car Portal</title>
<meta name="description" content="Free Bootstrap 4 Template by uicookies.com">
<meta name="keywords" content="Free website templates, Free bootstrap themes, Free template, Free bootstrap, Free website template">

<link href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i,600|Montserrat:200,300,400" rel="stylesheet">
<link rel="stylesheet" href="assets/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="assets/fonts/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="assets/fonts/law-icons/font/flaticon.css">
<link rel="stylesheet" href="assets/fonts/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/slick.css">
<link rel="stylesheet" href="assets/css/slick-theme.css">
<link rel="stylesheet" href="assets/css/helpers.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/landing-2.css">
<link rel="stylesheet" href="css2/listCar.css">
</head>
<body>
<jsp:include page="${Header}"/>

<section class=" bg-land " id="section-home">
  <div class="row">
     <div class="col-md-11 m-5 pt-5">
    <div class="row">
       <div class="col-md-3">
       	<div class="bg-light p-3 rounded">
            <h2 class="titular">Search here...</h2>
            <sc:form class="text-center" action="/searchCars" modelAttribute="searchCars" method="post" >
            	<label data-icon="M" > Make/Model/Registration Year</label><br>
            	<sc:input required="required" path="carMake" type="text" placeholder="Mercedez" /><br>
            	<br>
            	<div class="text-center">
            		<input class="btn btn-secondary text-center" type="submit" value="Search..."/>
            	</div>
            </sc:form>
       	</div>
       </div>
      <div class="col-md-9">
<div class="container">
<div class="row">
<vc:if test="${empty listCars}">
<div class="col-12 text-center align-items-center justify-content-center">
<h1 class="text-white">No Data Found</h1>
<h2 class="text-white">Search another Keyword!!!</h2>
</div>
</vc:if>
<vc:if test="${not empty listCars}">
<vc:forEach items="${listCars}" var="c">
       <div class="col-4">
		<a href="/carDetails?carId=${c.getCarId()}">
		 <div class="card radius-10 border-start border-0 border-3 border-info">
			<div class="card-body">
				<div class="d-flex align-items-center">
					<div>
						<p class="mb-0 text-secondary">${c.getRegistrationYear()} ${c.getCarMake()}</p>
						<h4 class="my-1 text-info">${c.getCarModel()}</h4>
						<p class="mb-0 font-13">$ ${c.getPrice()}</p>
					</div>
					<div class="widgets-icons-2  person-add  text-white ms-auto"><i class="fa fa-shopping-cart"></i>
					</div>
				</div>
			</div>
		 </div>
		</a>
	   </div>
</vc:forEach>
</vc:if>
	</div>
</div>
	  </div>
	 </div>
    </div>
   </div>

</section>
<!-- END section -->


<%@include file="footer.jsp" %>


</body>
</html>