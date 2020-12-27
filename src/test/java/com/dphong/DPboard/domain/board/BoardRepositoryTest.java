package com.dphong.DPboard.domain.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository repository;
	
	@Test
	public void insertBoardAndReadTest() {
		//given
		repository.save(Board.builder()
				.name("테스터")
				.email("test@test.com")
				.title("테스트 게시글")
				.content("테스트 게시글 입니다.")
				.build());
		
		//when
		List<Board> board = repository.findAll();
		
		
		//then
		Board sampleBoard = board.get(0);
		
		assertThat(sampleBoard).isNotNull();
		assertThat(sampleBoard.getName()).isEqualTo("테스터");
	}
}
