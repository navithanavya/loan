package loan.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import loan.example.demo.Projection.LoanProjection;
import loan.example.demo.domain.Loan;
@Repository
public interface LoanRepository  extends JpaRepository<Loan, Long>{
@Query(value = "Select * from loan q where q.branch=:branch", nativeQuery=true)
   Loan findByBranch(String branch);
Loan findByBorrower(String borrower);
Loan findByCity(String city);

@Query("select l from Loan  l where l.branch =:branch")
List<Loan> findByBranchName(String branch);
 @Query("SELECT l.borrower,l.city from Loan l ORDER BY l.id asc" )
 List<Object> sortByCity();
 @Query(value = "select l.borrower,l.branch,l.city from loan l where l.id=:id",nativeQuery=true)
List<LoanProjection> getvaluesfromDB(int id);
}
