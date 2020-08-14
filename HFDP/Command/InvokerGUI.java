
package Command;

public class InvokerGUI {

	private Invoker invoke;

	public InvokerGUI(Light[] lights) {

		Invoker invoke = new Invoker();
		int k = 0;

		for (Light light : lights) {
	
			DimCommand dm = new DimCommand(light);
			BrightCommand br = new BrightCommand(light);
			CycleLeftCommand lf = new CycleLeftCommand(light);
			CycleRightCommand rg = new CycleRightCommand(light);

			invoke.setCommand(k++, dm, br);
			invoke.setCommand(k++, lf, rg);		

		}

	}

	public JFrame generateFrame() {

		JFrame frame = new JFrame("Remote Control");
		frame.setSize(300, 700);

		//TODO: Add buttons & finish genFrame logic

	}

}

