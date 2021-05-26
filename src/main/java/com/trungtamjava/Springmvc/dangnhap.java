package com.trungtamjava.Springmvc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.trungtamjava.Service.NhanVienService;
import com.trungtamjava.entity.NhanVien;

@Controller
@RequestMapping("/dangnhap")
public class dangnhap {
	
	@Autowired
	NhanVienService nhanVienService;
	
    @GetMapping	
	public String Default(HttpSession httpSession, ModelMap map 
			
			) {
    
    	// neu nhu dang nhap roi
    	 if (httpSession.getAttribute("user")!=null) {
 			String email = (String) httpSession.getAttribute("user");
 			NhanVien nVien = nhanVienService.XuLyDangNhap(email, "*");
 			
 		//	System.out.println( " dang nhap "+ nVien.getMaNhanVien());
 			map.addAttribute("nhanvien", nVien);
 			
 		
 		//	map.addAttribute("chucaidau", email);

 			
 		}
    	// het da dang nhap 
    	 else {
    		 map.addAttribute("chucaidau", "");
    	 }
  
		return "dangnhap";
	}
    
    @PostMapping
    public   String update(HttpSession httpSession,ModelMap map, @ModelAttribute("nhanvien") @Valid NhanVien nhanvien ,BindingResult result ) {
    	System.out.println(nhanvien.getEmail()+ " "+ nhanvien.getMatKhau() + " "+ nhanvien.getMaNhanVien());
    		String errPass = "";
    
    	if (result.hasErrors()) {
    		System.out.println("errror");
    		
    		
    	    return "dangnhap";
    	    }
    	else {
    	
    		// nếu ko co error
    		if (!nhanvien.getMatKhau().equals(",") && nhanvien.getMatKhau().split("\\,").length ==2 ) {
    			String mk1 = nhanvien.getMatKhau().split("\\,")[0].trim();
    			String mk2 = nhanvien.getMatKhau().split("\\,")[1].trim();
    		
    			if (!mk1.equals(mk2)) {
					System.out.println("ko trung khop");
					errPass = "Mật Khẩu mới Không Khớp";
					map.addAttribute("errPass",errPass);
					return "dangnhap";
				}
    			else {
    				System.out.println("ok");
    				nhanvien.setMatKhau(mk1);
    		nhanVienService.updateNV(nhanvien);
    		return "redirect:/trangchu";
    			}
    			
			}
//    		else {
//    			System.out.println("nhập Mật Khẩu");	
//    			map.addAttribute("errPass", "Nhập Mật Khẩu");
//    			return "dangnhap";
//    		}
    		
    		
    	}
    	
    	
    	return "dangnhap";
	} 

    
    @GetMapping("logout")
    public String dangxuat(HttpSession httpsession) {
		
    httpsession.removeAttribute("user");
    System.out.println("remove user");
   return "redirect:/trangchu" ;
    	 
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
  
}
