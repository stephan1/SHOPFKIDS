package com.oracle.shopforkids.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SH_MYROLE database table.
 * 
 */
@Entity
@Table(name="SH_MYROLE")
public class ShMyrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SH_MYROLE_IDROLE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SH_MYROLE_IDROLE_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long idrole;

	@Column(length=20)
	private String description;

	@Column(length=20)
	private String namerole;

	@Column(length=20)
	private String shortname;

	//bi-directional many-to-one association to Usergrantrole
	@OneToMany(mappedBy="shMyrole")
	private List<Usergrantrole> usergrantroles;

	public ShMyrole() {
	}

	public long getIdrole() {
		return this.idrole;
	}

	public void setIdrole(long idrole) {
		this.idrole = idrole;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNamerole() {
		return this.namerole;
	}

	public void setNamerole(String namerole) {
		this.namerole = namerole;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public List<Usergrantrole> getUsergrantroles() {
		return this.usergrantroles;
	}

	public void setUsergrantroles(List<Usergrantrole> usergrantroles) {
		this.usergrantroles = usergrantroles;
	}

	
	public Usergrantrole addUsergrantroles(Usergrantrole usergrantroles) {
		getUsergrantroles().add(usergrantroles);
		usergrantroles.setShMyrole(this);

		return usergrantroles;
	}

	public Usergrantrole removeUsergrantroles(Usergrantrole usergrantroles) {
		getUsergrantroles().remove(usergrantroles);
		usergrantroles.setShMyrole(null);

		return usergrantroles;
	}
}