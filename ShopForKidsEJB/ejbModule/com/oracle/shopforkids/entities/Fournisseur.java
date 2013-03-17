package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.ValidationException;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the FOURNISSEUR database table.
 * 
 */
@Entity
@Table(name="FOURNISSEUR")
public class Fournisseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FOURNISSEUR_IDSUPPLIER_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FOURNISSEUR_IDSUPPLIER_GENERATOR")
	@Column(name="ID_SUPPLIER", unique=true, nullable=false, length=20)
	private String idSupplier;

	@Column(length=20)
	private String mailfourn;

	@Column(name="STREET_SUP", length=20)
	private String streetSup;

	@Column(name="TEL_SUPP", precision=22)
	private BigDecimal telSupp;

	//bi-directional many-to-one association to ShRegion
	@ManyToOne
	@JoinColumn(name="ID_REGION")
	private ShRegion shRegion;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="fournisseur")
	private List<Stock> stocks;

	public Fournisseur() {
	}

	public String getIdSupplier() {
		return this.idSupplier;
	}

	public void setIdSupplier(String idSupplier) {
		this.idSupplier = idSupplier;
	}

	public String getMailfourn() {
		return this.mailfourn;
	}

	public void setMailfourn(String mailfourn) {
		this.mailfourn = mailfourn;
	}

	public String getStreetSup() {
		return this.streetSup;
	}

	public void setStreetSup(String streetSup) {
		this.streetSup = streetSup;
	}

	public BigDecimal getTelSupp() {
		return this.telSupp;
	}

	public void setTelSupp(BigDecimal telSupp) {
		this.telSupp = telSupp;
	}

	public ShRegion getShRegion() {
		return this.shRegion;
	}

	public void setShRegion(ShRegion shRegion) {
		this.shRegion = shRegion;
	}

	
	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	
	public Stock addStocks(Stock stocks) {
		getStocks().add(stocks);
		stocks.setFournisseur(this);

		return stocks;
	}

	public Stock removeStocks(Stock stocks) {
		getStocks().remove(stocks);
		stocks.setFournisseur(null);

		return stocks;
	}
	
	@PrePersist
	@PreUpdate
	private void ValiderData(){
		if(mailfourn==null || "".equals(mailfourn))
			throw new ValidationException("Invalid email");
		if(streetSup==null || "".equals(streetSup))
			throw new ValidationException("Invalid Street");
		if(telSupp==null || "".equals(telSupp))
			throw new ValidationException("Invalid Street");
		
	}
}