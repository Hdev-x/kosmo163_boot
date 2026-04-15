package com.gguek.app.board.notice.dto;


import java.util.List;

import com.gguek.app.board.BoardDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeDTO extends BoardDTO{
	
	private List<NoticeFileDTO> list;
 
}
