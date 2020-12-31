package com.example.demo.model;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;


public class testcaseResult {
	private String testcaseid;
	private String testcaseStatus;
	private String testcaseDesc;
	private String testcasePrecondition;
	
	private CopyOnWriteArrayList<StepResult> AllStepResult;
	//private CopyOnWriteArrayList<String> preConditionAndStepDescription;
	//private CopyOnWriteArrayList<String> expectedResult;
	//private CopyOnWriteArrayList<String> testcaseStatus;	
	//private String stepDescription;	
	//private CopyOnWriteArrayList<String> actualResult;
	//private CopyOnWriteArrayList<String> resultLog;

	public String getTestcaseid() {
		return testcaseid;
	}

	public void setTestcaseid(String testcaseid) {
		this.testcaseid = testcaseid;
	}

	public String getTestcaseStatus() {
		return testcaseStatus;
	}

	public void setTestcaseStatus(String testcaseStatus) {
		this.testcaseStatus = testcaseStatus;
	}

	public String getTestcaseDesc() {
		return testcaseDesc;
	}

	public void setTestcaseDesc(String testcaseDesc) {
		this.testcaseDesc = testcaseDesc;
	}

	public String getTestcasePrecondition() {
		return testcasePrecondition;
	}

	public void setTestcasePrecondition(String testcasePrecondition) {
		this.testcasePrecondition = testcasePrecondition;
	}

	public CopyOnWriteArrayList<StepResult> getAllStepResult() {
		return AllStepResult;
	}

	public void setAllStepResult(CopyOnWriteArrayList<StepResult> allStepResult) {
		AllStepResult = allStepResult;
	}

	public testcaseResult(String testcaseid,  String testcaseDesc, String testcasePrecondition,String testcaseStatus,
			CopyOnWriteArrayList<StepResult> allStepResult ) {
		super();
		this.testcaseid = testcaseid;
		this.testcaseStatus = testcaseStatus;
		this.testcaseDesc = testcaseDesc;
		this.testcasePrecondition = testcasePrecondition;
		AllStepResult = allStepResult;
	}

	
	

	
	
	
	
	
	

}
