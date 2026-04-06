package com.gguek.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDAO {
	
	@Autowired
	private SqlSession session;
	
	
	public List<DepartmentDTO> list() throws Exception {
		System.out.println("DAO LIST");
		
		return session.selectList("com.gguek.app.departments.DepartmentDAO.list");//namespace.id명
	
		
	}
	
	
	
	
}
