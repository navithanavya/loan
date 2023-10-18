package loan.example.demo.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import loan.example.demo.Exception.ResourceNotFoundException;
import loan.example.demo.Exception.ResourceNotfound;
import loan.example.demo.Projection.LoanProjection;
import loan.example.demo.Repository.LoanRepository;
import loan.example.demo.domain.Loan;
import loan.example.demo.dto.BranchResponseDto;

@Service
public class LoanService {
	@Autowired
	private LoanRepository repository;

	public LoanService(LoanRepository repository) {
		super();
		this.repository = repository;
	}


	public String saveDetails(Loan l) {
		repository.save(l);
		return l.getBorrower()+"_saved_";
	}


	public Loan findLoanById(long id) throws Exception {
		return repository.findById(id).orElseThrow(()->new Exception());
	}


	public void deleteLoan(Long id) {
		repository.deleteById(id);
	}


	public BranchResponseDto getDetails(String branch) {
		try {
			Loan loan=repository.findByBranch(branch);

		} catch (Exception e) {
			throw new ResourceNotfound("Not_found");
		}
		Loan loan=repository.findByBranch(branch);

		BranchResponseDto dto= new BranchResponseDto();
		dto.setBorrower(loan.getBorrower());
		dto.setBranch(branch);
		dto.setCity(loan.getCity());
		return dto;
	}



	public Loan getLoanByBorrower(String borrower) {
		return repository.findByBorrower(borrower);
		  
	}


//	public List<Loan> getLoanByCity(String city) {
//
//		return repository.findByCity(city);
//	}

	public Loan getLoanByCity(String city) {

		return repository.findByCity(city);
	}




	public List<BranchResponseDto> getAllLoansUsingJPAQL(String branch) {
		List<Loan> list=repository.findByBranchName(branch);
		List<BranchResponseDto> dto= new ArrayList<BranchResponseDto>();

		for(Loan loan:list)	{
			BranchResponseDto bdto=new BranchResponseDto();
			bdto.setBorrower(loan.getBorrower());
			bdto.setBranch(loan.getBranch());
			bdto.setCity(loan.getCity());
			dto.add(bdto);
		}
		return dto;
	}


	public List<Object> sortByCity() {
		List<Object>loanlist=repository.sortByCity();
		return loanlist;
	}


	public List<LoanProjection> getvalues(int id) {
		return repository.getvaluesfromDB(id);
	}


	public Loan findById(long id) {

		try {
			return repository.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			throw new  ResourceNotFoundException(id+"Not_found");
		}
			
		
			
	}





}












