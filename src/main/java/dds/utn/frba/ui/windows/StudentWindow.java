package dds.utn.frba.ui.windows;

import java.util.List;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import dds.utn.frba.controller.StudentController;
import dds.utn.frba.model.Assignment;
import dds.utn.frba.model.Student;

public class StudentWindow extends Dialog<Student> {

	private StudentController studentController = new StudentController();
	
	public StudentWindow(WindowOwner owner, Student student) {
		super(owner, student);
	}

	@Override
	protected void createFormPanel(Panel form) {
		form.setLayout(new ColumnLayout(2));
		Panel leftPanel = new Panel(form);
		new Label(leftPanel).setText("Legajo:");
		new TextBox(leftPanel).setWidth(100).bindValueToProperty("code");
		new Label(leftPanel).setText("Nombre:");
		new TextBox(leftPanel).setWidth(100).bindValueToProperty("first_name");
		new Label(leftPanel).setText("Apellido:");
		new TextBox(leftPanel).setWidth(100).bindValueToProperty("last_name");
		new Label(leftPanel).setText("Github:");
		new TextBox(leftPanel).setWidth(100).bindValueToProperty("github_user");

		//Obtengo las asignaciones del estudiante para mostrarlas
		List<Assignment> assignments = studentController.getAssignment(this.getModelObject().getToken());
		this.getModelObject().setAssignments(assignments);
		
		Panel rightPanel = new Panel(form);		
//		Table<Assignment> tableAssignments = new Table<Assignment>(rightPanel, Assignment.class);
//		tableAssignments.bindItemsToProperty("assignments");
//		tableAssignments.bindValueToProperty("assignments");
//		Column<Assignment> columnaID = new Column<Assignment>(tableAssignments);
//		columnaID.setTitle("ID");
//		columnaID.bindContentsToProperty("id");
//		
//		Column<Assignment> columnaTitle = new Column<Assignment>(tableAssignments);
//		columnaTitle.setTitle("Titulo");
//		columnaTitle.bindContentsToProperty("title");
//		
//		Column<Assignment> columnaDescription = new Column<Assignment>(tableAssignments);
//		columnaDescription.setTitle("Description");
//		columnaDescription.bindContentsToProperty("description");
		
		Selector<Assignment> selectorAssignment = new Selector<Assignment>(rightPanel).allowNull(true);
		selectorAssignment.bindItemsToProperty("assignments");
		selectorAssignment.bindValueToProperty("assignments");
	}

}
