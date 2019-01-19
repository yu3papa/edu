package com.kosta.helloboot.board.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Board {

	private long postId;
	
	@NotEmpty(message="subject field is mandatory filed")
	@Length(min=10,max=100, message="10~100")
	private String subject;
	
	@NotEmpty(message="content field is mandatory filed")
	private String content;

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
