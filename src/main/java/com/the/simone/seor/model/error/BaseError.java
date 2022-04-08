package com.the.simone.seor.model.error;

public class BaseError {
	
	private String errId;
	private String errDescr;
	private String errType;
	private boolean isError = false;
	
	public String getErrId() {
		return errId;
	}
	public void setErrId(String errId) {
		this.errId = errId;
	}
	public String getErrDescr() {
		return errDescr;
	}
	public void setErrDescr(String errDescr) {
		this.errDescr = errDescr;
	}
	public String getErrType() {
		return errType;
	}
	public void setErrType(String errType) {
		this.errType = errType;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	
	

}
