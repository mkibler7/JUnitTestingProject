package taskservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
	
	@Test
	void testTaskClass() {
		Task task = new Task("task1", "First Task", "Description of the first task");
		assertTrue(task.getTaskID().equals("task1"));
		assertTrue(task.getName().equals("First Task"));
		assertTrue(task.getDescription().equals("Description of the first task"));
	}
	
	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("taskIDTooLong", "First Task", "Description of first task");
		});
	}
	
	@Test
	void testTaskIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "First Task", "Description of first task");
		});
	}
	

	@Test
	void testNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("task2", "This Task Name is one hundred percent too long", "Description of task2");
		});
	}
	
	@Test
	void testNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("task3", null, "Description of task3");
		});
	}
	@Test
	void testDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("task4", "Task Name", "This description is wayyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"
					+ "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"
					+ "yyyyyyyyyyyyyyyyyyyyyyyyyyyy too long man!");
		});
	}
	
	@Test
	void testDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("task5", "Task Name", null);
		});
	}
}
