package dds.utn.frba.ui.windows;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import dds.utn.frba.controller.AuthenticationController;
import dds.utn.frba.model.Student;
import dds.utn.frba.ui.vm.SessionViewModel;

public class AuthenticationWindow extends SimpleWindow<SessionViewModel> {

	private AuthenticationController auth = new AuthenticationController();

	public AuthenticationWindow(WindowOwner owner) {
		super(owner, new SessionViewModel());
	}

	public void authenticate() {
		Student student = auth.authenticate(this.getModelObject().getToken());
		this.getModelObject().setCurrentStudent(student);
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel).setCaption("Ingresar").onClick(() -> {
			this.authenticate();
		});
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Sistema de Notas");
		mainPanel.setLayout(new VerticalLayout());
		mainPanel.setWidth(600);
		new Label(mainPanel).setText("Ingrese el token");
		new TextBox(mainPanel).bindValueToProperty("token");
	}

}
