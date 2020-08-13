package com.example.demo.mockito.business;

import com.example.demo.mockito.api.ToDoService;
import com.example.demo.mockito.api.data.ToDoServiceStub;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

class ToDoBusinessImplTest {

    @Test
    public void getSpringRelatedToDos(){
        ToDoService toDoServiceStub = new ToDoServiceStub();
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoServiceStub);

        assertEquals(2, toDoBusiness.getToDosRelatedToSpring("Dummy").size());
    }

    @Test
    public void getSpringRelatedToDosWithMockito(){

        ToDoService toDoServiceMock = mock(ToDoService.class);
        when(toDoServiceMock.getToDoList("Dummy")).thenReturn(List.of("Spring is awesome","Welcome to Spring boot","Dance lessons"));
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoServiceMock);
        assertEquals(2, toDoBusiness.getToDosRelatedToSpring("Dummy").size());
    }

    @Test
    public void getSpringRelatedToDosWithMockitoForEmptyList(){

        ToDoService toDoServiceMock = mock(ToDoService.class);
        when(toDoServiceMock.getToDoList("Dummy")).thenReturn(List.of());
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoServiceMock);
        assertEquals(0, toDoBusiness.getToDosRelatedToSpring("Dummy").size());
    }

    @Test
    public void getSpringRelatedToDosWithMockitoUsingBDD(){
        //Given
        ToDoService toDoServiceMock = mock(ToDoService.class);
        given(toDoServiceMock.getToDoList("Dummy")).willReturn(List.of("Spring is awesome","Welcome to Spring boot","Dance lessons"));
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoServiceMock);
        //When
        int size = toDoBusiness.getToDosRelatedToSpring("Dummy").size();
        //Then
        assertThat (size, is(2));
    }

    @Test
    public void deleteToDosNotRelatedToSpringUsingBDD(){
        //Given
        ToDoService toDoServiceMock = mock(ToDoService.class);
        given(toDoServiceMock.getToDoList("Dummy")).willReturn(List.of("Spring is awesome","Welcome to Spring boot","Dance lessons"));
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoServiceMock);
        //When
        toDoBusiness.deleteToDosNotRelatedToSpring("Dummy");
        //Then
        verify(toDoServiceMock ,times(1)).deleteToDo("Dance lessons");
    }

    @Test
    public void deleteToDosNotRelatedToSpringUsingBDD_Atleast(){
        //Given
        ToDoService toDoServiceMock = mock(ToDoService.class);
        given(toDoServiceMock.getToDoList("Dummy")).willReturn(List.of("Spring is awesome","Welcome to Spring boot","Dance lessons"));
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoServiceMock);
        //When
        toDoBusiness.deleteToDosNotRelatedToSpring("Dummy");
        //Then
       // verify(toDoServiceMock ,atLeast(1)).deleteToDo("Dance lessons");//not BDD style
        then(toDoServiceMock).should().deleteToDo("Dance lessons");//BDD style
        then(toDoServiceMock).should(never()).deleteToDo("Spring is awesome");//BDD style
    }

    @Test
    public void deleteToDosNotRelatedToSpringUsingBDD_ArgumentCapture(){
        //Given
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ToDoService toDoServiceMock = mock(ToDoService.class);
        given(toDoServiceMock.getToDoList("Dummy")).willReturn(List.of("React is also awesome","Welcome to Spring boot","Dance lessons"));
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoServiceMock);
        //When
        toDoBusiness.deleteToDosNotRelatedToSpring("Dummy");
        //Then
        then(toDoServiceMock).should(times(2)).deleteToDo(stringArgumentCaptor.capture());//BDD style
       // assertThat(stringArgumentCaptor.getValue(), is("Dance lessons"));
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }

}