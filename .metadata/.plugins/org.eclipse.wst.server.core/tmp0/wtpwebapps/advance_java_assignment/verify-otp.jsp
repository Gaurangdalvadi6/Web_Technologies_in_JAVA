<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html lang="zxx">

<head>
    <title>My School Education Category Bootstrap Responsive website Template | Login :: w3layouts</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content="My School Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script>
        addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
    <!-- //Meta tag Keywords -->

    <!-- Custom-Files -->
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- Bootstrap-CSS -->
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <!-- Style-CSS -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- Font-Awesome-Icons-CSS -->
    <!-- //Custom-Files -->

    <!-- Web-Fonts -->
    <link href="//fonts.googleapis.com/css?family=Lora:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext,vietnamese"
        rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800&amp;subset=latin-ext" rel="stylesheet">
    <!-- //Web-Fonts -->
</head>

<body>
    <!-- header -->
    <header>
        <div class="container">
            <div class="header d-lg-flex justify-content-between align-items-center py-2 px-sm-2 px-1">
                <!-- logo -->
                <div id="logo">
                    <h1><a href="index.jsp">My School</a></h1>
                </div>
                <!-- //logo -->
                <!-- nav -->
                <div class="nav_w3ls ml-lg-5">
                    <nav>
                        <label for="drop" class="toggle">Menu</label>
                        <input type="checkbox" id="drop" />
                        <ul class="menu">
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="index.jsp">About</a></li>
                            <li><a href="index.jsp">Join Now</a></li>
                            <li>
                                <!-- First Tier Drop Down -->
                                <label for="drop-2" class="toggle toogle-2">Pages <span class="fa fa-angle-down"
                                        aria-hidden="true"></span>
                                </label>
                                <a href="#">Pages <span class="fa fa-angle-down" aria-hidden="true"></span></a>
                                <input type="checkbox" id="drop-2" />
                                <ul>
                                    <li><a href="index.jsp" class="drop-text">Events</a></li>
                                    <li><a href="index.jsp" class="drop-text">What We Do?</a></li>
                                    <li><a href="index.jsp" class="drop-text">Popular Courses</a></li>
                                    <li><a href="index.jsp" class="drop-text">Statistics</a></li>
                                    <li><a href="index.jsp" class="drop-text">Gallery</a></li>
                                </ul>
                            </li>
                            <li><a href="index.jsp">Contact</a></li>
                            <li><a href="login.jsp">Login</a></li>
                            <li><a href="register.html">Register</a></li>
                        </ul>
                    </nav>
                </div>
                <!-- //nav -->
            </div>
        </div>
    </header>
    <!-- //header -->
    <!-- inner banner -->
    <div class="inner-banner-w3ls py-5" id="home">
        <div class="container py-xl-5 py-lg-3">
        
            <!-- login  -->
            <div class="modal-body my-5 pt-4">
            <%
				String email = (String) request.getAttribute("email");
				%>
				<%
				int otp1 = (Integer) request.getAttribute("otp");
				%>
                <h3 class="title-w3 mb-5 text-center text-wh font-weight-bold">Verify Otp </h3>
                <h5 class="tittle text-center">
				<%String msg = (String)request.getAttribute("msg"); %>
				<%if(msg!= null){ %>
					<%out.print(msg); %>
				<%} %>
			</h5>
			<h5 class="tittle text-center">
				<%String msg1 = (String)request.getAttribute("msg1"); %>
				<%if(msg1!= null){ %>
					<%out.print(msg1); %>
				<%} %>
			</h5>
                <form action="StudentController" method="post">
                
                <div class="form-group">
                        <input type="hidden" class="form-control" name="email" value="<%=email%>">
                    </div>
                    <div class="form-group">
                        <input type="hidden" class="form-control" name="otp1" value="<%=otp1%>">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="otp2"  placeholder="Enter OTP"
							required="">
                    </div>
                    <button type="submit" class="btn button-style-w3" value="verify" name="action">Verify	</button>
                    </form>
            </div>
            <!-- //login -->
        </div>
    </div>
    <!-- //inner banner -->
                    
</body>
</html>