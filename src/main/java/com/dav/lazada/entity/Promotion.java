package com.dav.lazada.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@XmlRootElement
@Entity
@Table(name = "Promotions")
@NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p")
public class Promotion implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true , nullable = false)
	private Integer id;
	
	@Column(length=255)
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	
	private String imgPromotion;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="categoryId", nullable = false)
	private Category categoryPromotion;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "promotion")
	private List<PromotionDetail> details = new ArrayList<PromotionDetail>();

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getImgPromotion() {
		return imgPromotion;
	}

	public void setImgPromotion(String imgPromotion) {
		this.imgPromotion = imgPromotion;
	}

	public Category getCategoryPromotion() {
		return categoryPromotion;
	}

	public void setCategoryPromotion(Category categoryPromotion) {
		this.categoryPromotion = categoryPromotion;
	}

	public List<PromotionDetail> getDetails() {
		return details;
	}

	public void setDetails(List<PromotionDetail> details) {
		this.details = details;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
