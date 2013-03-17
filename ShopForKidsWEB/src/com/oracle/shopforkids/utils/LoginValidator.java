/**
 * 
 */
package com.oracle.shopforkids.utils;



import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.oracle.shopforkids.beans.CustomerBean;

/**
 * @author Steve Olela
 *
 */
public class LoginValidator implements  Validator {
	
	private CustomerBean custo;

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String enteredEmail = (String)value;
		  
		boolean emailused=getCusto().Checkloginused(enteredEmail);
		if(emailused){
			FacesMessage message = new FacesMessage();
			   message.setSummary("login already used");
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
