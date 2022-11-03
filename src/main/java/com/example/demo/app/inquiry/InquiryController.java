package com.example.demo.app.inquiry;

import com.example.demo.service.InquiryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 	public InquiryController(InquiryService inquiryService){
 		this.inquiryService = inquiryService;
 	}

	@GetMapping
	public String index(Model model) {

		//hands-on

		return "inquiry/index";
	}

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("title", "Inquiry Form");
		return "inquiry/form";
	}

	@PostMapping("/form")
	public String formGoBack(InquiryForm inquiryForm, Model model) {
		model.addAttribute("title", "InquiryForm");
		return "inquiry/form";
	}


	@PostMapping("/confirm")
	public String confirm(/*Add parameters. */) {

		//hands-on

		return "inquiry/confirm";
	}

	@PostMapping("/complete")
	public String complete(/*Add parameters. */) {

		//hands-on

		//redirect

		return "";
	}

}
