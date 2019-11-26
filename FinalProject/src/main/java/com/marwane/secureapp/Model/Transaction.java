package com.marwane.secureapp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTransaction;
	private String TransactionName;
	private Double TransactionValue;
	private boolean debit;
	private Long idBudget;
	
	public Transaction() {}
	public Transaction(String transactionName, Double transactionValue, boolean debit,Long idBudget) {
		TransactionName = transactionName;
		TransactionValue = transactionValue;
		this.debit = debit;
		this.idBudget=idBudget;
	}
	
	
	public Long getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}
	public String getTransactionName() {
		return TransactionName;
	}
	public void setTransactionName(String transactionName) {
		TransactionName = transactionName;
	}
	public Double getTransactionValue() {
		return TransactionValue;
	}
	public void setTransactionValue(Double transactionValue) {
		TransactionValue = transactionValue;
	}
	public boolean isDebit() {
		return debit;
	}
	public void setDebit(boolean debit) {
		this.debit = debit;
	}

}
