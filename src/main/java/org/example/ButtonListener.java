package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonListener implements ActionListener{

	// Обработчик событий
	@Override
	public void actionPerformed(ActionEvent e) {

		final GraphicUI ui = new GraphicUI();

		String command = e.getActionCommand();
		if (command.equals("шифр")) {
			ui.shifrFrame();
		} else if (command.equals("Дешифр")) {
			ui.deShifrFrame();
		} else if (command.equals("анализ")) {
			ui.brutaForceFrame();
		} else if (command.equals("форс")) {
			ui.statisticalAnalyzeFrame();
		}
	}

}
