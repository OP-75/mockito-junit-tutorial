package com.hitesh.data.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//We dont prefer stubs since whenever there are new methods added to 
// interface TodoService we have to make changes in the stubs as well

public class TodoServiceStub implements TodoService {

	@Override
	public List<String> retrieveTodos(String user) {

		if (user.equals("EmptyTodosUser")) {
			return new ArrayList<>();
		}

		return Arrays.asList("Learn Spring boot", "Learn Spring MVC", "Learn Testing", "Make Flutter app");
	}

}
