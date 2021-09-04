<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
<head>
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web Template | Home :: w3layouts</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel='stylesheet' type='text/css' />

<!-- Custom CSS -->

<link href="<c:url value="/resources/css/styleW3.css"/>" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="<c:url value="/resources/css/morris.css"/>" type="text/css"/>
<!-- Graph CSS -->

<link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet"> 
<!-- jQuery -->
 
<script src="<c:url value="/resources/Js/jquery-2.1.4.min.js"/>"></script>

<!-- hiện ảnh -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.0.0/magnific-popup.min.css">

<!-- //jQuery -->
<link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet" href="<c:url value="/resources/css/icon-font.min.css"/>" type='text/css' />
<!-- //lined-icons -->

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"/>
 <script src="https://cdn.jsdelivr.net/npm/animejs@3.0.1/lib/anime.min.js"></script>

<!-- talbe -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8" src="<c:url value="/resources/Js/jquery.dataTables.js"/>"></script>

</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content">
	 <div class="row">
		<div class="col-lg-9 col-sm-12 " style="float:right">
				<button id="btnThemSanPham" class="btn btn-primary"> Thêm sản phẩm </button>
				<button id="xoa-sanpham" class="btn btn-info"> Xóa </button>
		</div>
		<div class="col-md-10 col-sm-12 ">
				<table id="table-sanpham" class="table">
				<thead>
					<tr>
						<th>
							<div class="checkbox">
							  <label><input id="checkall" type="checkbox" value=""></label>
							</div>
						</th>
						<th>Hinh sản phẩm </th>
						<th>Tên sản phẩm </th>
						<th>Giá tiền</th>
						<th>Giành cho</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="value" items="${listSanPham }"> 
						<tr>
							<td>
								<div class="checkbox">
								  <label><input class="checkboxsanpham" type="checkbox" value="${value.getMaSanPham() }"></label>
								</div>
							</td>
								<td class="hinhsp" data-masp=" ${value.getMaSanPham() }"> 
									<a href="<c:url value="/resources/Image/sanpham/${value.getHinhSanPham()}"  />" class="work-image"> 
									<img src="<c:url value="/resources/Image/sanpham/${value.getHinhSanPham()}"  />" alt="">
									</a>
								</td>
							<td class="tensp" data-masp=" ${value.getMaSanPham() }"> ${value.getTenSanPham() }</td>
							<td class="giatien" >${value.getGiaTien() }</td>
							<td class="gianhcho">${value.getGianhcho() }</td>
							<td style="color:white" class="btn btn-warning capnhatsanpham" data-id="${value.getMaSanPham() }">Sửa</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<nav class="menuPhanTrang" aria-label="Page navigation example">
  <ul class="pagination">
    <li class="previ">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
        <span class="sr-only">Previous</span>
      </a>
    </li>
  	<c:forEach var = "i" begin = "1" end = "${tongsopage }">
				
					 <c:choose>
	         
				         <c:when test = "${i == 1 }">
				           <li class="paging-item active"><a href="#">${i}</a></li>
				         </c:when>
				         
				         <c:otherwise>
				             <li class="paging-item"><a href="#">${i}</a></li>
				         </c:otherwise>
				      </c:choose>
					
		     	 </c:forEach>
    <li class="nextpage">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
</nav>
</div>	
		
	</div>
	<!-- het row -->	
	 
	<!--  // phan upload sp -->
	 <div class="UploadSP">
	 	
	 		<form id="form-sanpham" action="">
	 			<label for="tensanpham">Tên sản phẩm </label></br>
			<input type="text" name="tensanpham" id="tensanpham" class="form-control" placeholder="Nhap vao ten san pham"/></br>
			
			<label for="giatien">Giá tiền  </label></br>
			<input type="text" id="giatien" name="giatien" class="form-control" placeholder="Nhap vao gia tien"/></br>
			
			<span>Giành cho</span></br>
			<label class="radio-inline">
		      <input type="radio" id="rd-nam" name="gianhcho" value="nam">Nam
		    </label>
		    <label class="radio-inline">
		      <input type="radio" id="rd-nu" name="gianhcho" value="nu">Nữ
		    </label></br>
			
			</br><label for="danhmucsanpham">Danh mục</label>
			  <select name="danhmucsanpham" class="form-control" id="danhmucsanpham">
			  	<c:forEach var="valuedanhmuc" items="${listDM}">
			  		<option value="${valuedanhmuc.getMaDanhMuc()}">${valuedanhmuc.getTenDanhMuc() }</option>
			  	</c:forEach>
			  </select></br>
			
			<label for="mota">Mô tả </label></br>
			<textarea rows="5" type="text" name="mota" id="mota" class="form-control" placeholder="Nhao vao mo ta" ></textarea></br>
			
			<label for="hinhanh">Hình ảnh  </label></br>
			<input type="file" id="hinhanh" name="hinhanh"  class="form-control" placeholder="Nhap vao gia tien" data-src=""  /> </br>
	<!-- 	// chi tiet sp -->
	<div id="addSp">
	 	<div class="col-md-6 addChitietSp" id="chitiet">
	 	     <div class="chitietsanpham">
					<span>Chi tiết  </labspanel></br>
					 <select  name="mausanpham" class="form-control" id="mausanpham">
					  	<c:forEach var="valuemau" items="${listmau}">
					  		<option value="${valuemau.getMamau()}">${valuemau.getTenmau() }</option>
					  	</c:forEach>
					  </select></br>
					  
					   <select name="sizesanpham" class="form-control" id="sizesanpham">
					  	<c:forEach var="valuesizesanpham" items="${listsize}">
					  		<option value="${valuesizesanpham.getMaSize()}">${valuesizesanpham.getSize() }</option>
					  	</c:forEach>
					  </select></br>
					  
					  <input min="1" value="1" type="number" id="soluong" name="soluong" class="form-control" placeholder="soluong"/></br>
					
					<!--   <button class="btn btn-primary btn-chitiet">Thêm chi tiết </button> -->
				</div>
	 	</div> 
	 </div> <!--  het addSp -->
	 
	 <!-- div dung de copy -->
	 	<div id="divcopy" class="col-md-6 addChitietSp">
	 	     <div class="chitietsanpham">
					<span>Chi tiết  </labspanel></br>
					 <select  name="mausanpham" class="form-control" id="mausanpham">
					  	<c:forEach var="valuemau" items="${listmau}">
					  		<option value="${valuemau.getMamau()}">${valuemau.getTenmau() }</option>
					  	</c:forEach>
					  </select></br>
					  
					   <select name="sizesanpham" class="form-control" id="sizesanpham">
					  	<c:forEach var="valuesizesanpham" items="${listsize}">
					  		<option value="${valuesizesanpham.getMaSize()}">${valuesizesanpham.getSize() }</option>
					  	</c:forEach>
					  </select></br>
					  
					  <input min="1" value="1" type="number" id="soluong" name="soluong" class="form-control" placeholder="soluong"/></br>
					  <button type="button" class="btn btn-primary huychitiet">huy chi tiet</button>
					<!--   <button class="btn btn-primary btn-chitiet">Thêm chi tiết </button> -->
				</div>
	 	</div> 
	 	 <button class="btn btn-primary btn-chitiet">Thêm chi tiết </button>
	<!--  het div dung de copy -->
	 	
	
			<button id="btnThemSanPham" class="btn btn-primary"> Thêm sản phẩm </button>
		<button id="btnCapNhatSanPham" class="btn btn-primary hidden"> cập nhật </button>
				<button id="btnHuyCapNhatSanPham" class="btn btn-primary hidden"> Hủy  </button>
		
			
		</form>
	 </div> 
	 <!-- // het upload them sp -->
	 
	 
</div>
  <!--//eftcontent-inner-->
			<!--/sidebar-menu-->
				<div class="sidebar-menu">
					<header class="logo1">
						<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> 
					</header>
						<div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
                           <div class="menu">
									<ul id="menu" >
										<li><a href="index.html"><i class="fa fa-tachometer"></i> <span>Dashboard</span><div class="clearfix"></div></a></li>
										
										
										 <li id="menu-academico" ><a href="<c:url value="/themsanpham"/>"><i class="fa fa-product-hunt" aria-hidden="true"></i><span>Sản phẩm</span><div class="clearfix"></div></a></li>
									<li><a href="gallery.html"><i class="fa fa-picture-o" aria-hidden="true"></i><span>Gallery</span><div class="clearfix"></div></a></li>
									<li id="menu-academico" ><a href="charts.html"><i class="fa fa-bar-chart"></i><span>Charts</span><div class="clearfix"></div></a></li>
									 <li id="menu-academico" ><a href="#"><i class="fa fa-list-ul" aria-hidden="true"></i><span> Short Codes</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										   <ul id="menu-academico-sub" >
										   <li id="menu-academico-avaliacoes" ><a href="icons.html">Icons</a></li>
											<li id="menu-academico-avaliacoes" ><a href="typography.html">Typography</a></li>
											<li id="menu-academico-avaliacoes" ><a href="faq.html">Faq</a></li>
										  </ul>
										</li>
									<li id="menu-academico" ><a href="errorpage.html"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Error Page</span><div class="clearfix"></div></a></li>
									  <li id="menu-academico" ><a href="#"><i class="fa fa-cogs" aria-hidden="true"></i><span> UI Components</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										   <ul id="menu-academico-sub" >
										   <li id="menu-academico-avaliacoes" ><a href="button.html">Buttons</a></li>
											<li id="menu-academico-avaliacoes" ><a href="grid.html">Grids</a></li>
										  </ul>
										</li>
									 <li><a href="tabels.html"><i class="fa fa-table"></i>  <span>Tables</span><div class="clearfix"></div></a></li>
									<li><a href="maps.html"><i class="fa fa-map-marker" aria-hidden="true"></i>  <span>Maps</span><div class="clearfix"></div></a></li>
							        <li id="menu-academico" ><a href="#"><i class="fa fa-file-text-o"></i>  <span>Pages</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										 <ul id="menu-academico-sub" >
											<li id="menu-academico-boletim" ><a href="calendar.html">Calendar</a></li>
											<li id="menu-academico-avaliacoes" ><a href="signin.html">Sign In</a></li>
											<li id="menu-academico-avaliacoes" ><a href="signup.html">Sign Up</a></li>
											

										  </ul>
									 </li>
									<li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>Forms</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
									  <ul>
										<li><a href="input.html"> Input</a></li>
										<li><a href="validation.html">Validation</a></li>
									</ul>
									</li>
								  </ul>
								</div>
							  </div>
							  <div class="clearfix"></div>		
							</div>
							<script>
							var toggle = true;
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }
											
											toggle = !toggle;
										});
							</script>
<!--js -->
 

<%--   <script type="text/javascript" src="<c:url value="/resources/Js/ConTen.js"/>"></script> 
 --%> 
<%--    <script type="text/javascript" src="<c:url value="/resources/Js/themchitiet.js"/>"></script>
 --%><script src="<c:url value="/resources/Js/jquery.nicescroll.js"/>"></script> 
<script src="<c:url value="/resources/Js/scripts.js"/>"></script>
 <script src="<c:url value="/resources/Js/ConTen.js"/>"></script> 
 
 
 
 <!-- Bootstrap Core JavaScript -->
   <script src="<c:url value="/resources/Js/bootstrap.min.js"/>"></script>
   <!-- /Bootstrap Core JavaScript -->	   
<!-- morris JavaScript -->	
<script src="<c:url value="/resources/Js/raphael-min.js"/>"></script>
<script src="<c:url value="/resources/Js/morris.js"/>"></script>

<!-- Magnific Popup core JS file -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.0.0/jquery.magnific-popup.min.js"></script>
<%-- <script type="text/javascript" src='<c:url value="/resources/Js/ConTen.js"  />'></script>
 --%>

<script>
	$(document).ready(function() {
		//BOX BUTTON SHOW AND CLOSE
	   jQuery('.small-graph-box').hover(function() {
		  jQuery(this).find('.box-button').fadeIn('fast');
	   }, function() {
		  jQuery(this).find('.box-button').fadeOut('fast');
	   });
	   jQuery('.small-graph-box .box-close').click(function() {
		  jQuery(this).closest('.small-graph-box').fadeOut(200);
		  return false;
	   });
	   
	    //CHARTS
	    function gd(year, day, month) {
			return new Date(year, month - 1, day).getTime();
		}
		
		graphArea2 = Morris.Area({
			element: 'hero-area',
			padding: 10,
        behaveLikeLine: true,
        gridEnabled: false,
        gridLineColor: '#dddddd',
        axes: true,
        resize: true,
        smooth:true,
        pointSize: 0,
        lineWidth: 0,
        fillOpacity:0.85,
			data: [
				{period: '2014 Q1', iphone: 2668, ipad: null, itouch: 2649},
				{period: '2014 Q2', iphone: 15780, ipad: 13799, itouch: 12051},
				{period: '2014 Q3', iphone: 12920, ipad: 10975, itouch: 9910},
				{period: '2014 Q4', iphone: 8770, ipad: 6600, itouch: 6695},
				{period: '2015 Q1', iphone: 10820, ipad: 10924, itouch: 12300},
				{period: '2015 Q2', iphone: 9680, ipad: 9010, itouch: 7891},
				{period: '2015 Q3', iphone: 4830, ipad: 3805, itouch: 1598},
				{period: '2015 Q4', iphone: 15083, ipad: 8977, itouch: 5185},
				{period: '2016 Q1', iphone: 10697, ipad: 4470, itouch: 2038},
				{period: '2016 Q2', iphone: 8442, ipad: 5723, itouch: 1801}
			],
			lineColors:['#ff4a43','#a2d200','#22beef'],
			xkey: 'period',
            redraw: true,
            ykeys: ['iphone', 'ipad', 'itouch'],
            labels: ['All Visitors', 'Returning Visitors', 'Unique Visitors'],
			pointSize: 2,
			hideHover: 'auto',
			resize: true
		});
		
	   
	});
	</script>
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>
</html>