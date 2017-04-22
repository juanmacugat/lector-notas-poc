package dds.utn.frba.ui.windows;

import java.util.List;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
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
import dds.utn.frba.utils.NotitasServiceMock;

public class StudentWindow extends Dialog<Student> {

	public StudentWindow(WindowOwner owner, Student student) {
		super(owner, student);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {

		Panel first = new Panel(mainPanel);
		first.setLayout(new HorizontalLayout());
		Panel second = new Panel(first);
		second.setLayout(new ColumnLayout(2));
		
		new Label(second).setText("Legajo:").setWidth(100);
		new Label(second).setWidth(100).bindValueToProperty("code");
		new Label(second).setText("Nombre:").setWidth(100);
		new Label(second).setWidth(100).bindValueToProperty("first_name");
		new Label(second).setText("Apellido:").setWidth(100);
		new Label(second).setWidth(100).bindValueToProperty("last_name");
		new Label(second).setText("Github:").setWidth(100);
		new Label(second).setWidth(100).bindValueToProperty("github_user");

		this.createAssignmentGrid(first);

		String token = this.getModelObject().getToken();
		NotitasService notitasService = NotitasServiceRest.getInstance(token);
		
		List<Assignment> assignments = notitasService.getAssignments();
		this.getModelObject().setAssignments(assignments);

	}

	private void describeAssignmentGrid(Table<Assignment> table) {
		Column<Assignment> columnaID = new Column<Assignment>(table);
		columnaID.setTitle("ID");
		columnaID.setFixedSize(30);
		columnaID.bindContentsToProperty("id");

		Column<Assignment> columnaTitle = new Column<Assignment>(table);
		columnaTitle.setTitle("Titulo");
		columnaTitle.setFixedSize(100);
		columnaTitle.bindContentsToProperty("title");

		Column<Assignment> columnaDescription = new Column<Assignment>(table);
		columnaDescription.setTitle("Description");
		columnaDescription.setFixedSize(100);
		columnaDescription.bindContentsToProperty("description");

		Column<Assignment> columnaNotas = new Column<Assignment>(table);
		columnaNotas.setTitle("Notas");
		columnaNotas.setFixedSize(100);
		columnaNotas.bindContentsToProperty("grades");

	}

	private void createAssignmentGrid(Panel mainPanel) {
		Table<Assignment> table = new Table<Assignment>(mainPanel, Assignment.class);
		table.setHeight(400);
		table.setWidth(600);
		table.bindItemsToProperty("assignments");
		this.describeAssignmentGrid(table);
	}
	
	protected void update(){
		Dialog<?> dialog = new UpdateStudentWindow(this, this.getModelObject());
		dialog.open();
		dialog.onAccept(() -> {
		});
	}

	@Override
	protected void addActions(Panel panel) {
		new Button(panel).setCaption("Actualizar").onClick(this::update);
		new Button(panel).setCaption("Salir").onClick(this::cancel);
	}

}
