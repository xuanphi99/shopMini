	$(document).ready(function() {

$('button#btnThemSanPham').click(function(event) {
			event.preventDefault();
			var frmData = $('form#form-sanpham').serializeArray();
			console.log(frmData);
		});
	});