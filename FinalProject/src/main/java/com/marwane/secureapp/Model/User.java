package com.marwane.secureapp.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
    private String lastName;
    private String firstName;
    private String pass;
    private String mail;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_budget", joinColumns = @JoinColumn(name = "id"),
	inverseJoinColumns = @JoinColumn(name = "idBudget"))
	private List<Budget> budgets;
	
	public User() {}
	public User( String username, String password) {
		this.username = username;
		this.password = password;
		this.budgets = new ArrayList<Budget>();
	}
	
	public User(String username, String password, String lastName, String firstName, String pass, String mail,
			List<Budget> budgets) {
		this.username = username;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.pass = pass;
		this.mail = mail;
		this.budgets = budgets;
	}
	/*public Budget createBudget( String budgetName, Double initialValue) {
		Budget budget=new Budget( budgetName,initialValue,null, this);
		return budget;
	}

	public Transaction createTransaction( String transactionName, Double transactionValue, boolean debit) {
		Transaction transaction=new Transaction( transactionName,transactionValue,debit);
		return transaction;
	}*/
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Budget> getBudgets() {
		return budgets;
	}
	public void setBudgets(List<Budget> budgets) {
		this.budgets = budgets;
	}
	
	public void addBudgets(Budget budget) {
		this.budgets.add(budget);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
