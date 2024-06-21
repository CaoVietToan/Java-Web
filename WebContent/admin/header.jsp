<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color:pink;">
    <div class="container-fluid">
        <a class="navbar-brand fs-1" href="home">
            <img alt="" src="image/book_note_icon.png" width="50">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="shoes" style="color:black;">Quản lý giày</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="order" style="color:black;">Lịch sử mua giày</a>
                </li>
            </ul>
            <div class="d-flex">
                <c:if test="${empty username}">
                    <a href="login" class="btn btn-outline-light me-2" style="color:black;">Đăng nhập</a>
                </c:if>
                 <c:if test="${not empty username }">
                    <div class="navbar-nav">
                        <a class="nav-item nav-link disable" style="color:black;">Welcome ADMIN
                        </a>
                        <a class="nav-item nav-link" href="<c:url value="/home?message=logout" ></c:url>" style="color:black;">Đăng xuất</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</nav>