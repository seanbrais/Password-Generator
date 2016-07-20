package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxHandler implements ActionListener{
	Window window;
	boolean lastChecked = false;
	int integerValue;
	
	public CheckBoxHandler(Window window, int integerValue){
		this.window = window;
		this.integerValue = integerValue;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(lastChecked == false){
			window.removeInt(integerValue);
			lastChecked = true;
		}
		else{
			window.addInt(integerValue);
			lastChecked = false;
		}
	}	
}