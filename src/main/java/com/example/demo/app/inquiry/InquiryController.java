package com.example.demo.app.inquiry;

import com.example.demo.entity.Inquiry;
import com.example.demo.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

/*
 * Add annotations here
 */

@Controller
@RequestMapping("/inquiry")
public class InquiryController {
		private final InquiryService inquiryService;

	 @Autowired
	 public InquiryController(InquiryService inquiryService) {
		 this.inquiryService = inquiryService;
	 }

	 @GetMapping
	 public String index(Model model) {
		 List<Inquiry> list = inquiryService.getAll();

		 model.addAttribute("inquiryList", list);
		 model.addAttribute("title", "Inquiry Index");

		 return "inquiry/index";
	 }

	// Add an annotation here
// 	public InquiryController(InquiryService inquiryService){
// 		this.inquiryService = inquiryService;
// 	}


	// フラッシュスコープを使用する場合には「ModelAttribute("★attributesName★")」を使用する。
	@GetMapping("/form")
	public String form(InquiryForm inquiryForm, Model model, @ModelAttribute("complete") String complete) {
		model.addAttribute("title", "Inquiry Form");
		return "inquiry/form";
	}

	// ブラウザバック用
	@PostMapping("/form")
	public String formGoBack(InquiryForm inquiryForm, Model model) {
		model.addAttribute("title", "Inquiry Form");
		return "inquiry/form";
	}


	// 「BindingResult」でバリデーションチェック結果によって処理を分岐
	@PostMapping("/confirm")
	public String confirm(@Validated InquiryForm inquiryForm, BindingResult result, Model model) {

		 if (result.hasErrors()) {
			 model.addAttribute("title", "Inquiry Form");
			 return "inquiry/form";
		 }

		 model.addAttribute("title", "Confirm Page");

		 return "inquiry/confirm";
	}

	// 今回はフラッシュスコープを使用するため、「RedirectAttributes」が必要
	@PostMapping("/complete")
	public String complete(@Validated InquiryForm inquiryForm, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			model.addAttribute("title", "Inquiry Form");
			return "inquiry/form";
		}

		// データベースの登録処理
		// フォームデータからエンティティへの詰め直し
		Inquiry inquiry = new Inquiry();
		inquiry.setName(inquiryForm.getName());
		inquiry.setEmail(inquiryForm.getEmail());
		inquiry.setContents(inquiryForm.getContents());
		inquiry.setCreated(LocalDateTime.now());

		inquiryService.save(inquiry);

		redirectAttributes.addFlashAttribute("complete", "Registered");

		return "redirect:/inquiry/form";
	}

}
