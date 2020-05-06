package View;

import java.util.Base64;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Controller.Controller;
import Errors.SimpleException;
import Errors.WrongInputFormatException;
import Errors.WrongOperationException;

@Path("/view")
public class View {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.TEXT_PLAIN, MediaType.TEXT_XML})
	@Path("/{firstNumber}/{secondNumber}/{operation}")
	public Response doGetPlainTextMsg(@PathParam("firstNumber") String fstNum, 
			                          @PathParam("secondNumber") String scndNum, 
			                          @PathParam("operation") String operation,
			                          @Context HttpHeaders headers) throws WrongInputFormatException, WrongOperationException {
		
		String accept = headers.getHeaderString(HttpHeaders.ACCEPT);
	    List<MediaType> acceptableType = headers.getAcceptableMediaTypes();
	    
	    System.out.println ("doGetXMLTextMsg");
	    System.out.println (accept);
	    
	    for (MediaType temp : acceptableType) {
            System.out.println(temp);
        }
		
		
		byte[] decodedBytes = Base64.getDecoder().decode(operation);
		String decodedOperation = new String(decodedBytes);		
		
		Controller control = new Controller (fstNum, scndNum, operation);
		return control.doGet();
		
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{firstNumber}/{secondNumber}/{operation}")
	public Response doGetXMLTextMsg(@PathParam("firstNumber") String fstNum, 
			                          @PathParam("secondNumber") String scndNum, 
			                          @PathParam("operation") String operation,
			                          @Context HttpHeaders headers) throws WrongInputFormatException, WrongOperationException {
		
		String accept = headers.getHeaderString(HttpHeaders.ACCEPT);
	    List<MediaType> acceptableType = headers.getAcceptableMediaTypes();
	    
	    System.out.println ("doGetXMLTextMsg");
	    System.out.println (accept);
	    
	    for (MediaType temp : acceptableType) {
            System.out.println(temp);
        }
	    
		String output = "<?xml version=\"1.0\"?>" + "Jersey Says : First Number is " + fstNum + " Second Number is " + scndNum + " Operation is " + operation;
        return Response.status(200).entity(output).build(); 
		
	}
	
}
