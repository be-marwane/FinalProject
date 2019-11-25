package com.marwane.secureapp.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Budget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idBudget;
	private String budgetName;
	private Double InitialValue;
	private Double currentValue;
	private Long administrator;
	@OneToMany
	@JoinColumn(name = "idBudget")
	private List<Transaction> transactions;

	
	
	
	public Budget() {}
	public Budget( String budgetName, Double initialValue,
			List<Transaction> transactions, Long administrator) {
		
		this.budgetName = budgetName;
		InitialValue = initialValue;
		this.currentValue = initialValue;
		this.transactions = new ArrayList<Transaction>();
		this.administrator = administrator;
		

	}
	public Long getIdBudget() {
		return idBudget;
	}
	public void setIdBudget(Long idBudget) {
		this.idBudget = idBudget;
	}
	public String getBudgetName() {
		return budgetName;
	}
	public void setBudgetName(String budgetName) {
		this.budgetName = budgetName;
	}
	public Double getInitialValue() {
		return InitialValue;
	}
	public void setInitialValue(Double initialValue) {
		InitialValue = initialValue;
	}
	public Double getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public void addTransactions(Transaction transactions) {
		this.transactions.add(transactions);
	}
	public Long getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Long administrator) {
		this.administrator = administrator;
	}
	
	

}
