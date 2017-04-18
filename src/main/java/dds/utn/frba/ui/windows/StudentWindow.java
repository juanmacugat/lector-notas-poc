package dds.utn.frba.ui.windows;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import dds.utn.frba.ui.vm.StudentViewModel;

public class StudentWindow extends Dialog<StudentViewModel> {

	public StudentWindow(WindowOwner owner) {
		super(owner, new StudentViewModel());
	}

	@Override
	protected void createFormPanel(Panel form) {

	}

}
