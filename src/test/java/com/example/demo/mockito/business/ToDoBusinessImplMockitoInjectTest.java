package com.example.demo.mockito.business;

import com.example.demo.mockito.api.ToDoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ToDoBusinessImplMockitoInjectTest {

    @Mock
    ToDoService toDoService;

    @InjectMocks
    ToDoBusinessImpl toDoBusiness;

    @Test
    public void getSpringRelatedToDosWithMockito(){
        when(toDoService.getToDoList("Dummy")).thenReturn(List.of("Spring is awesome","Welcome to Spring boot","Dance lessons"));
        assertEquals(2, toDoBusiness.getToDosRelatedToSpring("Dummy").size());
    }

}