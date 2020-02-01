import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;


public class SimpleMetronome {
	static Timer timer;
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("My First GUI");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(900,900);
       
       JTextArea bpmTextArea = new JTextArea("BPM");
       JTextField bpmTextField = new JTextField(10);
       JPanel colorPanel = new JPanel();
       JPanel buttonPanel = new JPanel();
       
       JButton startBtn = new JButton("Start");
       JButton stopBtn = new JButton("Stop");
       
       startBtn.addActionListener(new ActionListener(){  
    	   public void actionPerformed(ActionEvent e){  
    	       timer = new Timer();
    	       TimerTask task = new Helper(colorPanel);
    	       Double bpmI = Double.parseDouble(bpmTextField.getText());
    	       double o = bpmI * (100.0 / 6.0);
    	       System.out.println(o);
    	       timer.schedule(task, 0, (long)o);
    	   }  
       });  
       
       stopBtn.addActionListener(new ActionListener(){  
    	   public void actionPerformed(ActionEvent e){  
    	       timer.cancel();
    	   }  
       });  
       
       
       colorPanel.setBackground(Color.GREEN);
       
       buttonPanel.add(startBtn);
       buttonPanel.add(bpmTextArea);
       buttonPanel.add(bpmTextField);
       buttonPanel.add(stopBtn);
       
       frame.getContentPane().add(BorderLayout.CENTER, colorPanel);
       frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
      
       frame.setVisible(true);
       

	}
}
