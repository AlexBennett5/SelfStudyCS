
package Command;

public class DimCommand implements ICommand {

	private Light light;

	public DimCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.dim();
	}
	
	public void undo() {
		light.brighten();
	}

}

