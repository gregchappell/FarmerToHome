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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component -> disabled for @FormParam processing

@Entity
@Scope("prototype")
@Table(name="JPA_PRODUCT")
@XmlRootElement
@EntityListeners({ProductLifecycleListener.class})
@NamedQueries({@NamedQuery(name="Product.findByPrice", query="select p from Product p where p.price between :min and :max"),
			   @NamedQuery(name="Product.findByExpiryDate", query="select p from Product p where p.expiry_date between :min and :max"),
			   @NamedQuery(name="Product.findByCategory", query="select p from Product p where fk_categoryid = :categoryId")}) 
public class Product implements Serializable {
	
	@FormParam("productId")
	private int productId;
	
	@FormParam("product_name")
	@Value("Default name")
	private String product_name;
	
	@FormParam("price")
	@Value("-1")
	private double price;
	
	@FormParam("expiry_date")
	@Value("-1")
	private int expiry_date;
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Many to Many with Basket
	private Set<Basket> items = new HashSet<>();
	
	@ManyToMany(mappedBy="items")
	@XmlTransient
	public Set<Basket> getItems() {
		return items;
	}

	public void setItems(Set<Basket> items) {
		this.items = items;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Many to Many with Farmer
	private Set<Farmer> farmerProds = new HashSet<>();
	
	@ManyToMany(mappedBy="farmerProds")
	@XmlTransient
	public Set<Farmer> getFarmerProds() {
		return farmerProds;
	}

	public void setFarmerProds(Set<Farmer> farmerProds) {
		this.farmerProds = farmerProds;
	}	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Many to One with Category
	private Category currentCategory;
	
	@ManyToOne
	@JoinColumn(name="FK_CATEGORYID")
	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//-> Default constructor
	public Product() {
		System.out.println("Product created");
	}
	
	
	//-> Getters and Setters
	@Id 
	@Column(name="product_Id") 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Column(name="product_name", nullable=false, length=45)
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	@Column(name="product_price", nullable=false)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name="product_expiry_date", nullable=false)
	public int getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(int expiry_date) {
		this.expiry_date = expiry_date;
	}
	
	//-> ToString
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", product_name=" + product_name + ", price=" + price + ", expiry_date="
				+ expiry_date + ", items=" + items + ", currentCategory=" + currentCategory
				+ "]";
	}
}
