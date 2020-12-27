package com.dphong.DPboard.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dphong.DPboard.dto.BoardCreateRequestDto;
import com.dphong.DPboard.dto.BoardDto;
import com.dphong.DPboard.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardWebController {
	
	private BoardService boardService;
	
	@GetMapping("/main")
	public String main(Model model) throws Exception {
		return "main";
	}
	
	@GetMapping("/all")
	@ResponseBody
	public List<BoardDto> getAllBoardList(Model model) {
		log.debug("getAllBoardList started");
		
		List<BoardDto> boardList = boardService.getAllBoardList();
		
		log.debug("getAllBoardList ended");
		return boardList;
	}
	
	@PostMapping("/create")
	@ResponseBody
	public Long createBoardItem(@RequestBody BoardCreateRequestDto dto) {
		Long id = boardService.createBoardItem(dto.toEntity());
		return id;
	}
}
