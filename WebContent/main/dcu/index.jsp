<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<![endif]-->

<link rel="stylesheet" href="css/person.css">
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/templatemo-style.css">
<link rel="stylesheet" href="css/google_font.css">
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>CA675 Cloud Technologies ASS2</title>
</head>
<body>
<%--	<nav class="breadcrumb">--%>
<%--		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>--%>
<%--		统计--%>
<%--		<a class="btn btn-success radius r mr-20"--%>
<%--			style="line-height: 1.6em; margin-top: 3px"--%>
<%--			href="javascript:location.replace(location.href);" title="刷新"><i--%>
<%--			class="Hui-iconfont">&#xe68f;</i></a>--%>
<%--	</nav>--%>
<%--	<p style="font-size: 25px; margin-top: 20px; margin-left: 45%;">有效交易统计</p>--%>
<div style="text-align: center;">
	<h1>CA675 Cloud Technologies ASS2</h1>
	<h2>Irish Weather Analysis with Spark</h2>
</div>
	<!-- START 主要版块 -->
	<section id="work" class="tm-padding-top-bottom-100">
		<div class="container">
<%--			<br class="row">--%>
				<div class="col-md-offset-1 col-md-11">
					<h2 class="title">${indexList.info_list_head}</h2>
				</div>
				<a href="laptopList.html" target="_blank">
					<div class="col-md-4 col-sm-4" style="margin-top: -40px;">
						<div class="work-wrapper">
							<i class="fa fa-laptop"></i>
							<h3 class="text-uppercase tm-work-h3">Function 1</h3>
<%--							<hr>--%>
							<p style="color: #0a6999">Weather Inquiry Service</p>
							<p>The application will query the relevant weather information according to the user&#39;s input and visualize the query results in different ways to facilitate the user&#39;s understanding.</p>
						</div>
					</div>
				</a>
				<a href="laptopList.html" target="_blank">
					<div class="col-md-4 col-sm-4" style="margin-bottom: 40px; margin-top: -40px">
						<div class="work-wrapper">
							<i class="fa fa-laptop"></i>
							<h3 class="text-uppercase tm-work-h3">Function 2</h3>
<%--							<hr>--%>
							<p style="color: #0a6999">Visualization Of Meteorological Data</p>
							<p>The user enters the type of chart required, such as the wind direction chart and temperature heatmap, and the application will query the relevant data and generate the corresponding chart for the user.</p>
						</div>
					</div>
				</a>
			<div style="height: 20px; width: 100%"></div>
				<a href="forecast.html" target="_blank">
					<div class="col-md-4 col-sm-4">
						<div class="work-wrapper">
							<i class="fa fa-laptop"></i>
							<h3 class="text-uppercase tm-work-h3">Function 3</h3>
<%--							<hr>--%>
							<p style="color: #0a6999">Meteorological Data Time-series Analysis And Prediction</p>
							<p>Since the data set is full of time series data, we will try time series analysis, return the results to the user and try to make time-series predictions on the weather data</p>
						</div>
					</div>
				</a>
				<a href="laptopList.html" target="_blank">
					<div class="col-md-4 col-sm-4">
						<div class="work-wrapper">
							<i class="fa fa-laptop"></i>
							<h3 class="text-uppercase tm-work-h3">Function 4</h3>
<%--							<hr>--%>
							<p style="color: #0a6999">The Weather Classification</p>
							<p>Users can input their Observational data, and the model will use this data to judge the weather situation. We will try to use spark-MLlib to implement this function</p>
						</div>
					</div>
				</a>
<%--				<div class="toogle" style="width: 100%; float: left;">--%>
<%--					<hr style="width: 100%; height: 2px;" />--%>
<%--				</div>--%>


			</div>
		</div>
	</section>
	<!-- END 主要版块 -->


</body>
</html>