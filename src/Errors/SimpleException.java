package Errors;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@SuppressWarnings("serial")
@Provider
public class SimpleException extends Exception implements ExceptionMapper<SimpleException>  {
	
	public SimpleException() {
        super("This is a simple Exception");
    }
 
	
    public SimpleException(String description) {
        super(description);
    }
     
    @Override
    public Response toResponse(SimpleException exception) 
    {
        return Response.status(406).entity(exception.getMessage())
                                    .type("text/plain").build();
    }
}
