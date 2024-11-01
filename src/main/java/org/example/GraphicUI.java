package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MenuKeyListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicUI extends CaesarCipher{

	private final String PATH_OF_ICON = "src\\main\\resources\\static\\eth-crypto-cryptocurrency-cryptocurrencies-cash-money-bank-payment_95149.png";
	private final String PATH_TO_IMAGE_MAIN = "src\\main\\resources\\static\\Leonardo_Phoenix_A_modern_and_stylish_illustration_of_a_crypto_1.jpg";

	private int keyCipher = 0;
	private String resultText = "";
	private String customText = "";
	private JTextField field;
	private JFrame frame;

	public void GraphicUIMain() throws IOException {

		// Создание окна, главного и его настройка
		frame = new JFrame("Крипто-анализатор");
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
		menuItem1.addActionListener(listener);
		menuItem1.setActionCommand("дешифр");
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
		panelPhifr.add(labelTexttPhifr);
		frame.add(BorderLayout.CENTER, panelPhifr);

		frame.setVisible(true);
	}

	// Открытие окна шифрования
	public void shifrFrame() {

		// Создание и настройка окна
		 frame = new JFrame("Шифрование");
		 frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		 frame.setSize(500, 500);
		 frame.setLocationRelativeTo(null);
		 frame.setResizable(false);

		// Задаю логику чтения файла и записи с шифрованием
		JLabel label = new JLabel("Тут будет прочитанный текст");
		JPanel panelLabel = new JPanel();
		JFileChooser fileChooser = new JFileChooser("D:\\JavaProjects\\ProjectsJavaRush\\src\\main\\resources\\txtFiles");
		JButton buttonOpenDir = new JButton("Открыть файл");
		panelLabel.add(buttonOpenDir);
		// Действие чтения файла
		buttonOpenDir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				fileChooser.setDialogTitle("Открыть файл");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				resultText = "";
				int result = fileChooser.showOpenDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
					try {
						resultText = fileManager.readFile(String.valueOf(fileChooser.getSelectedFile()));
					} catch (IOException ex) {
						System.out.println(e);
					}
					JOptionPane.showMessageDialog(fileChooser, fileChooser.getSelectedFile());
					label.setText(resultText);
				}
			}
		});
		JButton saveDir = new JButton("Сохранить файл");
		panelLabel.add(saveDir);
		// Сохранение файла
		saveDir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setDialogTitle("Сохранение файла");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showSaveDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(fileChooser, "Файл " + fileChooser.getSelectedFile() + " сохранен");
					fileManager.writeFile(customText, String.valueOf(fileChooser.getSelectedFile()));
				}
			}
		});
		JButton buttonPhifr = new JButton("Зашифровать");
		panelLabel.add(buttonPhifr);
		field = new JTextField("", 5);
		// Действие шифрации
		buttonPhifr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textField = resultText;
				customText = "";
				keyCipher = Integer.parseInt(field.getText());
				if (validator.isValidKey(keyCipher)) {
					customText = cipher.encrypt(textField, keyCipher);
				} else {
					customText = "ERROR";
				}
				label.setText(customText);
			}
		});
		panelLabel.add(field);
		panelLabel.add(label);
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		frame.add(panelLabel);

		frame.setVisible(true);
	}

	// Открытие окна дешифрования
	public void deShifrFrame() {
		frame = new JFrame("Дешифрование");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// Задаю логику чтения файла и записи с дешифрованием
		JLabel label = new JLabel("Тут будет прочитанный текст");
		JPanel panelLabel = new JPanel();
		JFileChooser fileChooser = new JFileChooser("src\\main\\resources\\txtFiles");
		JButton buttonOpenDir = new JButton("Открыть файл");
		panelLabel.add(buttonOpenDir);
		// Действие чтения файла
		buttonOpenDir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				fileChooser.setDialogTitle("Открыть файл");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				resultText = "";
				int result = fileChooser.showOpenDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
					try {
						resultText = fileManager.readFile(String.valueOf(fileChooser.getSelectedFile()));
					} catch (IOException ex) {
						System.out.println(e);
					}
					JOptionPane.showMessageDialog(fileChooser, fileChooser.getSelectedFile());
					label.setText(resultText);
				}
			}
		});
		JButton saveDir = new JButton("Сохранить файл");
		panelLabel.add(saveDir);
		// Сохранение файла
		saveDir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setDialogTitle("Сохранение файла");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showSaveDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(fileChooser, "Файл " + fileChooser.getSelectedFile() + " сохранен");
					fileManager.writeFile(customText, String.valueOf(fileChooser.getSelectedFile()));
				}
			}
		});
		JButton buttonPhifr = new JButton("Расшифровать");
		panelLabel.add(buttonPhifr);
		field = new JTextField("", 5);
		// Действие дешифрации
		buttonPhifr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textField = resultText;
				customText = "";
				keyCipher = Integer.parseInt(field.getText());
				if (validator.isValidKey(keyCipher)) {
					customText = cipher.decrypt(textField, keyCipher);
				} else {
					customText = "ERROR";
				}
				label.setText(customText);
			}
		});
		panelLabel.add(field);
		panelLabel.add(label);
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		frame.add(panelLabel);

		frame.setVisible(true);
	}

	// Открытие окна бруте-форса
	public void brutaForceFrame() {
		frame = new JFrame("Бруте-форс");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	// Открытие окна статического анализа
	public void statisticalAnalyzeFrame() {
		frame = new JFrame("Статический анализ");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

}
