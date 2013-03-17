package com.oracle.shopforkids.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.oracle.shopforkids.beans.CustomerBean;


@FacesValidator("emailvalidator")
public class EmailValidator implements Validator {
	
	private CustomerBean custo;
	

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		// TODO Auto-generated method stub
		String enteredEmail = (String)value;
		   Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		   Matcher m = p.matcher(enteredEmail);
		   boolean matchFound = m.matches();

		   if (!matchFound) {
		   FacesMessage message = new FacesMessage();
		   message.setSummary("Invalid Email ID.");
		   throw new ValidatorException(message);
		   }
		boolean emailused=getCusto().Checkemail(enteredEmail);
		if(emailused){
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			   message.setSummary("Email already used");
			   FacesContext.getCurrentInstance().addMessage(null, message);
			   throw new ValidatorException(message);
		}
		
	}

	/**
	 * @return the custo
	 */
	public CustomerBean getCusto() {
		return custo;
	}

	/**
	 * @param custo the custo to set
	 */
	public void setCusto(CustomerBean custo) {
		this.custo = custo;
	}

																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									

}
