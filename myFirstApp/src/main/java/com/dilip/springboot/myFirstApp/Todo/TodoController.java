package com.dilip.springboot.myFirstApp.Todo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService TodoService;
	
	public TodoController(com.dilip.springboot.myFirstApp.Todo.TodoService todoService) {
		super();
		TodoService = todoService;
	}
	private Logger logger = LoggerFactory.getLogger(getClass());
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		logger.info("entering in method listAllTodos");
		 String username =getLoggedInUsername(model);
		 List<Todo> todos =TodoService.findByUsername(username);
		 model.addAttribute("todos",todos);
		logger.info("existing  method listAllTodos");
		return"listTodos";
	}

	

	
	
	@RequestMapping(value ="add-todo",method =RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		logger.info("entering in method showNewTodoPage");
		String username = getLoggedInUsername(model);
		 Todo todo =new Todo(0,username,"Dev",LocalDate.now().plusYears(2),false);
		 model.put("todo", todo);
		logger.info("existing  method showNewTodoPage");
		return"todo";
	}	
	
	@RequestMapping(value ="add-todo",method =RequestMethod.POST)
	public String addNewTodo( ModelMap model,@Valid Todo todo ,BindingResult result) {
		logger.info("entering in method addNewTodo");
		if(result.hasErrors()) {
			return"todo";
		}
		
		String username = getLoggedInUsername(model);
		TodoService.addTodo(username,todo.getDescription(),todo.getTargetDate(),false);
		logger.info("existing  method addNewTodo");
		return"redirect:list-todos";
	}	
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//delet todo
		logger.info("entering in method deleteTodo");
		TodoService.deleteById(id);
		logger.info("existing  method deleteTodo");
		return"redirect:list-todos";
	}
	
	@RequestMapping(value ="update-todo",method =RequestMethod.GET)
	public String updateTodo(@RequestParam int id ,ModelMap model) {
		//delet todo
		logger.info("entering in method updateTodo");
		Todo todo =TodoService.findById(id);
		model.addAttribute("todo",todo);
		logger.info("existing  method updateTodo");
		return"todo";
	}
	
	@RequestMapping(value ="update-todo",method =RequestMethod.POST)
	public String updateTodo( ModelMap model,@Valid Todo todo ,BindingResult result) {
		logger.info("entering in method addNewTodo");
		if(result.hasErrors()) {
			return"todo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		TodoService.updateTodo(todo);
		logger.info("existing  method addNewTodo");
		return"redirect:list-todos";
	}	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
