package com.dav.lazada.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;

@XmlRootElement
@Entity
@Table(name="Desiderates")
public class Desiderate implements Serializable{
	
	@Id
	private Integer id;

	private String content;

	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId", nullable = false)
	@JsonBackReference
	private Employee emplId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId", nullable = false)
	@JsonBackReference
	private Product prodId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employee getEmplId() {
		return emplId;
	}

	public void setEmplId(Employee emplId) {
		this.emplId = emplId;
	}

	public Product getProdId() {
		return prodId;
	}

	public void setProdId(Product prodId) {
		this.prodId = prodId;
	}
	
	
	
}
