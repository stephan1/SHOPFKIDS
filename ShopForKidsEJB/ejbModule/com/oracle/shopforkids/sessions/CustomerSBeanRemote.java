package com.oracle.shopforkids.sessions;



import java.security.MessageDigest;

import com.oracle.shopforkids.entities.ShAddress;
import com.oracle.shopforkids.entities.ShCartecredit;
import com.oracle.shopforkids.entities.ShUser;
import com.oracle.shopforkids.entities.Usergrantrole;
import javax.ejb.Remote;


/**
 * @generated DT_ID=none
 */
@Remote
public interface CustomerSBeanRemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Usergrantrole persistUsergrantrole(Usergrantrole usergrantrole);

    /**
     * @generated DT_ID=none
     */
    public Usergrantrole mergeUsergrantrole(Usergrantrole usergrantrole);

    /**
     * @generated DT_ID=none
     */
    public void removeUsergrantrole(Usergrantrole usergrantrole);

    /**
     * @generated DT_ID=none
     */
    public ShUser persistShUser(ShUser shUser);

    /**
     * @generated DT_ID=none
     */
    public ShUser mergeShUser(ShUser shUser);

    /**
     * @generated DT_ID=none
     */
    public void removeShUser(ShUser shUser);

    /**
     * @generated DT_ID=none
     */
    public ShAddress persistShAddress(ShAddress shAddress);

    /**
     * @generated DT_ID=none
     */
    public ShAddress mergeShAddress(ShAddress shAddress);

    /**
     * @generated DT_ID=none
     */
    public void removeShAddress(ShAddress shAddress);
    
    public Long genererIDUser();
    
    public ShUser genererSUser(ShUser shuser);
    public ShUser UpdateCustomerAddress(ShUser u, ShAddress v);
    public ShUser UpdateCustomerCartCredit(ShUser u, ShCartecredit v);
    public boolean  authenticate_user(String  user, String password) throws Exception;
    public String hashPassword(MessageDigest md1,String password) throws Exception;
    public String hashDigestPassword(String user, String password) throws Exception ;
    public boolean checkemailnotused(String mail);
    public boolean checkloginnotused(String logincusto);
    }
