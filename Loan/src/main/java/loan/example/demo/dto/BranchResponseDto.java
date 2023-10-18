package loan.example.demo.dto;

import lombok.*;

@Getter
@Setter
public class BranchResponseDto {
 private String branch;
 private String city;
 private String borrower;
 
public BranchResponseDto() {
	super();
}
public BranchResponseDto(String branch, String city, String borrower) {
	super();
	this.branch = branch;
	this.city = city;
	this.borrower = borrower;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getBorrower() {
	return borrower;
}
public void setBorrower(String borrower) {
	this.borrower = borrower;
}
 
}
