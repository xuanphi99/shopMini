package com.trungtamjava.Springmvc;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.trungtamjava.Service.ChiTietHoaDonService;
import com.trungtamjava.Service.DanhMucSanPhamService;
import com.trungtamjava.Service.HoaDonService;
import com.trungtamjava.Service.NhanVienService;
import com.trungtamjava.Service.SanPhamService;
import com.trungtamjava.entity.ChiTietHoaDonId;
import com.trungtamjava.entity.ChiTietSanPham;
import com.trungtamjava.entity.ChiTiethoaDon;
import com.trungtamjava.entity.DanhMucSanPham;
import com.trungtamjava.entity.GioHang;
import com.trungtamjava.entity.HoaDon;
import com.trungtamjava.entity.Json_SanPham;
import com.trungtamjava.entity.MauSanPham;
import com.trungtamjava.entity.NhanVien;
import com.trungtamjava.entity.SanPham;
import com.trungtamjava.entity.SizeSanPham;

@Controller
@SessionAttributes( value = {"user","giohang","dmAjax"})
@RequestMapping("api/")
public class TMP {
	
	private List<SanPham> listDMByID = new ArrayList<SanPham>();
	private String tenDM ;
	  // khai bao class bÃªn service vÃ o IOC
    @Autowired
  private  NhanVienService nhanvienSerice;
	@Autowired
	DanhMucSanPhamService danhmucSPService;
    
	@Autowired
	SanPhamService sanphamService;
	
	@Autowired
	HoaDonService hoadonservice;
	
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;

    @GetMapping("XuLyDangNhap")
    @ResponseBody
    public String XuLyDangNhap(@RequestParam String email , @RequestParam String matkhau, ModelMap map) {	 
    	boolean	value =  nhanvienSerice.XuLyDangNhap(email,matkhau)	;
    	if (value==true) {
    		map.addAttribute("user",email); // luu sessin
    	}
    	return ""+ value;
    }
    
	@GetMapping("XuLyDangKy")
	@ResponseBody
	public String XuLyDangKy(@RequestParam String email , @RequestParam String matkhau , @RequestParam String nhaplaimatkhau,ModelMap map) {	 
		boolean ktEmail = validate(email);
	  	String kqDk = "false";
	  	if (ktEmail) {
	  		
	  		
				 if (matkhau.equals(nhaplaimatkhau)&& isValid(matkhau)==0) {
					NhanVien nVien  = new NhanVien();
					nVien.setEmail(email);
					nVien.setMatKhau(matkhau);
					boolean ktThem = nhanvienSerice.XuLyDangKy(nVien);
					if (ktThem) {	
						kqDk =  "true";		
					}					  
			}
			}
	  	
	  return kqDk;
				}
	
   
	  public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		public static boolean validate(String emailStr) {
			 Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
			 return matcher.find();
		}
		public static int isValid(String password) {  
	        //return true if and only if password:
	        //1. have at least eight characters.
	        //2. consists of only letters and digits.
	        //3. must contain at least two digits.
	        if (password.trim().length() < 8) {   
	            return 1;  
	        } else {      
	            char c;  
	            int count = 1;   
	            for (int i = 0; i < password.length() - 1; i++) {  
	                c = password.charAt(i);  
	                if (!Character.isLetterOrDigit(c)) {          
	                    return 2;  
	                } else if (Character.isDigit(c)) {  
	                    count++;  
	                    if (count < 2)   {     
	                        return 3;  
	                    }     
	                }  
	            }  
	        }  
	        return 0;  
	    }  
	
		 @GetMapping("AddToCast")
		 @ResponseBody
			public String ThemGioHang(@RequestParam int masp,@RequestParam int masize 
					,@RequestParam int mamau,@RequestParam String tensp ,@RequestParam String giatien
					,@RequestParam String tenmau,@RequestParam String tensize ,@RequestParam int soluong
					, @RequestParam int machitiet,String urlAnhSP ,HttpSession httpSession){
			 // náº¿u giá»� hÃ ng chÆ°a cÃ³ 1 so nÃ o
			 if(null == httpSession.getAttribute("giohang") ){
			 List<GioHang> gioHangs = new ArrayList<GioHang>();	
			 GioHang gioHang = new GioHang();
			 	gioHang.setMasp(masp);
				gioHang.setMaSize(masize);
				gioHang.setMaMau(mamau);
				gioHang.setTenSP(tensp);
				gioHang.setGiaSP(giatien);
				gioHang.setTenMau(tenmau);
				gioHang.setTenSize(tensize);
				gioHang.setSoLuong(1);
				gioHang.setMachitiet(machitiet);
				gioHang.setUrlAnhSP(urlAnhSP);
				gioHang.setSoLuongTrongKho(soluong);
				gioHangs.add(gioHang);
			 httpSession.setAttribute("giohang", gioHangs);
//			 List<GioHang> list = (List<GioHang>) httpSession.getAttribute("giohang");
//			 System.out.println(list.size()+" "+ gioHangs.size());
			 return gioHangs.size()+"";
			 }
			 else {
				 List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
				 int check = checkExistCast(listGioHangs,masp, masize, mamau, httpSession);
			//	 ktra 1 san pham Ä‘Ã£ cÃ³ trong gio hang chÆ°a
				if (check==-1) {
				
					 GioHang gioHang = new GioHang();
					 	gioHang.setMasp(masp);
						gioHang.setMaSize(masize);
						gioHang.setMaMau(mamau);
						gioHang.setTenSP(tensp);
						gioHang.setGiaSP(giatien);
						gioHang.setTenMau(tenmau);
						gioHang.setTenSize(tensize);
						gioHang.setSoLuong(1);
						gioHang.setMachitiet(machitiet);
						gioHang.setUrlAnhSP(urlAnhSP);
						gioHang.setSoLuongTrongKho(soluong);
						listGioHangs.add(gioHang);
						return listGioHangs.size()+"";
				} 
				else {
					//neu so luong sp da mua nhá»� hoÆ¡n sá»‘ luong trong kho
					if (listGioHangs.get(check).getSoLuong()<= soluong) {
						listGioHangs.get(check).setSoLuong(listGioHangs.get(check).getSoLuong()+1);
						return listGioHangs.size()+"";	
					}
					return listGioHangs.size()+"";	
				} 
			 } 
			 
		 }	// het AddToCast 
		 
		 private int checkExistCast(List<GioHang> listGioHangs,int masp , int masize, int mamau, HttpSession httpSession) {
				
				for (int i = 0; i < listGioHangs.size(); i++) {
					if (listGioHangs.get(i).getMasp()== masp && listGioHangs.get(i).getMaSize()== masize && listGioHangs.get(i).getMaMau() == mamau) {
						return i;
					}
				}
				
				return -1;
			}
		 
		 // update sá»‘ lÆ°á»£ng vÃ  giÃ¡ tiá»�n giá»� hÃ ng vÃ o session
		 @GetMapping("updateCast")
		 @ResponseBody
		 public void UpdateDatacast(HttpSession httpSession,@RequestParam int soluong,@RequestParam int masp ,@RequestParam int masize,@RequestParam int mamau) {
				if (null !=httpSession.getAttribute("giohang") ) {
					List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri =	checkExistCast(listGioHangs,masp, masize, mamau, httpSession);
			listGioHangs.get(vitri).setSoLuong(soluong);
					//System.out.println("hihihih"+ vitri);
				}
			 
			
		 }
		 
		 // xoa 1 sp trong gio hang 
		 @GetMapping("xoasp")
		 @ResponseBody
		 public void DeleteOfCast(HttpSession httpSession,@RequestParam int masp ,@RequestParam int masize,@RequestParam int mamau) {
				if (null !=httpSession.getAttribute("giohang") ) {
					List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri =	checkExistCast(listGioHangs,masp, masize, mamau, httpSession);
			listGioHangs.remove(vitri);
					//System.out.println("hihihih"+ vitri);
				}
			 
			
		 } 
		 
		 // Dat hang  trong gio hang 
		 @PostMapping("dathang")
		 @ResponseBody
		 public String DatHang(
				 HttpSession httpSession ,
					@RequestParam	String tenKhachHang,
					@RequestParam	String sdt ,
					@RequestParam	String email ,
					@RequestParam	String diachiGiaoHang ,
					@RequestParam	String hinhthucGiaoHang,
					@RequestParam	String GhiChu
				 
				 ) {
				
				// kiem tra xem gio hang co null ko
				if (null !=httpSession.getAttribute("giohang") ) {
					
					
					
					List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
					
					//một Hóa đơn cần cátc huộc tính trên lấy từ form khi submit
					// các thuộc tính còn lại lấy trong gio Hang
					
					HoaDon hoaDon = new HoaDon();
					hoaDon.setTenKhachHang(tenKhachHang);
					hoaDon.setSdt(sdt);
					hoaDon.setDiachiGiaoHang(diachiGiaoHang);
					hoaDon.setHinhthucGiaoHang(hinhthucGiaoHang);
					hoaDon.setGhiChu(GhiChu);
					hoaDon.setNgayLap(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			// 1 hD cần 1 List ChiTietHD
			 // Mà ChiTietHD cần ChiTietHoaDonId 
			// mà ChiTietHoaDonId cần mã ChiTietSP
			// Lấy mã ChiTietSP trong GioHang sd forEach
					
			// hd cần lưu 1 list chitiet HD	
					
			int idHD = 	hoadonservice.themHD(hoaDon);
					
			if (idHD>0) {

				Set<ChiTiethoaDon> chiTiethoaDons = new HashSet<ChiTiethoaDon>();
				
				for (GioHang i : listGioHangs) {
					ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
					chiTietHoaDonId.setMachiTietSanPham(i.getMachitiet());
					chiTietHoaDonId.setMahoaDon(hoaDon.getMahoaDon());
					// gán ChiTietHoaDonId  vào ChiTiethoaDon
					
					ChiTiethoaDon chiTiethoaDon = new ChiTiethoaDon();
					chiTiethoaDon.setChiTietHoaDonId(chiTietHoaDonId);
					chiTiethoaDon.setGiaTien(i.getGiaSP());
					chiTiethoaDon.setSoLuong(i.getSoLuong());
				//	chiTiethoaDons.add(chiTiethoaDon); vì chiTietHdId có mã sp chi tiet ko kết nối đc với bảng Hd	4
				//	hoaDon.setDanhsachchitiethoadon(chiTiethoaDons);
				// khắc phục
				chiTietHoaDonService.ThemChiTietHoaDon(chiTiethoaDon);
				}
				
				System.out.println("yes");	
				return "true";
				
			}
			
			
		
				System.out.println("that bai ");
				return "false";
				
			
			

					
				
				
					
				
					
			     }  // kiem tra null session
				return "false";
				
				
			
			
				
			 
			 
			
		 } // het DatHang
		 
		 
		 //load danhmuc
		 
		 @GetMapping(path = "loaddanhmuc", produces="text/plain; charset=utf-8")
		 @ResponseBody
		 public String LoadDM(@RequestParam int MaDanhMuc,@RequestParam String TenDanhMuc  ) {
			 listDMByID.clear();
				 listDMByID = danhmucSPService.getListCatetogryById(MaDanhMuc);
			tenDM = TenDanhMuc;
				for (SanPham i : listDMByID) {
					System.out.println("ten sp trong api "+i.getTenSanPham());
				}
				String str  = "";
				if (listDMByID.size() == 0) {
					str = " <h3> Danh mục trống </h3>";	
				}
				//khi dm có sp thì trả về list dm theo dang html
				else {
				str = str + " <h3> " + TenDanhMuc + " </h3> ";
				str  = str +	"<div class='container'>";
				str  = str +    "<div class='row'>";
				double  y = 0.1; 
				for (SanPham i : listDMByID) {
					

					String urlAnh = "http://shopmini.j.layershift.co.uk/resources/Image/sanpham/"+i.getHinhSanPham();
					y= y+ 0.05;
					str = str + "<div class='col-md-4 col-lg-3 col-sm-6  '> ";
					str = str + " <div class=\"card text-center wow fadeInDown \"  data-wow-delay=\" "+y+" s \"  > ";
					str = str + " <a href=' "+urlAnh+" ' class=\"work-image\">  ";
					str = str + " <img class='card-img-top' src='"+urlAnh+"'  alt='Card image cap'>  ";
					str = str + " </a> ";
					str = str + " <div class=\"card-body\"> ";
					str = str + " <h4 class=\"card-title tensp\"> " +i.getTenSanPham()  +" </h4>  ";
					str = str + " <p class=\"card-text giasp\"> " + i.getGiaTien() +" VNĐ</p>  ";
					str = str + " <a href='/chitietsanpham/" +i.getMaSanPham() +"' class=\"btn btn-info nutsp\"> Xem chi tiết</a> ";
					str = str + " </div> ";
					str = str + " </div> ";
					str = str + " </div> ";
				}
				str = str + " </div> ";
				str = str + " </div> ";
				
					
					
				}
				// hết else
				return str;
		 }
		 
		 @GetMapping(path="PhanTrang", produces="text/plain; charset=utf-8")
		 @ResponseBody
		 public String PhanTrang(@RequestParam int spbatdau ) {
				
			 String html="";
			 List<SanPham> listSanPhams = sanphamService.listSanPham(spbatdau);
				for (SanPham sanPham : listSanPhams) {
					String urlAnh = "http://shopmini.j.layershift.co.uk/resources/Image/sanpham/"+ sanPham.getHinhSanPham();
					html += "<tr>";
					html += "<td><div class='checkbox'><label><input class='checkboxsanpham' type='checkbox' value='"+sanPham.getMaSanPham()+"'></label></div></td>";
					html+="<td class='hinhsp'>   <img src='"+urlAnh+"' alt='' />  </td>  ";
					html += "<td class='tensp' data-masp='" + sanPham.getMaSanPham() +"'>" + sanPham.getTenSanPham() +"</td>";
					html += "<td class='giatien' >" +sanPham.getGiaTien()  +"</td>";
					html += "<td class='gianhcho'>"+sanPham.getGianhcho() +"</td>";
					html += "<td style='color:white' class='btn btn-warning capnhatsanpham' data-id=" + sanPham.getMaSanPham() + ">Sửa</td>";
					html += "</tr>";
				}
				
				
				return html;
		 }
		 
		 @GetMapping("xoasanpham")
		 @ResponseBody
		 public String xoasanpham(@RequestParam int spxoa) {
			sanphamService.xoaSanPhambyId(spxoa);
			 return "true";
		}
		 
		 @Autowired
		 ServletContext context ;
		 
		 @PostMapping("UploadFile")
		 @ResponseBody
		 public String UploadFile(MultipartHttpServletRequest request) {  // 1 sd httpServerletRequest 2 sd muiltpart
			 Iterator<String> listNames = request.getFileNames(); // lay ds cac ten file
			 MultipartFile mpFile = request.getFile(listNames.next()); // lay tat ca file trong ds 
			 String path_save_file = context.getRealPath("/resources/Image/sanpham/") ; // lay duong dan can luu file vao sd ServletContxt co san cua bean spring khi sd ham realPath se nam o webapp
			 File file_save = new File(path_save_file + mpFile.getOriginalFilename()); // tao bien file de luu file vao thu muc
			 try {
				mpFile.transferTo(file_save); // chuyen vao thu muc
			} catch (Exception e) {
				// TODO: handle exception
			}
		//	 System.out.println(path_save_file);
			 return "true";
		}
		 
		 @PostMapping("themsanpham")
		 @ResponseBody
		 public String themsanpham(@RequestParam String data_themsp) {  // 1 sd httpServerletRequest 2 sd muiltpart
		ObjectMapper objectMapper = new ObjectMapper(); // cho phép map tới 1 json nào đo
		int ii =-1;
		JsonNode jsonNode ;   //  json Oject và Json Array
	//	System.out.println(data_themsp);
		try {
			SanPham sanPham = new SanPham();
			jsonNode = objectMapper.readTree(data_themsp);
			

			DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
			danhMucSanPham.setMaDanhMuc(jsonNode.get("danhmucsanpham").asInt());
			
			
			Set<ChiTietSanPham> liChiTietSanPhams = new HashSet<ChiTietSanPham>();
			//	là json Oject nếu bdd = {} là Json Array
			JsonNode jsonChiTietSP = jsonNode.get("chitietsanpham");	
			for (JsonNode i : jsonChiTietSP) {
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				
				MauSanPham mauSanPham = new MauSanPham();
				mauSanPham.setMamau(i.get("mausanpham").asInt());  // ep ve kieu int
				
				SizeSanPham sizeSanPham = new SizeSanPham();
				sizeSanPham.setMaSize(i.get("sizesanpham").asInt());
				
				chiTietSanPham.setMauSanPham(mauSanPham);
				chiTietSanPham.setSizeSanPham(sizeSanPham);
				chiTietSanPham.setSoluong(i.get("soluong").asInt());
				System.out.println(i.get("mausanpham").asInt()+" "+ i.get("sizesanpham").asInt()+" "+ i.get("soluong").asInt());
				liChiTietSanPhams.add(chiTietSanPham);
			}
		
		String tensanpham = jsonNode.get("tensanpham").asText();	
		String giatien = jsonNode.get("giatien").asText();	
		String hinhsanpham = jsonNode.get("hinhsanpham").asText();	
		String mota = jsonNode.get("mota").asText();	
		String gianhcho = jsonNode.get("gianhcho").asText();	
	//	int masanpham = jsonNode.get("masanpham").asInt();
		sanPham.setLi(liChiTietSanPhams);
		sanPham.setDanhMucSanPham(danhMucSanPham);
		sanPham.setTenSanPham(tensanpham);
		sanPham.setGiaTien(giatien);
		sanPham.setHinhSanPham(hinhsanpham);
		sanPham.setMota(mota);
		sanPham.setGianhcho(gianhcho);
	//	sanPham.setMaSanPham(masanpham);
	 ii =	sanphamService.ThemSp(sanPham);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
		if (ii>0) {
			return "true";
		}
		else {
			return "false";
		}
		}	 
	
		 
// 		 cap nhat sp truyen dl da nhap ra view
		 @PostMapping( path = "capnhatsanpham", produces = "application/json; charset=utf-8")
		 @ResponseBody
		 public Json_SanPham getSanPhamById(@RequestParam int maSanPham) {
			Json_SanPham json_SanPham = new Json_SanPham();
			 SanPham sanPham =sanphamService.listChiTietSanPham(maSanPham);
			
		 json_SanPham.setMasanpham(sanPham.getMaSanPham());
		 json_SanPham.setTensanpham(sanPham.getTenSanPham());
		 json_SanPham.setGiatien(sanPham.getGiaTien());
		 json_SanPham.setMota(sanPham.getMota());
		 json_SanPham.setHinhsanpham(sanPham.getHinhSanPham());
		 json_SanPham.setGianhcho(sanPham.getGianhcho());
			 
			 DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
			 danhMucSanPham.setMaDanhMuc(sanPham.getDanhMucSanPham().getMaDanhMuc());
			 danhMucSanPham.setTenDanhMuc(sanPham.getDanhMucSanPham().getTenDanhMuc());
			 
			 Set<ChiTietSanPham> chiTietSanPhams = new HashSet<ChiTietSanPham>();
		
		//	  chiTietSanPhams = sanPham.getLi();
			 for (ChiTietSanPham i : sanPham.getLi()) {
				 ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
		chiTietSanPham.setMachiTietSanPham(i.getMachiTietSanPham());
				 
				 MauSanPham mauSanPham = new MauSanPham();
				 mauSanPham.setMamau(i.getMauSanPham().getMamau());
				 mauSanPham.setTenmau(i.getMauSanPham().getTenmau());
				 
		chiTietSanPham.setMauSanPham(mauSanPham);
			 	
			 	SizeSanPham sizesanpham = new SizeSanPham();
				sizesanpham.setMaSize(i.getSizeSanPham().getMaSize());
				sizesanpham.setSize(i.getSizeSanPham().getSize());
				
		chiTietSanPham.setSizeSanPham(sizesanpham);
		chiTietSanPham.setSoluong(i.getSoluong());
			
	chiTietSanPhams.add(chiTietSanPham);
				
			}
			 json_SanPham.setDanhMucSanPham(danhMucSanPham);
			 json_SanPham.setChitietsanpham(chiTietSanPhams);
			 
			 System.out.println("hinh " + json_SanPham.getHinhsanpham());
			return json_SanPham;
		}
	 
	// thu sd API 	 
	/*	 @GetMapping(value = "/capnhatsanpham/{maSanPham}",produces = MediaType.APPLICATION_JSON_VALUE)
		    public @ResponseBody void getUser(@PathVariable("maSanPham") int maSanPham) {
		    SanPham sanPham = sanphamService.listChiTietSanPham(maSanPham);
		    System.out.println(sanPham.getGianhcho()+" "+ sanPham.getGiaTien()+" "+sanPham.getHinhSanPham()+" "
		    		+ sanPham.getMaSanPham()+"  "+sanPham.getDanhMucSanPham().getTenDanhMuc() +" "+
		    		sanPham.getLi());
		    }		 
		 */
		 
	// cap nhat sp vao csdl
		 
		 @PostMapping("updatesanpham")
		 @ResponseBody
		 public void updatesanpham(@RequestParam String data_themsp) {  // 1 sd httpServerletRequest 2 sd muiltpart
		ObjectMapper objectMapper = new ObjectMapper(); // cho phép map tới 1 json nào đo
		
		JsonNode jsonNode ;   //  json Oject và Json Array
	//	System.out.println(data_themsp);
		try {
			SanPham sanPham = new SanPham();
			jsonNode = objectMapper.readTree(data_themsp);
			

			DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
			danhMucSanPham.setMaDanhMuc(jsonNode.get("danhmucsanpham").asInt());
			
			
			Set<ChiTietSanPham> liChiTietSanPhams = new HashSet<ChiTietSanPham>();
			//	là json Oject nếu bdd = {} là Json Array
			JsonNode jsonChiTietSP = jsonNode.get("chitietsanpham");	
			for (JsonNode i : jsonChiTietSP) {
				ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
				
				MauSanPham mauSanPham = new MauSanPham();
				mauSanPham.setMamau(i.get("mausanpham").asInt());  // ep ve kieu int
				
				SizeSanPham sizeSanPham = new SizeSanPham();
				sizeSanPham.setMaSize(i.get("sizesanpham").asInt());
				
				chiTietSanPham.setMauSanPham(mauSanPham);
				chiTietSanPham.setSizeSanPham(sizeSanPham);
				chiTietSanPham.setSoluong(i.get("soluong").asInt());
				System.out.println(i.get("mausanpham").asInt()+" "+ i.get("sizesanpham").asInt()+" "+ i.get("soluong").asInt());
				liChiTietSanPhams.add(chiTietSanPham);
			}
		
		String tensanpham = jsonNode.get("tensanpham").asText();	
		String giatien = jsonNode.get("giatien").asText();	
		String hinhsanpham = jsonNode.get("hinhsanpham").asText();	
		String mota = jsonNode.get("mota").asText();	
		String gianhcho = jsonNode.get("gianhcho").asText();
		int masanpham = jsonNode.get("maSanPham").asInt();

		sanPham.setLi(liChiTietSanPhams);
		sanPham.setDanhMucSanPham(danhMucSanPham);
		sanPham.setTenSanPham(tensanpham);
		sanPham.setGiaTien(giatien);
		sanPham.setHinhSanPham(hinhsanpham);
		sanPham.setMota(mota);
		sanPham.setGianhcho(gianhcho);
		sanPham.setMaSanPham(masanpham);
	
		sanphamService.updateSanPham(sanPham);
		
		} catch (Exception e) {
			// TODO: handle exception
	}
		
}	 
		 
		 
} // het class














