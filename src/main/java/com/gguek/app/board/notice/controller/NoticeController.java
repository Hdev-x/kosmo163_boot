package com.gguek.app.board.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gguek.app.board.notice.dto.NoticeDTO;
import com.gguek.app.board.notice.service.NoticeService;

@Controller
@RequestMapping("/board/notice/")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping("list")
	public void list(Model model) throws Exception {
		List<NoticeDTO> ar = noticeService.list();
		model.addAttribute("list", ar);
	}
	
	@GetMapping("create")
	public void create() {
	}
	
	@PostMapping("create")
	public String create(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.create(noticeDTO);
		System.out.println("희망하는 값 : 1, 결과값 :"+result);
		return "redirect:list";
	}
	
	
	
}
