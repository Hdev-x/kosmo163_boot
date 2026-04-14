package com.gguek.app.board.notice.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.gguek.app.board.notice.dto.NoticeDTO;
import com.gguek.app.board.notice.dto.NoticeFileDTO;
import com.gguek.app.page.Pager;
import com.gguek.app.page.Pager2;

@Mapper
public interface NoticeMapper {
	
	//public abstract 생략 가능
	
	//createFile
	int createFile(NoticeFileDTO noticeFileDTO) throws Exception;
	
	//getCount
	Long getCount(Pager2 pager2) throws Exception;
	
	//list
	List<NoticeDTO> list(Pager2 pager2) throws Exception;
	
	//detail
	NoticeDTO detail(NoticeDTO noticeDTO) throws Exception;
	
	//create
	int create(NoticeDTO noticeDTO) throws Exception;
	
	//update
	int update(NoticeDTO noticeDTO) throws Exception;
	
	//delete
	int delete(NoticeDTO noticeDTO) throws Exception;
}
