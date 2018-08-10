package com.example.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.model.ToDoItem;
 
@Repository
public class ToDoItemDAO {

	private static final Map<String, ToDoItem> tdiMap = new HashMap<String, ToDoItem>();
	 
    static {
    	initTdis();
    }
 
    private static void initTdis() {
    	ToDoItem tdi1 = new ToDoItem("TDI1", "item1");
    	ToDoItem tdi2 = new ToDoItem("TDI2", "item2");
    	ToDoItem tdi3 = new ToDoItem("TDI3", "item3");
 
    	tdiMap.put(tdi1.gettdiNo(), tdi1);
    	tdiMap.put(tdi2.gettdiNo(), tdi2);
    	tdiMap.put(tdi3.gettdiNo(), tdi3);
    }
 
    public ToDoItem getToDoItem(String tdiNo) {
        return tdiMap.get(tdiNo);
    }
 
    public ToDoItem addToDoItem(ToDoItem tdi) {
    	tdiMap.put(tdi.gettdiNo(), tdi);
        return tdi;
    }
 
    public ToDoItem updateToDoItem(ToDoItem tdi) {
    	tdiMap.put(tdi.gettdiNo(), tdi);
        return tdi;
    }
 
    public void deleteToDoItem(String tdiNo) {
    	tdiMap.remove(tdiNo);
    }
 
    public List<ToDoItem> getAllToDoItems() {
        Collection<ToDoItem> c = tdiMap.values();
        List<ToDoItem> list = new ArrayList<ToDoItem>();
        list.addAll(c);
        return list;
    }
	
}
