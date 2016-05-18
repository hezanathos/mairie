<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.*"%>
<%@ page import="dto.*"%>
<%@ page import="controller.*"%>

<!doctype html>
<!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js ie7 oldie" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js ie8 oldie" lang="en"> <![endif]-->
<!--[if IE 9]>    <html class="no-js ie9" lang="en"> <![endif]-->
<!--[if gt IE 9]><!-->
<html>
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="description"
	content="Flatfy Free Flat and Responsive HTML5 Template ">
<meta name="author" content="">

<title>QuelleMairie.com</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom Google Web Font -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Arvo:400,700'
	rel='stylesheet' type='text/css'>

<!-- Custom CSS-->
<link href="css/general.css" rel="stylesheet">

<!-- Owl-Carousel -->
<link href="css/custom.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet">
<link href="css/owl.theme.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">

<!-- Magnific Popup core CSS file -->
<link rel="stylesheet" href="css/magnific-popup.css">

<script src="js/modernizr-2.8.3.min.js"></script>
<!-- Modernizr /-->
<!--[if IE 9]>
		<script src="js/PIE_IE9.js"></script>
	<![endif]-->
<!--[if lt IE 9]>
		<script src="js/PIE_IE678.js"></script>
	<![endif]-->

<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
	<![endif]-->
<!-- Custom footer -->
<link rel="stylesheet" href="css/footer.css">
</head>

<body id="home">

	<div id="preloader">
		<div id="status"></div>
	</div>

	<nav class="navbar-default" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">QuelleMairie</a>
			</div>
		</div>
	</nav>


	<div id="whatis" class="content-section-b" style="border-top: 0">
		<div class="container">
			<%
				Mairie m = (Mairie) request.getAttribute("userInput");
				System.out.println(m);
			%>
			<div class="col-md-6 col-md-offset-3 text-center wrap_title">
				<h3>
					<%
						out.println(m.getNom());
					%>
				</h3>
				<h4>
					<%
						out.println(m.getCodePostal());
					%>
				</h4>
			</div>

			<div class="row">

				<div class="col-sm-4 wow fadeInDown text-center">
					 <br>
					<p class="lead">
						Adresse Postale :
						<%
						out.println(m.getAdresse());
					%><br> <br> Adresse Mail :
						<%
 	out.println(m.getMail());
 %><br> <br> Telephone :
						<%
 	out.println(m.getTelephone());
 %><br> <br> Site Web : <a href=""> <%
 	out.println(m.getSite());
 %>
						</a><br> <br>
					</p>

					<!-- <p><a class="btn btn-embossed btn-primary view" role="button">View Details</a></p> -->
				</div>
				<!-- /.col-lg-4 -->

				<div class="col-sm-4 wow fadeInDown text-center">
					<br>
					<p class="lead">Carte Google Map</p>


					<script src='https://maps.googleapis.com/maps/api/js?v=3.exp'></script>
					<div style='overflow: hidden; height: 320px; width: 360px;'>
						<div id='gmap_canvas' style='height: 320px; width: 360px;'>
						</div>
						<div>
							<small> <a href="http://embedgooglemaps.com">google
									maps carte </a>
							</small>
						</div>
						<div>
							<small> <a href="http://www.youtubeembedcode.com">generate
									youtube code</a>
							</small>
						</div>
						<style>
#gmap_canvas img {
	max-width: none !important;
	background: none !important
}
</style>
					</div>
					<script type='text/javascript'>function init_map(){var myOptions = {zoom:15,center:new google.maps.LatLng(<%out.println(m.getlatitude());%>,<%out.println(m.getlongitude());%>),mapTypeId: google.maps.MapTypeId.HYBRID};map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(<%out.println(m.getlatitude());%>,<%out.println(m.getlongitude());%>)});infowindow = new google.maps.InfoWindow({content:'<%out.print(m.getNom());%>'});
							google.maps.event.addListener(marker, 'click',
									function() {
										infowindow.open(map, marker);
									});
							infowindow.open(map, marker);
						}
						google.maps.event.addDomListener(window, 'load',
								init_map);
					</script>

					<!-- <p><a class="btn btn-embossed btn-primary view" role="button">View Details</a></p> -->
				</div>
				<!-- /.col-lg-4 -->

				<div class="col-sm-4 wow fadeInDown text-center">
					<br>
					<p class="lead">
						Horaires<br> <br>
						<%
							for (String horraire : m.getHoraires()) {
								out.println(horraire + "<br>");
							}
						%>


					</p>
					<!-- <p><a class="btn btn-embossed btn-primary view" role="button">View Details</a></p> -->
				</div>
				<!-- /.col-lg-4 -->

			</div>
			<!-- /.row -->
		</div>
	</div>

	<footer class="footer">
		<div class="container">

			<p class="text-muted">Copyright &copy; QuelleMairie.com 2016 ,
				Nicolas Cailleux - Alex Lecoq</p>
		</div>
		<!-- JavaScript -->
		<script src="js/jquery-1.10.2.js"></script>
		<script src="js/bootstrap.js"></script>
		<script src="js/owl.carousel.js"></script>
		<script src="js/script.js"></script>
		<!-- StikyMenu -->
		<script src="js/stickUp.min.js"></script>
		<script type="text/javascript">
			jQuery(function($) {
				$(document).ready(function() {
					$('.navbar-default').stickUp();

				});
			})
		</script>
		<!-- Magnific Popup core JS file -->
		<script src="js/jquery.magnific-popup.js"></script>
</body>

</html>
