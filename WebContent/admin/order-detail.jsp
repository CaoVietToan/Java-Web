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
 <div class="container-fluid">
 	<section class="h-100 h-custom" style="background-color:#abedd2;">
        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center h-100">
            <div class="col">
              <div class="card">
                <div class="card-body p-4">
      
                  <div class="row" style="background-color:#abedd2;">
                    <h2>Chi tiết hóa đơn giày</h2>
                    <table class="table table-striped">
                        <thead>
                          <tr>
                            <th>#</th>
                            <th>Ảnh</th>
                            <th>Tên giày</th>
                            <th>Số lượng</th>
                            <th>Giá</th>
                            <th>Thành tiền</th>
                            <th>Trạng thái</th>
                            <th>Chức năng</th>
                          </tr>
                        </thead>
                        <tbody>  
                        	
                        	<c:forEach var="item" items="${orders}" varStatus="loop">
	                          <tr>
	                            <td>${loop.index + 1 }</td>
	                            <td><img src="<c:url value="/${item.getAnh()}"></c:url>" width="80" alt="Product Image"></td>
	                            <td>${item.getTengiay()}</td>
	                            <td>${item.getSoluong()}</td>
	                            <td>${item.getGia()}</td>
	                            <td>$ ${item.getThanhtien()}</td>
	                            <td>
	                            	<c:if test="${item.isTrangthai() == true }">
	                            		<span class="" style="background-color:yellow;">Đã thanh toán</span>
	                            	</c:if>
	                            	<c:if test="${item.isTrangthai() != true }">
	                            		<span class="" style="background-color:grey;"> Chưa thanh toán</span>
	                            	</c:if>
								</td>
								<td>
									<a href="order-detail?orderId=${item.getMahd()}&ODId=${item.getMacthd()}" class="btn btn-success" style="background-color:red;">Duyệt</a>
								</td>
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
 <!-- Toast -->
 <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
  <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-bs-delay="2000">
    <div class="toast-header text-${status }">
      <strong><i class="fa-solid fa-check"></i></strong>
      <strong class="me-auto">Order Message</strong>
      <small>11 mins ago</small>
      <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
    </div>
    <div class="toast-body bg-${status } text-light">
       <strong>${message }</strong> 
    </div>
  </div>
</div>

	<c:set var="message" value="${message}"/> 
<script type="text/javascript">
	var liveToast = document.getElementById('liveToast')
	var message = '${message}'
	if (message != '') {
	    var toast = new bootstrap.Toast(liveToast)
	    toast.show()
	}
</script>	
</body>
</html>