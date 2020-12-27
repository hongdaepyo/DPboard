package com.dphong.DPboard.dto;

import java.time.LocalDateTime;

import com.dphong.DPboard.domain.board.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardDto {
	private Long id;
	private String name;
	private String email;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@Builder
	public BoardDto(Board board) {
		this.id = board.getId();
		this.name = board.getName();
		this.email = board.getEmail();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.createdAt = board.getCreatedAt();
		this.updatedAt = board.getUpdatedAt();
	}
}
