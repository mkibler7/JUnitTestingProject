package taskservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contactservice.Contact;
import contactservice.ContactService;

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
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(task);
		});
		
		Task retrieved = service.getTask("task1");
	
		assertTrue(retrieved.getTaskID().equals("task1"));
		assertTrue(retrieved.getName().equals("Task Name"));
		assertTrue(retrieved.getDescription().equals("Task Description."));
	}
	
	@Test 
	void testAddContactDuplicateID() {
		
		Task task2 = new Task("task1", "Task Name Duplicate", "Task Description Duplicate.");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(task2);
		});
	}
	
	@Test 
	void testDeleteTask() {
		
		service.deleteTask("task1");
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask("task1");
		});
	}
	
	@Test
	void testUpdateName() {
		
		service.updateName("task1", "New Task Name");
		
		assertTrue(task.getName().equals("New Task Name"));
		
	}

	
	@Test
	void testUpdateDescription() {
		
		service.updateDescription("task1", "New Task Description.");
		
		assertTrue(task.getDescription().equals("New Task Description."));
		
	}

	@Test 
	void testGetTask() {
		
		Task returned = service.getTask("task1");
		
		assertTrue(returned.getTaskID().equals("task1"));	
		assertTrue(returned.getName().equals("Task Name"));
		assertTrue(returned.getDescription().equals("Task Description."));
	}
		
	@Test 
	void testGetTaskIsNull() {
		
		service.deleteTask("task1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getTask("task1");
		});
	}
}
