package View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Controller.Controller;

@Path("/view")
public class View {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{firstNumber}/{secondNumber}/{operation}")
	public Response doGetPlainTextMsg(@PathParam("firstNumber") String fstNum, 
			                          @PathParam("secondNumber") String scndNum, 
			                          @PathParam("operation") String operation) throws SimpleException {
		String output = fstNum + " " + scndNum + " " + operation;
		System.out.println (fstNum);
		System.out.println (scndNum);
		System.out.println (operation);
		
		if (fstNum.equals("Sriyal")){
			 throw new SimpleException();
		}
		return Response.status(Status.OK.getStatusCode()).entity(output).build();
	}
	
	/*
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{username}/{password}/{id : \\d+}")
    public Response getPlainTextMsg(@PathParam("username") String username, @PathParam("password") String password, @PathParam("id") int age)
    {
         String output = "Jersey Says : User Name is " + username + " Password is " + password + " Age is " + String.valueOf(age * 2);
         return Response.status(200).entity(output).build(); 
    }
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/{username}/{password}/{id : \\d+}")
    public Response getXMLMsg(@PathParam("username") String username, @PathParam("password") String password, @PathParam("id") int age)
    {
		 String output = "<?xml version=\"1.0\"?>" + "Jersey Says : User Name is " + username + " Password is " + password + " Age is " + String.valueOf(age * 3);
         return Response.status(200).entity(output).build(); 
    }
	
	
	
	@GET
	@Path("{id : \\d+}") //support digit only
	public Response getUserById(@PathParam("id") String id) {

	   return Response.status(200).entity("getUserById is called, id : " + id).build();

	}
	
	@GET
	@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
	public Response getUserByUserName(@PathParam("username") String username) {

	   return Response.status(200)
		.entity("getUserByUserName is called, username : " + username).build();

	}
   */
}
