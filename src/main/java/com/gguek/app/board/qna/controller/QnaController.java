package com.gguek.app.board.qna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gguek.app.board.qna.dto.QnaDTO;
import com.gguek.app.board.service.QnaService;
import com.gguek.app.page.Pager2;


@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@GetMapping("list")
	public String list(Pager2 pager2, Model model) throws Exception {
		List<QnaDTO> ar = qnaService.list(pager2);
		model.addAttribute("list", ar);
		model.addAttribute("pager2", pager2);
		return "board/qna/list";
	}

	@GetMapping("detail")
	public String detail(QnaDTO qnaDTO, Model model) throws Exception {
		qnaDTO = qnaService.detail(qnaDTO);
		model.addAttribute("detail", qnaDTO);
		return "board/qna/detail";
	}

	@GetMapping("create")
	public String create() {
		return "board/qna/create";
	}
	
	@PostMapping("create")
	public String create(QnaDTO qnaDTO, @RequestParam("attach") MultipartFile [] attach) throws Exception {
		int result = qnaService.create(qnaDTO, attach);
		return "redirect:./list";
	}
	
	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception {
//		int result = qnaService.reply(qnaDTO);
		model.addAttribute("qnaDTO", qnaDTO);
		return "board/qna/reply";
	}
	
	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.reply(qnaDTO);
		return "redirect:./list";
	}
}
