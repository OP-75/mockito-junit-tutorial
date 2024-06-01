package com.hitesh.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.hitesh.data.api.TodoService;
import com.hitesh.data.api.TodoServiceStub;

//We dont prefer stubs since whenever there are new methods added to 
// interface TodoService we have to make changes in the stubs as well

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingStub() {
		TodoService todoServiceStub = new TodoServiceStub();

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Some user");

		assertEquals(2, filteredTodos.size());

	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingStub2() {
		TodoService todoServiceStub = new TodoServiceStub();

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("EmptyTodosUser");

		assertEquals(0, filteredTodos.size());

	}

}
