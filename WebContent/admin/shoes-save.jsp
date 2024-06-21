<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="head.jsp"></jsp:include>
	<title>Thêm giày | Cheichei Store</title>
</head>
<body class="bg-light" style="height:100%;">
 <jsp:include page="header.jsp"></jsp:include>
	
	<section class="h-100 h-custom" style="background-color:#abedd2;">
        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center h-100">
            <div class="col">
              <div class="card">
              	<div class="card-header">
              		<h4>Thêm giày mới</h4>
              	</div>
                <div class="card-body p-4">
                	<form method="get" action="save" enctype= "multipart/form-data">
                	<div class="form-outline mb-4">
                      <label class="form-label" for="form2Example17">Mã giày</label>
                      <input type="text" id="form2Example17" name="maGiay" class="form-control form-control-lg" required />
                    </div>
                    <div class="form-outline mb-4">
                      <label class="form-label" for="form2Example17">Tên giày</label>
                      <input type="text" id="form2Example17" name="tenGiay" class="form-control form-control-lg" required />
                    </div>
                    <div class="form-outline mb-4">
                      <label class="form-label" for="form2Example17">Số lượng</label>
                      <input type="text" id="form2Example17" name="soLuong" class="form-control form-control-lg" required />
                    </div>
                    <div class="form-outline mb-4">
                      <label class="form-label" for="form2Example17">Mô tả</label>
                      <input type="text" id="form2Example17" name="mota" class="form-control form-control-lg" required />
                    </div>
                    <div class="form-outline mb-4">
                      <label class="form-label" for="form2Example17">Giá</label>
                      <input type="text" id="form2Example17" name="gia" class="form-control form-control-lg" required />
                    </div>
                    <div class="form-outline mb-4">
                      <label class="form-label" for="form2Example17">Giới tính</label>
                      <input type="text" id="form2Example17" name="gioiTinh" class="form-control form-control-lg" required />
                    </div>
                    <div class="form-outline mb-4">
                      <label class="form-label" for="maLoai">Loại giày</label>
                      <select type="text" id="maLoai" name="maLoai" class="form-control form-control-lg" required>
                      <c:forEach var="item" items="${loai1}">
                            <option style="color:black;"
                               class="nav-link <c:if test="${item.getMaLoai().equals(maloai)}" > active </c:if>"
                               aria-current="page" value="${item.getMaLoai()}">
                                    ${item.getTenLoai()}
                            </option>
                    </c:forEach>
                    </select>
                    </div>
                    <div class="form-outline mb-4">
                      <label class="form-label" for="maHang">Hãng giày</label>
                      <select type="text" id="maHang" name="maHang" class="form-control form-control-lg" required>
                      <c:forEach var="item" items="${hang1}">
                            <option style="color:black;"
                               class="nav-link <c:if test="${item.getMaHang().equals(mahang)}" > active </c:if>"
                               aria-current="page" value="${item.getMaHang()}">
                                    ${item.getTenHang()}
                            </option>
                    </c:forEach>
                    </select>
                    </div>
                      <div class="form-outline mb-4">
						  Ảnh: <input type="file" name="anh"><br>
						  </div>
                      <button type="submit">Thêm mới</button>
					  </form> 
                </div>
              </div>
            </div>
          </div>
        </div>
      </section> 
	}
</body>
</html>