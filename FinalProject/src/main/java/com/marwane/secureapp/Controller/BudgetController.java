package com.marwane.secureapp.Controller;



import java.util.ArrayList;

import org.apache.naming.TransactionRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marwane.secureapp.Model.Budget;
import com.marwane.secureapp.Model.Transaction;
import com.marwane.secureapp.Model.User;
import com.marwane.secureapp.Repository.BudgetRepository;
import com.marwane.secureapp.Repository.TransactionRepository;

@Controller
@RequestMapping("/budget")
public class BudgetController {

	@Autowired
	BudgetRepository budgetRepository;
	
	
	@Autowired
	TransactionRepository transactionRepository;
	
	//METHODE POST
    @RequestMapping(value="/create",method = RequestMethod.POST)
    @ResponseBody
    public Budget postUser(@RequestParam(value = "budgetName",required = true) String budgetName,
    		@RequestParam(value = "initialValue",required = true) Double initialValue){

            Budget b = new Budget(budgetName,initialValue,new ArrayList<Transaction>(),(long)1);
            budgetRepository.save(b);
            return b;
    }
    
    
	//METHODE POST
    @RequestMapping(value="/createtransaction",method = RequestMethod.POST)
    @ResponseBody
    public Budget postUser(@RequestParam(value = "budgetId",required = true) Long budgetId,
    		@RequestParam(value = "transactionName",required = true) String transactionName,
    		@RequestParam(value = "transactionValue",required = true) Double transactionValue,
    		@RequestParam(value = "debit",required = true) String debit
    		){
    		boolean b;
    		if(debit.contentEquals("true"))
    			b=true;
    		else b=false;
    		
    		Budget budget=budgetRepository.findById(budgetId).get();
            Transaction t = new Transaction(transactionName,transactionValue,b,budgetId);
            budget.addTransactions(t);
            transactionRepository.save(t);
            budgetRepository.save(budget);
            return budget;
    }
    
}
    
