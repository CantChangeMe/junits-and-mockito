package com.example.demo.mockito.business;

import com.example.demo.mockito.api.ToDoService;

import java.util.ArrayList;
import java.util.List;

public class ToDoBusinessImpl {

    private ToDoService toDoService;

    public ToDoBusinessImpl(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    public List<String> getToDosRelatedToSpring(String user){
        List<String> toDoList = toDoService.getToDoList("Dummy");
        List<String> toDoRelatedToSpring = new ArrayList<>();
        for(String todo : toDoList){
            if (todo.contains("Spring")){
                toDoRelatedToSpring.add(todo);
            }
        }

        return toDoRelatedToSpring;
    }

    public void deleteToDosNotRelatedToSpring(String user){
        List<String> toDoList = toDoService.getToDoList("Dummy");
        for(String todo : toDoList){
            if (!todo.contains("Spring")){
                toDoService.deleteToDo(todo);
            }
        }
    }


}
