package com.gguek.app.board.qna.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gguek.app.board.qna.dto.QnaDTO;
import com.gguek.app.board.qna.dto.QnaFileDTO;
import com.gguek.app.page.Pager2;

@Mapper
public interface QnaMapper {

	// getCount
	Long getCount(Pager2 pager2) throws Exception;

	// list
	List<QnaDTO> list(Pager2 pager2) throws Exception;
	
	//detail
	QnaDTO detail(QnaDTO qnaDTO) throws Exception;
	
	//create
	int create(QnaDTO qnaDTO) throws Exception;
	
	//reply
	int reply(QnaDTO qnaDTO) throws Exception;
		
	//createFile
	int createFile(QnaFileDTO qnaFileDTO) throws Exception;
	
	//replyupdate
	int replyupdate(QnaDTO qnaDTO) throws Exception;
	
}
