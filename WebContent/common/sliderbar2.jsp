<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div>
                <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">  
                            
                    <span class="fs-4 fw-bold">Hãng giày</span>
                </a>
                <hr>
                <ul class="nav nav-pills flex-column mb-auto">
                    <c:forEach var="item" items="${hang}">
                        <li class="nav-item"> 
                            <a href="home?hangId=${item.getMaHang()}" style="color:black;"
                               class="nav-link <c:if test="${item.getMaHang().equals(mahang)}"> active </c:if>"
                               aria-current="page">
                                    ${item.getTenHang()}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
