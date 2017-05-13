package com.dav.lazada.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement
@Entity
@Table(name="Employees")
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=true)
	private String name;
	
	private String userName;
	private String password;
	
	@Column(nullable=true)
	private String address;

	@Column(nullable=true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date birthDay;
	
	@Column(nullable=true,length=12)
	private Integer phoneNumber;
	
	@Column(nullable=true,length=2)
	private Integer sex;
	
	@Column(nullable=true)
	private Boolean emailExclusive;
	
	public Boolean getEmailExclusive() {
		return emailExclusive;
	}

	public void setEmailExclusive(Boolean emailExclusive) {
		this.emailExclusive = emailExclusive;
	}

	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryEId",nullable=false)
	private CategoryEmployee categoryEmployee;

	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="employeeComm")
	@JsonManagedReference
	private List<Comment> comments;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emplId")
	@JsonManagedReference
	private List<Desiderate> desiderates;
	
	public List<Desiderate> getDesiderates() {
		return desiderates;
	}

	public void setDesiderates(List<Desiderate> desiderates) {
		this.desiderates = desiderates;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public CategoryEmployee getCategoryEmployee() {
		return categoryEmployee;
	}

	public void setCategoryEmployee(CategoryEmployee categoryEmployee) {
		this.categoryEmployee = categoryEmployee;
	}
	
	
	

}
