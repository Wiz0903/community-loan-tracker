# Community Loan App

A simple, offline-first Java application to help South African stokvels, stokfondse, and informal lenders **track loans, repayments, and balances** — **without internet or data costs**.

> Built for communities. Runs anywhere Java runs.

## 🎯 Purpose
In many South African communities, money is managed through trusted groups — but they lack **reliable, private, and offline tools**.  
This app changes that by providing:
- ✅ **Zero internet required** — works on any Java-enabled device  
- ✅ **No cloud storage** — all data stays on your device  
- ✅ **Clear, transparent tracking** — no hidden fees, no confusion  

## 🛠️ Current Features (v0.1)
### Core Components
- **`Borrower` class**: Stores loan details per person  
  - Full name  
  - Original loan amount  
  - Loan date (YYYY-MM-DD)  
  - Current outstanding balance  
- **`LoanManager` class**: Manages multiple borrowers  
  - Add new borrowers  
  - View all active loans (`printLoans()`)  
  - Calculate total debt across all borrowers (`getTotalOutstanding()`)

### Repayment Safety
The `recordPayment(double amount)` method ensures:  
- ❌ No negative repayments  
- ❌ No overpayment (balance never goes below zero)  
- ✅ Every payment is logged with timestamp  
- ✅ Full repayment is detected accurately (handles decimal precision)

### Input Validation
- Prevents invalid loan amounts (≤ 0)  
- Blocks repayments exceeding outstanding balance  
- Graceful error messages — no crashes

## ▶️ How to Run
1. Compile: `javac *.java`  
2. Run: `java LoanApp` (or your main class)  
3. Use the console menu to manage loans

> 💡 **Designed for low-resource environments** — minimal memory, no external libraries.
