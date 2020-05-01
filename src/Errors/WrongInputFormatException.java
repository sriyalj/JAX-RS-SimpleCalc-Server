package Errors;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@SuppressWarnings("serial")
@Provider
public class WrongInputFormatException extends Exception implements ExceptionMapper<WrongInputFormatException>  {
	
	public WrongInputFormatException ( ) {
		super ("Wrong Input Format");
	}
	
	public WrongInputFormatException(String description) {		
        super(description);        
    }
 
    @Override
    public Response toResponse(WrongInputFormatException exception) 
    {
        return Response.status(422).entity(exception.getMessage())
                                    .type("text/plain").build();
    }
}
