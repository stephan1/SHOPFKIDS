package com.oracle.shopforkids.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

public class beans {
	private String text;
	private Integer count;
	 private String input1;
	    private String input2;
	    
	    // Actions ------------------------------------------------------------------------------------

	    public String submit() {
	        String message = String.format("Submitted: input1=%s, input2=%s", input1, input2);
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
			return message;
	    }

	    // Getters/setters ----------------------------------------------------------------------------

	    public String getInput1() {
	        return input1;
	    }

	    public void setInput1(String input1) {
	        this.input1 = input1;
	    }

	    public String getInput2() {
	        return input2;
	    }

	    public void setInput2(String input2) {
	        this.input2 = input2;
	    }
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	public void countListener(AjaxBehaviorEvent event) { 
		   count = text.length(); 
		}
}
