
package Command;

public class BrightCommand implements ICommand {

	private Light light;

	public BrightCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.brighten();
	}
	
	public void undo() {
		light.dim();
	}

}

