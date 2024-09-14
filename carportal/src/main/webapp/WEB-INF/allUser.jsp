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
<%@include file="headerAdmin.jsp" %>

<section class=" bg-land " id="section-home">
  <div class="row">
     <div class="col-md-11 m-5 pt-5">
    <div class="row">
       <div class="col-md-3">
       	<div class="bg-light p-3 rounded">
            <h2 class="titular">Search here...</h2>
            <sc:form class="text-center" action="/searchUser" modelAttribute="searchUser" method="get" >
            	<label data-icon="M" > Full name</label><br>
            	<sc:input required="required" path="fullName" type="text" placeholder="Sudhanshu" /><br>
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
<vc:forEach items="${listUsers}" var="c">
       <div class="col-6">

		 <div class="card radius-10 border-start  border-info">
			<div class="card-body">
				<div class="d-flex align-items-center">
					<div>
						<p class="mb-0 text-secondary">${c.getFullName()} </p>
						<h4 class="my-1 text-info">${c.getUsername()}</h4>
						<p class="mb-0 font-13"> </p>
					</div>
					<div class="widgets-icons-2 person-add text-white ms-auto">
					  <a href="/updateProfile?userId=${c.getUserId()}">
						<i class="fa fa-user"></i>
					  </a>
					</div>
					<div class="widgets-icons-2  person-add text-white">
					  <a href="/?userId=${c.getUserId()}">
						<i class="fa fa-trash"></i>
					  </a>
					</div>
				</div>
			</div>
		 </div>

	   </div>
</vc:forEach>
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