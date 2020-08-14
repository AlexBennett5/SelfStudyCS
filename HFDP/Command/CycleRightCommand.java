
package Command;

public class CycleRightCommand implements ICommand {

	private Light light;

	public CycleRightCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.cycleRight();
	}
	
	public void undo() {
		light.cycleLeft();
	}

}

