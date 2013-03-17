package com.oracle.shopforkids.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oracle.shopforkids.entities.ShAddress;
import com.oracle.shopforkids.entities.ShUser;
import com.oracle.shopforkids.entities.Usergrantrole;
import com.oracle.shopforkids.sessions.CustomerSBeanLocal;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;


/**
 * Managed bean for the CustomerSBeanLocal session bean.
 * @generated DT_ID=none
 */
public class CustomerBean
{
	private Date date_birth;
	private String jdate;
	private String mdate;
	private String adate;
	private boolean verifie;
	private String text1;

    /**
     * @generated DT_ID=none
     */
    @EJB
    private CustomerSBeanLocal sessionFacade;

    /**
     * @generated DT_ID=none
     */
    private Usergrantrole selectedUsergrantrole;

    /**
     * @generated DT_ID=none
     */
    private ShUser selectedShUser;

    /**
     * @generated DT_ID=none
     */
    private ShAddress selectedShAddress;

    /**
     * @generated DT_ID=none
     */
    public CustomerBean() {
        super();
    }

    /**
     * @generated DT_ID=none
     */
    public void setSessionFacade(CustomerSBeanLocal sessionFacade) {
        this.sessionFacade = sessionFacade;
    }

    /**
     * @generated DT_ID=none
     */
    public CustomerSBeanLocal getSessionFacade() {
        return sessionFacade;
    }

    /**
     * @generated DT_ID=none
     */
    public void setSelectedUsergrantrole(Usergrantrole current) {
        selectedUsergrantrole = current;
       
    }

    /**
     * @generated DT_ID=none
     */
    public Usergrantrole getSelectedUsergrantrole() {
        return selectedUsergrantrole;
    }

    /**
     * @generated DT_ID=none
     */
    public boolean isUsergrantroleSelected() {
        if (getSelectedUsergrantrole() != null)
            return true;
        else
            return false;
    }

    /**
     * @generated DT_ID=none
     */
    public String updateUsergrantrole() {
        if (getSelectedUsergrantrole() != null) {
            setSelectedUsergrantrole(getSessionFacade().mergeUsergrantrole(getSelectedUsergrantrole()));
            return "commit";
        }
        return null;
    }

    /**
     * @generated DT_ID=none
     */
    public String initCreateUsergrantrole() {
        Usergrantrole usergrantrole = new Usergrantrole();
        setSelectedUsergrantrole(usergrantrole);
        return "new";
    }

    /**
     * @generated DT_ID=none
     */
    public String createUsergrantrole() {
        if (getSelectedUsergrantrole() != null) {
            setSelectedUsergrantrole(getSessionFacade().persistUsergrantrole(getSelectedUsergrantrole()));
            return "commit";
        }
        return null;
    }

    /**
     * @generated DT_ID=none
     */
    public String deleteUsergrantrole() {
        if (getSelectedUsergrantrole() != null) {
            getSessionFacade().removeUsergrantrole(getSelectedUsergrantrole());
            return "commit";
        }
        return null;
    }

    /**
     * @generated DT_ID=none
     */
    public void setSelectedShUser(ShUser current) {
        selectedShUser = current;
    }

    /**
     * @generated DT_ID=none
     */
    public ShUser getSelectedShUser() {
        return selectedShUser;
    }

    /**
     * @generated DT_ID=none
     */
    public boolean isShUserSelected() {
        if (getSelectedShUser() != null)
            return true;
        else
            return false;
    }

    /**
     * @generated DT_ID=none
     */
    public String updateShUser() {
        if (getSelectedShUser() != null) {
            setSelectedShUser(getSessionFacade().mergeShUser(getSelectedShUser()));
            return "commit";
        }
        return null;
    }

    /**
     * @generated DT_ID=none
     */
    public String initCreateShUser() {
        ShUser shUser = new ShUser();
        setSelectedShUser(shUser);
        return "new";
    }

    /**
     * @generated DT_ID=none
     */
    public String createShUser() {
        if (getSelectedShUser() != null) {
            setSelectedShUser(getSessionFacade().persistShUser(getSelectedShUser()));
            return "commit";
        }
        return null;
    }

    /**
     * @generated DT_ID=none
     */
    public String deleteShUser() {
        if (getSelectedShUser() != null) {
            getSessionFacade().removeShUser(getSelectedShUser());
            return "commit";
        }
        return null;
    }

    /**
     * @generated DT_ID=none
     */
    public void setSelectedShAddress(ShAddress current) {
        selectedShAddress = current;
    }

    /**
     * @generated DT_ID=none
     */
    public ShAddress getSelectedShAddress() {
        return selectedShAddress;
    }

    /**
     * @generated DT_ID=none
     */
    public boolean isShAddressSelected() {
        if (getSelectedShAddress() != null)
            return true;
        else
            return false;
    }

    /**
     * @generated DT_ID=none
     */
    public String updateShAddress() {
        if (getSelectedShAddress() != null) {
            setSelectedShAddress(getSessionFacade().mergeShAddress(getSelectedShAddress()));
            return "commit";
        }
        return null;
    }

    /**
     * @generated DT_ID=none
     */
    public String initCreateShAddress() {
        ShAddress shAddress = new ShAddress();
        setSelectedShAddress(shAddress);
        return "new";
    }

    /**
     * @generated DT_ID=none
     */
    public String createShAddress() {
        if (getSelectedShAddress() != null) {
            setSelectedShAddress(getSessionFacade().persistShAddress(getSelectedShAddress()));
            return "commit";
        }
        return null;
    }

    /**
     * @generated DT_ID=none
     */
    public String deleteShAddress() {
        if (getSelectedShAddress() != null) {
            getSessionFacade().removeShAddress(getSelectedShAddress());
            return "commit";
        }
        return null;
    }
    public List<SelectItem> getTitre(){
    	List<SelectItem> maliste=new ArrayList<SelectItem>();
    	maliste.add(new SelectItem(0,"Choisizez votre sexe"));
    	maliste.add(new SelectItem(1,"Monsieur"));
    	maliste.add(new SelectItem(2,"Madame"));
    	maliste.add(new SelectItem(3,"Madame"));
    	return maliste;
    }

	/**
	 * @return the adate
	 */
	public String getAdate() {
		return adate;
	}

	/**
	 * @param adate the adate to set
	 */
	public void setAdate(String adate) {
		this.adate = adate;
	}

	/**
	 * @return the mdate
	 */
	public String getMdate() {
		return mdate;
	}

	/**
	 * @param mdate the mdate to set
	 */
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	/**
	 * @return the jdate
	 */
	public String getJdate() {
		return jdate;
	}

	/**
	 * @param jdate the jdate to set
	 */
	public void setJdate(String jdate) {
		this.jdate = jdate;
	}
	public Date getDateAnniv() throws ParseException{
		String Strdate=jdate;
		Strdate+=":"+mdate;
		Strdate+=":"+adate;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		date_birth=formatter.parse(Strdate);
		return date_birth;
	}
	public boolean Checkemail(String s){
		return getSessionFacade().checkemailnotused(s);
	}
	public boolean Checkloginused(String l){
		return getSessionFacade().checkloginnotused(l);
	}
	public String confirm(){
		
		boolean verifier=true;
		setVerifie(verifier);
		if(!verifier){
			return "failure";
		}
		return "success";
		
	}
	public String CreerUser(){
		String tr="";
		return tr;
	}
	public String CreerUserwithAdress(){
		String tr="";
		return tr;
	}
	public String BacktocreateUserForm(){
		return "back";
	}
	public String gotoAdressForm(){
		return "register_adress";
	}

	/**
	 * @return the verifie
	 */
	public boolean isVerifie() {
		return verifie;
	}

	/**
	 * @param verifie the verifie to set
	 */
	public void setVerifie(boolean verifie) {
		this.verifie = verifie;
	}

	/**
	 * @return the text1
	 */
	public String getText1() {
		return text1;
	}

	/**
	 * @param text1 the text1 to set
	 */
	public void setText1(String text1) {
		this.text1 = text1;
	}

	
}
