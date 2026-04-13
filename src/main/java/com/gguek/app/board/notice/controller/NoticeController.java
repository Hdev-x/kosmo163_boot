package com.gguek.app.board.notice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gguek.app.board.notice.dto.NoticeDTO;
import com.gguek.app.board.notice.service.NoticeService;
import com.gguek.app.page.Pager;
import com.gguek.app.page.Pager2;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping("list")
	public String list(Pager2 pager2, Model model) throws Exception {
		List<NoticeDTO> ar = noticeService.list(pager2);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager2);
		return "board/list";
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
