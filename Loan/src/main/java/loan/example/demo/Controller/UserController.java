package loan.example.demo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class UserController {
	
	@GetMapping("greet")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
	@PreAuthorize ("hasAuthority ('ROLE_USER')  && hasRole ('ROLE_ADMIN')")
	public String adminControlString() {
		return "HELLO ADMIN";
	}
	
	@GetMapping("greeting")
	@PreAuthorize("hasRole('USER')")
	public String userControlString() {
		return "HELLO USER";
	}

}
