
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.*" %>
<%@ page import="dto.*" %>
<%@ page import="controller.*" %>

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

	<!-- Contact -->
	<div id="contact" class="content-section-a">
		<div class="container">
			<div class="row">

				<div class="lead">
					<h4>Bonjour et bienvenue sur le site de référencement des
						mairies de France !</h4>
				</div>

				<form role="form" action="/projetJEE/AffichageServlet" method="post">
					<div class="col-md-6">
						<div class="form-group">
							<label for="InputName">Rechercher une mairie ( entrez un code postal ou un nom de ville )</label>
							<div class="input-group">
								<input id="villes" type="text" class="form-control" name="villes"
				onkeydown="if(event.keyCode==13) return getMairie($('#villes').val());"
								 placeholder="Nom de la Ville" required>
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-ok form-control-feedback"></i></span>
							</div>
						</div>
<div id="mairie"></div>
						

    <div id="results"></div>
						

						<input type="submit" name="submit" id="submit" value="Submit"
							class="btn wow tada btn-embossed btn-primary pull-right">
					</div>
				</form>

				<hr class="featurette-divider hidden-lg">

			</div>
		</div>
	</div>

	<footer>
		<center>
			<p>Copyright &copy; QuelleMairie.com 2016 , Nicolas Cailleux -
				Alex Lecoq</p>
		</center>
	</footer>
	<!-- JavaScript -->
	<script src="js/jquery-1.10.2.js"></script>
	  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	
	<script src="js/autocompletion.js"></script>
	
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
	
</body>

</html>
