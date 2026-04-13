package com.gguek.app.departments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<DepartmentDTO> list(Long page) throws Exception {
	    
	    // 1. 전달받은 page 번호로 시작(b)과 끝(e) 계산
	    Long b = (page - 1) * 10 + 1;
	    Long e = page * 10;

	    // 2. Mapper에 전달할 전송용 바구니(Map) 생성 및 데이터 저장
	    Map<String, Long> map = new HashMap<>();
	    map.put("begin", b);
	    map.put("end", e);
	    
	    // 3. Mapper 호출: "이 계산된 지도(map)를 줄 테니, 10개만 뽑아와!"
	    return departmentMapper.list(map); 
	}
	
	private void makepage(Long page) throws Exception {
		// 1) 전체 글의 개수 조회
		Long totalCount = departmentMapper.getCount();
		// 2) 전체 페이지 수 계산
		Long totalPage = totalCount / 10;
		if (totalCount % 10 > 0) totalPage++;
		// 3) 블럭 계산 (5개씩 보여준다고 가정)
		Long perBlock = 5L;
		Long totalBlock = totalPage / perBlock;
		if (totalPage % perBlock > 0) totalBlock++;
		// 4) 현재 페이지 번호로 현재 블럭 번호 구하기
		Long curBlock = page / perBlock;
		if (page % perBlock > 0) curBlock++;
		// 5) 현재 블럭 번호로 시작번호와 끝번호 구하기
		Long start = (curBlock - 1) * perBlock +1;
		Long end = curBlock * perBlock;
		
		// 🔥 6) 끝번호(end) 보정: 실제 마지막 페이지보다 블럭 끝번호가 크면 안 됨!
	    if (curBlock == totalBlock) {
	        end = totalPage;
	    }
		
		// 7) 이전/다음 유무 (JSP에서 버튼 띄울지 말지 결정)
	    boolean pre = curBlock > 1;
	    boolean next = curBlock < totalBlock;
	}
	
	public int create(DepartmentDTO departmentDTO) throws Exception {
		return departmentMapper.create(departmentDTO);
	}
	
	public int delete(DepartmentDTO departmentDTO) throws Exception {
		return departmentMapper.delete(departmentDTO);
	}
	
	public int update(DepartmentDTO departmentDTO) throws Exception {
		return departmentMapper.update(departmentDTO);
	}
	
	public DepartmentDTO detail(DepartmentDTO departmentDTO) throws Exception {
		return departmentMapper.detail(departmentDTO);
	}
	
}
