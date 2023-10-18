package loan.example.demo.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="loan")
@Getter
@Setter
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
 private long id;
 private  String borrower;
 private String branch;
 private float amount;
 private String city;
 
 
@Override
public String toString() {
	return "Loan [id=" + id + ", borrower=" + borrower + ", branch=" + branch + ", amount=" + amount + ", city=" + city + "]";
}
public Loan() {
	super();
}
public Loan(long id, String borrower, String branch, float amount, String city) {
	super();
	this.id = id;
	this.borrower = borrower;
	this.branch = branch;
	this.amount = amount;
	this.city = city;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public  String getBorrower() {
	return borrower;
}
public void setBorrower(String borrower) {
	this.borrower = borrower;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}

public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
 
 
 
 
 
}
