package com.example.demo.config;

import com.example.demo.service.InquiryNotFoundException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class WebMvcControllerAdvice {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
			dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	// SQLのセレクト結果が一件もなかった場合
	// data.sqlの「inquiry」に対するINSERT文を削除して、「http://localhost:8080/sample/test」へアクセス。
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public String handleException(EmptyResultDataAccessException e, Model model) {
		model.addAttribute("message", e);
		return "error/CustomPage";
	}
	
	@ExceptionHandler(InquiryNotFoundException.class)
	public String handleException(InquiryNotFoundException e, Model model) {
		model.addAttribute("message", e);
		return "error/CustomPage";
	}
   
}
