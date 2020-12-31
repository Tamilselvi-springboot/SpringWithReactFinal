/**
 * 
 */
package com.example.demo.model;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

/**
 * @author Tamil
 *
 */


public class inputData {
	
	private String ScenarioDesc;
	//private ConcurrentHashMap <String,String> stepDescription;
	private CopyOnWriteArrayList<StepDetails> StepDetails;
	private String ScenarioNum;
	private String Precondition;
	public String getScenarioDesc() {
		return ScenarioDesc;
	}
	public void setScenarioDesc(String scenarioDesc) {
		ScenarioDesc = scenarioDesc;
	}
	public CopyOnWriteArrayList<StepDetails> getStepDetails() {
		return StepDetails;
	}
	public void setStepDetails(CopyOnWriteArrayList<StepDetails> stepDetails) {
		StepDetails = stepDetails;
	}
	public String getScenarioNum() {
		return ScenarioNum;
	}
	public void setScenarioNum(String scenarioNum) {
		ScenarioNum = scenarioNum;
	}
	public String getPrecondition() {
		return Precondition;
	}
	public void setPrecondition(String precondition) {
		Precondition = precondition;
	}
	public inputData(String scenarioNum,String scenarioDesc, String precondition, CopyOnWriteArrayList<com.example.demo.model.StepDetails> stepDetails
			 ) {
		super();
		ScenarioDesc = scenarioDesc;
		StepDetails = stepDetails;
		ScenarioNum = scenarioNum;
		Precondition = precondition;
	}
	
	
	
	
	
	

}
