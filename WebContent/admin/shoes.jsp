<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Quản lý giày</title>
    	<jsp:include page="head.jsp"></jsp:include>
</head>
<body class="bg-light" style="height:100%;background-color:#FFCCFF;">
 <jsp:include page="header.jsp"></jsp:include>
 <div class="container-fluid h-100" style="background-color:#FFCCFF;" >
 	<section class="h-100 h-custom">
        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center h-100">
            <div class="col">
              <div class="card">
                <div class="card-body p-4">
      
                  <div class="row" style="background-color:#abedd2;">
                    <div class="d-flex">
	                    <h2>Quản lý giày dép</h2>
						<a href="shoes/save" class="btn btn-success ms-auto" style="background-color:grey;">Thêm giày mới</a>
                    </div>
                    <table class="table table-striped">
                        <thead>
                          <tr>
                            <th width="150">Mã giày</th>
                            <th>Ảnh</th>
                            <th>Tên giày</th>
                            <th>Mô tả</th>
                            <th>Số lượng</th>
                            <th>Giá</th>
                            <th>Loại giày</th>
                            <th>Hãng giày</th>
                            <th>Chức năng </th>
                            <th></th>
                          </tr>
                        </thead>
                        <tbody>  
                        	
                        	<c:forEach var="item" items="${shoes}" varStatus="loop">
	                          <tr>
	                            <td>${item.getMaGiay()}</td>
	                            <td><img
                                                                src="../${item.getAnh()}"
                                                                class="img-fluid rounded-3" alt="Shopping item"
                                                                style="width: 65px;"></td>
	                            <td>${item.getTenGiay()}</td>
	                            <td>${item.getMota()}</td>
	                            <td>${item.getSoLuong()}</td>
	                            <td>${item.getGia()} đ</td>
	                            <td>${item.getMaLoai()}</td>
	                            <td>${item.getMaHang()}</td>
	                            <td><button type="submit" name="delete" value="${item.getMaGiay()}"
                                                            class="btn text-danger" style="color: #cecece;"><i
                                                            class="fas fa-trash-alt"></i></button></td>
	                          </tr>
                        	</c:forEach>
                        </tbody>
                        
                      </table>
                         <c:if test="${orders.size() < 1}">
                        		<p class="d-flex align-item-center text-danger fw-bold">Lịch sử mua giày trống!</p>
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