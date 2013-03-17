package com.oracle.shopforkids.mdriven;

import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.oracle.shopforkids.entities.ShUser;



/**
 * Message-Driven Bean implementation class for: EnvoiMailConfirmation
 *
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic"
		) }, 
		mappedName = "topic/mailconfirmuser")
public class EnvoiMailConfirmation implements MessageListener {

	private static final Logger log=Logger.getLogger("EnvoiMail");
	
    /**
     * Default constructor. 
     */
    public EnvoiMailConfirmation() {
        // TODO Auto-generated constructor stub
    	log.info("Envoi mail apres creation utilisateur");
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	if(message instanceof ObjectMessage){
    		ObjectMessage lemessage=(ObjectMessage)message;
    		try{
    			ShUser user=(ShUser) lemessage.getObject();
    			
    		String StrinMAil="";
    		String s="Creation nouveau utilisateur";
    		SendMAilto(user.getEmail(),s,StrinMAil);
    		}catch(JMSException e){
    			e.printStackTrace();
    			
    		}
    		
    	}
        
    }
    public void SendMAilto(String email,String subject,String body){
    	Properties props=new Properties();
    	try {
			InitialContext macontext=new InitialContext(props);
			javax.mail.Session masession=(javax.mail.Session)macontext.lookup("mail/ShopMail");
			MimeMessage message=new MimeMessage(masession);
			message.setSubject(subject);
			message.setRecipients(javax.mail.Message.RecipientType.TO, javax.mail.internet.InternetAddress.parse(email, false));
			message.setText(body);
			message.saveChanges();
			Transport trans=masession.getTransport("smtp");
			trans.connect();
			trans.sendMessage(message, message.getAllRecipients());
			
	    		trans.close();
	    	
					
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

}
