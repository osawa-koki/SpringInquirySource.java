package com.example.demo.app.inquiry;

import com.example.demo.service.InquiryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Add annotations here
 */

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

// 	private final InquiryService inquiryService;

	// Add an annotation here
// 	public InquiryController(InquiryService inquiryService){
// 		this.inquiryService = inquiryService;
// 	}


	@GetMapping("/form")
	public String form(InquiryForm inquiryForm, Model model) {
		model.addAttribute("title", "Inquiry Form");
		return "inquiry/form";
	}

	// ブラウザバック用
	@PostMapping("/form")
	public String formGoBack(InquiryForm inquiryForm, Model model) {
		model.addAttribute("title", "Inquiry Form");
		return "inquiry/form";
	}


	@PostMapping("/confirm")
	public String confirm(@Validated InquiryForm inquiryForm, BindingResult result, Model model) {

		 if (result.hasErrors()) {
			 model.addAttribute("title", "Inquiry Form");
			 return "inquiry/form";
		 }

		 model.addAttribute("title", "Confirm Page");

		 return "inquiry/confirm";
	}

	@PostMapping("/complete")
	public String complete(/*Add parameters. */) {

		//hands-on

		//redirect

		return "";
	}

}
