package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.ValidationException;

import java.math.BigDecimal;



/**
 * The persistent class for the ONEORDER database table.
 * 
 */
@Entity
@Table(name="ONEORDER")
public class Oneorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ONEORDER_IDONEORDER_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ONEORDER_IDONEORDER_GENERATOR")
	@Column(name="ID_ONEORDER", unique=true, nullable=false, precision=22)
	private long idOneorder;

	@Column(name="QUANTITY_ONEORDER", nullable=false, precision=22)
	private BigDecimal quantityOneorder;

	//bi-directional many-to-one association to ShArticle
	@OneToOne
	@JoinColumn(name="ARTICLE_ID", nullable=false)
	private ShArticle shArticle;

	

	public Oneorder() {
	}

	public long getIdOneorder() {
		return this.idOneorder;
	}

	public void setIdOneorder(long idOneorder) {
		this.idOneorder = idOneorder;
	}

	public BigDecimal getQuantityOneorder() {
		return this.quantityOneorder;
	}

	public void setQuantityOneorder(BigDecimal quantityOneorder) {
		this.quantityOneorder = quantityOneorder;
	}

	public ShArticle getShArticle() {
		return this.shArticle;
	}

	public void setShArticle(ShArticle shArticle) {
		this.shArticle = shArticle;
	}

	
	@PrePersist
	@PreUpdate
	private void checkValidate(){
		if(quantityOneorder==null || quantityOneorder.intValue() <0)
			throw new ValidationException("Invalid number");
	}
public  BigDecimal getSubTotal(){
	
	return shArticle.getPrice().multiply(quantityOneorder);
}
	
}