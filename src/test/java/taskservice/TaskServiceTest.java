package taskservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TaskServiceTest {

	TaskService service;
	Task task;
	
	@BeforeEach
	void setup() {
		service = new TaskService();
		task = new Task("task1", "Task Name", "Task Description.");
		service.addTask(task);
	}

	
	@Test
	void testAddTask() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(task);
		});
		
		Task retrieved = service.getTask("task1");
	
		assertEquals("task1", retrieved.getTaskID());
		assertEquals("Task Name", retrieved.getName());
		assertEquals("Task Description.", retrieved.getDescription());
	}
	
	@Test 
	void testAddTaskDuplicateID() {
		
		Task task2 = new Task("task1", "Task Name Duplicate", "Task Description Duplicate.");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(task2);
		});
	}
	
	@Test 
	void testDeleteTask() {
		
		service.deleteTask("task1");
	
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask("task1");
		});
	}
	
	@Test
	void testUpdateName() {
		
		service.updateName("task1", "New Task Name");
		
		assertEquals("New Task Name", task.getName());
	}

	
	@Test
	void testUpdateDescription() {
		
		service.updateDescription("task1", "New Task Description.");
		
		assertEquals("New Task Description.", task.getDescription());
	}

	@Test 
	void testGetTask() {
		
		Task returned = service.getTask("task1");
		
		assertEquals("task1", returned.getTaskID());	
		assertEquals("Task Name", returned.getName());
		assertEquals("Task Description.", returned.getDescription());
	}
		
	@Test 
	void testGetTaskIsNull() {
		
		service.deleteTask("task1");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.getTask("task1");
		});
	}
}
