package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import model.Generate;

public class GenerateHandler implements ActionListener {

	private Window window;
	public GenerateHandler(Window window){
		this.window = window;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		window.setPasswordText(Generate.generatePassword(window.getInvalidIntegerList(), window.getSizeLabelText()));
	}
}

