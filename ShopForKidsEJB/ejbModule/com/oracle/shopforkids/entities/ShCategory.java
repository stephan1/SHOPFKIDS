package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SH_CATEGORIES database table.
 * 
 */
@Entity
@Table(name="SH_CATEGORIES")
public class ShCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SH_CATEGORIES_IDCATEGORIES_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SH_CATEGORIES_IDCATEGORIES_GENERATOR")
	@Column(name="ID_CATEGORIES", unique=true, nullable=false, precision=22)
	private long idCategories;

	@Column(name="CAT_DESCRIPTION", length=50)
	private String catDescription;

	@Column(name="CATALOG_NAME", length=50)
	private String catalogName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="shCategory" , cascade=CascadeType.REMOVE)
	
	private List<Product> products;

	//bi-directional many-to-one association to ShCatalog
	@ManyToOne
	@JoinColumn(name="ID_CATALOGS")
	private ShCatalog shCatalog;

	public ShCategory() {
	}

	public long getIdCategories() {
		return this.idCategories;
	}

	public void setIdCategories(long idCategories) {
		this.idCategories = idCategories;
	}

	public String getCatDescription() {
		return this.catDescription;
	}

	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}

	public String getCatalogName() {
		return this.catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	public Product addProducts(Product products) {
		getProducts().add(products);
		products.setShCategory(this);

		return products;
	}

	public Product removeProducts(Product products) {
		getProducts().remove(products);
		products.setShCategory(null);

		return products;
	}
	public ShCatalog getShCatalog() {
		return this.shCatalog;
	}

	public void setShCatalog(ShCatalog shCatalog) {
		this.shCatalog = shCatalog;
	}

	
}