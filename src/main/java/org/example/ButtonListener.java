package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Шифр")) {
			System.out.println("Хайп");
		} else if (command.equals("Дешифр")) {
			System.out.println("Не хайп");
		} else if (command.equals("анализ")) {
			System.out.println("аналитический хайп");
		} else if (command.equals("форс")) {
			System.out.println("брутевский хайп");
		}
	}

}
