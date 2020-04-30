package View;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class SimpleException extends Exception implements
ExceptionMapper<SimpleException>  {

	public SimpleException() {
        super("This is a simple Exception");
    }
 
    public SimpleException(String string) {
        super(string);
    }
 
    @Override
    public Response toResponse(SimpleException exception) 
    {
        return Response.status(404).entity(exception.getMessage())
                                    .type("text/plain").build();
    }
}
