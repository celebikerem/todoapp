package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ToDoListDAO;
import com.example.model.ToDoList;

@RestController

public class ToDoListController {

	@Autowired
	private ToDoListDAO todolistDAO;

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to RestTemplate Example.";
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employees
	@RequestMapping(value = "/todolists", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<ToDoList> getToDoLists() {
		List<ToDoList> list = todolistDAO.getAllToDoLists();
		return list;
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employee/{empNo}
	@RequestMapping(value = "/todolist/{tdlNo}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ToDoList getToDoList(@PathVariable("tdlNo") String tdlNo) {
		return todolistDAO.getToDoList(tdlNo);
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employee
	// http://localhost:8080/SomeContextPath/employee.xml
	// http://localhost:8080/SomeContextPath/employee.json

	@RequestMapping(value = "/todolist", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
						MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ToDoList addToDoList(@RequestBody ToDoList tdl) {

		System.out.println("(Service Side) Creating todolist: " + tdl.gettdlNo());

		return todolistDAO.addToDoList(tdl);
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employee
	// http://localhost:8080/SomeContextPath/employee.xml
	// http://localhost:8080/SomeContextPath/employee.json
	@RequestMapping(value = "/todolist", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ToDoList updateToDoList(@RequestBody ToDoList tdl) {

		System.out.println("(Service Side) Editing todolist: " + tdl.gettdlNo());

		return todolistDAO.updateToDoList(tdl);
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employee/{empNo}
	@RequestMapping(value = "/todolist/{tdlNo}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteToDoList(@PathVariable("tdlNo") String tdlNo) {

		System.out.println("(Service Side) Deleting todolist: " + tdlNo);

		todolistDAO.deleteToDoList(tdlNo);
	}

}