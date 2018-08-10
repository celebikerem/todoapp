package com.example.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.model.ToDoList;
 
@Repository
public class ToDoListDAO {
 
    private static final Map<String, ToDoList> tdlMap = new HashMap<String, ToDoList>();
 
    static {
    	initTdls();
    }
 
    private static void initTdls() {
    	ToDoList tdl1 = new ToDoList("TDL1", "To Do List One","OnGoing");
    	ToDoList tdl2 = new ToDoList("TDL2", "To Do List Two","Completed");
    	ToDoList tdl3 = new ToDoList("TDL3", "To Do List Three","OnGoing");
 
    	tdlMap.put(tdl1.gettdlNo(), tdl1);
    	tdlMap.put(tdl2.gettdlNo(), tdl2);
    	tdlMap.put(tdl3.gettdlNo(), tdl3);
    }
 
    public ToDoList getToDoList(String tdlNo) {
        return tdlMap.get(tdlNo);
    }
 
    public ToDoList addToDoList(ToDoList tdl) {
    	tdlMap.put(tdl.gettdlNo(), tdl);
        return tdl;
    }
 
    public ToDoList updateToDoList(ToDoList tdl) {
    	tdlMap.put(tdl.gettdlNo(), tdl);
        return tdl;
    }
 
    public void deleteToDoList(String tdlNo) {
    	tdlMap.remove(tdlNo);
    }
 
    public List<ToDoList> getAllToDoLists() {
        Collection<ToDoList> c = tdlMap.values();
        List<ToDoList> list = new ArrayList<ToDoList>();
        list.addAll(c);
        return list;
    }
 
}