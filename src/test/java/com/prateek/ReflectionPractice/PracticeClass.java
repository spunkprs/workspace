package com.prateek.ReflectionPractice;

import java.io.Serializable;

import org.junit.Test;

  public class PracticeClass implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer a;
	private String str;
	
	@Test
	public Integer getA() {
		return a;
	}
	public void setA(Integer a) {
		this.a = a;
	}
	public String getStr() {
		return str;
	}
	@Test
	public void setStr(String str) {
		this.str = str;
	}
	
	public void practiceMethod() {
		System.out.println("Inside practice method");
	}
	
	public class A {
		
	}
}
