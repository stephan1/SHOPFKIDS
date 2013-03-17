package com.oracle.shopforkids.sessions;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.oracle.shopforkids.entities.ShAddress;
import com.oracle.shopforkids.entities.ShCartecredit;
import com.oracle.shopforkids.entities.ShMyrole;
import com.oracle.shopforkids.entities.ShUser;
import com.oracle.shopforkids.entities.Usergrantrole;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import weblogic.utils.encoders.BASE64Encoder;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "CustomerSBean", mappedName = "ShopForKids-ShopForKidsEJB-CustomerSBean")
public class CustomerSBean
        implements CustomerSBeanLocal, CustomerSBeanRemote
{
	protected static final String ALGORITHM="SHA-1";
	private static final String REALNAME="myrealm";
	private transient MessageDigest md;
	@Resource(mappedName="jms/shopconnfact") 
	private ConnectionFactory mafactory; 
	@Resource(mappedName="topic/mailconfirmuser") private Topic destinationTopic;
	private ShUser user;

    /**
     * @generated DT_ID=none
     */
    @PersistenceContext(unitName="ShopForKidsEJB")
    private EntityManager em;
    
    /**
     * @generated DT_ID=none
     */
    public CustomerSBean() {
    	 try {
    		user=new ShUser(); 
			md = MessageDigest.getInstance(ALGORITHM.toUpperCase());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * @generated DT_ID=none
     */
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }

        return query.getResultList();
    }

    /**
     * @generated DT_ID=none
     */
    public Usergrantrole persistUsergrantrole(Usergrantrole usergrantrole) {
        em.persist(usergrantrole);
        return usergrantrole;
    }

    /**
     * @generated DT_ID=none
     */
    public Usergrantrole mergeUsergrantrole(Usergrantrole usergrantrole) {
        return em.merge(usergrantrole);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeUsergrantrole(Usergrantrole usergrantrole) {
        usergrantrole = em.find(Usergrantrole.class, usergrantrole.getIdGrantRole());
        em.remove(usergrantrole);
    }

    /**
     * @generated DT_ID=none
     */
    public ShUser persistShUser(ShUser shUser) {
        em.persist(shUser);
        return shUser;
    }
    
   
    /**
     * @generated DT_ID=none
     * Fait une mise a jour
     */
    public ShUser mergeShUser(ShUser shUser) {
        return em.merge(shUser);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeShUser(ShUser shUser) {
        shUser = em.find(ShUser.class, shUser.getIdUser());
        em.remove(shUser);
    }

    /**
     * @generated DT_ID=none
     */
    public ShAddress persistShAddress(ShAddress shAddress) {
        em.persist(shAddress);
        return shAddress;
    }

    /**
     * @generated DT_ID=none
     */
    public ShAddress mergeShAddress(ShAddress shAddress) {
        return em.merge(shAddress);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeShAddress(ShAddress shAddress) {
        shAddress = em.find(ShAddress.class, shAddress.getIdAddress());
        em.remove(shAddress);
    }
    
    ///MES FONCTIONS
    
    public ShMyrole roleuser_simple_register(){
    	ShMyrole rol=new ShMyrole();
    	String q="select c from ShMyrole c where c.idrole:=2 ";
    	Query query=em.createNamedQuery(q);
    	rol=(ShMyrole) query.getSingleResult();
    	return rol;
    }
    public Long genererIDUser(){
    	return  (Long) em.createNamedQuery("ShUser.GenerateID").getSingleResult();
    }
    
    
    public ShUser genererSUser(ShUser shuser){
    	
    	String val_hash_pass="";
    	String val_hash_disget_pass="";
    	//shuser.setShAddress(adresss);
    	try {
    		
    		val_hash_pass=hashPassword(md,this.user.getShPassword());
    		val_hash_disget_pass=hashDigestPassword(shuser.getLoginCusto(),shuser.getShPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	shuser.setShPassword(val_hash_pass);
    	shuser.setActivation(val_hash_disget_pass);
    	Date  sdate=new Date();
    	long t=sdate.getTime();
    	java.sql.Date sqlsdate=new java.sql.Date(t);
    	shuser.setDateJoined(sqlsdate);
    	
    	em.persist(shuser);
    	Usergrantrole sonrole=new Usergrantrole();
    	sonrole.setShMyrole(roleuser_simple_register());
    	sonrole.setShUser(shuser);
    	persistUsergrantrole(sonrole);
    	return shuser;
    }
    @TransactionAttribute(value=TransactionAttributeType.NEVER)
    public ShUser findUserbyId(String Login){
    	Query q=em.createNamedQuery("select u from ShUser u where u.loginCusto =:sonlog");
    	q.setParameter("sonlog", Login);
    	ShUser user=(ShUser)q.getSingleResult();
    	return user;
    }
    public ShUser UpdateCustomerAddress(ShUser u, ShAddress v){
    	u.setShAddress(v);
    	mergeShUser(u);
    	return u;
    	
    }
    public ShUser UpdateCustomerCartCredit(ShUser u, ShCartecredit v){
    	List <ShCartecredit> shCartecredits=new ArrayList<ShCartecredit>();
    	shCartecredits.add(v);
       u.setShCartecredits(shCartecredits);
       mergeShUser(u);
    	return u;
    }
    
    
    public String hashDigestPassword(String user, String password) throws Exception  {
        String key = user + ":" + REALNAME + ":" + password;
        return hashPassword(md, key);
    }

    
    public String hashPassword(MessageDigest md1,String password) throws Exception {
    	BASE64Encoder enc = new BASE64Encoder();
         md1 = (MessageDigest) MessageDigest.getInstance(ALGORITHM).clone();
        md1.reset();

        byte[] bytes = md1.digest(password.getBytes());
        
        return enc.encodeBuffer(bytes);
    }
    public boolean  authenticate_user(String  user, String password) throws Exception{
    	  	
    	Query q =em.createNamedQuery("select c.shPassword from ShUser c where c.loginCusto=:sonlog  ");
    	q.setParameter("sonlog", user);
    	ShUser u=(ShUser)q.getSingleResult();
    	String hashed=md!=null?hashPassword(md,password):password;
    	return hashed.equals(u.getShPassword());
    }
    public void MailtoTopic(ShUser u){
    	Connection con=null;
    	Session masession=null;
    	
    	try {
			con=mafactory.createConnection();
			masession=con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producteur=masession.createProducer(destinationTopic);
			ObjectMessage lemessage=masession.createObjectMessage();
			lemessage.setObject(u);
			producteur.send(lemessage);
			masession.close();
			con.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
 public void verifier(){
	 
    }
 public boolean checkemailnotused(String mail){
	 Query query=em.createNamedQuery("select c from ShUser c where c.email=:lemail ");
	 query.setParameter("lemail", mail);
	 ShUser u=(ShUser)query.getSingleResult();
	 String val=u.getEmail();
	
	 return  val.isEmpty();
 }
 public boolean checkloginnotused(String logincusto){
	 Query query=em.createNamedQuery("select c from ShUser c where c.loginCusto=:logincusto ");
	 query.setParameter("lemail", logincusto);
	 ShUser u=(ShUser)query.getSingleResult();
	 String val=u.getLoginCusto();
	 return val.isEmpty();
 }


}
