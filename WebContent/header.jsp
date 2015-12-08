<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Columbia - Buy n Sell</title>

	<link rel="shortcut icon" href="assets/images/cbs_logo.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="assets/css/main.css">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<a class="navbar-brand" href="index.html"><img src="assets/images/cbs_logo.png" alt="Progressus HTML5 template"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Post an Ad</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories <b class="caret"></b></a>
						<ol class="dropdown-menu">
							<li class="active" name="ALL" value="1"><a href="/CloudProject/SearchServlet" name="ALL">All</a></li>
							<li><a href="#">Bedding</a></li>
							<li><a href="#">Kitchen Ware</a></li>
							<li><a href="#">Furniture</a></li>
							<li><a href="#">Appliances</a></li>
							<li><a href="#">Apparels</a></li>
						</ol>
					</li>
					<li><a href="about.html">About</a></li>
					<li><a href="contact.html">Contact</a></li>
					<li><a class="btn" href="signin.html">SIGN IN</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 
	<!-- /.navbar -->

	<!-- Header -->
	<header id="head">
		<div class="container">
		<form id="form1" action="/CloudProject/SearchServlet" method="post">
			<div class="row">
				<h1 class="lead">BUY, BORROW, SELL</h1>
				<p class="tagline">Marketplace for the Columbia community</p>
				<p>
				<select class="btn btn-action btn-cbs" name="category" style="background-color:#f2f2f2;width:150px;color:black" >
				<option value="all" selected="selected">All</option>
  				<option value="Bedding">Bedding</option>
  				<option value="Kitchenware">Kitchen Ware</option>
  				<option value="Furniture">Furniture</option>
  				<option value="Applicances">Appliances</option>
  				<option value="Apparel">Apparels</option>
				</select>
				<input class="search_cbs" id="searchbox" name="sb" type="text" placeholder="Search..." style="width:500px;height:40px">
				<input class="btn btn-action btn-cbs" type="submit" value="Search" >
				
			</p>	
			</div>
			<div class="row">
			<input type="checkbox" id="loc" name="loc" value="loc" onchange="displayAddressBox()" style="color:orange;font-size:50px;width:20px;height:20px" ><font style="color:white;font-size:20px;width:20px;height:20px;font-weight:bold">Filter by location</font>
			</div>
			<div class="row" id="address_filter" style="display:none">
			<input type="text" name="address" placeholder="Enter address:">
			</div>
			</form>
		</div>
	</header>

</body>
<script>
function displayAddressBox()
{
var x=document.getElementById('loc').checked;
if(x==true)
	{
	document.getElementById('address_filter').style.display='block';
	}
else
	{
	document.getElementById('address_filter').style.display='none';
	}
}
</script>
</html>