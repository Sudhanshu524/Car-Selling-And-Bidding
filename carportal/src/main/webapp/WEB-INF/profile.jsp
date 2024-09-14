<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
	<head>
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
	</head>
	<body data-spy="scroll" data-target="#pb-navbar" data-offset="200">
<jsp:include page="${Header}"/>

<section class="bg-land" id="section-home">
  <div class="container">
    <div class="row align-items-center justify-content-center">
      <div class="col-md-5 relative align-self-center">

          <h2 class="mb-4 mt-0 text-center">User Profile</h2>
          <div class="form-group">
            <input readonly name="username" value="${uname}" required="required" type="text" class="form-control pb_height-50 reverse" />
          </div>
          <div class="form-group">
            <input readonly name="fullName" value="${fullName}" required="required" type="text" class="form-control pb_height-50 reverse" pattern="[A-Z a-z]+"/>
          </div>
          <div class="form-group">
            <input readonly name="password" value="${pass}" required="required" type="hidden" class="form-control pb_height-50 reverse" />
          </div>
          <div class="form-group">
          	<input name="userId" type="hidden"/>
            <a href="/updateProfile?userId=${userId}" ><button class="btn btn-primary btn-lg btn-block  btn-shadow-blue">Click to Update</button></a>
          </div>

       </div>
    </div>
  </div>
</section>
<!-- END section -->

<%@include file="footer.jsp" %>

    <!-- loader -->

	</body>
</html>
