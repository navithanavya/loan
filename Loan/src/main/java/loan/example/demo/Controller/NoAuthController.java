package loan.example.demo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class NoAuthController {
	
	@GetMapping("noauth")
	//@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public String noAUthCOntroller() {
		return "NOAUTH";
	}

}
