package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USERGRANTROLE database table.
 * 
 */
@Entity
@Table(name="USERGRANTROLE")
public class Usergrantrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERGRANTROLE_IDGRANTROLE_GENERATOR", sequenceName="SEQ_USERGRANTROLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERGRANTROLE_IDGRANTROLE_GENERATOR")
	@Column(name="ID_GRANT_ROLE", unique=true, nullable=false, precision=22)
	private long idGrantRole;

	//bi-directional many-to-one association to ShMyrole
	@ManyToOne
	@JoinColumn(name="ID_MYROLE")
	private ShMyrole shMyrole;

	//bi-directional many-to-one association to ShUser
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private ShUser shUser;

	public Usergrantrole() {
	}

	public long getIdGrantRole() {
		return this.idGrantRole;
	}

	public void setIdGrantRole(long idGrantRole) {
		this.idGrantRole = idGrantRole;
	}

	public ShMyrole getShMyrole() {
		return this.shMyrole;
	}

	public void setShMyrole(ShMyrole shMyrole) {
		this.shMyrole = shMyrole;
	}

	
	public ShUser getShUser() {
		return this.shUser;
	}

	public void setShUser(ShUser shUser) {
		this.shUser = shUser;
	}

	
}