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

	@Autowired
    private UserService userService;
	
	@GetMapping("/login") public String showLoginPage() {return "login";}
	
	@PostMapping("/login") public String login(@RequestParam String userId, @RequestParam String password, HttpSession session, Model model) {
		if (userService.validateUser(userId, password)) {
            User user = userService.getUser(userId);
            session.setAttribute("user", user); //유저정보 저장
			
            return "메인 페이지 만들면 바꿔야해";
        } else { model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다."); return "login"; }
	}
	
	@GetMapping("/logout")public String logout(HttpSession session) {session.invalidate(); return "redirect:/login";}

}
