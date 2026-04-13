package com.gguek.app.departments;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {

	//public abstract 생략 가능
	
	//getCount
	Long getCount() throws Exception;
	
	//list
	List<DepartmentDTO> list(Map<String, Long> map) throws Exception;
	
	//detail
	DepartmentDTO detail(DepartmentDTO departmentDTO) throws Exception;
	
	//create
	int create(DepartmentDTO departmentDTO) throws Exception;
	
	//update
	int update(DepartmentDTO departmentDTO) throws Exception;
	
	//delete
	int delete(DepartmentDTO departmentDTO) throws Exception;
	
}
