package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicUI extends CaesarCipher {

	private final String PATH_OF_ICON = "src\\main\\resources\\static\\eth-crypto-cryptocurrency-cryptocurrencies-cash-money-bank-payment_95149.png";
	private final String PATH_TO_IMAGE_MAIN = "src\\main\\resources\\static\\Leonardo_Phoenix_A_modern_and_stylish_illustration_of_a_crypto_1.jpg";

	private int keyCipher = 0;
	private String resultText = "";
	private String otherText = "";
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
		menuItem2.addActionListener(listener);
		menuItem2.setActionCommand("форс все");
		JMenuItem menuItem3 = new JMenuItem("Подходящего");
		menuItem3.addActionListener(listener);
		menuItem3.setActionCommand("форс один");
		menu2.add(menuItem2);
		menu2.add(menuItem3);
		JMenuItem menuItem4 = new JMenuItem("Статический анализ");
		menuItem4.addActionListener(listener);
		menuItem4.setActionCommand("анализ");
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
		JPanel mainPanelWithLabel = new JPanel();
		mainPanelWithLabel.add(label);
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		frame.add(BorderLayout.CENTER, mainPanelWithLabel);
		frame.add(BorderLayout.NORTH, panelLabel);

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
		JPanel mainPanelWithLabel = new JPanel();
		mainPanelWithLabel.add(label);
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		frame.add(BorderLayout.CENTER, mainPanelWithLabel);
		frame.add(BorderLayout.NORTH, panelLabel);

		frame.setVisible(true);
	}

	// Открытие окна бруте-форса с выводом всех вариантов
	public void brutaForceFrameAll() {
		frame = new JFrame("Бруте-форс");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// Задаю логику чтения файла и записи с шифрованием
		JLabel label = new JLabel("Тут будет результат работы программы");
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
		JButton buttonPhifr = new JButton("Дешифровать");
		panelLabel.add(buttonPhifr);
		// Действие бруте-форса
		buttonPhifr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customText = bruteForce.decryptByBruteForce(resultText);
				label.setText("Дешифрация прошла успешна");
			}
		});
		JPanel mainPanelWithLabel = new JPanel();
		mainPanelWithLabel.add(label);
		label.setFont(new Font("Arial", Font.PLAIN, 25));
		frame.add(BorderLayout.CENTER, mainPanelWithLabel);
		frame.add(BorderLayout.NORTH, panelLabel);
	}

	// Открытие окна бруте-форса в выводом определенного варианта
	public void brutaForceFrameOne() {
		frame = new JFrame("Бруте-форс");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// Создание логики кнопок
		JLabel label = new JLabel("Тут будет ваш ключ");
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		JPanel panelLabel = new JPanel();
		JFileChooser fileChooser = new JFileChooser("src\\main\\resources\\txtFiles");
		JButton buttonOpenDir = new JButton("Открыть файл №1");
		panelLabel.add(buttonOpenDir);
		// Открытие изначального текстового файла
		buttonOpenDir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		JButton buttonOpenDirOther = new JButton("Открыть файл №2");
		panelLabel.add(buttonOpenDirOther);
		// Открытие вспомогательного текстового файла
		buttonOpenDirOther.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setDialogTitle("Открыть файл");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				otherText = "";
				int result = fileChooser.showOpenDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
					try {
						otherText = fileManager.readFile(String.valueOf(fileChooser.getSelectedFile()));
					} catch (IOException ex) {
						System.out.println(e);
					}
					JOptionPane.showMessageDialog(fileChooser, fileChooser.getSelectedFile());
				}
			}
		});
		JButton analyze = new JButton("Получить дешифрование");
		panelLabel.add(analyze);
		// Поиск правильного дешифрования
		analyze.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customText = String.valueOf(bruteForce.findOutTheNearestDecryption(resultText, otherText));
				label.setText(customText);
			}
		});
		JButton writeButton = new JButton("Записать дешифрование");
		panelLabel.add(writeButton);
		// Запись в файл
		writeButton.addActionListener(new ActionListener() {
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
		JPanel mainPanelWithLabel = new JPanel();
		mainPanelWithLabel.add(label);
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		frame.add(BorderLayout.CENTER, mainPanelWithLabel);
		frame.add(BorderLayout.NORTH, panelLabel);
		frame.setVisible(true);
	}

	// Открытие окна статического анализа
	public void statisticalAnalyzeFrame() {
		frame = new JFrame("Статический анализ");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// Создание логики кнопок
		JLabel label = new JLabel("Тут будет ваш ключ");
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		JPanel panelLabel = new JPanel();
		JFileChooser fileChooser = new JFileChooser("src\\main\\resources\\txtFiles");
		JButton buttonOpenDir = new JButton("Открыть файл №1");
		panelLabel.add(buttonOpenDir);
		// Открытие изначального текстового файла
		buttonOpenDir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				}
			}
		});
		JButton buttonOpenDirOther = new JButton("Открыть файл №2");
		panelLabel.add(buttonOpenDirOther);
		// Открытие вспомогательного текстового файла
		buttonOpenDirOther.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setDialogTitle("Открыть файл");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				otherText = "";
				int result = fileChooser.showOpenDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
					try {
						otherText = fileManager.readFile(String.valueOf(fileChooser.getSelectedFile()));
					} catch (IOException ex) {
						System.out.println(e);
					}
					JOptionPane.showMessageDialog(fileChooser, fileChooser.getSelectedFile());
				}
			}
		});
		JButton analyze = new JButton("Получить ключ");
		panelLabel.add(analyze);
		// Поиск ключа
		analyze.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customText = String.valueOf(statisticalAnalysis.findMostLikelyShift(resultText, otherText));
				label.setText(customText);
			}
		});
		JButton writeButton = new JButton("Записать ключ");
		panelLabel.add(writeButton);
		// Запись в файл
		writeButton.addActionListener(new ActionListener() {
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
		JPanel mainPanelWithLabel = new JPanel();
		mainPanelWithLabel.add(label);
		label.setFont(new Font("Arial", Font.PLAIN, 34));
		frame.add(BorderLayout.CENTER, mainPanelWithLabel);
		frame.add(BorderLayout.NORTH, panelLabel);
		frame.setVisible(true);

	}

}
