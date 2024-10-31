package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MenuKeyListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicUI {

	private final String PATH_OF_ICON = "src\\main\\resources\\static\\eth-crypto-cryptocurrency-cryptocurrencies-cash-money-bank-payment_95149.png";
	private final String PATH_TO_IMAGE_MAIN = "src\\main\\resources\\static\\Leonardo_Phoenix_A_modern_and_stylish_illustration_of_a_crypto_1.jpg";

	public void GraphicUIMain() throws IOException {

		// Создание окна, главного и его настройка
		JFrame frame = new JFrame("Крипто-анализатор");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 900);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// Создаем объект слушателя событий
		ActionListener listener = new ButtonListener();

		// Создание меню
		JMenuBar menu = new JMenuBar();
		menu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		JMenu menu1 = new JMenu("Варианты работы");
		JMenuItem menuItem = new JMenuItem("Шифрование");
		menuItem.addActionListener(listener);
		menuItem.setActionCommand("шифр");
		JMenuItem menuItem1 = new JMenuItem("Дешифрование");
		JMenu menu2 = new JMenu("Бруте-форс");
		JMenuItem menuItem2 = new JMenuItem("Все");
		JMenuItem menuItem3 = new JMenuItem("Подходящего");
		menu2.add(menuItem2);
		menu2.add(menuItem3);
		JMenuItem menuItem4 = new JMenuItem("Статический анализ");
		menu1.add(menuItem);
		menu1.add(menuItem1);
		menu1.add(menu2);
		menu1.add(menuItem4);
		menu.add(menu1);
		frame.setJMenuBar(menu);

		// Создание картинки
		BufferedImage img = ImageIO.read(new File(PATH_TO_IMAGE_MAIN));
		JLabel labelImg = new JLabel(new ImageIcon(img.getScaledInstance(800, 500, 500)));
		labelImg.setSize(200, 200);
		JPanel panelImages = new JPanel();
		panelImages.add(labelImg);
		frame.add(BorderLayout.NORTH, panelImages);

		// Задаём инонку для окна
		ImageIcon imageIcon = new ImageIcon(PATH_OF_ICON);
		frame.setIconImage(imageIcon.getImage());

		// Создание кнопки и обработка нажатия
		JPanel panelPhifr = new JPanel();
		JLabel labelTexttPhifr = new JLabel("Выберите подходящий тип работы");
		labelTexttPhifr.setFont(new Font("Arial", Font.PLAIN, 40));
		labelTexttPhifr.setBorder(BorderFactory.createDashedBorder(Color.BLACK, 3, 2, 1, true));
//		JButton buttonPhifr = new JButton("Нажать");
//		buttonPhifr.setActionCommand("Шифр");
//		buttonPhifr.addActionListener(listener);
		panelPhifr.add(labelTexttPhifr);
//		panelPhifr.add(buttonPhifr);
		frame.add(BorderLayout.CENTER, panelPhifr);

		frame.setVisible(true);
	}

	// Открытие окна шифрования
	public void shifrFrame() {

		// Создание и настройка окна
		JFrame frame = new JFrame("Шифрование");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// Задаю текст и поле для ввода пути к файлу
		JLabel label = new JLabel("Hello, world!");
		JTextField textField = new JTextField("", 20);
		JPanel panelLabel = new JPanel();
		panelLabel.add(textField);
		panelLabel.add(label);
		label.setFont(new Font("Arial", Font.PLAIN, 56));
		frame.add(panelLabel);

		frame.setVisible(true);
	}

	// Открытие окна дешифрования
	public void deShifrFrame() {
		JFrame frame = new JFrame("Дешифрование");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	// Открытие окна бруте-форса
	public void brutaForceFrame() {
		JFrame frame = new JFrame("Бруте-форс");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	// Открытие окна статического анализа
	public void statisticalAnalyzeFrame() {
		JFrame frame = new JFrame("Статический анализ");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

}
