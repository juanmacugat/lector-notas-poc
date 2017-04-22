package dds.utn.frba.notitas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dds.utn.frba.model.Assignment;
import dds.utn.frba.model.Student;
import dds.utn.frba.service.NotitasService;
import dds.utn.frba.utils.NotitasServiceMock;

public class NotitasServiceTest {
	
	private NotitasService notitasService;
	private String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

	@Before
	public void setUp(){
		this.notitasService = NotitasServiceMock.getInstance(token);
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testGetStudentAndReturnMe() throws Exception {
		Student student = notitasService.getStudent();
		assertNotNull(student);
		assertEquals("123456789", student.getCode());
		assertEquals("Juan Manuel", student.getFirst_name());
		assertEquals("Cugat", student.getLast_name());
		assertEquals("juanmacugat", student.getGithub_user());
	}
	
	@Test
	public void testGetAssignmentsAndReturnTwoAssignmentsWithGrades() throws Exception {
		List<Assignment> assignments = notitasService.getAssignments();
		assertNotNull(assignments);
		assertEquals(2, assignments.size());
	}
	
	@Test
	public void testGetAssignmentsAndReturnFirstShouldBeTPAnual() throws Exception {
		List<Assignment> assignments = notitasService.getAssignments();
		assertNotNull(assignments);
		assertEquals(2, assignments.size());
		
		Assignment assignment = assignments.get(0);
		assertEquals("TP ANUAL",assignment.getTitle());
		assertNull(assignment.getDescription());
		assertEquals(2,assignment.getGrades().size());
	}
	

}
