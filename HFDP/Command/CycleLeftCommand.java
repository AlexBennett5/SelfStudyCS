
package Command;

public class CycleLeftCommand implements ICommand {

	private Light light;

	public CycleLeftCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.cycleLeft();
	}
	
	public void undo() {
		light.cycleRight();
	}

}

