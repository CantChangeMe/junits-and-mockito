package com.example.demo.mockito.api.data;

import com.example.demo.mockito.api.ToDoService;

import java.util.List;

public class ToDoServiceStub implements ToDoService {

    @Override
    public List<String> getToDoList(String user) {
        return List.of("Spring is awesome","Welcome to Spring boot","Dance lessons");
    }

    @Override
    public void deleteToDo(String toDo) {

    }
}