package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CONTINENT database table.
 * 
 */
@Entity
@Table(name="CONTINENT")
public class Continent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTINENT_CONTINENTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTINENT_CONTINENTID_GENERATOR")
	@Column(name="CONTINENT_ID", unique=true, nullable=false, precision=22)
	private long continentId;

	@Column(name="CONT_NAME", nullable=false, length=20)
	private String contName;

	//bi-directional many-to-one association to Country
	@OneToMany(mappedBy="continentBean")
	private List<Country> countries;

	public Continent() {
	}

	public long getContinentId() {
		return this.continentId;
	}

	public void setContinentId(long continentId) {
		this.continentId = continentId;
	}

	public String getContName() {
		return this.contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public List<Country> getCountries() {
		return this.countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	
	public Country addCountries(Country countries) {
		getCountries().add(countries);
		countries.setContinentBean(this);

		return countries;
	}

	public Country removeCountries(Country countries) {
		getCountries().remove(countries);
		countries.setContinentBean(null);

		return countries;
	}
}