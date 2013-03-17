package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COUNTRY database table.
 * 
 */
@Entity
@Table(name="COUNTRY")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COUNTRY_COUNTRYID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COUNTRY_COUNTRYID_GENERATOR")
	@Column(name="COUNTRY_ID", unique=true, nullable=false, precision=22)
	private long countryId;

	@Column(name="COUNTRY_NAME", length=20)
	private String countryName;

	//bi-directional many-to-one association to Continent
	@ManyToOne
	@JoinColumn(name="CONTINENT", nullable=false)
	private Continent continentBean;

	//bi-directional many-to-one association to ShRegion
	@OneToMany(mappedBy="country")
	private List<ShRegion> shRegions;

	public Country() {
	}

	public long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Continent getContinentBean() {
		return this.continentBean;
	}

	public void setContinentBean(Continent continentBean) {
		this.continentBean = continentBean;
	}

	
	public List<ShRegion> getShRegions() {
		return this.shRegions;
	}

	public void setShRegions(List<ShRegion> shRegions) {
		this.shRegions = shRegions;
	}

	
	public ShRegion addShRegions(ShRegion shRegions) {
		getShRegions().add(shRegions);
		shRegions.setCountry(this);

		return shRegions;
	}

	public ShRegion removeShRegions(ShRegion shRegions) {
		getShRegions().remove(shRegions);
		shRegions.setCountry(null);

		return shRegions;
	}
}