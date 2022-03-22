package com.campus.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String home() {
		return "loginForm";
	}
	
	@PostMapping("loginOk")
	@ResponseBody
	public String loginOk(String userid, String userpwd) {
		if(userid.equals("abcd") && userpwd.equals("1234")) {
			return "Y";
		}
		return "N";
	}
}
