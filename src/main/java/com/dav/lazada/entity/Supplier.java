package com.dav.lazada.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonManagedReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@Table(name="Suppliers")
public class Supplier implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String logo;
	private Integer buys;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="supplier",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Product> products=new ArrayList<Product>();

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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getBuys() {
		return buys;
	}

	public void setBuys(Integer buys) {
		this.buys = buys;
	}
	
	
	
}
