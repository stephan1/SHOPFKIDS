package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;



/**
 * The persistent class for the SH_ARTICLE database table.
 * 
 */
@Entity
@Table(name="SH_ARTICLE")
public class ShArticle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SH_ARTICLE_IDARTICLE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SH_ARTICLE_IDARTICLE_GENERATOR")
	@Column(name="ID_ARTICLE", unique=true, nullable=false, precision=22)
	private long idArticle;

	@Column(name="ARTICLE_NAME", nullable=false, length=20)
	private String articleName;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_AJOUTE", nullable=false)
	private Date dateAjoute;

	@Column(nullable=false, length=100)
	private String description;

	@Column(length=20)
	private String imgalt;

	@Column(length=20)
	private String imgheight;

	@Column(length=20)
	private String imgwidth;

	@Column(nullable=false, precision=22)
	private BigDecimal price;

	@Temporal(TemporalType.DATE)
	@Column(name="WARRANTY_PERIOD", nullable=false)
	private Date warrantyPeriod;

	//bi-directional many-to-one association to Oneorder
	@OneToOne(mappedBy="shArticle")
	private Oneorder oneorders;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="ID_PROD", nullable=false)
	private Product product;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="ID_STOCK", nullable=false)
	private Stock stock;

	public ShArticle() {
	}

	public long getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}

	public String getArticleName() {
		return this.articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public Date getDateAjoute() {
		return this.dateAjoute;
	}

	public void setDateAjoute(Date dateAjoute) {
		this.dateAjoute = dateAjoute;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgalt() {
		return this.imgalt;
	}

	public void setImgalt(String imgalt) {
		this.imgalt = imgalt;
	}

	public String getImgheight() {
		return this.imgheight;
	}

	public void setImgheight(String imgheight) {
		this.imgheight = imgheight;
	}

	public String getImgwidth() {
		return this.imgwidth;
	}

	public void setImgwidth(String imgwidth) {
		this.imgwidth = imgwidth;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getWarrantyPeriod() {
		return this.warrantyPeriod;
	}

	public void setWarrantyPeriod(Date warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public Oneorder getOneorders() {
		return this.oneorders;
	}

	public void setOneorders(Oneorder oneorders) {
		this.oneorders = oneorders;
	}

	
	
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	
}