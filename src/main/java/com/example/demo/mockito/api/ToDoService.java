package com.example.demo.mockito.api;

import java.util.List;

public interface ToDoService {

    public List<String> getToDoList(String user);
    public void deleteToDo(String toDo);
}
