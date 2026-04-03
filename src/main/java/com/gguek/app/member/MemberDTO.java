package com.gguek.app.member;

import java.time.LocalDate;

public class MemberDTO {
	
	private String name;
	private Integer age;
	private LocalDate birth;
	private String[] num;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public String[] getNum() {
		return num;
	}
	public void setNum(String[] num) {
		this.num = num;
	}

	
	
}
