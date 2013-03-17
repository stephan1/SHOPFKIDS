package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.ValidationException;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the SH_ADDRESS database table.
 * 
 */
@Entity
@Table(name="SH_ADDRESS")
public class ShAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SH_ADDRESS_IDADDRESS_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SH_ADDRESS_IDADDRESS_GENERATOR")
	@Column(name="ID_ADDRESS", unique=true, nullable=false, precision=22)
	private long idAddress;

	@Column(nullable=false, length=20)
	private String city;

	@Column(precision=22)
	private BigDecimal numappartement;

	@Column(name="POSTAL_CODE", nullable=false, length=20)
	private String postalCode;

	@Column(name="STREET_NAME", nullable=false, length=50)
	private String streetName;

	//bi-directional many-to-one association to ShRegion
	@ManyToOne
	@JoinColumn(name="REGION_ID")
	private ShRegion shRegion;

	//bi-directional many-to-one association to ShOrder
	@OneToMany(mappedBy="shAddress1")
	private List<ShOrder> shOrders1;

	//bi-directional one-to-one association to ShUser
	@OneToOne
	@JoinColumn(name="ID_ADDRESS", referencedColumnName="ID_ADDRESS", nullable=false, insertable=false, updatable=false)
	private ShUser shUser;

	//bi-directional many-to-one association to ShOrder
	@OneToMany(mappedBy="shAddress2")
	private List<ShOrder> shOrders2;

	public ShAddress() {
	}

	public long getIdAddress() {
		return this.idAddress;
	}

	public void setIdAddress(long idAddress) {
		this.idAddress = idAddress;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public BigDecimal getNumappartement() {
		return this.numappartement;
	}

	public void setNumappartement(BigDecimal numappartement) {
		this.numappartement = numappartement;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreetName() {
		return this.streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public ShRegion getShRegion() {
		return this.shRegion;
	}

	public void setShRegion(ShRegion shRegion) {
		this.shRegion = shRegion;
	}

	
	public List<ShOrder> getShOrders1() {
		return this.shOrders1;
	}

	public void setShOrders1(List<ShOrder> shOrders1) {
		this.shOrders1 = shOrders1;
	}

	
	public ShOrder addShOrders1(ShOrder shOrders1) {
		getShOrders1().add(shOrders1);
		shOrders1.setShAddress1(this);

		return shOrders1;
	}

	public ShOrder removeShOrders1(ShOrder shOrders1) {
		getShOrders1().remove(shOrders1);
		shOrders1.setShAddress1(null);

		return shOrders1;
	}
	public ShUser getShUser() {
		return this.shUser;
	}

	public void setShUser(ShUser shUser) {
		this.shUser = shUser;
	}

	
	public List<ShOrder> getShOrders2() {
		return this.shOrders2;
	}

	public void setShOrders2(List<ShOrder> shOrders2) {
		this.shOrders2 = shOrders2;
	}

	
	public ShOrder addShOrders2(ShOrder shOrders2) {
		getShOrders2().add(shOrders2);
		shOrders2.setShAddress2(this);

		return shOrders2;
	}

	public ShOrder removeShOrders2(ShOrder shOrders2) {
		getShOrders2().remove(shOrders2);
		shOrders2.setShAddress2(null);

		return shOrders2;
	}
	
@PrePersist
@PreUpdate
private void ValiderData(){
	if(city==null || "".equals(city))
		throw new ValidationException("Invalid city");
	if(postalCode==null || "".equals(postalCode))
		throw new ValidationException("Invalid postal Code");
	if(numappartement==null || "".equals(numappartement))
	throw new ValidationException("Invalid appartment number");
	if(streetName==null || "".equals(streetName))
		throw new ValidationException("Invalid street");
}
}