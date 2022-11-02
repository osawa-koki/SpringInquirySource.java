package com.example.demo.app;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Add annotations here
 */
public class SampleController {
	
// 	private final JdbcTemplate jdbcTemplate;

// 	//Add an annotation here 
// 	public SampleController(JdbcTemplate jdbcTemplate) {
// 		this.jdbcTemplate = jdbcTemplate;
// 	}
	
	@GetMapping
	public String test(Model model) {
		
		//hands-on

		return "test";
	}

}
