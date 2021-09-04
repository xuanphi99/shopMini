package com.trungtamjava.Springmvc;

import javax.persistence.NoResultException;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHand {

	
	@ExceptionHandler(value = {Exception.class , NoResultException.class})
	public String error(Exception exception,ModelMap m) {
		System.out.println(exception);
	//	System.out.println("Đã xảy ra lỗi"+exception);
		return "error";
	}
	
}
