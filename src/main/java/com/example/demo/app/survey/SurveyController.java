package com.example.demo.app.survey;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.SurveyService;

/*
 * Add annotations here
 */
public class SurveyController {
	
	private final SurveyService surveyService;
	
	public SurveyController(SurveyService surveyService){
		this.surveyService = surveyService;
	}
	
	@GetMapping
	public String index(Model model) {
		
		//hands-on
		
		return "survey/index";
	}
	
	@GetMapping("/form")
	public String form(/*Add parameters.*/) {
		
		//hands-on
		
		return "survey/form";
	}
	
	@PostMapping("/form")
	public String form(SurveyForm surveyForm, Model model) {
		
		//hands-on
		
		return "survey/form";
	}
	
	
	@PostMapping("/confirm")
	public String confirm(/*Add parameters.*/) {
		
		//hands-on
		
		return "survey/confirm";
	}
	
	@PostMapping("/complete")
	public String complete(/*Add parameters.*/) {
		
		//hands-on
		
		return "";
	}
	
}
