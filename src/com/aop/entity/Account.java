/**
 * Gagandeep
 * 2:24:53 pm
 * 11-Apr-2020
 */
package com.aop.entity;

public class Account {
	
	private String name;
	private String level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Account(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}
	
	public Account() {
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}
	
	

}
