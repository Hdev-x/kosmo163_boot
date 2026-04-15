package com.gguek.app.board.qna.dto;

import com.gguek.app.files.dto.FileDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnaFileDTO extends FileDTO{
	private Long boardNo;
}
