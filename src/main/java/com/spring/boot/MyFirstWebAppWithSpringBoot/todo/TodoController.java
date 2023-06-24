package com.spring.boot.MyFirstWebAppWithSpringBoot.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
  
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("todo-list")
	public String listAllTodos(ModelMap model) {
		String name = getLoggedInUsername();
		List<Todo> todos = todoService.findByUsername(name);
		model.addAttribute("todos",todos);
		return "listTodos";
	}
    private String getLoggedInUsername() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		String name = (String)model.get("name");
		Todo todos = new Todo(0,name,"",LocalDate.now().plusYears(1),false);
		model.put("todo",todos);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult res) {
		
		if(res.hasErrors()) {
			return "todo";
		}
		String name = (String)model.get("name");
		todoService.addTodos(name, todo.getDescription(),todo.getLocalDate(), false);
		return "redirect:todo-list";
	}
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodoById(id);
		return "redirect:todo-list";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showingUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.put("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult res) {
		
		if(res.hasErrors()) {
			return "todo";
		}
		
		todoService.updateTodo(todo);
		return "redirect:todo-list";
	}
}
