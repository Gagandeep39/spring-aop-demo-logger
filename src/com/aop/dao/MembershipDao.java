/**
 * Gagandeep
 * 1:54:08 pm
 * 11-Apr-2020
 */
package com.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
	
	private int id;
	
	public void addAccount() {
		System.out.println(getClass() + " Doing DB Work: Adding a member");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
