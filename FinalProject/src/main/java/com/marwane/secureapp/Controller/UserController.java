package com.marwane.secureapp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Bucket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marwane.secureapp.Model.Budget;
import com.marwane.secureapp.Model.Transaction;
import com.marwane.secureapp.Model.User;
import com.marwane.secureapp.Repository.BudgetRepository;
import com.marwane.secureapp.Repository.UserRepository;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BudgetRepository budgetRepository;
	
    
    //Methode GET
    @RequestMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Long id){
        User result = userRepository.findById(id).get();
        List<Budget> list= budgetRepository.findUsers(id);
        
        for(int i=0; i<list.size(); i++)
        	result.addBudgets(list.get(i));
        
        return result;
    }
    
  //Methode GET
    @RequestMapping("/all")
    @ResponseBody
    public List<User> getUser(){
        List<User> result = userRepository.findAll();
        return result;
    }
    //METHODE POST
    @RequestMapping(value="/create",method = RequestMethod.POST)
    @ResponseBody
    public User postUser(@RequestParam(value = "username",required = true) String username,
    		@RequestParam(value = "password",required = true) String password){

            User result = new User(username,password);
            userRepository.save(result);
            return result;
    }
    
  //METHODE POST
    @RequestMapping(value="/createbody",method = RequestMethod.POST)
    @ResponseBody
    public User postUser(@RequestBody User u){

            userRepository.save(u);
            return u;
    }
    
    //METHODE POST
    @RequestMapping(value="/createbudget",method = RequestMethod.POST)
    @ResponseBody
    public User createbud(@RequestParam(value = "userid",required = true) Long userid,
    		@RequestParam(value = "budgetName",required = true) String budgetName,
    		@RequestParam(value = "initialValue",required = true) Double initialValue){
    		User result = userRepository.findById(userid).get();
    		Budget b = new Budget(budgetName,initialValue,new ArrayList<Transaction>(),userid);
            budgetRepository.save(b);
            result.addBudgets(b);
            userRepository.save(result);
            return result;
    }
    
    /*METHODE POST
    @RequestMapping(value="/createTransaction",method = RequestMethod.POST)
    @ResponseBody
    public User createTransaction(@RequestParam(value = "budgetid",required = true) Long budgetid,
    		@RequestParam(value = "budgetName",required = true) String budgetName,
    		@RequestParam(value = "initialValue",required = true) Double initialValue){
    		User result = userRepository.findById(userid).get();
    		Budget b = new Budget(budgetName,initialValue,new ArrayList<Transaction>(),userid);
            budgetRepository.save(b);
            result.addBudgets(b);
            userRepository.save(result);
            return result;
    }*/
  

}
