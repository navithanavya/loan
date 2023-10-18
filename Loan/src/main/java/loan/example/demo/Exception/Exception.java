package loan.example.demo.Exception;

import java.time.LocalDateTime;

import lombok.*;
@Getter
@Setter
public class Exception {
  
private LocalDateTime localDateTime;
   private String message;
   private String path;
   
   public Exception() {
	super();
}

public Exception(LocalDateTime localDateTime, String message, String path) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.path = path;
	}

@Override
public String toString() {
	return "Exception [localDateTime=" + localDateTime + ", message=" + message + ", path=" + path + "]";
}


}
