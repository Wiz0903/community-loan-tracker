import java.util.ArrayList;

public class Loan {
   // Original loan amount (must be positive)
   private double loanAmount;
   
   // Current amount still owed (starts equal to loanAmount, decreases with repayments)
   private double outstandingBalance;
   
   // Due date for full repayment, stored in ISO format "YYYY-MM-DD"
   private String dueDate;
   
   private ArrayList<String> transactionLog = new ArrayList<>();
   
   /**
    * Constructs a Loan with the specified amount and due date.
    * Initializes the outstanding balance to the full loan amount.
    * 
    * @param loanAmount the initial loan amount (must be > 0)
    * @param dueDate the repayment deadline in "YYYY-MM-DD" format
    */
   public Loan(double loanAmount, String dueDate) {
      this.dueDate = dueDate;
      
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
   
  /**
    * Returns the repayment due date for this loan.
    * 
    * @return due date as a string in "YYYY-MM-DD" format
    */
   public String getDueDate() {
      return dueDate;
   }
   
   // Returns the original loan amount
   public double getLoanAmount() {
      return loanAmount;
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
      System.out.println("Repayment History for Loan (R" + loanAmount + "):");
      if (transactionLog.isEmpty()) {
         System.out.println("No repayments recorded yet.");
      } else {
         for (int i = 0; i < transactionLog.size(); i++) {
            System.out.println((i + 1) + ". " + transactionLog.get(i));
         }
      }
   }
   
   /**
    * Checks if this loan is overdue by comparing today's date to the due date.
    * Prints "Overdue" if the current date is past the due date.
    * Uses lexicographical comparison of ISO-formatted date strings ("YYYY-MM-DD").
    */
   public void printOverdueStatus() {
      String todayDate = java.time.LocalDate.now().toString();
      int result = todayDate.compareTo(dueDate);
      
      if (result > 0) {
         System.out.println("Overdue");
      }
   }
}