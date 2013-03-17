package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.ValidationException;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the STOCK database table.
 * 
 */
@Entity
@Table(name="STOCK")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STOCK_IDSTOCK_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STOCK_IDSTOCK_GENERATOR")
	@Column(name="ID_STOCK", unique=true, nullable=false, precision=22)
	private long idStock;

	@Column(precision=22)
	private BigDecimal quantity;

	//bi-directional many-to-one association to ShArticle
	@OneToMany(mappedBy="stock")
	private List<ShArticle> shArticles;

	//bi-directional many-to-one association to Fournisseur
	@ManyToOne
	@JoinColumn(name="ID_SUPPLIER")
	private Fournisseur fournisseur;

	public Stock() {
	}

	public long getIdStock() {
		return this.idStock;
	}

	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public List<ShArticle> getShArticles() {
		return this.shArticles;
	}

	public void setShArticles(List<ShArticle> shArticles) {
		this.shArticles = shArticles;
	}

	
	public ShArticle addShArticles(ShArticle shArticles) {
		getShArticles().add(shArticles);
		shArticles.setStock(this);

		return shArticles;
	}

	public ShArticle removeShArticles(ShArticle shArticles) {
		getShArticles().remove(shArticles);
		shArticles.setStock(null);

		return shArticles;
	}
	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@PrePersist
	@PreUpdate
	private void ValiderData(){
		if(quantity==null || "".equals(quantity))
			throw new ValidationException("Invalid quantity");
		
	}
}