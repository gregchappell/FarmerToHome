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
import javax.persistence.OneToMany;
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
@Table(name="JPA_CONSUMER")
@XmlRootElement
@EntityListeners({ConsumerLifecycleListener.class})
public class Consumer implements Serializable {

	@FormParam("consno")
	private int consno;
	
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
	
	@FormParam("consumerPassword")
	@Value("passwordtest")
	private String consumerPassword;
	
	@FormParam("consumerUsername")
	@Value("usernametest")
	private String consumerUsername;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//One to Many - One Consumer -> Many Baskets
	private Set<Basket> orderHistory = new HashSet<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="currentConsumer")
	@XmlTransient //ignore the collections while using api
	public Set<Basket> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(Set<Basket> orderHistory) {
		this.orderHistory = orderHistory;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//-> Default constructor
	public Consumer() {
		System.out.println("Consumer Created");
	}
	

	//-> Getters and Setters
	@Id
	@Column(name="consumer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getConsno() {
		return consno;
	}
	public void setConsno(int consno) {
		this.consno = consno;
	}
	
	@Column(name="consumer_name",nullable=false,length=45)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="consumer_last_name",nullable=false,length=45)
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
	
	@Column(name="consumer_password",nullable=false,length=20)
	public String getConsumerPassword() {
		return consumerPassword;
	}

	public void setConsumerPassword(String consumerPassword) {
		this.consumerPassword = consumerPassword;
	}

	@Column(name="consumer_username",nullable=false,length=45)
	public String getConsumerUsername() {
		return consumerUsername;
	}

	public void setConsumerUsername(String consumerUsername) {
		this.consumerUsername = consumerUsername;
	}


	//-> ToString
	@Override
	public String toString() {
		return "Consumer [consno=" + consno + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + ", consumerPassword=" + consumerPassword
				+ ", consumerUsername=" + consumerUsername + ", orderHistory=" + orderHistory + "]";
	}
}
