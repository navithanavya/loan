package loan.example.demo.Exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;


   @ControllerAdvice
   @ResponseBody
public class GlobalExceptionHandler {
       @ExceptionHandler( ResourceNotFoundException.class)
       public ResponseEntity<?> ResourceNotFoundExceptionhandling (
       ResourceNotFoundException exception ,WebRequest request){
           Exception e=new Exception(
            LocalDateTime.now(),
            exception.getMessage(),
            request.getDescription(false));
           
           System.out.println(e);
    		   return new ResponseEntity<>
           (e,HttpStatus.NOT_FOUND);
     
   
       }
       

     @ExceptionHandler(ResourceNotfound.class)
      public ResponseEntity<?>ResourceNotFound(
		
		ResourceNotfound exception,WebRequest request){
	    Exception info=new Exception(
			LocalDateTime.now(),
			exception.getMessage(),
			request.getDescription(false));
			
	  return new ResponseEntity<>(info,HttpStatus.BAD_REQUEST);
     }
		

      @ExceptionHandler(ResourceNotFoundEx.class)
       public ResponseEntity<?> resourceNotFoundEx(
		ResourceNotFoundEx exception,WebRequest request){
	    Exception ex=new Exception(
			LocalDateTime.now(),
			exception.getMessage(),
			request.getDescription(false));
			return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
       
     }
     