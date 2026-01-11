import java.util.ArrayList;

/**
 * Represents a borrower in a community loan system.
 * Encapsulates loan details including name and date issued.
 *Ensures data integrity by preventing
 */
public class Borrower {
   // Borrower's full name
   private String name;
   
   // Date the loan was issued (stored as YYYY-MM-DD string for simplicity)
   private String dateOfLoan;
   
   private ArrayList<Loan> loans = new ArrayList<>();
   
   /**
    * Constructs a Borrower with the given name and loan date.
    * 
    * @param name        the borrower's full name (e.g., "Tshokolo Ntho")
    * @param dateOfLoan  the date the loan was issued (format: "YYYY-MM-DD")
    */
   public Borrower(String name, String dateOfLoan) {
      this.name = name;
      this.dateOfLoan = dateOfLoan;
   }
   
   // Returns the borrower's name
   public String getName() {
      return name;
   }
   
   // Returns the loan issuance date as a string
   public String getDateOfLoan() {
      return dateOfLoan;
   }
   
   /**
    * Adds a new loan to this borrower's loan portfolio.
    * 
    * @param loan the Loan object to associate with this borrower
    */
   public void addLoan(Loan loan) {
      loans.add(loan);
   }
   
   /**
    * Prints the repayment statement for every loan associated with this borrower.
    * Delegates printing to each Loan's printStatement() method.
    */
   public void printAllStatements() {
      for (int i = 0; i < loans.size(); i++) {
         loans.get(i).printStatement();
      }
   }
   
   /**
   * Returns the list of loans associated with this borrower.
   * Provides direct access to the internal loan collection for iteration or aggregation.
   * 
   * @return ArrayList of Loan objects representing all loans issued to this borrower
   */
   public ArrayList<Loan> getLoans() {
      return loans;
   }
}
