package Errors;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@SuppressWarnings("serial")
@Provider
public class WrongOperationException extends Exception implements ExceptionMapper<WrongOperationException>{
	
	public WrongOperationException ( ) {
		super ("Wrong Operation Requested");
	}

	public WrongOperationException(String description) {		
        super(description);        
    }
 
    @Override
    public Response toResponse(WrongOperationException exception) 
    {
        return Response.status(422).entity(exception.getMessage())
                                    .type("text/plain").build();
    }
}
