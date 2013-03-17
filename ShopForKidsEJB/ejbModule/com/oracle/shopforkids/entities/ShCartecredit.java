package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.ValidationException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SH_CARTECREDIT database table.
 * 
 */
@Entity
@Table(name="SH_CARTECREDIT")
public class ShCartecredit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SH_CARTECREDIT_IDCREDIT_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SH_CARTECREDIT_IDCREDIT_GENERATOR")
	@Column(name="ID_CREDIT", unique=true, nullable=false, precision=22)
	private long idCredit;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_EXPIRATION")
	private Date dateExpiration;

	@Column(name="NUMERO_CARTE_CREDIT", nullable=false, precision=12)
	private BigDecimal numeroCarteCredit;

	@Column(name="TYPE_CARTE_CREDIT", nullable=false, length=20)
	private String typeCarteCredit;

	//bi-directional many-to-one association to ShUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private ShUser shUser;

	//bi-directional many-to-one association to ShOrder
	@OneToMany(mappedBy="shCartecredit")
	private List<ShOrder> shOrders;

	public ShCartecredit() {
	}

	public long getIdCredit() {
		return this.idCredit;
	}

	public void setIdCredit(long idCredit) {
		this.idCredit = idCredit;
	}

	public Date getDateExpiration() {
		return this.dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public BigDecimal getNumeroCarteCredit() {
		return this.numeroCarteCredit;
	}

	public void setNumeroCarteCredit(BigDecimal numeroCarteCredit) {
		this.numeroCarteCredit = numeroCarteCredit;
	}

	public String getTypeCarteCredit() {
		return this.typeCarteCredit;
	}

	public void setTypeCarteCredit(String typeCarteCredit) {
		this.typeCarteCredit = typeCarteCredit;
	}

	public ShUser getShUser() {
		return this.shUser;
	}

	public void setShUser(ShUser shUser) {
		this.shUser = shUser;
	}

	
	public List<ShOrder> getShOrders() {
		return this.shOrders;
	}

	public void setShOrders(List<ShOrder> shOrders) {
		this.shOrders = shOrders;
	}

	
	public ShOrder addShOrders(ShOrder shOrders) {
		getShOrders().add(shOrders);
		shOrders.setShCartecredit(this);

		return shOrders;
	}

	public ShOrder removeShOrders(ShOrder shOrders) {
		getShOrders().remove(shOrders);
		shOrders.setShCartecredit(null);

		return shOrders;
	}
	@PrePersist
	@PreUpdate
	private void ValiderData(){
		if(dateExpiration==null || "".equals(dateExpiration))
			throw new ValidationException("Invalid datee");
		if(numeroCarteCredit==null || "".equals(numeroCarteCredit))
			throw new ValidationException("Invalid numero Carte de credit");
		if(typeCarteCredit==null || "".equals(typeCarteCredit))
		throw new ValidationException("Invalid Password");
		
	}
}