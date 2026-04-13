package com.gguek.app.departments;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	
	public DepartmentController() {
		System.out.println("DepartmentController 생성");
	}
	
	
	
	
	
	@GetMapping("list")
	public String list(@RequestParam(name="page", defaultValue="1") Long page, Model model) throws Exception {
		List<DepartmentDTO> ar = departmentService.list(page);
		
		
		//request와 비슷한 역할, Spring에서 제공하는 객체
		//jsp에서 ${list}로 접근 가능
		model.addAttribute("list", ar);
		return "department/list";
	}
	
	
	//URL정보와 JSP의 경로가 같다면 void로 반환타입을 설정해도 된다. 
	//(반환타입이 String이 아니어도 된다.)
	@GetMapping("create") 
	public void create() {
		
	}
	
	@PostMapping("create")
	public String create(DepartmentDTO departmentDTO) throws Exception {
		
		int result = departmentService.create(departmentDTO);
		System.out.println("희망하는 값 : 1, 결과값 : "+result);
		
		//redirect : URL정보를 다시 요청하겠다. (새로운 요청이 발생한다.)
		return "redirect:./list";
	}
	
	@PostMapping("delete")
	public String detail(DepartmentDTO departmentDTO) throws Exception {
		
		int result = departmentService.delete(departmentDTO);
		
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public void update(DepartmentDTO departmentDTO, Model model) throws Exception {
		departmentDTO = departmentService.detail(departmentDTO);
		model.addAttribute("d", departmentDTO);
	}
	
	@PostMapping("update")
	public String update(DepartmentDTO dtoDepartmentDTO) throws Exception {
		
		
		int result = departmentService.update(dtoDepartmentDTO);
		
		return "redirect:./list";
	
	}
	
	
	@GetMapping("detail")
	public void detail(Model model, DepartmentDTO departmentDTO) throws Exception {
		departmentDTO = departmentService.detail(departmentDTO);
		System.out.println(departmentDTO);
		model.addAttribute("d", departmentDTO);
	}
	
}
