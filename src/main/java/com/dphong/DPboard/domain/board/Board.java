package com.dphong.DPboard.domain.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Board {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String email;
	private String title;
	private String content;
	
	@Column(name = "read_count")
	private int readCount;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@Builder
	public Board (String name, String email, String title, String content) {
		this.name = name;
		this.email = email;
		this.title = title;
		this.content = content;
		this.readCount = 0;
	}
}
