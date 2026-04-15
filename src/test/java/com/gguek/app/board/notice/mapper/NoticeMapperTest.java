package com.gguek.app.board.notice.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gguek.app.board.notice.dto.NoticeDTO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void detailTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardNo(161L);
		
		noticeDTO = noticeMapper.detail(noticeDTO);
		log.info("Map : {}", noticeDTO);
		assertNotNull(noticeDTO);
	}
	


}
