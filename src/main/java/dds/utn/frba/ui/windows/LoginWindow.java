package dds.utn.frba.ui.windows;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import dds.utn.frba.model.Student;
import dds.utn.frba.model.Token;
import dds.utn.frba.service.NotitasService;
import dds.utn.frba.service.NotitasServiceRest;
import dds.utn.frba.utils.NotitasServiceMock;

public class LoginWindow extends SimpleWindow<Token> {

	public LoginWindow(WindowOwner owner) {
		super(owner, new Token());
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Ingresar").onClick(() -> {
			this.authenticate();
		}).setWidth(300);
		new Button(actionsPanel).setCaption("Salir").onClick(() -> {
			this.close();;
		}).setWidth(300);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Sistema de Notas");
		mainPanel.setLayout(new VerticalLayout());
		mainPanel.setWidth(600);
		new Label(mainPanel).setText("Ingrese el token");
		new TextBox(mainPanel).setWidth(600).bindValueToProperty("token");
	}
	
	protected void authenticate() {
		String token = this.getModelObject().getToken();
		NotitasService notitasService = NotitasServiceRest.getInstance(token);
		Student student = notitasService.getStudent();
		student.setToken(token);

		Dialog<?> dialog = new StudentWindow(this, student);
		dialog.open();
		dialog.onAccept(() -> {
		});
	}


}
