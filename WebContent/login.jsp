<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Đăng nhập - Cheichei Store</title>
       	<jsp:include page="common/head.jsp"></jsp:include>
</head>
<body>
<section class="vh-100" style="background-color: #3399FF;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <div class="row g-0">
            <div class="col-md-6 col-lg-5 d-none d-md-block">
            </div>
            
              <div class="card-body p-4 p-lg-5 text-black">

                <form action="login" method="post" class="form-login">
	                  <div class="d-flex align-items-center mb-3 pb-1">
	                    
	                    <span class="h1 fw-bold mb-0">Đăng nhập</span>
	                  </div>
	
	                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Đăng nhập tài khoản của bạn</h5>
					 <c:if test="${report != null}">
					 	<div class="alert alert-danger">Tài khoản hoặc mật khẩu không chính xác!</div>
					 </c:if>	
					 <c:if test="${ not empty message and not empty status }">
					 	<div class="alert alert-${status }">${message }</div>
					 </c:if>
					 
	                  <div class="form-outline mb-4">
	                    <label class="form-label" for="form2Example17">Tài khoản</label>
	                    <input type="text" id="form2Example17" name="username" placeholder="Enter Username" required class="form-control form-control-lg" />
	                  </div>
	
	                  <div class="form-outline mb-4">
	                    <label class="form-label" for="form2Example27">Mật khẩu</label>
	                    <input type="password" id="form2Example27" name="password" placeholder="Enter Password" required class="form-control form-control-lg" />
	                  </div>
	
	                  <div class="pt-1 mb-4">
	                    <button class="btn btn-dark btn-lg btn-block" type="submit">Đăng nhập</button>
	                  </div>
	                  <p> <button type="button" onclick="showRegister()" 
	                  class="bg-transparent border-0 text-primary fw-bold text-decoration-underline">Đăng ký</button></p>
                </form>
                <form action="register" method="post" class="form-register d-none">
                    <div class="d-flex align-items-center  pb-1">
                      <span class="h1 fw-bold mb-0">Đăng nhập</span>
                    </div>
  
                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Đăng ký tài khoản mới</h5>
  
                    <div class="form-outline mb-4">
                      <label class="form-label" for="form2Example17">Họ và tên</label>
                      <input type="text" id="form2Example17" name="fullname" class="form-control form-control-lg" required />
                    </div>
                    <div class="form-outline mb-4">
                      <label class="form-label" for="username">Tên đăng nhập</label>
                      <input type="text" id="username" name="username" class="form-control form-control-lg"  required/>
                    </div>
                    <div class="form-outline mb-4">
                      <label class="form-label" for="form2Example17">Mật khẩu</label>
                      <input type="password" id="form2Example17" name="password" class="form-control form-control-lg" required/>
                    </div>
                    <div class="pt-1 mb-4">
                      <button class="btn btn-dark btn-lg btn-block" type="submit">Đăng ký</button>
                    </div>
                    
                    <p class="pb-lg-2" style="color: #393f81;"><button type="button" onclick="showLogin()"
	                      class="bg-transparent border-0 text-primary fw-bold text-decoration-underline">Login here</button></p>
                 </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script type="text/javascript">
	function showRegister() {
	    $('.form-login').addClass('d-none')
	    $('.form-register').removeClass('d-none')
	}
	function showLogin() {
	    $('.form-login').removeClass('d-none')
	    $('.form-register').addClass('d-none')
	}
</script>
</body>
</html>