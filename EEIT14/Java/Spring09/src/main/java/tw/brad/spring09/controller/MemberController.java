package tw.brad.spring09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/")
@Controller
public class MemberController {

	@RequestMapping("/")
	public String root() {
		return "redirect:/main";
	}
	
	@GetMapping("/login")
	public String login(
			@RequestParam(value="error", required = false) String error,
			@RequestParam(value="logout", required = false) String logout,
			Model model) {
		if (error != null) model.addAttribute("error", "登入失敗");
		if (logout != null) model.addAttribute("logout", "成功登出");
		return "login";
	}
	
	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("title", "會員主頁");
		return "main";
	}
	
	@GetMapping("/member/page1")
	public String page1(Model model) {
		return "/member/page1";
	}
	
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("title", "管理員主頁");
		return "admin";
	}
	@GetMapping("/page403")
	public String page403() {
		return "page403";
	}
	
}