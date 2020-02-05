package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Diese Klasse dient dazu, dass die rechte Seite des Fensters durch eine
 * Tabelle gebildet wird. Die Klasse erbt von JPanel AusgabePanel besitzt über 5
 * Attribute, die die rechte Seite des Fensters ausmachen. einer davon
 * beinhaltet die Inhalte der Tabelle x ist die Zeile und y Spalte ausgabePanel
 * ist die Panel arr ist dazu da um die Position der markierten Stelle
 * herauszuinden
 * 
 * @author farjad
 *
 */
public class AusgabePanel extends JPanel {
	public static final JLabel[][] labels = {
			{ new JLabel("Alter"), new JLabel("unter"), new JLabel("zwischen"), new JLabel("über") },
			{ new JLabel("19-24"), new JLabel("19"), new JLabel("19-24"), new JLabel("24") },
			{ new JLabel("25-34"), new JLabel("20"), new JLabel("20-25"), new JLabel("25") },
			{ new JLabel("35-44"), new JLabel("21"), new JLabel("21-26"), new JLabel("26") },
			{ new JLabel("45-54"), new JLabel("22"), new JLabel("22-27"), new JLabel("27") },
			{ new JLabel("55-64"), new JLabel("23"), new JLabel("23-28"), new JLabel("28") },
			{ new JLabel("über 64"), new JLabel("24"), new JLabel("24-29"), new JLabel("29") },
			{ new JLabel("das bedeutet"), new JLabel("zu dünn"), new JLabel("gerade richtig"),
					new JLabel("zu dick") } };
	private int x;
	private int y;
	public static JPanel ausgabePanel = new JPanel();

	private int[] arr = { 0, 0 };

	/**
	 * Der Default-Konstruktor beinhaltet verschiedene Anweisung, damit beim
	 * Aufruf durch die Klasse Hauptfenster, die rechte Seite des Fensters mit
	 * Tabelle angezeigt wird
	 * 
	 */
	public AusgabePanel() {

		ausgabePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		ausgabePanel.setPreferredSize(new Dimension(300, 300));
		ausgabePanel.setBackground(Color.WHITE);
		GridBagLayout gb2 = new GridBagLayout();
		ausgabePanel.setLayout(gb2);

		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.fill = GridBagConstraints.HORIZONTAL;
		gbc1.weightx = 1;
		gbc1.weighty = 1;
		gbc1.gridwidth = 1;
		gbc1.gridheight = 1;

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int a = 0; a < 8; a++) {
			for (int j = 0; j < 4; j++) {
				gbc1.gridx = j;
				gbc1.gridy = a;
				ausgabePanel.add(labels[a][j], gbc1);
			}
		}

	}

	/**
	 * Diese Methode gibt die Position der markierten Stelle zurück
	 * 
	 * @return array
	 */
	public int[] getArr() {
		return arr;
	}

	/**
	 * Diese Methode dient zur Markierung der zu BMI passenden Inhalte das
	 * erfolgt durch die verschachtelte Verzweigung, indem erstmal die zeilen
	 * festgelegt werden und in Spalten nach passendem Inhalt gesucht wird
	 * 
	 * @param alter
	 *            ist das vom Benutzer ausgewählte alter
	 * @param bmi
	 *            ist der berechnete Bmi-wert
	 */
	public void markiere(String alter, float bmi) {

		arr = new int[2];

		switch (alter) {
		case "19-24":
			if (bmi < 19) {

				labels[1][1].setForeground(Color.RED);

				x = 1;
				y = 1;
			} else if (bmi >= 19 && bmi <= 24) {

				labels[1][2].setForeground(Color.RED);

				x = 1;
				y = 2;
			} else {

				labels[1][3].setForeground(Color.RED);

				x = 1;
				y = 3;
			}
			break;
		case "25-34":
			if (bmi < 20) {

				labels[2][1].setForeground(Color.RED);

				x = 2;
				y = 1;
			} else if (bmi >= 20 && bmi <= 25) {

				labels[2][2].setForeground(Color.RED);

				x = 2;
				y = 2;
			} else {

				labels[2][3].setForeground(Color.RED);

				x = 2;
				y = 3;
			}
			break;
		case "35-44":
			if (bmi < 21) {

				labels[3][1].setForeground(Color.RED);

				x = 3;
				y = 1;
			} else if (bmi >= 21 && bmi <= 26) {

				labels[3][2].setForeground(Color.RED);

				x = 3;
				y = 2;
			} else {

				labels[3][3].setForeground(Color.RED);

				x = 3;
				y = 3;

			}
			break;
		case "45-54":
			if (bmi < 22) {

				labels[4][1].setForeground(Color.RED);

				x = 4;
				y = 1;
			} else if (bmi >= 22 && bmi <= 27) {

				labels[4][2].setForeground(Color.RED);

				x = 4;
				y = 2;
			} else {

				labels[4][3].setForeground(Color.RED);

				x = 4;
				y = 3;

			}
			break;
		case "55-64":
			if (bmi < 23) {

				labels[5][1].setForeground(Color.RED);

				x = 5;
				y = 1;
			} else if (bmi >= 23 && bmi <= 28) {

				labels[5][2].setForeground(Color.RED);

				x = 5;
				y = 2;
			} else {

				labels[5][3].setForeground(Color.RED);

				x = 5;
				y = 3;

			}
			break;
		case "über 64":
			if (bmi < 24) {

				labels[6][1].setForeground(Color.RED);

				x = 6;
				y = 1;
			} else if (bmi >= 24 && bmi <= 29) {

				labels[6][2].setForeground(Color.RED);

				x = 6;
				y = 2;
			} else {

				labels[6][3].setForeground(Color.RED);

				x = 6;
				y = 3;

			}
		}
		arr[0] = x;
		arr[1] = y;

	}

}
