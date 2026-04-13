package com.gguek.app.board.notice.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gguek.app.board.notice.dto.NoticeDTO;
import com.gguek.app.board.notice.mapper.NoticeMapper;
import com.gguek.app.page.Pager;
import com.gguek.app.page.Pager2;

@Service
public class NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	public List<NoticeDTO> list(Pager2 pager2) throws Exception {
		Map<String, Long> map = new HashMap<>();
		
		pager2.makePageNumber(noticeMapper.getCount(pager2));
		return noticeMapper.list(pager2);
	}
	
	
	
	public int create(NoticeDTO noticeDTO) throws Exception {
		return noticeMapper.create(noticeDTO);
	}
}
