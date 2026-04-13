package com.gguek.app.professor.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gguek.app.page.Pager2;
import com.gguek.app.professor.dto.ProfessorDTO;
import com.gguek.app.professor.mapper.ProfessorMapper;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorMapper professorMapper;

	public List<ProfessorDTO> list(Pager2 pager2) throws Exception {
		
		
		return professorMapper.list(pager2);
	}

	public ProfessorDTO detail(ProfessorDTO professorDTO) throws Exception {
		 return professorMapper.detail(professorDTO);
	}

	public int create(ProfessorDTO professorDTO) throws Exception {
		return professorMapper.create(professorDTO);
	}

	public int update(ProfessorDTO professorDTO) throws Exception {
		return professorMapper.update(professorDTO);
	}

	public int delete(ProfessorDTO professorDTO) throws Exception {
		return professorMapper.delete(professorDTO);
	}

}
