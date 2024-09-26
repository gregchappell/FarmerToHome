package com.example.farmerHome.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class FarmerLifecycleListener {
	
	@PrePersist
	public void beforeInsert(Farmer f) {
		System.out.println("Before Insert: "+f);		
	}
	
	@PostPersist
	public void afterInsert(Farmer f) {
		System.out.println("After Insert: "+f);
	}
	
	@PreUpdate
	public void beforeUpdate(Farmer f) {
		System.out.println("Before Update: "+f);
	}
	
	@PostUpdate
	public void afterUpdate(Farmer f) {
		System.out.println("After Update: "+f);
	}
	
	@PreRemove
	public void beforeDelete(Farmer f) {
		System.out.println("Before Delete: "+f);
	}
	
	@PostLoad
	public void afterSelect(Farmer f) {
		System.out.println("After Select: "+f);
	}
}
