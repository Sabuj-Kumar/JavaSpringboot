package com.spring.boot.MyFirstWebAppWithSpringBoot.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
   
  private static List<Todo> todos = new ArrayList<Todo>();
  
  private static int todoCount =0;
  static {
	  todos.add(new Todo(++todoCount,"Sabuj","Java Spring boot",LocalDate.now().plusYears(1),false));
	  todos.add(new Todo(++todoCount,"Niber","Mathamatics",LocalDate.now().plusYears(2),false));
	  todos.add(new Todo(++todoCount,"Sabuj","Dot net core",LocalDate.now().plusYears(3),false));
	  todos.add(new Todo(++todoCount,"Niber","Anda koco vudai",LocalDate.now().plusYears(4),false));
  }
  
  public List<Todo> findByUsername(String name){
	  Predicate<? super Todo> predicate =
	  todo-> todo.getUserName().equalsIgnoreCase(name);
	return todos.stream().filter(predicate).toList();
  }
  
  public void addTodos(String name,String description,LocalDate localDate,boolean done) {
	  
	  Todo todo = new Todo(++todoCount,name,description,localDate,false);
	  todos.add(todo);
  }
  
  public void deleteTodoById(int id){
	  Predicate<Todo> predicate = type-> type.getId() == id; 
	todos.removeIf(predicate);
  }
  
  public Todo findById(int id){
	  Predicate<Todo> predicate = type-> type.getId() == id; 
	 Todo todo = todos.stream().filter(predicate).findFirst().get();
	 return todo;
  }

  public void updateTodo(@Valid Todo todo) {
	  Todo existingtodo = findById(todo.getId());
	  
	  if(todo.getUserName() != null) {
		  existingtodo.setUserName(todo.getUserName()); 
	  }
	  if(todo.getDescription() != null) {
		  existingtodo.setDescription(todo.getDescription());
	  }
	  if(todo.getLocalDate() != null) {
		  existingtodo.setLocalDate(todo.getLocalDate());
	  }
	  deleteTodoById(todo.getId());
	  todos.add(existingtodo); 
  }
  
}
