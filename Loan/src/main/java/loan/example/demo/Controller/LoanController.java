package loan.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import loan.example.demo.Exception.ResourceNotFoundEx;
import loan.example.demo.Exception.ResourceNotfound;
import loan.example.demo.Projection.LoanProjection;
import loan.example.demo.Service.LoanService;
import loan.example.demo.domain.Loan;
import loan.example.demo.dto.BranchResponseDto;

@RestController
public class LoanController {
@Autowired
private LoanService service;




 @PostMapping("save")
 public String saveDetails(@RequestBody Loan l) {
	return  service.saveDetails( l); 
 }
 @PutMapping("update/{id}")
 public String updateDetails(@RequestParam String branch,@RequestParam String city,@PathVariable Long id) throws Exception {
	 Loan loanDB=service.findLoanById(id);
	 loanDB.setBorrower(loanDB.getBorrower());
	 loanDB.setBranch(branch);
	 loanDB.setCity(city);
	 
	return  service.saveDetails(loanDB);
 }
 @DeleteMapping("delete/{id}")
 public String deleteLoan(@PathVariable Long id) {
	 service.deleteLoan(id);
	 return "loan deleted successfully" ;
	 
 }
 
 @GetMapping("get/{branch}")
 public BranchResponseDto
 getDetails(@PathVariable String branch) {
	 BranchResponseDto dto=new BranchResponseDto();
	 
//	 if(service.getDetails(branch)!=null) {
//			dto= service.getDetails(branch);
//	 }
//	 else {
//		 System.out.println(new ResourceNotfound("Bad _Exception"+branch));
//	 }
//	return dto;
		 
	 try {
		dto= service.getDetails(branch);
		return dto;

	} catch (Exception e) {
		throw new ResourceNotfound("Not_Found "+branch);
	}
 }
 @GetMapping("/getLoanByBorrower/{borrower}")
 public Loan getLoanByBorrower(@PathVariable String borrower) {
	 if(service.getLoanByBorrower(borrower) != null){
//		 mailSender.sendEmail("navithanavya32@gmail.com",);
			return service.getLoanByBorrower(borrower);
	} else { 
		System.out.println( new ResourceNotfound(borrower+"Bad_request"));
	}
	return new Loan();
	 
 }
 
// @GetMapping("/getLoanByCity/{city}")
// public List<Loan> getLoanByCity(@PathVariable String city) {
//	return service.getLoanByCity(city);
//	 
// }
 
 @GetMapping("getLoanByCity/{city}")
 public Loan getLoanByCity(@PathVariable String city) {
	 if (service.getLoanByCity(city) != null) {
	    return service.getLoanByCity(city);
	}
	 else {
		System.out.println(new ResourceNotFoundEx(city+"INTERNAL_SERVER_ERROR"));
	}
	return new Loan();
	}
 @GetMapping("/getAll")
 public List<BranchResponseDto> getAllLoansUsingJPAQL(@RequestParam String branch) {
	return service.getAllLoansUsingJPAQL(branch);
 }
 @GetMapping("/getSortByCity")
 public List<Object> sortByCity() {
	return service.sortByCity();
 }
 @GetMapping("value/{id}")
 public List<LoanProjection> getvalues(@PathVariable int id){
	return service.getvalues(id);
 }
 
 
// @GetMapping("get/{id}")
// public Loan get(@PathVariable long id)  {
//		if(service.findById(id) != null) 
//		{
//		 return service.findById(id);
//		}
//		else {
//		System.out.println(new ResourceNotFoundException(id+"Not_found"));
//		     }
//	
//	return new Loan();
//	 
// }
 
 
}
