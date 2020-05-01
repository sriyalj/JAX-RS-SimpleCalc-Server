package View;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class SimpleException extends Exception implements ExceptionMapper<SimpleException>  {
	
	int statusCode;

	public SimpleException() {
        super("This is a simple Exception");
    }
 
    public SimpleException(String string) {
        super(string);
    }
    
    public SimpleException(int statusCode, String description) {		
        super(description);
        this.statusCode = statusCode;        
    }
 
    @Override
    public Response toResponse(SimpleException exception) 
    {
        return Response.status(406).entity(exception.getMessage())
                                    .type("text/plain").build();
    }
}
