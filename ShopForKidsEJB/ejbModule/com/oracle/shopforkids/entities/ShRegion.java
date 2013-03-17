package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SH_REGION database table.
 * 
 */
@Entity
@Table(name="SH_REGION")
public class ShRegion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SH_REGION_REGIONID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SH_REGION_REGIONID_GENERATOR")
	@Column(name="REGION_ID", unique=true, nullable=false, precision=22)
	private long regionId;

	@Column(name="REGION_NAME", nullable=false, length=20)
	private String regionName;

	//bi-directional many-to-one association to Fournisseur
	@OneToMany(mappedBy="shRegion")
	private List<Fournisseur> fournisseurs;

	//bi-directional many-to-one association to ShAddress
	@OneToMany(mappedBy="shRegion")
	private List<ShAddress> shAddresses;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	//bi-directional many-to-one association to Warehouse
	@OneToMany(mappedBy="shRegion")
	private List<Warehouse> warehouses;

	public ShRegion() {
	}

	public long getRegionId() {
		return this.regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public List<Fournisseur> getFournisseurs() {
		return this.fournisseurs;
	}

	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	
	public Fournisseur addFournisseurs(Fournisseur fournisseurs) {
		getFournisseurs().add(fournisseurs);
		fournisseurs.setShRegion(this);

		return fournisseurs;
	}

	public Fournisseur removeFournisseurs(Fournisseur fournisseurs) {
		getFournisseurs().remove(fournisseurs);
		fournisseurs.setShRegion(null);

		return fournisseurs;
	}
	public List<ShAddress> getShAddresses() {
		return this.shAddresses;
	}

	public void setShAddresses(List<ShAddress> shAddresses) {
		this.shAddresses = shAddresses;
	}

	
	public ShAddress addShAddresses(ShAddress shAddresses) {
		getShAddresses().add(shAddresses);
		shAddresses.setShRegion(this);

		return shAddresses;
	}

	public ShAddress removeShAddresses(ShAddress shAddresses) {
		getShAddresses().remove(shAddresses);
		shAddresses.setShRegion(null);

		return shAddresses;
	}
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	
	public List<Warehouse> getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	
	public Warehouse addWarehouses(Warehouse warehouses) {
		getWarehouses().add(warehouses);
		warehouses.setShRegion(this);

		return warehouses;
	}

	public Warehouse removeWarehouses(Warehouse warehouses) {
		getWarehouses().remove(warehouses);
		warehouses.setShRegion(null);

		return warehouses;
	}
}