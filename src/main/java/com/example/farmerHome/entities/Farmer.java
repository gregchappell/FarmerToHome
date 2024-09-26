package com.example.farmerHome.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

//@Component -> disabled for @FormParam processing

@Entity
@Scope("prototype")
@Table(name="JPA_FARMER")
@XmlRootElement
@EntityListeners({FarmerLifecycleListener.class})
public class Farmer implements Serializable {
	
	@FormParam("farmerId")
	@Value("-1")
	private int farmerId;
	
	@FormParam("firstName")
	@Value("Default Consumer")
	private String firstName;
	
	@FormParam("lastName")
	@Value("Default Consumer")
	private String lastName;
	
	@FormParam("email")
	@Value("Default@gmail.com")
	private String email;
	
	@FormParam("address")
	@Value("1 Default Lane")
	private String address;
	
	@FormParam("phone")
	@Value("12345")
	private long phone;
	
	@FormParam("farmerPassword")
	@Value("passwordtest")
	private String farmerPassword;
	
	@FormParam("farmerUsername")
	@Value("usernametest")
	private String farmerUsername;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Many to Many with Products
	private Set<Product> farmerProds = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="JPA_FARMER_PRODS", 
		joinColumns=@JoinColumn(name="FK_FARMERID"),
		inverseJoinColumns=@JoinColumn(name="FK_PRODUCTID"))
	@XmlTransient
	public Set<Product> getFarmerProds() {
		return farmerProds;
	}
	
	public void setFarmerProds(Set<Product> farmerProds) {
		this.farmerProds = farmerProds;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//-> Default constructor
	public Farmer() {
		System.out.println("Farmer created");
	}


	//-> Getters and Setters
	@Id
	@Column(name="farmer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	@Column(name="farmer_name",nullable=false,length=45)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="farmer_last_name",nullable=false,length=45)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="email",nullable=false,length=45)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="address",nullable=false,length=45)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="phone",nullable=false)
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Column(name="farmer_password",nullable=false,length=45)
	public String getFarmerPassword() {
		return farmerPassword;
	}

	public void setFarmerPassword(String farmerPassword) {
		this.farmerPassword = farmerPassword;
	}

	@Column(name="farmer_username",nullable=false,length=45)
	public String getFarmerUsername() {
		return farmerUsername;
	}

	public void setFarmerUsername(String farmerUsername) {
		this.farmerUsername = farmerUsername;
	}
	
	
	//-> ToString
	@Override
	public String toString() {
		return "Farmer [farmerId=" + farmerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", address=" + address + ", phone=" + phone + ", farmerPassword=" + farmerPassword
				+ ", farmerUsername=" + farmerUsername + ", farmerProds=" + farmerProds + "]";
	}
}
