package com.gguek.app.board.service;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gguek.app.board.qna.dto.QnaDTO;
import com.gguek.app.board.qna.dto.QnaFileDTO;
import com.gguek.app.board.qna.mapper.QnaMapper;
import com.gguek.app.page.Pager2;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {

	@Autowired
	private QnaMapper qnaMapper;

	@Value("${app.upload.base}")
	private String filePath;

	// list
	public List<QnaDTO> list(Pager2 pager2) throws Exception {
		Map<String, Long> map = new HashMap<>();
		pager2.makePageNumber(qnaMapper.getCount(pager2));
		return qnaMapper.list(pager2);
	}

	// detail
	public QnaDTO detail(QnaDTO dtoQnaDTO) throws Exception {
		return qnaMapper.detail(dtoQnaDTO);
	}

	// create
	public int create(QnaDTO qnaDTO, MultipartFile[] attach) throws Exception {
		int result = qnaMapper.create(qnaDTO);

		// 1. 어디에 저장?
		log.info(filePath);
		String filePath = this.filePath + "qna";

		// attach 자체가 Null인 경우
		if (attach == null)
			return result;
		for (MultipartFile m : attach) {
			// 파일이 없는 경우
			if (m.isEmpty())
				continue;
			// 파일이 있는 경우
			// 2. 어떤 이름으로 저장?
			String fileName = UUID.randomUUID().toString();
			fileName = fileName + "_" + m.getOriginalFilename();
			// 3. 저장
			File file = new File(filePath);
			if (!file.exists())
				file.mkdirs();
			file = new File(file, fileName);

			//a. 파일 저장
			m.transferTo(file);
			
			//b. Spring에서 제공
			//FileCopyUtils.copy(m.getBytes(), file);
			
			//4. DB에 저장
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriginName(m.getOriginalFilename());
			qnaFileDTO.setBoardNo(qnaDTO.getBoardNo());
			result = qnaMapper.createFile(qnaFileDTO);
		}
		return result;
	}
	
	
	//reply
	public int reply(QnaDTO qnaDTO) throws Exception {
		// 1. 부모 글의 정보(REF, STEP, DEPTH)를 가져옴
		QnaDTO parent = qnaMapper.detail(qnaDTO);
		
		
		// 2. 부모의 정보를 바탕으로 내(답글)가 들어갈 위치 계산
		qnaDTO.setBoardRef(parent.getBoardRef()); 	//답글의 REF
		qnaDTO.setBoardStep(parent.getBoardStep() + 1);  //답글의 STEP
		qnaDTO.setBoardDepth(parent.getBoardDepth() + 1);  //답글의 DEPTH
		
		// [핵심!] 3. 나보다 뒤에 와야 할 기존 답글들의 STEP을 +1씩 밀어버림 (자리 만들기)
		qnaMapper.replyupdate(qnaDTO);
		// 4. 비워진 자리에 내 답글을 저장
		int result = qnaMapper.create(qnaDTO);
		
		return result;
	}
	
	
	//update
	public int replyupdate(QnaDTO qnaDTO) throws Exception {
		int result = qnaMapper.replyupdate(qnaDTO);
		return result;
	}
}
