package edu.bit.ex.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria {

	private int pageNum;	//페이지번호
	private int amount; 	//한페이지 당 보여줄 게시글 갯수
	
	public Criteria() {	
		
		this(1, 10);	//기본값 1페이지 10개
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}
