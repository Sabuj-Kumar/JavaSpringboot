package com.spring.boot.MyFirstWebAppWithSpringBoot.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class Todo {
   
	private int id;
	private String userName;
	@Size(min=10, message="Enter at list 10 charecter.")
	private String description;
	private LocalDate localDate;
	private boolean done;
	
	public Todo(int id, String userName, String description, LocalDate localDate, boolean done) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.localDate = localDate;
		this.done = done;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", userName=" + userName + ", description=" + description + ", localDate=" + localDate
				+ ", done=" + done + "]";
	}
}
