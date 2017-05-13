package com.dav.lazada.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jettison.json.JSONObject;


@XmlRootElement
@Entity
@Table(name = "Products")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	private Double unitPrice;
	private String bigImage;
	private String smallImage;
	private String description;
	private Integer quantity;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="supplierId",nullable=false)
	private Supplier supplier;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryId",nullable=false)
	private Category category;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="product")
	@JsonManagedReference
	private List<OrderDetail>orderDetails;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="productComm")
	@JsonManagedReference
	private List<Comment> comments;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="productPromition")
	@JsonManagedReference
	private List<PromotionDetail> promotionDetails;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prodId")
	@JsonManagedReference
	private List<Desiderate> desiderates;
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getBigImage() {
		return bigImage;
	}

	public void setBigImage(String bigImage) {
		this.bigImage = bigImage;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<PromotionDetail> getPromotionDetails() {
		return promotionDetails;
	}

	public void setPromotionDetails(List<PromotionDetail> promotionDetails) {
		this.promotionDetails = promotionDetails;
	}

	public List<Desiderate> getDesiderates() {
		return desiderates;
	}

	public void setDesiderates(List<Desiderate> desiderates) {
		this.desiderates = desiderates;
	}
	
	
	
}
