package com.codingdojo.pokebooks.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


	
@Entity
@Table(name="poke_books")
public class PokeBook {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull
		@Size(min = 3, max = 200, message= "Expense item must be at least 3 characters.")
		private String expense;
		
		@NotNull
		@Size(min = 3, max = 200, message = "Vendor's name must be at least 3 characters.")
		private String vendor;
		
		@NotNull
		@Min(value = 1, message= "Expenses must be at least $1 to be logged")
		private double amount;
		
		@NotNull
		@Size(min = 5, max =200, message= "Description must be at least 5 characters.")
		private String description;
		
		@Column(updatable=false)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;
		
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;
		
		public PokeBook() {
			
		}
		
		public PokeBook(String expense, String vendor, double amount, String description) 
		{
			this.expense = expense;
			this.vendor = vendor;
			this.amount = amount;
			this.description = description;
			
		}
		
		public PokeBook(Long id, String expense, String vendor, double amount, String description) 
		{
			this.id = id;
			this.expense = expense;
			this.vendor = vendor;
			this.amount = amount;
			this.description = description;
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getExpense() {
			return expense;
		}

		public void setExpense(String expense) {
			this.expense = expense;
		}

		public String getVendor() {
			return vendor;
		}

		public void setVendor(String vendor) {
			this.vendor = vendor;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		@PrePersist
		protected void onCreate() 
		{
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() 
		{
			this.updatedAt = new Date();
		}
		
		
	}


