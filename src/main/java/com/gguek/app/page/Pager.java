package com.gguek.app.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pager {

	//페이지 번호
	private Long page;
	
	//JSP에 출력할 시작번호
	private Long start;
	
	//JSP에 출력할 끝번호
	private Long end;
	

	
	public Long getPage() {
		if(this.page == null) {
			this.page=1L;
		}
		return this.page;
	}
	

	
	
	
	
}
