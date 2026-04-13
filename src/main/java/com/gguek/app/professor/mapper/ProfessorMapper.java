package com.gguek.app.professor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gguek.app.page.Pager2;
import com.gguek.app.professor.dto.ProfessorDTO;

@Mapper
public interface ProfessorMapper {

	//list
	List<ProfessorDTO> list(Pager2 pager2) throws Exception;
	//detail
	ProfessorDTO detail(ProfessorDTO professorDTO) throws Exception;
	//create
	int create(ProfessorDTO professorDTO) throws Exception;
	//update
	int update(ProfessorDTO professorDTO) throws Exception;
	//delete
	int delete(ProfessorDTO professorDTO) throws Exception;
}
