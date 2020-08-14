
package Command;

public class Invoker {

	ICommand[] lCommands;
	ICommand[] rCommands;
	ICommand undoCommand;

	public Invoker() {

		lCommands = new ICommand[8];
		rCommands = new ICommand[8];

		ICommand noCommand = new NoCommand();

		for (int i = 0; i < 8; i++) {
			lCommands[i] = noCommand;
			rCommands[i] = noCommand;
		}

		undoCommand = noCommand;

	}

	public void setCommand(int slot, ICommand lCommand, ICommand rCommand) {
		lCommands[slot] = lCommand;
		rCommands[slot] = rCommand;
	}

	public void leftPressed(int slot) {
		lCommands[slot].execute();
		undoCommand = lCommands[slot];
	}

	public void rightPressed(int slot) {
		rCommands[slot].execute();
		undoCommand = rCommands[slot];
	}

	public void undoPressed() {
		undoCommand.execute();
	}

}

