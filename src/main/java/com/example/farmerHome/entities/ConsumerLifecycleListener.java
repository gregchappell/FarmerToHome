package com.example.farmerHome.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class ConsumerLifecycleListener {

	@PrePersist
	public void beforeInsert(Consumer e) {
		System.out.println("Before Insert: "+e);
	}
	
	@PostPersist
	public void afterInsert(Consumer e) {
		System.out.println("After Insert: "+e);
	}
	
	@PreUpdate
	public void beforeUpdate(Consumer e) {
		System.out.println("After Update: "+e);
	}
	
	@PostUpdate
	public void afterUpdate(Consumer e) {
		System.out.println("After Update: "+e);
	}
	
	@PreRemove
	public void beforeDelete(Consumer e) {
		System.out.println("After Delete: "+e);
	}
	
	@PostLoad
	public void afterSelect(Consumer e) {
		System.out.println("After Select: "+e);
	}
}
