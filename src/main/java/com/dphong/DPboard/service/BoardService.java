package com.dphong.DPboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dphong.DPboard.domain.board.Board;
import com.dphong.DPboard.domain.board.BoardRepository;
import com.dphong.DPboard.dto.BoardDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
	final private BoardRepository boardRepository;
	
	@Transactional
	public List<BoardDto> getAllBoardList() {
		List<Board> boardList = boardRepository.findAll();
		List<BoardDto> boardDtoList = fromBoardEntityToDto(boardList);
		return boardDtoList;
	}
	
	@Transactional
	public Long createBoardItem(Board board) {
		log.info("createBoardItem started");
		Long id = boardRepository.save(board).getId();
		
		log.info("created board Id = {}", id);
		
		log.info("createBoardItem ended");
		return id;
	}
	
	private BoardDto fromBoardEntityToDto(Board board) {
		return BoardDto.builder().board(board).build();
	}
	
	private List<BoardDto> fromBoardEntityToDto(List<Board> boardList) {
		List<BoardDto> boardDtoList = new ArrayList<BoardDto>();
		
		for (int i = 0; i < boardList.size(); i++) {
			boardDtoList.add(fromBoardEntityToDto(boardList.get(i)));
		}
		
		return boardDtoList;
	}
}
