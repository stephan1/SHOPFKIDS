package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_IDPROD_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_IDPROD_GENERATOR")
	@Column(name="ID_PROD", unique=true, nullable=false, precision=22)
	private long idProd;

	@Column(length=20)
	private String nomprod;

	@Column(name="PROD_DESCRIPTION", length=20)
	private String prodDescription;

	//bi-directional many-to-one association to ShCategory
	@ManyToOne
	@JoinColumn(name="CATALOG_ID")
	private ShCategory shCategory;

	//bi-directional many-to-one association to ShArticle
	@OneToMany(mappedBy="product")
	private List<ShArticle> shArticles;

	public Product() {
	}

	public long getIdProd() {
		return this.idProd;
	}

	public void setIdProd(long idProd) {
		this.idProd = idProd;
	}

	public String getNomprod() {
		return this.nomprod;
	}

	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}

	public String getProdDescription() {
		return this.prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public ShCategory getShCategory() {
		return this.shCategory;
	}

	public void setShCategory(ShCategory shCategory) {
		this.shCategory = shCategory;
	}

	
	public List<ShArticle> getShArticles() {
		return this.shArticles;
	}

	public void setShArticles(List<ShArticle> shArticles) {
		this.shArticles = shArticles;
	}

	
	public ShArticle addShArticles(ShArticle shArticles) {
		getShArticles().add(shArticles);
		shArticles.setProduct(this);

		return shArticles;
	}

	public ShArticle removeShArticles(ShArticle shArticles) {
		getShArticles().remove(shArticles);
		shArticles.setProduct(null);

		return shArticles;
	}
}