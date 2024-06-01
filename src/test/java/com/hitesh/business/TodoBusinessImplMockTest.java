package com.hitesh.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.hitesh.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingMock() {
		TodoService mockTodoService = mock(TodoService.class);
		List<String> mocktodosToReturn = Arrays.asList("Learn Spring boot", "Learn Spring MVC", "Learn Testing",
				"Make Flutter app");
		when(mockTodoService.retrieveTodos(anyString())).thenReturn(mocktodosToReturn);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Some user");

		assertEquals(2, filteredTodos.size());

	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingMock2() {
		TodoService mockTodoService = mock(TodoService.class);
		/*
		 * when a method which is not explicitly declared in when().thrnReturn()... is
		 * called mockito returns a "nice mock" ie it return a default value
		 * for example if the the below line was not written then mocked method will
		 * still return an empty list
		 */
		when(mockTodoService.retrieveTodos(anyString())).thenReturn(new ArrayList<>()); // this is optional

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("EmptyTodosUser");

		assertEquals(0, filteredTodos.size());

	}

}
