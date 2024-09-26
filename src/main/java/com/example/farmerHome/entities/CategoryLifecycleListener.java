package com.example.farmerHome.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class CategoryLifecycleListener {
	@PrePersist
	public void beforeInsert(Category c) {
		System.out.println("Before Insert: "+c);
	}
	
	@PostPersist
	public void afterInsert(Category c) {
		System.out.println("After Insert: "+c);
	}
	
	@PreUpdate
	public void beforeUpdate(Category c) {
		System.out.println("After Update: "+c);
	}
	
	@PostUpdate
	public void afterUpdate(Category c) {
		System.out.println("After Update: "+c);
	}
	
	@PreRemove
	public void beforeDelete(Category c) {
		System.out.println("After Delete: "+c);
	}
	
	@PostLoad
	public void afterSelect(Category c) {
		System.out.println("After Select: "+c);
	}
}