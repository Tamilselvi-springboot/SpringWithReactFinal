package com.example.demo.model;

import java.util.concurrent.CopyOnWriteArrayList;

public class RESTTestResult {
	private String scenario_No;
	private boolean isSelected;
	  private String  scenario_Description;
	  private String precondition;
	  private CopyOnWriteArrayList<String>  step_Number;
	  private CopyOnWriteArrayList<String>step_Description;
	  private CopyOnWriteArrayList<String> step_ExpectedResult;
	  private String tcStatus;
	  private CopyOnWriteArrayList<String> step_ActualResult;
	  private CopyOnWriteArrayList<String> stepResultLog;
	  private CopyOnWriteArrayList<String> stepResult;
	public String getScenario_No() {
		return scenario_No;
	}
	public void setScenario_No(String scenario_No) {
		this.scenario_No = scenario_No;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	public String getScenario_Description() {
		return scenario_Description;
	}
	public void setScenario_Description(String scenario_Description) {
		this.scenario_Description = scenario_Description;
	}
	public String getPrecondition() {
		return precondition;
	}
	public void setPrecondition(String precondition) {
		this.precondition = precondition;
	}
	public CopyOnWriteArrayList<String> getStep_Number() {
		return step_Number;
	}
	public void setStep_Number(CopyOnWriteArrayList<String> step_Number) {
		this.step_Number = step_Number;
	}
	public CopyOnWriteArrayList<String> getStep_Description() {
		return step_Description;
	}
	public void setStep_Description(CopyOnWriteArrayList<String> step_Description) {
		this.step_Description = step_Description;
	}
	public CopyOnWriteArrayList<String> getStep_ExpectedResult() {
		return step_ExpectedResult;
	}
	public void setStep_ExpectedResult(CopyOnWriteArrayList<String> step_ExpectedResult) {
		this.step_ExpectedResult = step_ExpectedResult;
	}
	public String getTcStatus() {
		return tcStatus;
	}
	public void setTcStatus(String tcStatus) {
		this.tcStatus = tcStatus;
	}
	public CopyOnWriteArrayList<String> getStep_ActualResult() {
		return step_ActualResult;
	}
	public void setStep_ActualResult(CopyOnWriteArrayList<String> step_ActualResult) {
		this.step_ActualResult = step_ActualResult;
	}
	public CopyOnWriteArrayList<String> getStepResultLog() {
		return stepResultLog;
	}
	public void setStepResultLog(CopyOnWriteArrayList<String> stepResultLog) {
		this.stepResultLog = stepResultLog;
	}
	public CopyOnWriteArrayList<String> getStepResult() {
		return stepResult;
	}
	public void setStepResult(CopyOnWriteArrayList<String> stepResult) {
		this.stepResult = stepResult;
	}
	public RESTTestResult(String scenario_No, boolean isSelected, String scenario_Description, String precondition,
			CopyOnWriteArrayList<String> step_Number, CopyOnWriteArrayList<String> step_Description,
			CopyOnWriteArrayList<String> step_ExpectedResult, String tcStatus,
			CopyOnWriteArrayList<String> step_ActualResult, CopyOnWriteArrayList<String> stepResultLog,
			CopyOnWriteArrayList<String> stepResult) {
		super();
		this.scenario_No = scenario_No;
		this.isSelected = isSelected;
		this.scenario_Description = scenario_Description;
		this.precondition = precondition;
		this.step_Number = step_Number;
		this.step_Description = step_Description;
		this.step_ExpectedResult = step_ExpectedResult;
		this.tcStatus = tcStatus;
		this.step_ActualResult = step_ActualResult;
		this.stepResultLog = stepResultLog;
		this.stepResult = stepResult;
	}
	  
	  
	
	  
	  
	  
	
	

}
