package com.example.demo.mockito.business;

import com.example.demo.mockito.api.ToDoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Temp {

    @Mock
    private ToDoService toDoService;

    @InjectMocks
    private ToDoBusinessImpl toDoBusiness;

    @Test
    public void getSpringRelatedToDosWithMockito(){
        when(toDoService.getToDoList("Dummy")).thenReturn(List.of("Spring is awesome","Welcome to Spring boot","Dance lessons"));
        assertEquals(2, toDoBusiness.getToDosRelatedToSpring("Dummy").size());
    }

}
