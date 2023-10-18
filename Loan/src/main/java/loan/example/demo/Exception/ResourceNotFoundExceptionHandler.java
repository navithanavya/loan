package loan.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.ACCEPTED)
public class ResourceNotFoundExceptionHandler extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExceptionHandler(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
