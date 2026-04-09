package com.gguek.app.board.notice.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gguek.app.board.notice.dto.NoticeDTO;

@SpringBootTest
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
//	@Test
//	void testList() throws Exception {
//		List<NoticeDTO> list = noticeMapper.list();
//		
//		// 1. 리스트 출력: 데이터가 어떻게 들어있는지 눈으로 확인
//	    System.out.println("======= 공지사항 목록 =======");
//	    list.forEach(notice -> System.out.println(notice)); 
//	    // 혹은 list.forEach(System.out::println);
//		
//		assertNotNull(list, "null");
//		assertTrue(list.size() > 0, "조회된 교수 데이터가 없습니다");
//		
//	}

	
	@Test
	void testCreate() throws Exception{
		//dummy data
		int idx=1;
		for (int i = 0; i < 110; i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNoticeTitle("제목"+i);
			noticeDTO.setNoticeContents("내용"+i);
			noticeDTO.setProfessorNo("P00"+idx);
			int result = noticeMapper.create(noticeDTO);	
			idx++;
			if (idx>9) {
				idx=1;
			}
			
			if (i%10==0) {
				
				Thread.sleep(1000);
			}
		}
		System.out.println("END");
	}



}
