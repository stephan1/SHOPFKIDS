package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.ValidationException;

import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SH_USER database table.
 * 
 */
@Entity
@Table(name="SH_USER")
@NamedStoredProcedureQueries(value = { @NamedStoredProcedureQuery(name = "ShUser.GenerateID", procedureName = "STEVE.GENERATEIDUSER") })
public class ShUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SH_USER_IDUSER_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SH_USER_IDUSER_GENERATOR")
	@Column(name="ID_USER", unique=true, nullable=false, precision=22)
	private long idUser;

	@Column(length=20)
	private String activation;

	@Column(nullable=false, length=20)
	private String email;

	@Column(precision=22)
	private BigDecimal fax;

	@Column(nullable=false, length=20)
	private String firstname;

	@Column(name="LANG_CUSTO", length=20)
	private String langCusto;

	@Column(name="LOGIN_CUSTO", nullable=false, length=20)
	private String loginCusto;

	@Column(nullable=false, length=20)
	private String name;

	@Column(name="PHONE_USER", precision=10)
	private BigDecimal phoneUser;

	@Column(name="SH_PASSWORD", nullable=false, length=20)
	private String shPassword;

	@Column(length=20)
	private String titre;
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_JOINED", nullable=false)
	private Date dateJoined;

	//bi-directional many-to-one association to ShCartecredit
	@OneToMany(mappedBy="shUser")
	private List<ShCartecredit> shCartecredits;

	//bi-directional many-to-one association to ShOrder
	@OneToMany(mappedBy="shUser")
	private List<ShOrder> shOrders;

	//bi-directional many-to-one association to Usergrantrole
	@OneToMany(mappedBy="shUser")
	private List<Usergrantrole> usergrantroles;

	//bi-directional one-to-one association to ShAddress
	@OneToOne(mappedBy="shUser")
	private ShAddress shAddress;

	public ShUser() {
	}

	public long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getActivation() {
		return this.activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getFax() {
		return this.fax;
	}

	public void setFax(BigDecimal fax) {
		this.fax = fax;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLangCusto() {
		return this.langCusto;
	}

	public void setLangCusto(String langCusto) {
		this.langCusto = langCusto;
	}

	public String getLoginCusto() {
		return this.loginCusto;
	}

	public void setLoginCusto(String loginCusto) {
		this.loginCusto = loginCusto;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPhoneUser() {
		return this.phoneUser;
	}

	public void setPhoneUser(BigDecimal phoneUser) {
		this.phoneUser = phoneUser;
	}

	public String getShPassword() {
		return this.shPassword;
	}

	public void setShPassword(String shPassword) {
		this.shPassword = shPassword;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<ShCartecredit> getShCartecredits() {
		return this.shCartecredits;
	}

	public void setShCartecredits(List<ShCartecredit> shCartecredits) {
		this.shCartecredits = shCartecredits;
	}

	
	public ShCartecredit addShCartecredits(ShCartecredit shCartecredits) {
		getShCartecredits().add(shCartecredits);
		shCartecredits.setShUser(this);

		return shCartecredits;
	}

	public ShCartecredit removeShCartecredits(ShCartecredit shCartecredits) {
		getShCartecredits().remove(shCartecredits);
		shCartecredits.setShUser(null);

		return shCartecredits;
	}
	public List<ShOrder> getShOrders() {
		return this.shOrders;
	}

	public void setShOrders(List<ShOrder> shOrders) {
		this.shOrders = shOrders;
	}

	
	public ShOrder addShOrders(ShOrder shOrders) {
		getShOrders().add(shOrders);
		shOrders.setShUser(this);

		return shOrders;
	}

	public ShOrder removeShOrders(ShOrder shOrders) {
		getShOrders().remove(shOrders);
		shOrders.setShUser(null);

		return shOrders;
	}
	public List<Usergrantrole> getUsergrantroles() {
		return this.usergrantroles;
	}

	public void setUsergrantroles(List<Usergrantrole> usergrantroles) {
		this.usergrantroles = usergrantroles;
	}

	
	public Usergrantrole addUsergrantroles(Usergrantrole usergrantroles) {
		getUsergrantroles().add(usergrantroles);
		usergrantroles.setShUser(this);

		return usergrantroles;
	}

	public Usergrantrole removeUsergrantroles(Usergrantrole usergrantroles) {
		getUsergrantroles().remove(usergrantroles);
		usergrantroles.setShUser(null);

		return usergrantroles;
	}
	public ShAddress getShAddress() {
		return this.shAddress;
	}

	public void setShAddress(ShAddress shAddress) {
		this.shAddress = shAddress;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	@PrePersist
	@PreUpdate
	private void ValiderData(){
		if(firstname==null || "".equals(firstname))
			throw new ValidationException("Invalid firstname");
		if(name==null || "".equals(name))
			throw new ValidationException("Invalid name");
		if(shPassword==null || "".equals(shPassword))
		throw new ValidationException("Invalid Password");
		if(loginCusto==null || "".equals(loginCusto))
			throw new ValidationException("Invalid login");
	}
	public void matchPassword(String pwd){
		if(pwd==null || "".equals(pwd))
		throw new ValidationException("Invalid Password");
		if(!pwd.equals(shPassword))
			throw new ValidationException("Password don't match");
	}
}