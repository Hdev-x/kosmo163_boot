package com.gguek.app.departments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {
 
	@Autowired
	private DepartmentService departmentService;
	
	//전체 목록 list
	
	@GetMapping("list")
	public void list() throws Exception {
		System.out.println("CONTROLLER LIST");
		List<DepartmentDTO> ar = departmentService.list();
//		for(int i=0;i<ar.size();i++) {
//			System.out.println(ar.get(i));
//		}
		//for(데이터타입 변수명:collection){}
		for(DepartmentDTO dto:ar) {
			System.out.println(dto);
		}
		
	}
	
}
