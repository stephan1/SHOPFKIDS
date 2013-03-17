package com.oracle.shopforkids.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SH_ORDER database table.
 * 
 */
@Entity
@Table(name="SH_ORDER")
public class ShOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SH_ORDER_IDORDER_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SH_ORDER_IDORDER_GENERATOR")
	@Column(name="ID_ORDER", unique=true, nullable=false, precision=22)
	private long idOrder;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_ORDER", nullable=false)
	private Date dateOrder;

	
	@Column(name="STATUS_ORDER", length=20)
	private String statusOrder;
	//bi-directional many-to-many association to Oneorder
	@OneToMany
	@JoinTable(
		name="SH_ONEORDER_TJ"
		, joinColumns={
			@JoinColumn(name="ID_ORDER", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_ONEORDER", nullable=false)
			}
		)
	private List<Oneorder> oneorders;

	//bi-directional many-to-one association to ShAddress
	@ManyToOne
	@JoinColumn(name="ID_ADDRESS")
	private ShAddress shAddress1;

	//bi-directional many-to-one association to ShCartecredit
	@ManyToOne
	@JoinColumn(name="ID_CREDIT")
	private ShCartecredit shCartecredit;

	//bi-directional many-to-one association to ShUser
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private ShUser shUser;

	//bi-directional many-to-one association to ShAddress
	@ManyToOne
	@JoinColumn(name="ID_ADDRESS")
	private ShAddress shAddress2;

	public ShOrder() {
	}

	public long getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDateOrder() {
		return this.dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}
	@PrePersist
	
	private void setDateCommande(){
		dateOrder=new Date();
	}

	public List<Oneorder> getOneorders() {
		return this.oneorders;
	}

	public void setOneorders(List<Oneorder> oneorders) {
		this.oneorders = oneorders;
	}

	
	public ShAddress getShAddress1() {
		return this.shAddress1;
	}

	public void setShAddress1(ShAddress shAddress1) {
		this.shAddress1 = shAddress1;
	}

	
	public ShCartecredit getShCartecredit() {
		return this.shCartecredit;
	}

	public void setShCartecredit(ShCartecredit shCartecredit) {
		this.shCartecredit = shCartecredit;
	}

	
	public ShUser getShUser() {
		return this.shUser;
	}

	public void setShUser(ShUser shUser) {
		this.shUser = shUser;
	}

	
	public ShAddress getShAddress2() {
		return this.shAddress2;
	}

	public void setShAddress2(ShAddress shAddress2) {
		this.shAddress2 = shAddress2;
	}
	public String getStatusOrder() {
		return this.statusOrder;
	}

	public void setStatusOrder(String statusOrder) {
		this.statusOrder = statusOrder;
	}

	public BigDecimal getTotal(){
		if(oneorders==null||oneorders.isEmpty())
			return BigDecimal.ZERO;
		BigDecimal total=BigDecimal.ZERO;
		for(Oneorder s:oneorders){
			total.add(s.getSubTotal());
		}
		return total;
	}
}