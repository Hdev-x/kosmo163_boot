package com.gguek.app.board.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gguek.app.board.notice.dto.NoticeDTO;
import com.gguek.app.board.notice.mapper.NoticeMapper;

@Service
public class NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	public List<NoticeDTO> list() throws Exception {
		return noticeMapper.list();
	}
	
	public int create(NoticeDTO noticeDTO) throws Exception {
		return noticeMapper.create(noticeDTO);
	}
}
