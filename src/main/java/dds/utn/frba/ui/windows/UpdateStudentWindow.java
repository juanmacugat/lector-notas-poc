package dds.utn.frba.ui.windows;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import dds.utn.frba.model.Student;
import dds.utn.frba.service.NotitasService;
import dds.utn.frba.service.NotitasServiceRest;
import dds.utn.frba.utils.NotitasServiceMock;

public class UpdateStudentWindow extends Dialog<Student>{

	public UpdateStudentWindow(WindowOwner owner, Student model) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel second = new Panel(mainPanel);
		second.setLayout(new ColumnLayout(2));
		
		new Label(second).setText("Legajo:").setWidth(100);
		new TextBox(second).setWidth(100).bindValueToProperty("code");
		new Label(second).setText("Nombre:").setWidth(100);
		new TextBox(second).setWidth(100).bindValueToProperty("first_name");
		new Label(second).setText("Apellido:").setWidth(100);
		new TextBox(second).setWidth(100).bindValueToProperty("last_name");
		new Label(second).setText("Github:").setWidth(100);
		new TextBox(second).setWidth(100).bindValueToProperty("github_user");

	}
	
	@Override
	protected void addActions(Panel panel) {
		new Button(panel).setCaption("Actualizar").onClick(this::updateStudent);
		new Button(panel).setCaption("Salir").onClick(this::cancel);
	}

	protected void updateStudent(){
		String token = this.getModelObject().getToken();
		NotitasService notitasService = NotitasServiceRest.getInstance(token);
		notitasService.updateStudent(this.getModelObject());		
		this.close();
	}
}
