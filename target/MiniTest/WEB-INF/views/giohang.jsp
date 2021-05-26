<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Gio hang</title>
<jsp:include page="header.jsp"/>
<%-- <link  href="<c:url value="/resources/Bootstrap/bootstrap.min.css"/>" rel="stylesheet">
<link  href="<c:url value="/resources/css/styleTrangchu.css"/>" rel="stylesheet">
<link  href="<c:url value="/resources/css/animate.min.css"/>" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"/>

<!-- hiện ảnh -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.0.0/magnific-popup.min.css">

<!-- talbe -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">


<script type="text/javascript" src='<c:url value="/resources/css/wow.min.js"  />'></script>



<script> new WOW().init(); </script>
 --%>

</head>
<body>


		<div class="MenuChiTiet">
		<div class="headerChitiet container-fluid">
		
		<!-- 		phan menu -->
	
	
		<nav class="navbar navbar-expand-lg navbar-light bg-light maumenu">
  <a class="navbar-brand "  href="#">
  	
  		<div class="quanlyml">
								<span class="fname">Đ</span> <span class="fname">o</span> <span
									class="fname">à</span> <span class="fname">n</span> <span
									class="fname">x</span> <span class="fname">u</span> <span
									class="fname">â</span> <span class="fname">n</span> <span
									class="fname">P</span> <span class="fname">h</span> <span
									class="fname">i</span>
							</div> <!-- ekdkdk -->
  
  </a>
<!--    phan nay de menu thu nhu
 -->  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse itemmenu  " id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto  itemmenutrai wow fadeInDown  "  data-wow-delay="0.5s" data-wow-delay="1s">
      <li class="nav-item active">
        <a class="nav-link" href=' <c:url value="/trangchu"/>   '>Trang chủ <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Dịch vụ</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Danh mục
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
         
          <c:forEach var="danhMucSP" items="${danhmucsanpham}">
			  <a class="dropdown-item" href='<c:url value="/danhmuc/${danhMucSP.getMaDanhMuc()}/${danhMucSP.getTenDanhMuc() }"/> '> ${danhMucSP.getTenDanhMuc()}</a>
				
				</c:forEach>
         
         
        </div> 
        
        
      </li>
      </ul> 
<!--       het iemtrai -->
     <ul  class="navbar-nav itemphai " data-login="${chucaidau}">
				<c:choose>
					<c:when test="${chucaidau != null }">
			<li class="nav-item ">
			<a class=" nav-link circle-avartar" href=' <c:url value="/dangnhap"/>   '>
			<span> ${chucaidau }</span>
			</a>
			
			</li>
		</c:when>
					
					<c:otherwise>
			<li class="nav-item ">	<a class="nav-link LinkDangNhap" href=' <c:url value="/dangnhap"/>   '>
				Đăng nhập
				</a>	
				</li>
					</c:otherwise>
				</c:choose>

     	
<!-- 	<div class="shoppingCast"> -->
     	 <li class="nav-item ParentShoppingCast ">
     	  <a class="logogioohang" href=' <c:url value="/giohang"/>   '>
     <img alt="anh bia" src='<c:url value="/resources/Image/ic_shopping_cart_white_24dp_1x.png" />'>
     
     <c:if test="${SumCast > 0 }">
			        	 <span id="giohang" class="sumCast">${SumCast } </span>
			        </c:if>
			        
			        <c:if test="${SumCast <= 0 || SumCast == null  }">
			        	 <span id="giohang" class=""> </span>
			        </c:if>
      	 </a>
		</li>

	</ul>
  </div>
</nav>
</div>
</div>
<!-- het menu -->

    <div class="Messenger alert alert-warning alert-dismissible fade show">
    <svg fill="currentColor" preserveAspectRatio="xMidYMid meet" height="1em" width="1em" viewBox="0 0 40 40" style="vertical-align:middle"><g><path d="m31.7 16.4q0-0.6-0.4-1l-2.1-2.1q-0.4-0.4-1-0.4t-1 0.4l-9.1 9.1-5-5q-0.5-0.4-1-0.4t-1 0.4l-2.1 2q-0.4 0.4-0.4 1 0 0.6 0.4 1l8.1 8.1q0.4 0.4 1 0.4 0.6 0 1-0.4l12.2-12.1q0.4-0.4 0.4-1z m5.6 3.6q0 4.7-2.3 8.6t-6.3 6.2-8.6 2.3-8.6-2.3-6.2-6.2-2.3-8.6 2.3-8.6 6.2-6.2 8.6-2.3 8.6 2.3 6.3 6.2 2.3 8.6z"></path></g></svg>
  <strong class="TextOne">Thêm vào giỏ hàng thành công!</strong> 
  <button type="button" class="close nutX" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
  <a class="btn-view-cart" herf="">Xem giỏ hàng và thanh toán</a>
</div>

<!--  Start body -->


		<div class="container-fluid">
			<div class="row phanDongGiohang">
			 <c:if test="${SumCast > 0 }">
				<div class="col-lg-9 col-sm-12 ">
			
			
			        <h5 class="tieuDeGioHang">Thông tin giỏ hàng</h5>
				<table class="table" id= "">
					<thead>
						<tr>
							<td><h5>Hinh san pham</h5></td>
							<td><h5>ten san pham</h5></td>
							<td><h5>Size</h5></td>
							<td><h5>Mau san pham</h5></td>
							<td><h5>so luong</h5></td>
							<td><h5>Gia tien</h5></td>
							<td><h5>Xử  lý</h5></td>
						</tr>
					</thead>	
	
						<tbody>
					
								<c:forEach var="ListGioHang" items="${ListGioHang}">
								<tr>
								<td >
				<a href=" ${ListGioHang.getUrlAnhSP() }" class="work-image"> 
						<img class="anhsp"  src='${ListGioHang.getUrlAnhSP() } ' alt="" />
						</a>
								</td>
								<td class="tensp" data-Masp="${ListGioHang.getMasp() }" ">${ListGioHang.getTenSP() }
									</td>
								
								</td>
									<td class="size" data-maSize="${ListGioHang.getMaSize() }" >${ListGioHang.getTenSize() }
									</td>
									<td class="mau" data-MaMau="${ ListGioHang.getMaMau() } ">${ListGioHang.getTenMau() }
									</td>
									<td class="amount">
									
										
									<div class="input-group nhomSoLuong">
										<span class="decrease"  title = "Giảm Số Lượng " >-</span>
											<input type="number" min="1" max="${ListGioHang.getSoLuongTrongKho()}" value="${ListGioHang.getSoLuong() }" class="input giohang_SoLuong" data-countPrev="${ListGioHang.getSoLuong() }"  data-SoLuongKho="${ListGioHang.getSoLuongTrongKho()}" />
									
										<span class="increase"  data-toggle="tooltip" data-placement="bottom" title = "Thêm Số Lượng ">+</span>
										</div>
										
									
										
									</td>
									<td class="giaTien"   data-giaTien="${ListGioHang.getGiaSP() }"     >${ListGioHang.getGiaSP() }
									</td>
									<td class="xoaGioHang"> <button type="button" class="btn btn-warning btn-de" data-soluong="${SumCast}">Xoa </button>
									
									</td>
	</td>
								</tr>
							</c:forEach>
							
	
	
						</tbody>
					
				</table>
			
			      
			      <h5 class="TongTienDonHang">Tong tien : 1,500,000 VNĐ</h5>
			        
			 </div>
		
			<div class="col-lg-3 col-sm-12 ">
				 <h5 class="tieuDeGioHang" >Thông tin khách hàng</h5>
				 	
				 <!-- 	<form action="#" method="post"> -->
				 	
					  <div class="form-group">
					      <label for="tenKhachHang">Ten Khach Hang :</label>
					      <input  type="text" class="form-control" id="tenKhachHang" placeholder="Enter Name" name="tenKhachHang"   required>
					    </div>
					     <div class="form-group">
					      <label for="sdt">SĐT Khach Hang :</label>
					      <input type="text" class="form-control" id="sdt" placeholder="Enter SDT" name="sdt" required pattern="[0][0-9]{9}" title="Nhập lại SĐT" >
					    </div>
					    
					     <div class="form-group">
					      <label for="email">Email Khach Hang :</label>
					      <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" required >
					    </div>
					    
			 			
			 			 <div class="form-check">
							  <label class="form-check-label active">
							    <input checked="" type="radio" class="form-check-input " name="hinhthucGiaoHang" value="Giao hàng tận nơi">Giao hàng tận nơi
							  </label>
							</div>
							<div class="form-check">
							  <label class="form-check-label">
							    <input type="radio" class="form-check-input" name="hinhthucGiaoHang" value="Nhận tại cửa hàng">Nhận tại cửa hàng
							  </label>
							</div>
			 			
			 			   <div class="form-group">
					      <label for="diachiGiaoHang">Địa chỉ nhận hàng :</label>
					      <input type="text" class="form-control" id="diachiGiaoHang" placeholder="Enter Address" name="diachiGiaoHang" required>
					    </div>
			 			
			 			<div class="form-group">
					  <label for="GhiChu">Comment:</label>
					  <textarea class="form-control" rows="5" id="GhiChu" name="GhiChu"></textarea>
					</div>
					 <button type="submit" class="btn btn-primary dathang">Đặt hàng</button>
			<!--  </form> -->
			</div> 
			 </c:if>
		
		 <c:if test="${SumCast <= 0 || SumCast == null  }">
		 		<div class="col-md-12 text-md-center mt-2 emptyCast ">
			        	 <img alt="anh shopping" src='<c:url value="/resources/Image/mascot.png" />'>
			        	 <h5>giỏ hàng trống tiếp tục mua sắm</h5>
			        <a href=' <c:url value="/trangchu"/>   '  > <button class="btn btn-outline-info"> Về trang chủ</button></a>	
			</c:if>
		
			 <div class="alert alert-warning alert-dismissible thongBaoHetHang">
										  <button type="button" class="close" data-dismiss="alert">&times;</button>
								 	    <strong>Warning!</strong> Số lượng sản phẩm trong kho không đủ  sản phẩm
				 </div>
			
			 <div class="alert alert-success alert-dismissible thongBaoDatHang">
										  <button type="button" class="close" data-dismiss="alert">&times;</button>
								 	    <strong>Success!</strong>Đặt hàng thành công Vui lòng Check Email
				 </div>
		
		
		</div>  <!-- // het row -->


		</div> <!--  het container-fluid-body -->
	</div>
		
		




<!--  End body -->
	
	
	
<!--  het ndgiua -->

		
	
			<!-- footer -->
			<div id="footer">
	<div  class="container">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow tada">
				<p><span class="title-footer">THÔNG TIN SHOP</span></p>
				<span>Yame là một thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng.</span>
			</div>
			
			<div class="col-sm-4 col-md-4 wow tada">
				<p><span class="title-footer">LIÊN HỆ</span></p>
				<span>43Nam Giang Nam Trực Nam định</span>
				<span>Doanxuanphi@gmail.com</span>
				<span>0909489834</span>
			</div>
			
			<div class="col-sm-4 col-md-4 wow tada">
				<p><span class="title-footer">GÓP Ý</span></p>
			<!-- 	<form action="" method="post"> -->
					<input name="tenNhanVien" class="material-textinput" style="margin-bottom: 8px" type="text" placeholder="Email"/>
					<textarea name="tuoi" style="margin-bottom: 8px" rows="4" cols="50" placeholder="Nội dung"></textarea>
					<button class="btn btn-primary review">ĐỒNG Ý</button>
				<!-- </form> -->
				
			</div>
		</div>
		
	</div>
</div>
			<!-- end footer  -->
		
		
<%-- 	


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script type="text/javascript" src='<c:url value="/resources/Js/jquery-3.2.1.min.js"  />'></script>		

 <script src="https://cdn.jsdelivr.net/npm/animejs@3.0.1/lib/anime.min.js"></script>


<!-- jQuery 1.7.2+ or Zepto.js 1.0+ -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<!-- Magnific Popup core JS file -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.0.0/jquery.magnific-popup.min.js"></script>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- table -->

<script type="text/javascript" charset="utf8" src="<c:url value="/resources/Js/jquery.dataTables.js"/>"></script>
<script type="text/javascript" src='<c:url value="/resources/Js/ConTen.js"  />'></script>
 --%>
</body>
</html>