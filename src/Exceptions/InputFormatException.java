package Exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import View.SimpleException;

@Provider
public class InputFormatException extends Exception implements ExceptionMapper<InputFormatException>  {

	public InputFormatException(String string) {
        super(string);
    }
 
    @Override
    public Response toResponse(InputFormatException exception) 
    {
        return Response.status(404).entity(exception.getMessage())
                                    .type("text/plain").build();
    }
}
