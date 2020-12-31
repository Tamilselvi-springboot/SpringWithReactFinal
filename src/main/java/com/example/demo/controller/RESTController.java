package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controllerService.googleAppTestService;
import com.example.demo.model.APIReqParam;
import com.example.demo.model.RESTSelObj;

import com.example.demo.model.RESTTestObj;
import com.example.demo.model.RESTTestResult;
import com.example.demo.model.SampleReq;
import com.example.demo.model.allData;
import com.example.demo.model.testcaseResult;
import com.example.demo.utilities.Reporting;

import cucumber.api.cli.Main;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")

public class RESTController {
	
	public static APIReqParam reqInput = new APIReqParam();
	
	@Autowired 
	public static allData mad;
	//public static allData mad = new allData();
	@Autowired 
	public Reporting Reporter;
	@Autowired
	googleAppTestService serviceImp;
	long startTime;	 
	long stopTime;
	long TCExecutionTime = 0;
	
//	@RequestMapping(value ="/", method = RequestMethod.GET)
//	public ModelAndView renderHomePage() {
//		serviceImp.GetProperties("application.properties");
//		serviceImp.GetTextFileinMap("AutomationKeywordDef.txt");
//		serviceImp.GetTextFileinMap("GlobalMessages.txt");
//		ModelAndView home = new ModelAndView("home");
//		return home;
//	}
	 @PostMapping( "/uploadFiles")
    public String uploadFileHandler1( @RequestBody Map<String,String> ReqParams) throws Throwable {
		 System.out.println(ReqParams.size());
	    	for (Map.Entry<String,String> entry : ReqParams.entrySet())  
	            System.out.println("Key = " + entry.getKey() + 
	                             ", Value = " + entry.getValue()); 
	    
    	return "aaa";
    }
    @PostMapping( "/uploadFile")
    public List<RESTTestResult> uploadFileHandler( @RequestBody APIReqParam ReqParams) throws Throwable {
    	reqInput = ReqParams;
    	
    	System.out.println(ReqParams.getParallel());
    	System.out.println(ReqParams.getTestType());
    	for (RESTTestObj  Test : ReqParams.getTestSuites()) { 		      
	           System.out.println(Test.getScenario_No()); 	
	           System.out.println(Test.getPrecondition()); 	
	           System.out.println(Test.getScenario_Description()); 
	          
	      }
    	
    	for (RESTSelObj  selobj : reqInput.getSelObjectCollection()) { 		      
	           System.out.println(selobj.getObjName());     
	          
    	}
    	ConcurrentHashMap<String,String> param = reqInput.getParamdata();
    	System.out.println(param.mappingCount());
    	for (Map.Entry<String,String> entry : param.entrySet())  
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); 
    	
    	
    	
    	
    	
    	serviceImp.GetProperties("application.properties");
		serviceImp.GetTextFileinMap("AutomationKeywordDef.txt");
		serviceImp.GetTextFileinMap("GlobalMessages.txt");
		googleAppTestService.TestData=reqInput.getParamdata();
		googleAppTestService.TestSuiteList =reqInput.getTestSuites();
		googleAppTestService.SeleniumObjects = reqInput.getSelObjectCollection();
		
		
    	startTime = System.nanoTime();
    	//serviceImp.UploadFileInServer(file);    
    	//Reporter.CreateResultFile(file);
      	    
    	mad = serviceImp.getAlldataInMap();
   	if (!(ReqParams.getTestType() =="")) {
   		googleAppTestService.TypeofTest = ReqParams.getTestType();
   	} else {
    		googleAppTestService.TypeofTest = "UI";
    	} 
        if (ReqParams.getParallel() == "parallel") {
        	googleAppTestService.Parallel = "parallel";
       }
   		
 	String [] argv = new String[]{ "-g","com.example.demo.StepDefinition",serviceImp.AppProperites.get("newfeatureFilePath")};
	ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
	try {
		byte exitstatus = Main.run(argv, contextClassLoader);
		} 
	catch (IOException e) {
			
		e.printStackTrace();
		}
		stopTime = System.nanoTime();
		TCExecutionTime =  stopTime - startTime;
		long TCExecutionseconds = TimeUnit.SECONDS.convert(TCExecutionTime, TimeUnit.NANOSECONDS);
		long TCExecutionminutes = TimeUnit.MINUTES.convert(TCExecutionTime, TimeUnit.NANOSECONDS);
		
		for (Map.Entry<String,testcaseResult> entry : mad.getAllProcessedScenarios().entrySet())  {
			 System.out.println("Key = " + entry.getKey()); 
			 System.out.println("value = " + entry.getValue().getTestcaseStatus()); 
		}
		
		List<RESTTestResult> ProcessedTestSuites = serviceImp.convertToTestSuites();
		
		System.out.println("Execution is completed. Time taken for execution is " + TCExecutionseconds + " seconds");
		System.out.println("Execution is completed. Time taken for execution is " + TCExecutionminutes + " minutes");
		startTime = 0;
		stopTime =0;
	
//		if (!(ServiceChecked ==null)) {
//    		googleAppTestService.TypeofTest = "";
//    	} else {
//    		googleAppTestService.TypeofTest = "";
//    	} 
//    	if (!(ParallelChecked ==null)) {
//    		googleAppTestService.Parallel = "";
//    	}
    	
    
    	return  ProcessedTestSuites;
    	
    	
    }
    
    @RequestMapping(value="/downloadLogFile")
    public void getLogFile(HttpSession session,HttpServletResponse response) throws Exception {
        try {
            String filePathToBeServed = googleAppTestService.AppProperites.get("resultFilePath");
            File fileToDownload = new File(filePathToBeServed);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename="+googleAppTestService.AppProperites.get("resultFileName")+".xlsx"); 
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception e){
           // LOGGER.debug("Request could not be completed at this moment. Please try again.");
            e.printStackTrace();
        }

    }

    
  

}
