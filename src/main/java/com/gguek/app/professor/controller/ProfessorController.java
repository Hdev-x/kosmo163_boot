package com.gguek.app.professor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gguek.app.page.Pager2;
import com.gguek.app.professor.dto.ProfessorDTO;
import com.gguek.app.professor.service.ProfessorService;

@Controller
@RequestMapping("/professor/*")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;

	@GetMapping("list")
	public void list(Pager2 pager2, Model model) throws Exception {
		List<ProfessorDTO> ar = professorService.list(pager2);
		model.addAttribute("list", ar);
	}
	
	@GetMapping("detail")
	public void detail(Model model, ProfessorDTO professorDTO) throws Exception {
		professorDTO = professorService.detail(professorDTO);
		model.addAttribute("detail", professorDTO);		
	}
	
	@GetMapping("create")
	public void create() {
		
	}
	
	@PostMapping("create")
	public String create(ProfessorDTO professorDTO) throws Exception {
		int result = professorService.create(professorDTO);
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public void update(Model model, ProfessorDTO professorDTO) throws Exception {
		professorDTO = professorService.detail(professorDTO);
		model.addAttribute("update", professorDTO);
	}
	
	@PostMapping("update")
	public String update(ProfessorDTO professorDTO) throws Exception {
		int result = professorService.update(professorDTO);
		return "redirect:./list";
	}
	
	@PostMapping("delete")
	public String delete(ProfessorDTO professorDTO) throws Exception {
		int result = professorService.delete(professorDTO);
		return "redirect:./list";
	}
	
}
