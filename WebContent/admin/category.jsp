<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Quản lý giày dép</title>
    	<jsp:include page="head.jsp"></jsp:include>
</head>
<body class="bg-light" style="height:100%;">
 <jsp:include page="header.jsp"></jsp:include>
 <div style="margin-top:86px;" style="background-color:#FFCCFF;"></div>
 <div class="container-fluid h-100" style="background-color:#FFCCFF;">
 	<section class="h-100 h-custom" style="background-color:#FFCCFF;">
        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center h-100">
            <div class="col">
              <div class="card">
                <div class="card-body p-4">
      
                  <div class="row">
                    <h2>Lịch sử mua giày</h2>
                    <table class="table table-striped" >
                        <thead>
                          <tr>
                            <th>Mã giày</th>
                            <th>Ảnh</th>
                            <th>Tên giày</th>
                            <th>Mô tả</th>
                            <th>Số lượng</th>
                            <th>Giá</th>
                            <th>Loại giày</th>
                            <th>Hãng giày</th>
                            <th>Size</th>
                          </tr>
                        </thead>
                        <tbody>  
                        	
                        	<c:forEach var="item" items="${shoes}" varStatus="loop">
	                          <tr>
	                            <td>${item.getMaGiay()}</td>
	                            <td><img width="70" alt="${item.getAnh() }" src=""></td>
	                             <td>${item.getTenGiay()}</td>
	                            <td>${item.getMota()}</td>
	                            <td>${item.getSoLuong()}</td>
	                            <td>${item.getGia()}</td>
	                            <td>${item.getTenLoai()}</td>
	                            <td>$ ${item.getTenHang()}</td>
	                            <td>$ ${item.getSize()}</td>
	                          </tr>
                        	</c:forEach>
                        </tbody>
                      </table>
                         <c:if test="${orders.size() < 1}">
                        		<p class="d-flex align-item-center text-danger fw-bold">Lịch sử mua hàng trống!</p>
                         </c:if>
                  </div>
      
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>  
</div>
</body>
</html>