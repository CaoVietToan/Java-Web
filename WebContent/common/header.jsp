<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="../css/css.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <style>
  	.navbar .navbar-brand {
    font-family: 'Lobster', cursive;
    font-size: 30px;
}
    </style>
	<header class="header-area overlay">
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color:pink;">
            <div class="container"  >
                <a href="home?page=1" class="navbar-brand" style="color:black;">CheiCheiShop</a>
                
                <button type="button" class="navbar-toggler collapsed" data-toggle="collapse" data-target="#main-nav">
                    <span class="menu-icon-bar"></span>
                    <span class="menu-icon-bar"></span>
                    <span class="menu-icon-bar"></span>
                </button>
                
                <div id="main-nav" class="collapse navbar-collapse">
                    <ul class="navbar-nav ml-auto">
                        <li><a href="home?page=1" class="nav-item nav-link active" style="padding-right: 65px; color:black;">Home</a></li>
                        <li><a href="cart" class="nav-item nav-link" style="padding-right: 60px;color:black;">Cart</a></li>
                        <li><a href="purchase" class="nav-item nav-link" style="padding-right: 50px;color:black;">History</a></li>
                        <li><a href="my-account" class="nav-item nav-link" style="padding-right: 25px;color:black;">My Account</a></li>
                        <div class="d-flex">
                <c:if test="${empty username}">
                    <a href="login" class="nav-item nav-link active" style="padding-right: 65px; color:black;" >Login</a>
                </c:if>
                 <c:if test="${not empty username }">
                    <div class="navbar-nav">
                        <a class="nav-item nav-link active" style="padding-right: 0px; color:black;">Xin chào, ${username}  |
                        </a>
                        <a class="nav-item nav-link active" href="home?message=logout" style="padding-right: 0px;color:black;">Logout</a>
                    </div>
                </c:if>
            </div>
                        <!-- <li class="dropdown">
                            <a href="#" class="nav-item nav-link" data-toggle="dropdown">Services</a>
                            <div class="dropdown-menu">
                                <a href="#" class="dropdown-item">Dropdown Item 1</a>
                                <a href="#" class="dropdown-item">Dropdown Item 2</a>
                                <a href="#" class="dropdown-item">Dropdown Item 3</a>
                            </div>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="nav-item nav-link" data-toggle="dropdown">Portfolio</a>
                            <div class="dropdown-menu">
                                <a href="#" class="dropdown-item">Dropdown Item 1</a>
                                <a href="#" class="dropdown-item">Dropdown Item 2</a>
                                <a href="#" class="dropdown-item">Dropdown Item 3</a>
                                <a href="#" class="dropdown-item">Dropdown Item 4</a>
                                <a href="#" class="dropdown-item">Dropdown Item 5</a>
                            </div>
                        </li> -->
            
                    </ul>
                </div>
            </div>
        </nav>

    </header>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script>
jQuery(function($) {
    $(window).on('scroll', function() {
		if ($(this).scrollTop() >= 200) {
			$('.navbar').addClass('fixed-top');
		} else if ($(this).scrollTop() == 0) {
			$('.navbar').removeClass('fixed-top');
		}
	});
	
	function adjustNav() {
		var winWidth = $(window).width(),
			dropdown = $('.dropdown'),
			dropdownMenu = $('.dropdown-menu');
		
		if (winWidth >= 768) {
			dropdown.on('mouseenter', function() {
				$(this).addClass('show')
					.children(dropdownMenu).addClass('show');
			});
			
			dropdown.on('mouseleave', function() {
				$(this).removeClass('show')
					.children(dropdownMenu).removeClass('show');
			});
		} else {
			dropdown.off('mouseenter mouseleave');
		}
	}
	
	$(window).on('resize', adjustNav);
	
	adjustNav();
});
</script>