package dds.utn.frba.service;

import java.util.List;

import dds.utn.frba.model.Assignment;
import dds.utn.frba.model.Student;

public interface NotitasService {

	public Student getStudent();

	public List<Assignment> getAssignments();

	public void updateStudent(Student student);

}
