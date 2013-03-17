package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the WAREHOUSE database table.
 * 
 */
@Entity
@Table(name="WAREHOUSE")
public class Warehouse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WAREHOUSE_IDWAREHOUSE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WAREHOUSE_IDWAREHOUSE_GENERATOR")
	@Column(name="ID_WAREHOUSE", unique=true, nullable=false, precision=22)
	private long idWarehouse;

	@Column(name="W_ADDRESS", length=20)
	private String wAddress;

	@Column(name="W_CITY", length=20)
	private String wCity;

	@Column(name="W_CODEPOSTAL", length=20)
	private String wCodepostal;

	//bi-directional many-to-one association to ShRegion
	@ManyToOne
	@JoinColumn(name="ID_REGION")
	private ShRegion shRegion;

	public Warehouse() {
	}

	public long getIdWarehouse() {
		return this.idWarehouse;
	}

	public void setIdWarehouse(long idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public String getWAddress() {
		return this.wAddress;
	}

	public void setWAddress(String wAddress) {
		this.wAddress = wAddress;
	}

	public String getWCity() {
		return this.wCity;
	}

	public void setWCity(String wCity) {
		this.wCity = wCity;
	}

	public String getWCodepostal() {
		return this.wCodepostal;
	}

	public void setWCodepostal(String wCodepostal) {
		this.wCodepostal = wCodepostal;
	}

	public ShRegion getShRegion() {
		return this.shRegion;
	}

	public void setShRegion(ShRegion shRegion) {
		this.shRegion = shRegion;
	}

	
}