package com.example.farmerHome.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class BasketLifecycleListener {

	@PrePersist
	public void beforeInsert(Basket b) {
		System.out.println("Before Insert: "+b);
	}
	
	@PostPersist
	public void afterInsert(Basket b) {
		System.out.println("After Insert: "+b);
	}
	
	@PreUpdate
	public void beforeUpdate(Basket b) {
		System.out.println("After Update: "+b);
	}
	
	@PostUpdate
	public void afterUpdate(Basket b) {
		System.out.println("After Update: "+b);
	}
	
	@PreRemove
	public void beforeDelete(Basket b) {
		System.out.println("After Delete: "+b);
	}
	
	@PostLoad
	public void afterSelect(Basket b) {
		System.out.println("After Select: "+b);
	}
}