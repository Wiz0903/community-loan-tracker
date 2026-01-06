# Community Loan App

A simple, offline-first Java application to help South African stokvels, stokfondse, and informal lenders **track loans, repayments, and balances** — **without internet or data costs**.

> Built for communities. Runs anywhere Java runs.

## 🎯 Purpose
In many South African communities, people manage money through trusted groups — but they lack **reliable, private, and offline tools**.  
This app aims to change that:  
- No internet needed  
- No personal data stored in the cloud  
- Clear, honest tracking of who owes what

## 🛠️ Current Features (v0.1)
- `Borrower` class to store:
  - Name
  - Loan amount
  - Loan date (YYYY-MM-DD)
  - Outstanding balance
- Input validation:
  - Prevents negative loans
  - Ensures balance never drops below zero

## ▶️ How to Run
1. Ensure you have **Java JDK 8+** installed
2. Compile:  
   ```bash
   javac Borrower.java
