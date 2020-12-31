package com.example.demo.model;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class APIReqParam {
	private List<RESTTestObj>testSuites ;
	private String parallel;
	private String testType;	
	private ConcurrentHashMap<String,String> paramdata;
	private List<RESTSelObj> selObjectCollection;
	
	
	
	public List<RESTTestObj> getTestSuites() {
		return testSuites;
	}
	public void setTestSuites(List<RESTTestObj> testSuites) {
		this.testSuites = testSuites;
	}
	public String getParallel() {
		return parallel;
	}
	public void setParallel(String parallel) {
		this.parallel = parallel;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public ConcurrentHashMap<String, String> getParamdata() {
		return paramdata;
	}
	public void setParamdata(ConcurrentHashMap<String, String> paramdata) {
		this.paramdata = paramdata;
	}
	public List<RESTSelObj> getSelObjectCollection() {
		return selObjectCollection;
	}
	public void setSelObjectCollection(List<RESTSelObj> selObjectCollection) {
		this.selObjectCollection = selObjectCollection;
	}
	
	
	
	

	
}
