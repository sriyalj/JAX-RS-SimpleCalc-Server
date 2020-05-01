package Controller;

import java.util.Base64;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Errors.SimpleException;
import Errors.WrongInputFormatException;
import Errors.WrongOperationException;
import Model.Model;


public class Controller {	
	
	private String firstNum;
	private String scndNum;
	private String operation;
	private String JSONString;
	
	private String response;
	private Response serverResponse;
	
	public Controller (String firstNum, String scndNum, String operation) {
		this.firstNum =  firstNum;
		this.scndNum = scndNum;
		this.operation = operation;
	}
	
	public Controller (String JSONString) {
		this.JSONString = JSONString;
	}
	
	public Response doGet () throws WrongInputFormatException, WrongOperationException, SimpleException {
		
		byte[] decodedBytes = Base64.getDecoder().decode(operation);
		String decodedOperation = new String(decodedBytes);
		//String decodedOperation = operation;
		
		if (decodedOperation.equals("+") || decodedOperation.equals("-") || decodedOperation.equals("*") || decodedOperation.equals("/") || decodedOperation.equals("%")) {
        	
        	try {
        		try {
        			Model <Long> longModel = new Model <> (Long.valueOf(Long.parseLong(firstNum)),Long.valueOf(Long.parseLong(scndNum)));        		
        			Long longAns = null; 
        			Double divLongAns = null;
        			
        			switch (decodedOperation) {
        				case "+" : longAns = longModel.addNumbers();         						   
        						   response = "Addition of " + firstNum + " & " + scndNum + " is : " + longAns.toString();        						   
        						   break;
        				
        				case "-" : longAns = longModel.substractNumbers(); 
        						   response = "Substracting " + scndNum + " From " + firstNum + " is : " + longAns.toString();
						 		   break;
						 
        				case "*" : longAns = longModel.multiplyNumbers();
        						   response = "Multiplication of " + firstNum + " & " + scndNum + " is : " + longAns.toString();
		 				 		   break;
		 				 				 
        				case "/" : divLongAns = longModel.<Double>divideNumbers();
        						   response = "Division of " + firstNum + " By " + scndNum + " is : " + divLongAns.toString();
		 				 		   break;
		 				 
        				case "%" : longAns = longModel.modulusNumbers(); 
        						   response = "Modulus of " + firstNum + " by " + scndNum + " is : " + longAns.toString();
		 				 		   break;
        			  }     
        			  return Response.status(Status.OK.getStatusCode()).entity(response).build();
        		 }
        		 catch (NumberFormatException e){
        			Model <Double> doubleModel = new Model <> (Double.valueOf(Double.parseDouble(firstNum)),Double.valueOf(Double.parseDouble(scndNum)));
        			Double doubleAns = null;
        			
        			switch (decodedOperation) {
        				case "+" : doubleAns = doubleModel.addNumbers();
        						   response = "Addition of " + firstNum + " & " + scndNum + " is : " + doubleAns.toString();
        						   break;
        				
        				case "-" : doubleAns = doubleModel.substractNumbers(); 
        						   response = "Substracting " + scndNum + " From " + firstNum + " is : " + doubleAns.toString();
						 		   break;
						 
        				case "*" : doubleAns = doubleModel.multiplyNumbers();
        						   response = "Multiplication of " + firstNum + " & " + scndNum + " is : " + doubleAns.toString();        				           
		 				 		   break;
		 				 				 
        				case "/" : doubleAns = doubleModel.<Double>divideNumbers();
        						   response = "Division of " + firstNum + " By " + scndNum + " is : " + doubleAns.toString();
		 				 		   break;
		 				 
        				case "%" : doubleAns = doubleModel.modulusNumbers();
        						   response = "Modulus of " + firstNum + " by " + scndNum + " is : " + doubleAns.toString();
		 				 		   break;
        		    }
        			return Response.status(Status.OK.getStatusCode()).entity(response).build();
        	   }
        	}
        	catch (Exception e){
        		throw new WrongInputFormatException("Wrong Formatting of Input Numbers. The System Only Supports Integers and/or Doubles");
           	}
        	
        }
        else {        	
    		//throw new WrongOperationException("Wrong Operation Requested. System Only Supports +, -, *, /, %");
    		//throw new WrongOperationException("This is a Stupid Exception 123. System Only Supports +, -, *, /, %");
        	throw new SimpleException("This is a Stupid Exception");
        }     
	}
	/*
	void parseJson () throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(JSONString.getBytes());
		JsonNode fstNumber = rootNode.path("FirstNumber");	
		JsonNode scndNumber = rootNode.path("SecondNumber");
		JsonNode opration = rootNode.path("Operation");
		
		firstNum =  fstNumber.asText();
		scndNum = scndNumber.asText();
		operation = opration.asText();
		 
	}
	
	public ArrayList <String> doPost () {
		try {
			parseJson ();	
			return (doGet());
		}
		catch (IOException e) {
			res = new ArrayList <> ();
        	res.add("Srever Response Code " + Integer.toString(HttpServletResponse.SC_BAD_REQUEST));
        	res.add("Wrong Formatting of JSON data" );
        	return res;
		}
		
		
	}
	*/

}
