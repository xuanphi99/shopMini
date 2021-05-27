<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">



<title>Shop Mini</title>
<jsp:include page="header.jsp"/>
<%-- <link href="<c:url value="/resources/Bootstrap/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styleTrangchu.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/css/animate.min.css"/>"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css" />

<!-- hiện ảnh -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.0.0/magnific-popup.min.css">



<script type="text/javascript"
	src='<c:url value="/resources/css/wow.min.js"  />'></script>
<script>
	new WOW().init();
</script> --%>




</head>
<body>

<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v10.0&appId=159490242814839&autoLogAppEvents=1" nonce="3AMC9C7K"></script>


	<div class="trangchu">
		<div class="trangchuPanMenu">

			<div class="header container-fluid">

				<!-- 		phan menu -->


				<nav class="navbar navbar-expand-lg navbar-light bg-light maumenu">
					<a class="navbar-brand "  href="#"> 
				<%-- data-wow-duration="1s"
						data-wow-iteration="5" wow flash  <img alt="anh bia" src='<c:url value="/resources/Image/icon_yame_shop.png" />'> --%>



					
							<!-- 			        	<img src="images/logo.png" alt="">
 --> <!-- aksksksk -->

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
 -->
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse itemmenu  "
						id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto  itemmenutrai wow fadeInDown  "
							data-wow-delay="0.5s" data-wow-delay="1s">
							<li class="nav-item active"><a class="nav-link" href="#">Trang
									chủ <span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Dịch
									vụ</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> Danh Mục </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">


									<c:forEach var="danhMucSP" items="${danhmucsanpham}">
										<a class="dropdown-item"
											href='<c:url value="/danhmuc/${danhMucSP.getMaDanhMuc()}/${danhMucSP.getTenDanhMuc() }"/> '>
											${danhMucSP.getTenDanhMuc()}</a>

									</c:forEach>

									<!--   <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
           -->


								</div></li>
						</ul>
						<!--       het iemtrai -->
						<ul class="navbar-nav itemphai ">
							<c:choose>
								<c:when test="${chucaidau != null }">
									<li class="nav-item " data-dn="noNull"><a class=" nav-link circle-avartar"
										href=' <c:url value="/dangnhap"/>   '> <span>
												${chucaidau }</span>
									</a></li>
								</c:when>

								<c:otherwise>
									<li class="nav-item " data-dn="null"><a class="nav-link"
										href=' <c:url value="/dangnhap"/>   '> Đăng nhập </a></li>
								</c:otherwise>
							</c:choose>


							<!-- 	<div class="shoppingCast"> -->

							<li class="nav-item ParentShoppingCast "><a
								class="logogioohang updateGioHangTrangChu"
								href=' <c:url value="/giohang"/>   '> <img alt="anh bia"
									src='<c:url value="/resources/Image/ic_shopping_cart_white_24dp_1x.png" />'></a>

								<c:if test="${SumCast > 0 }">
									<span id="giohang" class="sumCast gioHangTrangchu">${SumCast }
									</span>
								</c:if> <c:if test="${SumCast <= 0 || SumCast == null  }">
									<span id="giohang" class=""> ${SumCast }</span>
								</c:if></li>
							<!-- 		</div> -->
						</ul>
					</div>
				</nav>
				<!-- het menu -->
			</div>
			<!--  hết header -->


		</div>
		<!-- // end mt -->

		<!-- ndgiua -->
		<div class="ndgiua wow rollIn">
			<p class="itemndgiua">ngay 04/06/2020</p>
			<h1 class="textndgiua">mua 1 tặng 1</h1>
			<button type="button" class="btn btn-info clickme">Click me</button>


		</div>
		<!--  het ndgiua -->
	</div>


	<!--  phan than
 -->

	<div class="container info  ">
		<div class="row">
			<div class="col-md-4 nd1khoiinfo wow fadeInDown"
				data-wow-delay="0.5s">
				<img class="icon"
					src='<c:url value="/resources/Image/icon_chatluong.png" />' alt="">
				<br> <span style="font-size: 32px; font-weight: 500;">CHẤT
					LƯỢNG</span><br /> <span>Chúng tôi cam kết sẽ mang đến cho các bạn
					chất lượng sản phẩm tốt nhất</span>
			</div>
			<div class="col-md-4 nd1khoiinfo wow fadeInDown" data-wow-delay="1s">
				<img class="icon"
					src='<c:url value="/resources/Image/icon_conheo.png"/>' /><br /> <span
					style="font-size: 32px; font-weight: 500;">TIẾT KIỆM CHI PHÍ</span><br />
				<span>Cam kết giá rẻ nhất Việt Nam giúp các bạn tiết kiệm hơn
					20%cho từng sản phẩm</span>
			</div>
			<div class="col-md-4 nd1khoiinfo wow fadeInDown"
				data-wow-delay="1.5s">
				<img class="icon"
					src='<c:url value="/resources/Image/icon_giaohang.png"/>' /><br />
				<span style="font-size: 32px; font-weight: 500;">GIAO HÀNG</span><br />
				<span>Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm
					đếncho khách hàng nhanh nhất</span>
			</div>
		</div>
	</div>
	<!--  het phan info
 -->

	<!--  phan sp hot -->
	<div  class="container" id="title-sanpham ">
		<span class="sphot">SẢN PHẨM HOT</span>
		<div class="row">
			<%
				double x = 0.1;
			%>
			<c:forEach var="SanPhamThuI" items="${listSanPham}">
				<%
					x = x + 0.05;
				%>
				<div class=" col-6 col-sm-6 col-md-4 col-lg-3 itemsanPham "
					data-attr="${SizelistSanPham}" data-Countitem-Show="4">
					<div class="card text-center wow animate__zoomIn "
						data-wow-delay="<%=x%>s">
						<a
							href=" <c:url value="/resources/Image/sanpham/${ SanPhamThuI.getHinhSanPham()}"/> "
							class="work-image"> <img class="card-img-top"
							src="<c:url value="/resources/Image/sanpham/${ SanPhamThuI.getHinhSanPham()}"/>"
							alt="Card image cap">
						</a>
						<div class="card-body">
							<h4 class="card-title tensp">${SanPhamThuI.getTenSanPham()}
							</h4>
							<p class="card-text giasp">${SanPhamThuI.getGiaTien()}VNĐ</p>
							
							<!-- //nut thich -->
							<div class="fb-like" data-href="https://shopmini-demo.herokuapp.com/" data-width="100" data-layout="button_count" data-action="like" data-size="small" data-share="true"></div>
							
							
							<a
								href='  <c:url value="/chitietsanpham/${SanPhamThuI.getMaSanPham()}"/> '
								class="btn btn-info nutsp">Xem chi tiết</a>
						</div>
					</div>
				</div>
			</c:forEach>

			


		</div>
	</div>


<a href="#" id="loadMore">Load More</a>

			<p class="totop">
				<a href="#top">Back to top</a>
			</p>


	<!--  het sp hot -->
	<!-- footer -->
	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-md-4 wow tada">
					<p>
						<span class="title-footer">THÔNG TIN SHOP</span>
					</p>
					<span>MiniShop là một thương hiệu thời trang đầy uy tín, luôn
						đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng.</span>
				</div>

				<div class="col-sm-4 col-md-4 wow tada">
					<p>
						<span class="title-footer">LIÊN HỆ</span>
					</p>
					<span>TT số 5 , Nam giang Nam Trực Nam Định</span> <span>doanxuanphi2@gmail.com</span>
					<span>0345329009</span>
				</div>

				<div class="col-sm-4 col-md-4 wow tada">
					<p>
						<span class="title-footer">GÓP Ý</span>
					</p>
					<!-- <form action="" method="post"> -->
						<input name="tenNhanVien" class="material-textinput"
							style="margin-bottom: 8px" type="text" placeholder="Email" />
						<textarea name="tuoi" style="margin-bottom: 8px" rows="4"
							cols="50" placeholder="Nội dung"></textarea>
						<button class="btn btn-primary review">ĐỒNG Ý</button>
					<!-- </form> -->

				</div>
			</div>

		</div>
	</div>
	<!-- end footer  -->





<%-- 	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>

 <script src="https://cdn.jsdelivr.net/npm/animejs@3.0.1/lib/anime.min.js"></script>

	<!-- jQuery 1.7.2+ or Zepto.js 1.0+ -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

	<!-- Magnific Popup core JS file -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.0.0/jquery.magnific-popup.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript"
		src='<c:url value="/resources/Js/ConTen.js"  />'></script>

 --%>
</body>
</html>