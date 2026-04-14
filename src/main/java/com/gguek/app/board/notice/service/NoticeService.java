package com.gguek.app.board.notice.service;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gguek.app.board.notice.dto.NoticeDTO;
import com.gguek.app.board.notice.dto.NoticeFileDTO;
import com.gguek.app.board.notice.mapper.NoticeMapper;
import com.gguek.app.page.Pager;
import com.gguek.app.page.Pager2;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Value("${app.upload.base}")
	private String filePath;
	
	
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		return noticeMapper.detail(noticeDTO);
	}
	
	
	public List<NoticeDTO> list(Pager2 pager2) throws Exception {
		Map<String, Long> map = new HashMap<>();
		
		pager2.makePageNumber(noticeMapper.getCount(pager2));
		return noticeMapper.list(pager2);
	}
	
	
	
	public int create(NoticeDTO noticeDTO, MultipartFile [] attach) throws Exception {
		int result = noticeMapper.create(noticeDTO);
		
		//1. 어디에 저장?
		log.info(filePath);
		String filePath = this.filePath+"notice";
		
		//attach 자체가 Null인 경우
		if (attach == null) {
			return result;
		}
		
		for (MultipartFile m:attach) {
			
			//파일이 없는 경우
			if (m.isEmpty()) {
				continue;
			}
			
		//2. 어떤 이름으로 저장??
		String fileName = UUID.randomUUID().toString();
//		log.warn(fileName);
//		
//		
//		//3. 확장자 처리?
//		log.error(attach.getOriginalFilename());
//		String f = attach.getOriginalFilename();
//		f = f.substring(f.lastIndexOf("."));
//		log.info(f);
		
		fileName = fileName+"_"+m.getOriginalFilename();
		
		//3. 저장
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		
		file = new File(file, fileName);
		
		//a. 파일 저장
		m.transferTo(file);
		
		
		//b. Spring에서 제공
		//FileCopyUtils.copy(attach.getBytes(), file);
		
		//4. DB에 저장
		NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
		noticeFileDTO.setFileName(fileName);
		noticeFileDTO.setOriginName(m.getOriginalFilename());
		noticeFileDTO.setNoticeNo(noticeDTO.getNoticeNo());
		result = noticeMapper.createFile(noticeFileDTO);
		
		}
		
		return result; //noticeMapper.create(noticeDTO, attach);
	}
}






















