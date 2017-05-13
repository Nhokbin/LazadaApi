package com.dav.lazada.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@XmlRootElement
@Entity
@Table(name = "Categories")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parentId",nullable=false)
	private Category parentId;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="parentId",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Category> categories=new ArrayList<Category>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Product> products = new ArrayList<Product>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categoryPromotion", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Promotion> promotions = new ArrayList<Promotion>();

	
	
	
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

	public Category getParentId() {
		return parentId;
	}

	public void setParentId(Category parentId) {
		this.parentId = parentId;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

}
