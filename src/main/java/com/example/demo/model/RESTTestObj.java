package com.example.demo.model;

import java.util.concurrent.CopyOnWriteArrayList;

public class RESTTestObj {
	private String scenario_No;	
	private boolean isSelected;
	  private String  scenario_Description;
	  private String precondition;
	  private CopyOnWriteArrayList<String>  step_Number;
	  private CopyOnWriteArrayList<String> step_Description;
	  private CopyOnWriteArrayList<String> step_ExpectedResult;
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
	  
	  
	
	
	 
}
