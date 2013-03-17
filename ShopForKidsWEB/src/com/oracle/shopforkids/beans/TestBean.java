package com.oracle.shopforkids.beans;

public class TestBean {
	private String radioValue = "foo";
	private String stringValue;

	public void changeRadioValue() {
	    setRadioValue("bar");
	}

	/**
	 * @return the radioValue
	 */
	public String getRadioValue() {
		return radioValue;
	}

	/**
	 * @param radioValue the radioValue to set
	 */
	public void setRadioValue(String radioValue) {
		this.radioValue = radioValue;
	}

	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * @param stringValue the stringValue to set
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
}
