package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class GraphicUI {

	private final String PATH_OF_ICON = "src\\main\\resources\\static\\eth-crypto-cryptocurrency-cryptocurrencies-cash-money-bank-payment_95149.png";
	private final String PATH_TO_IMAGE_MAIN = "src\\main\\resources\\static\\ea72ffb3f3faac1443604be46dae84b1.jpg";

	public GraphicUI() throws IOException {
		BufferedImage img = ImageIO.read(new File(PATH_TO_IMAGE_MAIN));
		JFrame frame = new JFrame("Крипто-анализатор");
		JPanel panel = new JPanel();
		JPanel panelImages = new JPanel();
		JLabel label = new JLabel(new ImageIcon(img));
		ImageIcon imageIcon = new ImageIcon(PATH_OF_ICON);

		frame.setIconImage(imageIcon.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		frame.setVisible(true);
		JButton buttonPhifr = new JButton("Шифрование");
		JButton buttonDePhifr = new JButton("Дешифрование");
		JButton buttonBruteForce = new JButton("Бруте-Форс");
		JButton buttonStaticalAnalyzer = new JButton("Статический Анализ");
		ActionListener listener = new ButtonListener();

		panel.add(buttonPhifr);
		buttonPhifr.setActionCommand("Шифр");

		panel.add(buttonDePhifr);
		buttonDePhifr.setActionCommand("Дешифр");

		panel.add(buttonBruteForce);
		buttonBruteForce.setActionCommand("форс");

		panel.add(buttonStaticalAnalyzer);
		buttonStaticalAnalyzer.setActionCommand("анализ");

		panelImages.add(label);

		buttonPhifr.addActionListener(listener);
		buttonDePhifr.addActionListener(listener);
		buttonBruteForce.addActionListener(listener);
		buttonStaticalAnalyzer.addActionListener(listener);

		JPanel panelString = new JPanel();
		JLabel str = new JLabel("Привет всем!");

		panelString.add(str);

		frame.add(BorderLayout.NORTH, panelImages);
		frame.getContentPane().add(BorderLayout.SOUTH, panelString);
		frame.getContentPane().add(BorderLayout.CENTER, panel);

		frame.setVisible(true);
	}

}
