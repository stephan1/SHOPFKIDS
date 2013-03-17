package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SH_CATALOGS database table.
 * 
 */
@Entity
@Table(name="SH_CATALOGS")
public class ShCatalog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SH_CATALOGS_IDCATALOGSS_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SH_CATALOGS_IDCATALOGSS_GENERATOR")
	@Column(name="ID_CATALOGSS", unique=true, nullable=false, precision=22)
	private long idCatalogss;

	@Column(name="DESCRIPTION_CAT", length=100)
	private String descriptionCat;

	@Column(name="NAME_CAT", nullable=false, length=50)
	private String nameCat;

	//bi-directional many-to-one association to ShCategory
	@OneToMany(mappedBy="shCatalog")
	private List<ShCategory> shCategories;

	public ShCatalog() {
	}

	public long getIdCatalogss() {
		return this.idCatalogss;
	}

	public void setIdCatalogss(long idCatalogss) {
		this.idCatalogss = idCatalogss;
	}

	public String getDescriptionCat() {
		return this.descriptionCat;
	}

	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}

	public String getNameCat() {
		return this.nameCat;
	}

	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}

	public List<ShCategory> getShCategories() {
		return this.shCategories;
	}

	public void setShCategories(List<ShCategory> shCategories) {
		this.shCategories = shCategories;
	}

	
	public ShCategory addShCategories(ShCategory shCategories) {
		getShCategories().add(shCategories);
		shCategories.setShCatalog(this);

		return shCategories;
	}

	public ShCategory removeShCategories(ShCategory shCategories) {
		getShCategories().remove(shCategories);
		shCategories.setShCatalog(null);

		return shCategories;
	}
}