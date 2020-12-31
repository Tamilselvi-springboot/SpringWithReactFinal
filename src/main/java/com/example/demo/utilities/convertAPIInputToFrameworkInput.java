package com.example.demo.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.openqa.selenium.By;

import com.example.demo.model.AppPropertyObj;
import com.example.demo.model.RESTSelObj;
import com.example.demo.model.RESTTestObj;
import com.example.demo.model.RESTTestResult;
import com.example.demo.model.StepDetails;
import com.example.demo.model.StepResult;
import com.example.demo.model.inputData;
import com.example.demo.model.testcaseResult;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class convertAPIInputToFrameworkInput {

	public ConcurrentHashMap<String, inputData> convertAPITestSuitesToFrameWorkTestSuites(
			List<RESTTestObj> RESTTestObjects) {
		List<RESTTestObj> TestObjects = RESTTestObjects;
		ConcurrentHashMap<String, inputData> allScenarios = new ConcurrentHashMap<String, inputData>();

		String ScenarioNumber;
		String ScenDesc;
		String Precondition;

		for (RESTTestObj Test : TestObjects) {
			ScenarioNumber = Test.getScenario_No();
			Precondition = Test.getPrecondition();
			ScenDesc = Test.getScenario_Description();
			CopyOnWriteArrayList<StepDetails> StepDescExp = new CopyOnWriteArrayList<StepDetails>();
			int index = 0;

			for (String StepCounter : Test.getStep_Description()) {
				String StepNo = Test.getStep_Number().get(index);
				String Stepdes = Test.getStep_Description().get(index);
				String ExpRes = Test.getStep_ExpectedResult().get(index);
				StepDetails stepdet = new StepDetails(StepNo, Stepdes, ExpRes);
				StepDescExp.add(stepdet);
				index = index + 1;

			}

			inputData ScenarioObj = new inputData(ScenarioNumber, ScenDesc, Precondition, StepDescExp);
			System.out.println(ScenarioObj.toString());
			allScenarios.put(ScenarioNumber, ScenarioObj);

		}

		System.out.println("******* " + "All scenario info is read and stored in MAP successfully." + "******* ");
	//	Map<String, List<String>> treeMapallScenarios = new TreeMap<String, String>(allScenarios);
		return allScenarios;

	}

	public ConcurrentHashMap<String, ConcurrentHashMap<String, String>> convertAPITestDataToFrameWorkData(
			ConcurrentHashMap<String, String> APITestdata) {
		ConcurrentHashMap<String, String> APITestData = APITestdata;
		ConcurrentHashMap<String, ConcurrentHashMap<String, String>> allTestData = new ConcurrentHashMap<String, ConcurrentHashMap<String, String>>();
		ObjectMapper mapper = new ObjectMapper();
		// ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String,
		// Object>();
		ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap<String, String>();
		for (Map.Entry<String, String> entry : APITestData.entrySet()) {
			try {
				map1 = mapper.readValue(entry.getValue(), new TypeReference<ConcurrentHashMap<String, String>>() {
				});
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(map1);

			for (Map.Entry<String, String> entry1 : map1.entrySet()) {
				System.out.println(entry1.getKey());
				System.out.println(entry1.getValue());
				// map1.put(entry1.getKey(), entry1.getValue().toString());
			}
			allTestData.put(entry.getKey(), map1);
		}
//		Map<String, Object> map = new HashMap<String, Object>();
//		// convert JSON string to Map
//		map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
//		System.out.println(map);
//		
//			allTestData[entry.getKey()] =  entry.getValue(); 

		System.out.println("******* " + "All test data info is read and stored in MAP successfully." + "******* ");

		return allTestData;

	}

	public ConcurrentHashMap<String, AppPropertyObj> convertAPISelObjToFrameSelObj(List<RESTSelObj> SeliumObjects) {

		List<RESTSelObj> SeleniumObjects = SeliumObjects;
		String ObjName;
		String ObjLocatorMethod;
		String ObjProperty;
		String PageName;
		By SelAppObj = null;
		ConcurrentHashMap<String, AppPropertyObj> allObj = new ConcurrentHashMap<String, AppPropertyObj>();
		for (RESTSelObj SelObj : SeleniumObjects) {
			ObjName = SelObj.getObjName();
			ObjLocatorMethod = SelObj.getObjLocatorMethod();
			ObjProperty = SelObj.getObjProperty();
			PageName = SelObj.getPageName();
			SelAppObj = locatorParser(ObjLocatorMethod, ObjProperty);
			AppPropertyObj selobj = new AppPropertyObj(ObjName, SelAppObj, PageName);

			allObj.put(ObjName, selobj);

		}
		System.out.println("******* " + "All obj info is read and stored in MAP successfully." + "******* ");
		return allObj;
	}

	public static By locatorParser(String locator, String PropValue) {

		By loc = By.xpath(PropValue);

		if (locator.contains("id"))
			loc = By.id(PropValue);

		else if (locator.contains("name"))
			loc = By.name(PropValue);

		if (locator.contains("xpath"))
			loc = By.xpath(PropValue);

		return loc;

	}
	
	public List<RESTTestResult> convertFrameworkTestSuiteToAPITestSuite(
			ConcurrentHashMap<String,testcaseResult> allProcessedScenarios) {
		List<RESTTestResult> ConvertedTestSuites = new  ArrayList<RESTTestResult>();
		ConcurrentHashMap<String, testcaseResult> allScenarioResults1 = allProcessedScenarios;
		//Map<String,testcaseResult> map = allScenarioResults1;
		TreeMap<String, testcaseResult> treeMapallScenarios = new TreeMap<>();
		treeMapallScenarios.putAll(allScenarioResults1);
	
		 for (Map.Entry<String,testcaseResult> entry : treeMapallScenarios.entrySet())  {
			 

			 String scenario_No = entry.getKey();
			 boolean isSelected = true;
			 String  scenario_Description = entry.getValue().getTestcaseDesc();
			 String precondition=entry.getValue().getTestcasePrecondition();
			 String tcStatus = entry.getValue().getTestcaseStatus();
			 CopyOnWriteArrayList<String>  step_Number = new CopyOnWriteArrayList<String> () ;
			 CopyOnWriteArrayList<String>step_Description = new CopyOnWriteArrayList<String> () ;
			 CopyOnWriteArrayList<String> step_ExpectedResult = new CopyOnWriteArrayList<String> () ;			 
			 CopyOnWriteArrayList<String> step_ActualResult = new CopyOnWriteArrayList<String> () ;
			 CopyOnWriteArrayList<String> step_ResultLog = new CopyOnWriteArrayList<String> () ;
			 CopyOnWriteArrayList<String> stepResult = new CopyOnWriteArrayList<String> () ;
			 
			 
			 
			 for (StepResult  stepres : entry.getValue().getAllStepResult()) { 		      
				   step_Number.add(stepres.getStepNo());
				step_Description.add(stepres.getStepDesc());
				 step_ExpectedResult.add(stepres.getExpected());			 
				step_ActualResult.add(stepres.getActual());
				  step_ResultLog.add(stepres.getStepResultLog());
				stepResult.add(stepres.getStepResultStatus());   
		          
	    	}
		
			 ConvertedTestSuites.add(new RESTTestResult(scenario_No, isSelected, scenario_Description, precondition,step_Number, step_Description,step_ExpectedResult, tcStatus,
						step_ActualResult,  step_ResultLog, stepResult));
		}

		System.out.println("******* " + "All prcoessed test suites are converted and stored in List successfully." + "******* ");

		return ConvertedTestSuites;

	}

}
