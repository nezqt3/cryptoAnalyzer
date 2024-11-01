package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

	// Обработчик событий открытия окон
	@Override
	public void actionPerformed(ActionEvent e) {

		final GraphicUI ui = new GraphicUI();

		String command = e.getActionCommand();
		if (command.equals("шифр")) {
			ui.shifrFrame();
		} else if (command.equals("дешифр")) {
			ui.deShifrFrame();
		} else if (command.equals("форс")) {
			ui.brutaForceFrame();
		} else if (command.equals("анализ")) {
			ui.statisticalAnalyzeFrame();
		}
	}

}
