package com.example.farmerHome.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class ProductLifecycleListener {
		
	@PrePersist 
	public void beforeInsert(Product p) {
		System.out.println("Before Insert: "+p);
	}

	@PostPersist
	public void afterInsert(Product p) {
		System.out.println("After Insert: "+p);
	}
	
	@PreUpdate 
	public void beforeUpdate(Product p) {
		System.out.println("Before Update: "+p);
	}

	@PostUpdate
	public void afterUpdate(Product p) {
		System.out.println("After Update: "+p);
	}
	
	@PreRemove
	public void beforeDelete(Product p) {
		System.out.println("Before Delete: "+p);
	}

	@PostLoad
	public void afterSelect(Product p) {
		System.out.println("After Select: "+p);
	}
}
