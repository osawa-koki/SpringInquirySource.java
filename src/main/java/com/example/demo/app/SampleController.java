package com.example.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;


// コントローラクラスとして宣言
@Controller
// 「/sample」に対するアクセスに対応
@RequestMapping("/sample")
public class SampleController {
	
	private final JdbcTemplate jdbcTemplate;

	public SampleController(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}

	// 「/sample/test」へのアクセスに対応
	@GetMapping("/test")
	public String index(Model model) {
		
		// データ(モデル)をHTMLに渡す
		String sql = "";
		sql += " SELECT id, name, email ";
		sql += " FROM inquiry ";
		sql += " WHERE id = 1; ";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);

		model.addAttribute("title", "Inquiry");
		model.addAttribute("name", map.get("name"));
		model.addAttribute("email", map.get("email"));

		// 「test.html」を対象にレンダリング
		return "test";
	}

}
