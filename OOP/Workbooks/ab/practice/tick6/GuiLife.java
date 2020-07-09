
package ab.practice.tick6;

import java.awt.BorderLayout;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.util.List;
import java.io.IOException;

public class GuiLife extends JFrame {

	private PatternPanel patternPanel;
	private ControlPanel controlPanel;

	public GuiLife() {
		super("GuiLife");
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JComponent optionsPanel = createOptionsPanel();
		add(optionsPanel, BorderLayout.WEST);

		JComponent gamePanel = createGamePanel();
		add(gamePanel, BorderLayout.CENTER);
	}

	private JComponent createOptionsPanel() {
	
		Box result = Box.createVerticalBox();
		result.add(createSourcePanel());
		result.add(createPatternPanel());
		result.add(createControlPanel());
		return result;	

	}

	private void addBorder(JComponent component, String title) {

		Border etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		Border tb = BorderFactory.createTitledBorder(etch, title);
		component.setBorder(tb);

	}

	private JComponent createGamePanel() {
  		JPanel holder = new JPanel();
  		addBorder(holder,Strings.PANEL_GAMEVIEW);
  		JPanel result = new JPanel();
  		holder.add(result);
  		return new JScrollPane(holder);
 	}

 	private JComponent createSourcePanel() {
  		SourcePanel result = new SourcePanel();
		addBorder(result,Strings.PANEL_SOURCE);
  		return result; 
 	}

 	private JComponent createPatternPanel() { 
       		PatternPanel result = new PatternPanel();
		addBorder(result, Strings.PANEL_PATTERN);
		patternPanel = result;
		return result;
	}
 	
	private JComponent createControlPanel() {
		ControlPanel result = new ControlPanel();
		addBorder(result, Strings.PANEL_CONTROL);
		controlPanel = result;
		return result;	
	}

 	public static void main(String[] args) {
  		GuiLife gui = new GuiLife();
  		
		try {
			List<Pattern> list = PatternLoader.loadFromDisk("ab/practice/tick6/testpatterns.txt");
			gui.patternPanel.setPatterns(list);
		} catch (IOException ioe) {
		} catch (PatternFormatException ex) {}
		
		gui.setVisible(true);
 	}	

}

