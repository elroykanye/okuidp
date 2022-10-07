package com.camsoft.okuidp.util;

public enum IDPType {

	FAMILY("Family"),
	INDIVIDUAL("Individual");
	
	private String value;
	
	private IDPType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
