import java.util.ArrayList;

/**
 * Manages a dynamic collection of Borrower objects for a community loan tracking system.
 * Provides aggregated views of loan data, including total outstanding debt and formatted reports.
 */
public class LoanManager {
   // Holds all registered borrowers; dynamically expands as new loans are added
   ArrayList<Borrower> manager = new ArrayList<>();
   
   /**
    * Adds a new borrower to the loan portfolio.
    * 
    * @param b The Borrower object representing a loan recipient (must not be null)
    */
   public void addBorrower(Borrower b) {
      manager.add(b);
   }
   
   /**
    * Calculates the total outstanding debt across all borrowers.
    * Sums the current balance of every active loan in the portfolio.
    * 
    * @return Total amount owed by all borrowers (in Rands), rounded to 2 decimal places
    */
   public double getTotalOutstanding() {
      double total = 0;
      
      // Iterate through all borrowers and accumulate their individual balances
      for (Borrower b : manager) {
         for (Loan loan : b.getLoans()) {
            total += loan.getOutstandingBalance();
         }
      }
      return total;
   }
   
   /**
    * Prints a human-readable summary of all active loans.
    * Displays each borrower's name and current outstanding balance in Rand format.
    * Example output: "Tshokolo: R150.00"
    */
   public void printLoans() {
      // Format each loan entry as "[Name]: R[Balance]" for clarity and consistency
      for (Borrower b : manager) {
         for (Loan loan : b.getLoans()) {
            System.out.println(String.format("%s: R%.2f", b.getName(), loan.getOutstandingBalance()));
         }
      }
   }
}