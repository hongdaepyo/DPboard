package com.dphong.DPboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardWebController {
	
	@GetMapping("/main")
	public String main(Model model) throws Exception {
		return "main";
	}
}
