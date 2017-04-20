package dds.utn.frba.ui.windows;

import java.util.List;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import dds.utn.frba.model.Assignment;
import dds.utn.frba.model.Student;
import dds.utn.frba.service.NotitasService;
import dds.utn.frba.service.NotitasServiceRest;

public class StudentWindow extends Dialog<Student> {

	public StudentWindow(WindowOwner owner, Student student) {
		super(owner, student);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {

		Panel first = new Panel(mainPanel);
		first.setLayout(new ColumnLayout(2));
		new Label(first).setText("Legajo:").setWidth(100);
		new TextBox(first).setWidth(100).bindValueToProperty("code");
		new Label(first).setText("Nombre:").setWidth(100);
		new TextBox(first).setWidth(100).bindValueToProperty("first_name");
		new Label(first).setText("Apellido:").setWidth(100);
		new TextBox(first).setWidth(100).bindValueToProperty("last_name");
		new Label(first).setText("Github:").setWidth(100);
		new TextBox(first).setWidth(100).bindValueToProperty("github_user");

		this.createAssignmentGrid(mainPanel);

		NotitasService notitasService = NotitasServiceRest.getInstance(this.getModelObject().getToken());
		List<Assignment> assignments = notitasService.getAssignments();
		this.getModelObject().setAssignments(assignments);

	}

	private void describeAssignmentGrid(Table<Assignment> table) {
		Column<Assignment> columnaID = new Column<Assignment>(table);
		columnaID.setTitle("ID");
		columnaID.bindContentsToProperty("id");

		Column<Assignment> columnaTitle = new Column<Assignment>(table);
		columnaTitle.setTitle("Titulo");
		columnaTitle.bindContentsToProperty("title");

		Column<Assignment> columnaDescription = new Column<Assignment>(table);
		columnaDescription.setTitle("Description");
		columnaDescription.bindContentsToProperty("description");

	}

	private void createAssignmentGrid(Panel mainPanel) {
		Table<Assignment> table = new Table<Assignment>(mainPanel, Assignment.class);
		table.setHeight(400);
		table.setWidth(600);
		table.bindItemsToProperty("assignments");
		this.describeAssignmentGrid(table);
	}

}
