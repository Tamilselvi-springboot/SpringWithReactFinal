package com.example.demo.model;

public class StepDetails {
	
	private String StepDesc;
	private String Expected;
	private String StepNo;
	public String getStepDesc() {
		return StepDesc;
	}
	public void setStepDesc(String stepDesc) {
		StepDesc = stepDesc;
	}
	public String getExpected() {
		return Expected;
	}
	public void setExpected(String expected) {
		Expected = expected;
	}
	public String getStepNo() {
		return StepNo;
	}
	public void setStepNo(String stepNo) {
		StepNo = stepNo;
	}
	public StepDetails(String stepNo, String stepDesc, String expected ) {
		super();
		StepNo = stepNo;
		StepDesc = stepDesc;
		Expected = expected;
		
	}
	
	
	
	

}
