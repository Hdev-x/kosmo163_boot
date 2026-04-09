package com.gguek.app.board.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gguek.app.board.notice.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {
	
	//public abstract 생략 가능
	
	//list
	List<NoticeDTO> list() throws Exception;
	
	//detail
	NoticeDTO detail(NoticeDTO noticeDTO) throws Exception;
	
	//create
	int create(NoticeDTO noticeDTO) throws Exception;
	
	//update
	int update(NoticeDTO noticeDTO) throws Exception;
	
	//delete
	int delete(NoticeDTO noticeDTO) throws Exception;
}
