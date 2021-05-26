	$(document).ready(function() {
		
		
	//animate Logo
		
		let animation = anime({
		    targets: '.fname',
		    opacity: 1,

		    translateY: [-50,0], 
		    rotate: {
		      value: 360,
		      duration: 3000,
		      easing: 'easeInExpo'
		    }, 
		    scale: anime.stagger([0.7, 1], {from: 'center'}), 
		    delay: anime.stagger(100, {start: 1000}), 
		    translateX: [-10, 30],
		    endDelay: 1500,

		    direction: 'alternate',

		    loop : true
		  }); 
		
	//review gop y
		 $('.review').click(function () {
			 swal("Thông Báo!", "Cảm ơn bạn đã phản hồi! :)) ");

			 
		 })

		
		
		// click me
		
		 $('.clickme').click(function () {
			 swal("Thông Báo!", "Rất Tiếc đã hết Sản Phẩm! :)) ");

			 
		 })
	
		
		
		// check so uong gio hang Cast
		
		itemCount  = $('#giohang').text();
		
		if(itemCount == 0){
			$('#giohang').hide();
		}
		
	//load more
		var soLuongLoadMore = 0;
		var distanceLoadMore = 4;
		var wit =window.innerWidth;
		//&& $(window).width >= 768
		console.log(wit);
		if ( wit < 992 && wit >= 768) {
			soLuongLoadMore = 3;
			distanceLoadMore = 3;
			
		}
		else {
			soLuongLoadMore = 4;
			distanceLoadMore =4;
			
		}
	
		$('.itemsanPham').hide();
		 $('.itemsanPham').slice(0, soLuongLoadMore).show();
		 
		
		 

			// countItem = $('.itemsanPham').attr("data-Countitem-Show");
			 countItem = distanceLoadMore;
			  countItem = parseInt(countItem);
			  
			  $(".itemsanPham").slice(0, soLuongLoadMore).show();
			    $("#loadMore").on('click', function (e) {
			    	 countItem = countItem +distanceLoadMore;
			        e.preventDefault();
			        $(".itemsanPham:hidden").slice(0,soLuongLoadMore).slideDown();
			   
			        
			        if ($(".itemsanPham:hidden").length == 0) {
			            $("#load").fadeOut('slow');
			        }
			        $('html,body').animate({
			            scrollTop: $(this).offset().top
			        }, 1500);
			        console.log(countItem+ " "+$('.itemsanPham').length);
			        // check de hidden load more
			        if($('.itemsanPham').length <= countItem ){
						  $("#loadMore").hide();
					  }

			        
			    });
			  
	//	  });
		 
		 
		 //back to top
		
		 $('a[href=#top]').click(function () {
			    $('body,html').animate({
			        scrollTop: 0
			    }, 1000);
			    return false;
			});
		 
		 $(window).scroll(function () {
			    if ($(this).scrollTop() > 50) {
			        $('.totop a').fadeIn();
			    } else {
			        $('.totop a').fadeOut();
			    }
			}); 
		 
		
		$('.btnDangNhap').click(function(event) {
		var email = $('.email').val(); 
		var matkhau = $('.matkhau').val();
		
	
		$.ajax({
			url: '/api/XuLyDangNhap',
			type: 'GET',
			dataType : 'json',
			data: {
				email: email,
				matkhau: matkhau
			},
			success : function(value) {
			  if (value == true) {
				
			 	$('#kqdn').text('Dang nhap thanh cong');
				var  urlCurrent = 	window.location.href;
				var urlWise = urlCurrent.replace("dangnhap","trangchu");
				window.location = urlWise;
				console.log(urlCurrent);
				console.log(urlWise);
			  }
			  else {
			  	$('#kqdn').text('Dang nhap that bai');
			  }
			}


		}); // het ajax
		
	}); // het btndangnhap

		$('#Formdangnhap').click(function(event) {
			$('.container-login-form') .show();
			
			$('#Formdangnhap') .addClass('actived');
			$('.container-signup-form') .hide();
			$('#Formdangky') .removeClass('actived');
			
		});
		$('#Formdangky').click(function(event) {
			$('.container-login-form') .hide();
			
			$('#Formdangnhap') .removeClass('actived');
			$('.container-signup-form') .show();
			$('#Formdangky') .addClass('actived');
			
		});
		
		
		
		$('#xulydk').click(function(event) {
			
			
			var emaildk = $('#emaildk').val(); 
			var nhaplaimatkhau = $('.nhaplaimatkhau').val(); 
			var matkhaudk = $('#matkhaudk').val();
			$.ajax({
				url: '/api/XuLyDangKy',
				type: 'GET',
				dataType : 'json',
				data: {
					email: emaildk,
					matkhau: matkhaudk,
					nhaplaimatkhau : nhaplaimatkhau
				},
				success : function(kqDk) {
					
					
				  if (kqDk ==true) {
					  $('#ketqua0').text("");  
					  $('#ketquadky1').text(""); 
					  $('#ketquadky2').text(""); 
				  	$('#ketquadky3').text('Dang ky thanh cong');
				  	$('.email').val(emaildk); 
				  	$('.matkhau').val(matkhaudk); 
				  	$('.btnDangNhap').trigger('click'); 
				var  urlCurrent = 	window.location.href;
				var urlWise = urlCurrent.replace("dangnhap","trangchu");
				window.location = urlWise;
				  }
				  else {
					  if (IsEmail(emaildk)==false) {
						  $('#ketqua0').text("vui lòng nhập đúng định dạng email abc@gmail.com");  
					  }
					  else  if (checkPasswordStrength(matkhaudk)) {
						  $('#ketqua0').text("");  
						  $('#ketquadky1').text(" mat khau > 8  ki tu"); 
						  }
						 
					  else  if (nhaplaimatkhau!=matkhaudk) {
						  $('#ketqua0').text("");  
						  $('#ketquadky1').text(""); 
						  $('#ketquadky2').text(" mat khau khong trung nhau"); 
						  }
					
					  
				  }
				}


			}); // het ajax
			
			
		});


		
		function IsEmail(email) {
			  var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			  if(!regex.test(email)) {
			    return false;
			  }else{
			    return true;
			  }
		
		}
		function checkPasswordStrength(matkhau) {
			if (matkhau.length < 8) {
				return 1;		
			}
			
			
			
			
		}
		
		
		$('.showmk').click(function(event) {

			var x = document.getElementById("matkhaudk");
			  if (x.type === "password") {
			    x.type = "text";
			  } else {
			    x.type = "password";
			  }
			  var y = document.getElementById("matkhaunhaplaidk");
			  if (y.type === "password") {
			    y.type = "text";
			  } else {
			    y.type = "password";
			  }
			  var y = document.getElementById("matkhau");
			  if (y.type === "password") {
			    y.type = "text";
			  } else {
			    y.type = "password";
			  }
		});
//	show mat khau 	
		
		 // xu ly gio hang

		$('.Addtocast').click(function(event) {
			$('.Messenger').hide();
		var tensize= 	$(this).parent().siblings('.size').text();
		var tenmau= 	$(this).parent().siblings('.mau').text();
		var soluong= 	$(this).parent().siblings('.amount').text();
		var giatien= 	$('.gia').text();
		var tensp= 	$('.tenspchitiet').text();
		var masp= 	$('.tenspchitiet').attr("data-masp");
		var mamau= 	$(this).parent().siblings('.mau').attr("data-MaMau");
		var masize=$(this).parent().siblings('.size').attr("data-Masize");
		var machitiet=$(this).parent().siblings('.size').attr("data-machitiet");
		var urlAnhSP = $('.anhSPChitiet').attr("data-urlAnhSP");
	//	 console.log(urlAnhSP); 	
//	 console.log(tensize +" -"+ tenmau +" -"+soluong+"-" +giatien+"-"+tensp+" -"+masp+" "+mamau+" "+masize+" "+machitiet+" "); 
	
		
		
			$.ajax({
				url: '/api/AddToCast',
					type: 'GET',
					dataType : 'json',
					data: {
						masp:masp,
				    	masize:masize,
				    	mamau:mamau,
				    	tensp: tensp,
				    	giatien:giatien,
				    	tenmau:tenmau,
				    	tensize:tensize,
				    	soluong:soluong,
				    	machitiet:machitiet,
				    	urlAnhSP:urlAnhSP
				    	
		  },
			success : function(value) {
				$('#giohang').show();
				$("#giohang").addClass("sumCast");
			//	$("#giohang").html("<span>" + value + "</span>") ;
				$("#giohang").html(value);
				
				$('.Messenger').show();
				
				 $('body,html').animate({
				        scrollTop: 0
				    }, 1000);
				
			}
			
			
		})
			
	
		});
		 // het xu ly gio hang 
		$('.btn-view-cart').click(function(event) {
			window.location.href = "/giohang";

			
		});
		$('body').click(function(event) {
			$('.Messenger').hide();

			
		});
	
	
// click load danhmuc


		$('.clickdm').hide();	//an khoi danh muc dl
$('.DM').click(function(event) {
		var MaDanhMuc =$(this).attr("data-idDM");
		var TenDanhMuc =$(this).text();	
		$('.pageDetail8').hide();
		$('.pageDetail2').hide();
	console.log(MaDanhMuc+" "+ TenDanhMuc);
			$.ajax({
				url: '/api/loaddanhmuc',
					type: 'GET',
//					dataType : 'json',
// ben ajax controller de produces = "text/plain" len datatype k dc de json
					data: {
					MaDanhMuc: MaDanhMuc,
		    		TenDanhMuc: TenDanhMuc
		  },
			success : function(value,status) {
				
				if(value == 0){
					console.log("0");
					$('.tuLoad').hide();
					$('.clickdm').show();
				}
				else {
				$('.tuLoad').hide();
				
				$('.clickdm').empty();
				$('.clickdm').append(value);
				$('.clickdm').show();	
			}
			//	window.location = "http://localhost:8080/MiniTest/danhmuc/"+MaDanhMuc+"/"+TenDanhMuc;
			
			}
		})

	});	
	
	

	
	
// hàm tính tng tien khi vừa load vào page gioHang
		var SoLuongKhoClick= 0;
		SumOfCastLoader();
  
		
		
		$('.giohang_SoLuong').click(function(event) {
			
			var sum  = 		$(this).val();
			var soLuongKho =$(this).attr("data-SoLuongKho");	
			
			if (parseInt(sum)>=parseInt(soLuongKho)&& SoLuongKhoClick==0){
				
				$('.thongBaoHetHang').addClass('hienTbHetHang');
			}
			else {
				
				 SoLuongKhoClick= 0;
				$('.thongBaoHetHang').removeClass('hienTbHetHang');
			}
			
		
		
			
		});
		
		
		 
// xử lí khi thay đổi số lượng giỏ hàng
		$('.giohang_SoLuong').change(function(event) {
	var sum  = 		$(this).val();
	var soLuongKho =$(this).attr("data-SoLuongKho");
	console.log(sum+" "+soLuongKho); 
	if (parseInt(sum)<=parseInt(soLuongKho)) {
	
	
			 SoLuongKhoClick= 1;
		
		
		var costtmp1 = 	    $(this).parent().parent().siblings('.giaTien').attr("data-giaTien"); 
		var tien = format(sum,costtmp1);
		 $(this).parent().parent().siblings('.giaTien').html("Gia : "+ tien+" VNĐ" );
		 SumOfCastLoader(); // hàm tự động tính tiền khi mới load trang
		 // phần sd ajaxx luwu lại thay đổi
		 var soluong= 	sum;
		var giatien = 	costtmp1;		
			var masp= 	$(this).parent().parent().siblings('.tensp').attr("data-masp");
			var mamau=  $(this).parent().parent().siblings('.mau').attr("data-MaMau");
			var masize= $(this).parent().parent().siblings('.size').attr("data-maSize");
			$.ajax({
				url	: '/api/updateCast',
					type: 'GET',
					dataType : 'json',
					data: {
						masp:parseInt(masp),
				    	masize:parseInt(masize),
				    	mamau:parseInt(mamau),		  	    	
				    	soluong:parseInt(soluong)				
		  },
			success : function(value) {
				
			}
		}) // het xử lí ajax lưu thay đổi
		
	}
			
		});

		//  xoas 1 sp trong gio hang
		
		$('.btn-de').click(function(event) {
			
	// link : https://sweetalert.js.org/guides/#getting-started	
			swal({
				  title: "Bạn chắc chắn?",
				  text: "Xóa Sản phẩm khỏi giỏ hàng!",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willDelete) => {
				  if (willDelete) {
					  //xoa
				    swal("Poof! Đã xóa sản phẩm khỏi giỏ hàng!", {
				      icon: "success",
				    });
				
			
			
			
			
			var This = $(this);
			var masp= 	$(this).parent().siblings('.tensp').attr("data-masp");
			var mamau=  $(this).parent().siblings('.mau').attr("data-MaMau");
			var masize= $(this).parent().siblings('.size').attr("data-maSize");
			console.log("ma size= "+ masize +" ma sp = "+masp+" ma mau  "+ mamau );
			var sum =parseInt($('#giohang').text());
			console.log("tong so luong  = "+ sum);
			$(this).parent().parent().remove();
			SumOfCastLoader();
			
			
				$('#giohang').html(sum-1);
			
			if (sum==1) {

					window.location.href = "/giohang";	
				
			}
//			
			
			$.ajax({
				url: '/api/xoasp',
					type: 'GET',
					dataType : 'json',
					data: {
						masp:parseInt(masp),
				    	masize:parseInt(masize),
				    	mamau:parseInt(mamau)
						
		  },
			success : function(value) {
				console.log(value);
			}
	
		}); // het ajax
			
				  }  // het xoa
				  else {
					  //khong xoa
				   
		 }
		}); // het alert xac nhan xoa sp
		
	})		// end xoa sp

//check number phone	

	function checkPhone(number){
		var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;
		 if(number !==''){
		        if (vnf_regex.test(number) == false) 
		        {
		            alert('Số điện thoại của bạn không đúng định dạng!');
		            return false
		        }else{
		          
		            return true;
		        }
		    }else{
		        alert('Bạn chưa điền số điện thoại!');
		        return false;
		    }
		}
	
	
//end checknumber phone

		//check email
		function validateEmail(email) 
	    {
	        var re = /\S+@gmail.com/;
	        return re.test(email);
	    }
	    
	
		//end check mail
		
		
	//Cick dat hang
	$('.dathang').click(function(event) {
	//	event.preventDefault();
		
		var tenKhachHang= $('#tenKhachHang').val();
		var sdt= $('#sdt').val();
		var email= $('#email').val();
		var diachiGiaoHang= $('#diachiGiaoHang').val();
		var GhiChu= $('#GhiChu').val();
		
		var hinhthucGiaoHang = $("input[name='hinhthucGiaoHang']:checked").val();
		
		
		if(tenKhachHang === '' ){
			swal("Thông Báo!", "Nhập lại Tên KH!");

		}
		else if(!checkPhone(sdt)){
			swal("Thông Báo!", " Nhập lại SDT!");

		}
		else if(!validateEmail(email)){
			swal("Thông Báo!", " Nhập lại Email!");

		}
		
	
		
		else {
		
		$.ajax({
			url: '/api/dathang',
				type: 'POST',
				
				data: {
					tenKhachHang:tenKhachHang,
			    	sdt:sdt,
			    	email:email,
			    	diachiGiaoHang: diachiGiaoHang,
			    	GhiChu : GhiChu,
			    	hinhthucGiaoHang: hinhthucGiaoHang
	  },
		success : function(value) {
			if(value == 'true'){
				$('.thongBaoDatHang').addClass('HienthongBaoDatHang');
				swal("Thông Báo !","Đặt hàng thành công!", "success");
				
			}
			else {
				$('.thongBaoDatHang').removeClass('HienthongBaoDatHang');
			}
			
		}

	}); // het ajax
} // het else	
		
	})
	
	// het cick dat hang
	
	
	
	//phan trang
	
	$('.paging-item').click(function(event) {
		
		$('.paging-item').removeClass('active');
		$(this).addClass('active');
		var sotrang = $(this).text();
		var spbatdau = (sotrang - 1) * 3;
	//	console.log("san pham bd "+spbatdau);
		LoadSpadmin(spbatdau);
//		$.ajax({
//			url:"/MiniTest/api/PhanTrang",
//		    type:"GET",
//		    data:{
//		    	spbatdau:spbatdau,
//		    	
//		    },
//			success: function(value){
//				var tbodysanpham = $("#table-sanpham").find("tbody");
//				tbodysanpham.empty();
//				tbodysanpham.append(value);
//			}
//		})
		
	});
	
		$('.previ').click(function(event) {
			 var pagecurrent =parseInt( $('li.paging-item.active').text());
			  var pageFirst = parseInt($('.paging-item:first').text());
		if (pagecurrent>pageFirst) {
		$('.paging-item').removeClass('active');
		   $('.paging-item').eq(pagecurrent-2).addClass('active');
		   var spbatdau1 =  $('.paging-item').eq(pagecurrent-2).text();
		    var spbatdau =( spbatdau1-1)*3
		    //	console.log( $('.paging-item').eq(pagecurrent-2).text());
		    	LoadSpadmin(spbatdau);
		}
			
		
		});
		$('.nextpage').click(function(event) {
			  var pagecurrent =parseInt( $('li.paging-item.active').text());
			  var pageLast = parseInt($('.paging-item:last').text());
			//  console.log(pagecurrent+" "+pageLast);
			  if (pagecurrent < pageLast ) {
			  	
			   	$('.paging-item').removeClass('active');
		   $('.paging-item').eq(pagecurrent).addClass('active');
		   var   spbatdau1 =$('.paging-item').eq(pagecurrent).text();
		var spbatdau =( spbatdau1-1)*3
			    	console.log( $('.paging-item').eq(pagecurrent).text());
	//	console.log("san pham bdnext "+spbatdau);
			    	 LoadSpadmin(spbatdau);
			    	

			    	
			    	
			    	
			   }
			 
			});	
		
		
	
	//end phan trang
// check tat ca sp
		$("#checkall").change(function(event) {
			if (this.checked) {
				 $(".checkboxsanpham").each(function(){
			    		$(this).prop('checked', true);
			  		});
			}
			else {
				 $(".checkboxsanpham").each(function(){
			    		$(this).prop('checked', false);
			  		});
			}
		});	
		
		
		$('#xoa-sanpham').click(function(event) {
			$('input.checkboxsanpham').each(function(index, el) {
				if (this.checked) {
				var spxoa =	$(this).val();
				var This  = 	$(this);
				This.closest("tr").remove();
				
			$.ajax({
				url:"/api/xoasanpham",
			    type:"GET",
			    data:{
			    	spxoa:spxoa,
			    	
			    },
				success: function(value){
				This.closest('tr').remove();
				}
			})  // het ajax

		}
				else {
					console.log("sai");
				}
		});
			
		});
		
		
// end chat tat ca sp	

		// upload file
		
		var files=[];
		var tenhinh="";
		$("#hinhanh").change(function(event){
		
		files	= event.target.files  // laasy tat ca cac file thong so
		tenhinh = files[0].name;
		console.log(files);
		forms = new FormData();  // them the form de gui dl trong html
		forms.append("file",files[0]);  // tao 1 bien ten file gan gia tri trong mang file vua lay ddc
		
		$.ajax({
			url:"/api/UploadFile",
		    type:"POST",
		    data:forms,  // kieu dl the form vua tao
		    contentType:false,  // do file dc ma hoa ra nhieu ki tu nen phai sd pt Post , va contentype khong dinh dan ai file da ma hoa
		    processData:false,  // dung xl the form de gui dl
		    enctype: "multipart/form-data", // khi gui dl data can sd enctype de ma hoa
			success: function(value){
				
			}
		})
		
		
		})	
		// het upload file
// xu li them chi tpet san pham
		
		$('body').on('click', '.btn-chitiet', function(event) {
			event.preventDefault();  // dừng load lai trang
	var chitietSp = $('#divcopy').clone().removeAttr('id');
	$('#addSp').append(chitietSp);
//	$(this).remove();	
});
		
		$('button#btnThemSanPham').click(function(event) {
			event.preventDefault();  // dừng load lai trang
			var frmData = $('form#form-sanpham').serializeArray();  // nhan tat ca dl từ input
			json ={};
			$.each(frmData, function(index, filed) {
				 json[filed.name] = filed.value;
			});
			
			ArrChiTiet =[];
			// lay dl tu frm chitiet
			$("#addSp >.addChitietSp").each(function(index, el) {
				TmpFrmChiTiet = {};
				mausanpham = $(this).find('select[name ="mausanpham"]').val();
				sizesanpham = $(this).find('select[name ="sizesanpham"]').val();
				soluong = $(this).find('input[name ="soluong"]').val();
		TmpFrmChiTiet["mausanpham"] = mausanpham;
		TmpFrmChiTiet["sizesanpham"] = sizesanpham;
		TmpFrmChiTiet["soluong"] = soluong;
	//	console.log(mausanpham +" "+ sizesanpham+" " + soluong);
		ArrChiTiet.push(TmpFrmChiTiet);
			});  // het for chitietsp h
			
//			console.log(JSON.stringify(json));

			//console.log(json_encode(json));
			 // push mang chi tiet sp vao json
			 json["chitietsanpham"] = ArrChiTiet;
			 json["hinhsanpham"] = tenhinh;
			 console.log(json);
			
			$.ajax({
				url:"/api/themsanpham",
			    type:"POST",
			    dataType: json,
			    data:
			    {
			    	data_themsp : JSON.stringify(json)  // convert dl json thanh chuoi gui sang api
			    },	
			  
				success: function(value){
					if (value == "true") {
						alert("them thanh cong");
					}
				}
			})
			
			
				
		});
		
// het them chi tiet sp		
	
		
// cap nhat san pham vao Data
	var	maSanPham = 0;
		$('#btnCapNhatSanPham').click(function(event) {
			event.preventDefault();
			// copy code lay dl tu form dua vao json de sd ajax chuyen qua controller
			
			var frmData = $('form#form-sanpham').serializeArray();  // nhan tat ca dl từ input
			json ={};
			$.each(frmData, function(index, filed) {
				 json[filed.name] = filed.value;
			});
			
			ArrChiTiet =[];
			// lay dl tu frm chitiet
			$("#addSp >.addChitietSp").each(function(index, el) {
				TmpFrmChiTiet = {};
				mausanpham = $(this).find('select[name ="mausanpham"]').val();
				sizesanpham = $(this).find('select[name ="sizesanpham"]').val();
				soluong = $(this).find('input[name ="soluong"]').val();
		TmpFrmChiTiet["mausanpham"] = mausanpham;
		TmpFrmChiTiet["sizesanpham"] = sizesanpham;
		TmpFrmChiTiet["soluong"] = soluong;
	//	console.log(mausanpham +" "+ sizesanpham+" " + soluong);
		ArrChiTiet.push(TmpFrmChiTiet);
			});  // het for chitietsp h
			
			console.log(JSON.stringify(json));

			
			 // push mang chi tiet sp vao json
			 json["chitietsanpham"] = ArrChiTiet;
			 
	if (tenhinh == '') {
		tenhinh = $('#hinhanh').attr('data');
	}		 
			 
			 json["hinhsanpham"] = tenhinh;
			 json["maSanPham"] = maSanPham;
			 console.log(json);
			
			$.ajax({
				url:"/api/updatesanpham",
			    type:"POST",
			    dataType: json,
			    data:
			    {
			    	data_themsp : JSON.stringify(json)  // convert dl json thanh chuoi gui sang api
			    },	
			  
				success: function(value){
					
						alert("update thanh cong");
					
				}
			})
			
			
			
		});
		
// add dl co san vao form		
		$('body').on('click', '.capnhatsanpham', function(event) {
			maSanPham = $(this).attr("data-id");
		//	alert(masanpham);
		
			$('#btnCapNhatSanPham').removeClass('hidden');
			$('#btnHuyCapNhatSanPham').removeClass('hidden');
			$('button#btnThemSanPham').addClass('hidden');
			
			$.ajax({
				url:"/api/capnhatsanpham/",
			    type:"Post",
			   
			    data:
			    {
			    	 maSanPham: maSanPham,
			    },	
			  
				success: function(value){
				//	console.log(value);
					$('#tensanpham').val(value.tensanpham);
					$('#giatien').val(value.giatien);
					$('#mota').val(value.mota);
					$('#hinhanh').attr('data', value.hinhsanpham);
					if(value.gianhcho == "nam"){
						$('#rd-nam').prop("checked",true);
					}
					else {
						$('#rd-nu').prop("checked",true);
						
					}
				
					$('#danhmucsanpham').val(value.danhMucSanPham.maDanhMuc);
					
					$('#addSp').empty();
			
					var countchitiet = value.chitietsanpham.length;
				
					for(i=0; i<countchitiet;i++){
						
						var chitietSp = $('#divcopy').clone().removeAttr('id');
						if (i==0) {
							chitietSp.find(".huychitiet").remove();
						}
						
//						if(i < countchitiet - 1){
//							chitietSp.find(".btn-chitiet").remove();
//						}
						chitietSp.find("#mausanpham").val(value.chitietsanpham[i].mauSanPham.mamau);
						chitietSp.find("#sizesanpham").val(value.chitietsanpham[i].sizeSanPham.maSize);
						chitietSp.find("#soluong").val(value.chitietsanpham[i].soluong);
						console.log(value.chitietsanpham[i].sizeSanPham.size);
						$("#addSp").append(chitietSp);	
						
					}
					
					
				}
			})
			
			
		});/*het cap nhat sp */
	
		// huy 1 chitiet
		
		$('body').on('click', '.huychitiet', function(event) {
			event.preventDefault();
			
			$(this).parent().parent().parent().remove();
			
		});
		
		// het huy chi tiet
		
		
		
// các hàm dùng lại
		function LoadSpadmin(spbatdau) {
			$.ajax({
				url:"/api/PhanTrang",
			    type:"GET",
			    data:{
			    	spbatdau:spbatdau,
			    	
			    },
				success: function(value){
					var tbodysanpham = $("#table-sanpham").find("tbody");
					tbodysanpham.empty();
					tbodysanpham.append(value);
					
				}
			})
	}	
		
		
		// hàm định dạng tiền tệ
		 function format(sum,costtmp1) {
			 var costtmp2=   costtmp1.replace('Giá : ','');
			
			 var arr = costtmp2.split("",costtmp2.length);
			 var tmp ="";
			 for (var i = 0; i < arr.length; i++) {
			 	if (arr[i]==',') {
			 		tmp =tmp;
			 	}
			 	else{
			 		tmp=tmp+arr[i];
			 	} 
			 }
			 
	 
			 
			var cost = parseFloat(tmp.replace(' VNĐ',''));
			var sumCast = (cost * sum); 
		

		var tong =  dinhdangCurrent(sumCast);
		
				return tong;
			 }
		
		function dinhdangCurrent(tongdon) {
			
			 var sumCast = tongdon.toString();
				var sumTmp = "";
				var res = sumCast.split("",sumCast.length);
				var dem =0;
				for (var i =res.length-1 ; i >=0 ; i--) {
					dem++;
					if (dem%3==0) {
						sumTmp=sumTmp+res[i]+".";
						dem=0;
					}
					else {
						sumTmp=sumTmp+res[i];
					}
					
				}
				var tong ="";
				for (var i =  sumTmp.length-1; i>=0 ; i--) {
					if ( i==sumTmp.length-1 && sumTmp[i] == '.') {
						tong =tong;
						

					}
					else {
						tong =tong+sumTmp[i]; }
				} 
			return tong;
		}// end dinhdangCurrent.
	
// ham tự động loader
		 function SumOfCastLoader() {
				var sumArr=[];  // mang so luong
				var CostArr=[];   // mang gia tien
				var i=0;
					 $('.giaTien').each(function() {
						 				
						var costtmp1 = 	$(this).attr("data-giaTien");
					CostArr[i]=costtmp1;
					i++;
						 });
					 //giohang_SoLuong
					 
					var j =0; 
					 $('.giohang_SoLuong').each(function() {
			 				
							var costtmp1 = 	$(this).val();
							sumArr[j]=costtmp1;
						 //console.log(costtmp1); 
					j++;
							 });
					 
				//	 console.log(sumArr[0]);
					 var trig =0,tongdon=0;
					 
					 $('.giaTien').each(function() {
					var tien	= format(sumArr[trig],CostArr[trig]);
//					console.log(sumArr[trig]+" " + CostArr[trig]); 
					var arr = tien.split("",tien.length);
					// khi String to Float thì sẽ mất các số 0 đằng sau nên cần xl như sau
					var tmp ="";
					for (var i = 0; i < arr.length; i++) {
						if (arr[i]==','||arr[i]=='.') {
							tmp =tmp;
						}

						else{
							tmp=tmp+arr[i];
						} 
					}
					 
					tongdon = tongdon + parseFloat(tmp);
							 	$(this).html(" Giá : "+ tien+" VNĐ" );
							 
						trig++;
							 });
					 
				 // dinh dang tong tien
					
				var tong =	 dinhdangCurrent(tongdon);
					 
						$('.TongTienDonHang').html("Tổng tiền "+ tong + " VNĐ");

						
						return tong;
			 
					 
			}
		
		//click detail img
		 $('.work-image').magnificPopup({
			
		      type: 'image'
		      
		    });
		
		
	});
	
	
	
	
	
	