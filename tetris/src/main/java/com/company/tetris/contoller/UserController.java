package com.company.tetris.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.tetris.service.UserService;

@Controller
public class UserController {
	private UserService userService = new UserService();
	
	@GetMapping("/login") public String showLoginPage() {return "login";}
	
	@PostMapping("/login") public String login(@RequestParam String userId, @RequestParam String password, HttpSession session, Model model) {
		if(userService.validdateUser(userId, password)) {session.setAttribute("user", userId); return "나중에만들어질메인페이지";}
		else {model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다."); return "login";}
	}
	
	@GetMapping("/logout")public String logout(HttpSession session) {session.invalidate(); return "redirect:/login";}

}
