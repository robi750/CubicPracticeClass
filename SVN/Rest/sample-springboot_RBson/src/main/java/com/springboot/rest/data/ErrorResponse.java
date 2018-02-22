package com.springboot.rest.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorResponse {
	private String code;
	private String error;

	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(String code, String error) {
		super();
		this.code = code;
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ErrorResponse [code=" + code + ", error=" + error + "]";
	}

}
