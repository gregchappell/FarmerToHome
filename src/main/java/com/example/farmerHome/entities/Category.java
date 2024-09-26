package com.example.farmerHome.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component -> disabled for @FormParam processing

@Entity
@Scope("prototype")
@Table(name="JPA_CATEGORY")
@XmlRootElement
@EntityListeners({CategoryLifecycleListener.class})
public class Category implements Serializable {
	
	@FormParam("categoryId")
	private int categoryId;
	
	@FormParam("category")
	private String category;

	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//One to Many with Products
	private Set<Product> categoryProds = new HashSet<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="currentCategory")
	@XmlTransient
	public Set<Product> getCategoryProds() {
		return categoryProds;
	}

	public void setCategoryProds(Set<Product> categoryProds) {
		this.categoryProds = categoryProds;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////

	
	//-> Default constructor
	public Category() {
		System.out.println("Category created");
	}
	
	
	//-> Getters and Setters
	@Id
	@Column(name="category_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
		
	@Column(name="product_category", nullable=false, length=20)
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	//-> ToString
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", category=" + category + "]";
	}
	
	

}
