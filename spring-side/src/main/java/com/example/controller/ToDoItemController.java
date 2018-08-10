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

import com.example.dao.ToDoItemDAO;
import com.example.model.ToDoItem;
import com.example.dao.ToDoListDAO;
import com.example.model.ToDoList;

@RestController

public class ToDoItemController {

	@Autowired
	private ToDoItemDAO todoitemDAO;

	// URL:
	// http://localhost:8080/SomeContextPath/employees
	@RequestMapping(value = "/todoitems", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<ToDoItem> getToDoItems() {
		List<ToDoItem> list = todoitemDAO.getAllToDoItems();
		return list;
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employee/{empNo}
	@RequestMapping(value = "/todoitem/{tdiNo}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ToDoItem getToDoList(@PathVariable("tdlNo") String tdiNo) {
		return todoitemDAO.getToDoItem(tdiNo);
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employee
	// http://localhost:8080/SomeContextPath/employee.xml
	// http://localhost:8080/SomeContextPath/employee.json

	@RequestMapping(value = "/todoitem", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ToDoItem addToDoItem(@RequestBody ToDoItem tdi) {

		System.out.println("(Service Side) Creating todolist: " + tdi.gettdiNo());

		return todoitemDAO.addToDoItem(tdi);
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employee
	// http://localhost:8080/SomeContextPath/employee.xml
	// http://localhost:8080/SomeContextPath/employee.json
	@RequestMapping(value = "/todoitem", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ToDoItem updateToDoItem(@RequestBody ToDoItem tdi) {

		System.out.println("(Service Side) Editing todolist: " + tdi.gettdiNo());

		return todoitemDAO.updateToDoItem(tdi);
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employee/{empNo}
	@RequestMapping(value = "/todoitem/{tdiNo}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteToDoItem(@PathVariable("tdiNo") String tdiNo) {

		System.out.println("(Service Side) Deleting todolist: " + tdiNo);

		todoitemDAO.deleteToDoItem(tdiNo);
	}

}