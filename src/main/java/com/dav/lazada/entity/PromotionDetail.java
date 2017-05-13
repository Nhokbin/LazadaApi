package com.dav.lazada.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;

@XmlRootElement
@Entity
@Table(name="PromotionDetails")
@NamedQuery(name = "PromotionDetail.findAll",query = "SELECT pd FROM PromotionDetail pd")
public class PromotionDetail implements Serializable{
	
	private static final long srserialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique= true, nullable = false)
	private Integer id;
	
	private Integer percent;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="productId",nullable = false)
	private Product productPromition;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "promotionId",nullable = false)
	private Promotion promotion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPercent() {
		return percent;
	}

	public void setPercent(Integer percent) {
		this.percent = percent;
	}

	public Product getProductPromition() {
		return productPromition;
	}

	public void setProductPromition(Product productPromition) {
		this.productPromition = productPromition;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public static long getSrserialversionuid() {
		return srserialVersionUID;
	}
	
	
	
}
