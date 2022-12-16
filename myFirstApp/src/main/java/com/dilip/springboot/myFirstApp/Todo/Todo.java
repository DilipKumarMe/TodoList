package com.dilip.springboot.myFirstApp.Todo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
@Entity
public class Todo {
	@Id
	@GeneratedValue
	private int id;
	private String username;
	@Size(min=10 , message ="Enter minimum 10 character.")
	private String description;
	private LocalDate targetDate;
	private boolean done;
	
	public Todo(){
		
	}
	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + ", getId()=" + getId() + ", getUsername()=" + getUsername()
				+ ", getDescription()=" + getDescription() + ", getTargetDate()=" + getTargetDate() + ", isDone()="
				+ isDone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}