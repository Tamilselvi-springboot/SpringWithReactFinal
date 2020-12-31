package com.example.demo.model;

public class StepResult {

	private String StepDesc;
	private String StepNo;
	private String Expected;
	private String Actual;
	private String StepResultStatus;
	private String stepResultLog;
	private String stepValidationType;
	public String getStepDesc() {
		return StepDesc;
	}
	public void setStepDesc(String stepDesc) {
		StepDesc = stepDesc;
	}
	public String getStepNo() {
		return StepNo;
	}
	public void setStepNo(String stepNo) {
		StepNo = stepNo;
	}
	public String getExpected() {
		return Expected;
	}
	public void setExpected(String expected) {
		Expected = expected;
	}
	public String getActual() {
		return Actual;
	}
	public void setActual(String actual) {
		Actual = actual;
	}
	public String getStepResultStatus() {
		return StepResultStatus;
	}
	public void setStepResultStatus(String stepResultStatus) {
		StepResultStatus = stepResultStatus;
	}
	public String getStepResultLog() {
		return stepResultLog;
	}
	public void setStepResultLog(String stepResultLog) {
		this.stepResultLog = stepResultLog;
	}
	public String getStepValidationType() {
		return stepValidationType;
	}
	public void setStepValidationType(String stepValidationType) {
		this.stepValidationType = stepValidationType;
	}
	public StepResult(String stepNo, String stepDesc, String expected, String actual, String stepResultStatus,
			String stepResultLog, String stepValidationType) {
		super();
		StepDesc = stepDesc;
		StepNo = stepNo;
		Expected = expected;
		Actual = actual;
		StepResultStatus = stepResultStatus;
		this.stepResultLog = stepResultLog;
		this.stepValidationType = stepValidationType;
	}
	
	
	

	
	
	
}
