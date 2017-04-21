package dds.utn.frba.main;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import dds.utn.frba.ui.windows.LoginWindow;

public class LectorNotasApplication extends Application {

	public static void main(String[] args) {
		new LectorNotasApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		return new LoginWindow(this);
	}

}
