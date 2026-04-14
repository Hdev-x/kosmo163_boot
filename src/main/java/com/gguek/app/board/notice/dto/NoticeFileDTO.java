package com.gguek.app.board.notice.dto;

import com.gguek.app.files.dto.FileDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeFileDTO extends FileDTO {
	private Long noticeNo;

}
