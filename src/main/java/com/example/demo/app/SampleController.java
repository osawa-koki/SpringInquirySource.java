package com.example.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Add annotations here
 */


// コントローラクラスとして宣言
@Controller
// 「/sample」に対するアクセスに対応
@RequestMapping("/sample")
public class SampleController {
	
// 	private final JdbcTemplate jdbcTemplate;

// 	//Add an annotation here 
// 	public SampleController(JdbcTemplate jdbcTemplate) {
// 		this.jdbcTemplate = jdbcTemplate;
// 	}

	// 「/sample/test」へのアクセスに対応
	@GetMapping("/test")
	public String index(Model model) {
		
		// データ(モデル)をHTMLに渡す
		model.addAttribute("title", "Inquiry Form");

		return "test";
	}

}
