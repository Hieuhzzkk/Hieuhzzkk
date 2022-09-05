<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
        <header class="row bg-light">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img style="width: 1300px; height: 300px;" src="https://nhanlucnhatban.com/wp-content/uploads/2020/01/the-gioi-manga-nhat.jpg" alt="">
                    </div>
                    <div class="carousel-item">
                        <img style="width: 1300px; height: 300px;" src="https://truyenbanquyen.com/wp-content/uploads/2018/01/BANNER-WEB-180102.jpg" alt="">
                    </div>
                    <div class="carousel-item">
                        <img style="width: 1300px; height: 300px;" src="https://media.sohuutritue.net.vn/resize/534x280/files/news/2020/06/09/nhat-ban-ban-hanh-luat-bao-ho-ban-quyen-de-cam-tai-lau-truyen-manga-064313.jpg" alt="">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                    data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                    data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
        </header>
        <nav class="row navbar navbar-expand-lg  navbar-dark bg-dark">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#my-navbar"
                    aria-controls="my-navbar" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="my-navbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="http://localhost:8080/truyen/home">Trang chu</a>
                        </li>
                         <c:if test="${ sessionScope.user.vaiTro == 1}">
                        <li class="nav-item">
                            <a class="nav-link" href="http://localhost:8080/hhh/users/index">User</a>
                        </li>
                         </c:if>
                         <c:if test="${ sessionScope.user.vaiTro == 1}">
                        <li class="nav-item">
                            <a class="nav-link" href="http://localhost:8080/hhh/categories/index">Category</a>
                        </li>
                         </c:if>
                         
                        <li class="nav-item">
                            <a class="nav-link" href="http://localhost:8080/truyen">Truyen Tranh</a>
                        </li>
                        
                        
                        <c:if test="${ sessionScope.user == null }">
	                        <li class="nav-item">
	                            <a class="nav-link" href="http://localhost:8080/hhh/Login">Login</a>
	                        </li>
                        </c:if>
                                                                
                    </ul>
                    <span class="nav-item dropdown ">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false" text="white">
								${ sessionScope.user.email }
                        </a>
                        
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">                                                                                    
                            <div class="dropdown-divider"></div>
                            <c:if test="${ sessionScope.user != null }">
	                            <a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#dangxuat">Đăng
	                                xuất </a>
                            </c:if>
                            
                            <a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#doimk">Đổi mật
                                khẩu</a>
                            <a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#capnhattk">Cập
                                nhật tài khoản</a>
                        </div>
                    </span>
                </div>
            </div>
        </nav>
        <div class="row">
            <div class="row mt-2">
                <article class="col-12 col-md-12 row center">
					<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Ten Truyen</th>
					      <th scope="col">So Luong</th>	
					      <th scope="col">Total</th>
					      <th scope="col">Create Date</th>     
						  <th scope="col">Status</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach items="${order}" var="order">
					  <c:set var="s" value="${s + cart.truyentranh.gia * cart.soLuong}"></c:set>
					  	
						  	<tr>
						      <td>${ order.truyenId }</td>
						      <td>${ order.truyentranh.tenTruyen }</td>
						      <td>${ order.soLuong }</td>
						      <td>${ order.gia * order.soLuong}</td>
						     <td><fmt:formatDate pattern="dd-MM-yyyy" value="${order.order.createdDate}"></fmt:formatDate></td>
						      <td><c:choose>
								<c:when test="${ order.order.status == false }">Pending</c:when>
								
								<c:otherwise> - </c:otherwise>
								</c:choose></td>
							  				
						    </tr>
					  	</c:forEach>    
					  </tbody>
					</table>
						
					
					
                </article>
                    
                   
                    
                    <div class="modal fade" id="dangxuat" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                <h5>Ban co muon dang xuat</h5>
										
                                    <a href="http://localhost:8080/hhh/Logout">Dang xuat</a>
                                       
                                </div>                          
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="doimk" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Đổi mật khẩu</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="row">
                                        <form action="" method="">
                                            <div class="mt-2 row">
                                                <label for="exampleInputPassword1" class="form-label col-4">Mật khẩu
                                                    hiện tại</label>
                                                <div class="col-6">
                                                    <input type="password" class="form-control"
                                                        id="exampleInputPassword1">
                                                </div>
                                            </div>
                                            <div class="mt-2 row">
                                                <label for="exampleInputPassword1" class="form-label col-4">Mật khẩu
                                                    mới</label>
                                                <div class="col-6">
                                                    <input type="password" class="form-control"
                                                        id="exampleInputPassword1">
                                                </div>
                                            </div>
                                            <div class="mt-2 row">
                                                <label for="exampleInputPassword1" class="form-label col-4">Nhập lại mật
                                                    khẩu mới</label>
                                                <div class="col-6">
                                                    <input type="password" class="form-control"
                                                        id="exampleInputPassword1">
                                                </div>
                                            </div>
                                            <div class="mt-2 pt-4 text-center">
                                                <button class="btn btn-primary">
                                                    Đổi mật khẩu
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="capnhattk" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Đổi mật khẩu</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="row">
                                        <form action="" method="">
                                            <div class="mt-2 row">
                                                <label class="col-2" for="fullname">Họ tên</label>
                                                <div class="col-10">
                                                    <input type="text" name="fullname" id="fullname"
                                                        class="form-control" />
                                                </div>
                                            </div>
                                            <div class="mt-2 row">
                                                <label class="col-2" for="number">SĐT</label>
                                                <div class="col-10">
                                                    <input type="tel" name="number" id="number" class="form-control" />
                                                </div>
                                            </div>
                                            <div class="mt-2 row">
                                                <label class="col-2" for="email">
                                                    Email
                                                </label>
                                                <div class="col-10">
                                                    <input type="email" name="email" id="email" class="form-control" />
                                                </div>
                                            </div>
                                            <div class="mt-2 row">
                                                <label class="col-2" for="gioi_tinh_nam">
                                                    Giới tính
                                                </label>
                                                <div class="col-10">
                                                    <div class="form-check col-2">
                                                        <input type="radio" class="form-check-input" name="gioi_tinh"
                                                            id="gioi_tinh_nam" />
                                                        <label for="gioi_tinh_nam">Nam</label>
                                                    </div>
                                                    <div class="form-check col-2">
                                                        <input type="radio" class="form-check-input" name="gioi_tinh"
                                                            id="gioi_tinh_nu" />
                                                        <label for="gioi_tinh_nu">Nữ</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mt-2 row">
                                                <label class="col-2" for="ngaysinh">
                                                    Ngày sinh
                                                </label>
                                                <div class="col-10">
                                                    <input type="ngaysinh" name="ngaysinh" id="ngaysinh"
                                                        class="form-control" />
                                                </div>
                                            </div>
                                            <div class="mt-2 row">
                                                <label class="col-2" for="hocphi">
                                                    Học phí
                                                </label>
                                                <div class="col-10">
                                                    <input type="hocphi" name="hocphi" id="hocphi"
                                                        class="form-control" />
                                                </div>
                                            </div>
                                            <div class="mt-2 row pt-4">
                                                <button class="btn btn-primary">
                                                    Cập nhật
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                
            </div>
            
            <div class="row">
				<div class="" style="height: ;"></div>
				<div class="col-sm-9">
					<jsp:include page="${ view }"></jsp:include>
				</div>
			</div>
			
            <footer class="row bg-dark text-center text-light p-2 mt-3">
                <footer class="bg-dark text-white pt-2 pb-1 mt-5">
                    <div class="container text-center text-md-start">
                      <div class="row text-center text-md-start">
                        <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
                          <h5 class="text-uppercase mb-4 fw-bold text-warning">FPT Polytechnic</h5>
                          <p>DC: P.Trinh Văn Bô, Xuân Phương, Nam Từ Liêm, Hà Nội</p>
                          <p>Email: hieuntph14720@fpt.edu.vn</p>
                        </div>
                        <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
                          <h5 class="text-uppercase mb-4 fw-bold text-warning">Sản phẩm</h5>
                          <p>
                            <a href="#" class="text-white" style="text-decoration: none;">Bootstrap 5</a>
                          </p>
                          <p>
                            <a href="#" class="text-white" style="text-decoration: none;">Visual Studio Code</a>
                          </p>
                          <p>
                            <a href="#" class="text-white" style="text-decoration: none;">Drift</a>
                          </p>
                        </div>
                        <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
                          <h5 class="text-uppercase mb-4 fw-bold text-warning">Thông tin liên hệ</h5>
                          <p>
                            <i class="bi bi-house-fill">Nam Từ Liêm, Hà Nội</i>
                          </p>
                          <p>
                            <i class="bi bi-envelope">hieuntph14720@fpt.edu.vn</i>
                          </p>
                          <p>
                            <i class="bi bi-telephone">016541651</i>
                          </p>
                          <p>
                            <i class="bi bi-printer">+01 132 321 76</i>
                          </p>
                        </div>
                      </div>
                    </div>
                </footer>
            </footer>

            
        </div>












	
</body>
</html>