package com.gguek.app.board.qna.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gguek.app.board.qna.dto.QnaDTO;

@SpringBootTest
class QnaMapperTest {

	@Autowired
	private QnaMapper qnaMapper;
	
	@Test
	void testCreate() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setBoardTitle("답글");
		qnaDTO.setBoardContents("답글내용");
		qnaDTO.setBoardWriter("user");
		qnaDTO.setBoardRef(1L);
		qnaDTO.setBoardStep(2L);
		qnaDTO.setBoardDepth(1L);
		
		
		int result = qnaMapper.create(qnaDTO);
		assertEquals(1, result);
	}

}
