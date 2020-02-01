import java.awt.Color;
import java.awt.Panel;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Helper extends TimerTask {
	JPanel panel;
	public Helper(JPanel panel) {
		this.panel = panel;
	}
	public static int i = 0;
	public void run() {
		System.out.println("Timer ran " + i++);
		
		if (i%2 == 0)
			panel.setBackground(Color.GREEN);
		else panel.setBackground(Color.ORANGE);
	}
	
}
