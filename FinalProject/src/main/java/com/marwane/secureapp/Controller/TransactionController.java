package com.marwane.secureapp.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marwane.secureapp.Model.Budget;
import com.marwane.secureapp.Model.Transaction;
import com.marwane.secureapp.Repository.TransactionRepository;

@RequestMapping("/transaction")
@Controller
public class TransactionController {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	/*/METHODE POST
    @RequestMapping(value="/create",method = RequestMethod.POST)
    @ResponseBody
    public Transaction postUser(@RequestParam(value = "transactionName",required = true) String transactionName,
    		@RequestParam(value = "transactionValue",required = true) Double transactionValue,
    		@RequestParam(value = "debit",required = true) String debit
    		){
    		boolean b;
    		if(debit.contentEquals("true"))
    			b=true;
    		else b=false;
            Transaction t = new Transaction(transactionName,transactionValue,b);
            transactionRepository.save(t);
            return t;
    }*/

}
