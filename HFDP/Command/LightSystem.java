
package Command;

import java.util.ArrayList;

public class LightSystem {

	private ArrayList<Light> lights;
	private Invoker invoke;

	public LightSystem(ArrayList<Light> lights) {

		this.lights = lights;
		invoke = new Invoker();
		initializeInvoker();

	}

	private void initializeInvoker() {

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

	public InvokerGUI generateInvokerGUI() {

		return new InvokerGUI(invoke);

	}

	public LightWindowGUI generateLightWindowGUI() {

		LightWindowGUI window = new LightWindowGUI();

		for (Light light : lights) {

			window.addLight(light);

		}

		setWindowForAllLights(window);

		return window;

	}

	private void setWindowForAllLights(LightWindowGUI window) {

		for (Light light : lights) {

			light.setWindow(window);
		}

	}	


}

