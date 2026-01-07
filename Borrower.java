import java.util.ArrayList;

/**
 * Represents a borrower in a community loan system.
 * Encapsulates loan details including name, original amount, date issued,
 * and current outstanding balance. Ensures data integrity by preventing
 * negative or zero loan amounts and negative balances.
 */
public class Borrower {
   // Borrower's full name
   private String name;
   
   // Original loan amount (must be positive)
   private double loanAmount;
   
   // Date the loan was issued (stored as YYYY-MM-DD string for simplicity)
   private String dateOfLoan;
   
   // Current amount still owed (starts equal to loanAmount, decreases with repayments)
   private double outstandingBalance;
   
   private ArrayList<String> transactionLog = new ArrayList<>();
   
   /**
    * Constructs a Borrower with the given name, loan amount, and loan date.
    * Initializes outstanding balance to the full loan amount.
    * 
    * @param name        the borrower's full name (e.g., "Tshokolo Ntho")
    * @param loanAmount  the initial loan amount (must be > 0)
    * @param dateOfLoan  the date the loan was issued (format: "YYYY-MM-DD")
    */
   public Borrower(String name, double loanAmount, String dateOfLoan) {
      this.name = name;
      this.dateOfLoan = dateOfLoan;
      
      // Validate loan amount to ensure it's meaningful and positive
      if (loanAmount > 0) {
         this.loanAmount = loanAmount;
         this.outstandingBalance = loanAmount; // New loan: full amount is outstanding
      } else {
         System.out.println("Loan amount must be positive");
         this.loanAmount = 0;
         this.outstandingBalance = 0;
      }
   }
   
   // Returns the borrower's name
   public String getName() {
      return name;
   }
   
   // Returns the original loan amount
   public double getLoanAmount() {
      return loanAmount;
   }
   
   // Returns the loan issuance date as a string
   public String getDateOfLoan() {
      return dateOfLoan;
   }
   
   // Returns the current outstanding balance (amount still owed)
   public double getOutstandingBalance() {
      return outstandingBalance;
   }
   
   /**
    * Updates the original loan amount.
    * Only accepts positive values to maintain financial validity.
    * 
    * @param amount the new loan amount (must be > 0)
    */
   public void setLoanAmount(double amount) {
      if (amount > 0) {
         this.loanAmount = amount;
      } else {
         System.out.println("Amount must be positive");
      }
   }
   
   /**
    * Updates the outstanding balance.
    * Accepts zero (fully repaid) but rejects negative values.
    * 
    * @param amount the new outstanding balance (must be >= 0)
    */
   public void setOutstandingBalance(double amount) {
      if (amount >= 0) {
         this.outstandingBalance = amount;
      } else {
         System.out.println("Outstanding balance cannot be negative");
      }
   }
   
   /**
   * Records a repayment against this loan.
   * Validates the payment amount and updates the outstanding balance.
   * Logs the transaction with the current date and notifies when the loan is fully repaid.
   * 
   * @param amount The repayment amount (must be positive and not exceed the outstanding balance)
   */
   public void recordPayment(double amount) {
      // Validate that the repayment amount is positive
      if (amount > 0) {
         // Ensure the repayment does not exceed the current outstanding balance
         if (outstandingBalance >= amount) {
            // Deduct the repayment amount from the outstanding balance
            outstandingBalance -= amount;
            
            // Capture today's date in ISO format (e.g., "2026-01-05") for accurate record-keeping
            String currentDate = java.time.LocalDate.now().toString();
            
            // Log the repayment if space is available in the transaction log
            transactionLog.add(String.format("Repaid R%.2f on %s", amount, currentDate));
            
            // Check if the loan is now fully repaid (using tolerance for floating-point safety)
            if (outstandingBalance < 0.01) {
               System.out.println("Loan fully repaid");
            }
         } else {
             // Inform user when repayment exceeds what is owed
            System.out.println("Repayment amount exceeds outstanding balance.");
         }
      } else {
         // Reject non-positive payments (zero or negative amounts are invalid)
         System.out.println("Amount must be positive");
      }
   }

/**
 * Displays the full repayment history for this borrower.
 * Shows a numbered list of all recorded repayments.
 */
public void printStatement() {
   System.out.println("Repayment History for " + name + ":");
   if (transactionLog.isEmpty()) {
      System.out.println("No repayments recorded yet.");
   } else {
      for (int i = 0; i < transactionLog.size(); i++) {
         System.out.println((i + 1) + ". " + transactionLog.get(i));
      }
   }
}
