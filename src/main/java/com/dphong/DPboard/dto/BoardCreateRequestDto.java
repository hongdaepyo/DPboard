package com.dphong.DPboard.dto;

import com.dphong.DPboard.domain.board.Board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardCreateRequestDto {
	private String name;
	private String email;
	private String title;
	private String content;
	
	public Board toEntity() {
		return Board.builder()
				.name(name)
				.email(email)
				.title(title)
				.content(content)
				.build();
	}
}
