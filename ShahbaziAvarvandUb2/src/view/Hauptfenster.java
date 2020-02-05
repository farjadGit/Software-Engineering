package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * Die Klasse Hauptfenster dient dazu, dass das Fenster angezeigt wird und
 * beinhaltet Methoden und einen Konstruktor damit nach der Eingabe des
 * Gewichtes und der Körpergröße im Fenster, BMI berechnet und angezeigt werden
 * kann. Die Klasse erbt von der Klasse JFrame Die Klasse hat 11 Attribute, die
 * das Fenster ausmachen
 * 
 * @author farjad
 *
 */
public class Hauptfenster extends JFrame {

	private JTextField koerpergroesse;
	private JTextField koerpergewicht;
	private JTextField tabele;
	private JComboBox alterCombo;
	private JRadioButton[] rbG;
	private ButtonGroup rbGruppe;
	private JTextPane ergebnisBmi;
	private JButton berechneButton;
	private JButton beendenButton;

	private float bmi;
	private String alter;

	/**
	 * 
	 * Der Default-Kontsruktor, in dem die Methode initWindow aufgerufen und das
	 * fenster angezeigt wird
	 *
	 */
	public Hauptfenster() {
		this.initWindow();

	}

	/**
	 * Die methode beinhaltet verschiedene Methoden, mit denen das Anzeigen des
	 * Fensters möglich ist.
	 */
	protected void initWindow() {
		this.fenster();

		Container contentPane = getContentPane();

		BorderLayout bl = new BorderLayout();
		contentPane.setLayout(bl);

		JPanel eingabePanel = new JPanel();
		this.panelLinks(eingabePanel);

		GridBagConstraints gbc = new GridBagConstraints();
		this.panelLinksGbc(gbc);
		this.panelLinksErsteZeile(eingabePanel, gbc);
		this.panelLinksZweiteZeile(eingabePanel, gbc);
		this.panelLinksDritteZeile(eingabePanel, gbc);
		this.panelLinksVierteZeile(eingabePanel, gbc);
		this.panelLinksFuenfteZeile(eingabePanel, gbc);
		contentPane.add(eingabePanel, BorderLayout.WEST);
		AusgabePanel ausgabePan = new AusgabePanel();
		contentPane.add(AusgabePanel.ausgabePanel, BorderLayout.EAST);

		Panel aktionPanel = new Panel();
		this.panelAktion(aktionPanel, ausgabePan);

		contentPane.add(aktionPanel, BorderLayout.SOUTH);

		this.demensio();
		setVisible(true);
	}

	/**
	 * die Methode wird aufgerufen immer dann, wenn das Fenster schließen soll
	 */
	private void buttonBeendeClicked() {

		System.exit(0);
	}

	/**
	 * Diese Methode wird immer aufgerufen, wenn im Fenster der BMI-wert
	 * berechnet werden soll
	 * 
	 * @param ausgabePan
	 *            als Parameter wird ein Objekt der Klasse AusgabePanel
	 *            übergeben, um auf die Daten der Klasse zugreifen zu können
	 */
	private void buttonBerechneClicked(AusgabePanel ausgabePan) {
		alter = (alterCombo.getSelectedItem().toString());

		int kgr = 0;
		float kge = 0;

		try {
			kgr = Integer.parseInt(koerpergroesse.getText());
			kge = Float.parseFloat(koerpergewicht.getText());
		} catch (NumberFormatException e) {
			kgr = -1;
			kge = -1;
		}
		if (kgr >= 0 && kge >= 0) {// wird überprüft, ob die Eingabe zulässig
									// ist
			float bmi = this.bmiBerechnung(kgr, kge);
			NumberFormat nf = NumberFormat.getInstance();

			nf.setMaximumFractionDigits(2);// Aufrunden des Ergebnises auf
											// 2.nachkomma

			String ausgabe = nf.format(bmi);

			ergebnisBmi.setText(ausgabe);
			ergebnisBmi.setForeground(Color.red);
			ausgabePan.markiere(alter, bmi);
		} else {
			JOptionPane.showMessageDialog(null, "eingabe ist unzulässig");
			ergebnisBmi.setText(null);
			koerpergroesse.setText(null);
			koerpergewicht.setText(null);
		}
	}

	/**
	 * In dieser Methode wird der Bmi-Wert durch eine Formel berechnet
	 * 
	 * @param kgr  ist die eingebene Körpergröße
	 * @param kge ist das eingegebene Körpergewicht
	 * @return der berechnete Bmi-wert wird zurückgegeben
	 */
	public float bmiBerechnung(int kgr, float kge) {
		float koerpergroesseInMeter = (float) (kgr / 100.0);
		float bmi = kge / (koerpergroesseInMeter * koerpergroesseInMeter);
		this.bmi = bmi;
		return bmi;
	}

	/**
	 * Die Methode beinhaltet den Titel,Size und DefaultCloseOperation( damit
	 * das Programm nach dem Schließen des Fensters auch beendet wird.)
	 */
	public void fenster() {
		setTitle("Berechnung des Bodymass Index");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(625, 300);
	}

	/**
	 * Diese Methode umfasst die benötigten Anweisungen zur Realisierung des
	 * linken Teils vom Fenster
	 * 
	 * @param eingabePanel
	 *            ist das Objekt des JPanel, das zurückgegeben wird
	 */
	public void panelLinks(JPanel eingabePanel) {
		eingabePanel.setPreferredSize(new Dimension(300, 300));
		eingabePanel.setBackground(Color.WHITE);
		eingabePanel.setBorder(BorderFactory.createLineBorder(Color.black));

		GridBagLayout gbl = new GridBagLayout();
		eingabePanel.setLayout(gbl);
	}

	/**
	 * 
	 * Diese Methode beinhaltet die Koordinaten des GridBagConstraints
	 * 
	 * @param gbc
	 *            das Objekt des GridBagConstraints
	 */
	public void panelLinksGbc(GridBagConstraints gbc) {

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
	}

	/**
	 * Diese Methode definiert die erste Zeile des linken Teils des Fensters
	 * 
	 * @param eingabePanel
	 *            das Objekt des JPanel
	 * @param gbc
	 *            das Objekt des GridBagConstraintsgbc
	 */
	public void panelLinksErsteZeile(JPanel eingabePanel, GridBagConstraints gbc) {
		JLabel koerpergroesseLabel = new JLabel("Koerpergroesse in cm");
		gbc.gridx = 0;
		gbc.gridy = 1;
		eingabePanel.add(koerpergroesseLabel, gbc);
		koerpergroesse = new JTextField();
		gbc.gridx = 1;

		eingabePanel.add(koerpergroesse, gbc);

	}

	/**
	 * 
	 * Diese Methode definiert die zweite Zeile des linken Teils des Fensters
	 * 
	 * @param eingabePanel
	 *            das Objekt des JPanel
	 * @param gbc
	 *            das Objekt des GridBagConstraints
	 */
	public void panelLinksZweiteZeile(JPanel eingabePanel, GridBagConstraints gbc) {
		JLabel gewichtLabel = new JLabel("               Gewicht in KG");
		gbc.gridx = 0;
		gbc.gridy = 2;
		eingabePanel.add(gewichtLabel, gbc);
		koerpergewicht = new JTextField();

		gbc.gridx = 1;
		eingabePanel.add(koerpergewicht, gbc);
	}

	/**
	 * 
	 * Diese Methode definiert die dritte Zeile des linken Teils des Fensters
	 * 
	 * @param eingabePanel
	 *            das Objekt des JPanel
	 * @param gbc
	 *            das Objekt des GridBagConstraints
	 */

	public void panelLinksDritteZeile(JPanel eingabePanel, GridBagConstraints gbc) {
		JLabel alterLabel = new JLabel("                                Alter");
		gbc.gridx = 0;
		gbc.gridy = 3;
		eingabePanel.add(alterLabel, gbc);
		String[] jahre = { "19-24", "25-34", "35-44", "45-54", "55-64", "über 64" };
		alterCombo = new JComboBox(jahre);

		gbc.gridx = 1;
		eingabePanel.add(alterCombo, gbc);
	}

	/**
	 * 
	 * Diese Methode definiert die vierte Zeile des linken Teils des Fensters
	 * 
	 * @param eingabePanel
	 *            das Objekt des JPanel
	 * @param gbc
	 *            das Objekt des GridBagConstraints
	 */

	public void panelLinksVierteZeile(JPanel eingabePanel, GridBagConstraints gbc) {

		String[] rbText = { "Mann", "Frau", };
		rbG = new JRadioButton[rbText.length];
		rbGruppe = new ButtonGroup();
		int xPos = 1;
		int yPos = 4;

		for (int i = 0; i < rbG.length; i++) {
			rbG[i] = new JRadioButton();
			rbG[i].setText(rbText[i]);

			gbc.gridx = xPos;
			gbc.gridy = yPos++;
			eingabePanel.add(rbG[i], gbc);

			rbGruppe.add(rbG[i]);
		}

		rbG[1].setSelected(true);

	}

	/**
	 * 
	 * Diese Methode definiert die fünfte Zeile des linken Teils des Fensters
	 * 
	 * @param eingabePanel
	 *            das Objekt des JPanel
	 * @param gbc
	 *            das Objekt des GridBagConstraints
	 */

	public void panelLinksFuenfteZeile(JPanel eingabePanel, GridBagConstraints gbc) {
		JLabel ergebnisname = new JLabel("            " + "Ergebnis in BMI");
		gbc.gridx = 0;
		gbc.gridy = 6;
		eingabePanel.add(ergebnisname, gbc);

		ergebnisBmi = new JTextPane();

		ergebnisBmi.setBackground(UIManager.getColor("button.background"));
		gbc.gridx = 1;
		gbc.gridy = 6;
		eingabePanel.add(ergebnisBmi, gbc);
	}

	/**
	 * 
	 * Diese Methode definiert die untere Seite des Fensters d.h die
	 * Aktionspanel
	 * 
	 * @param aktionPanel
	 *            das Objekt des Panel
	 * @param ausgabePan
	 *            das Objekt des AusgabePanel
	 */
	public void panelAktion(Panel aktionPanel, AusgabePanel ausgabePan) {
		aktionPanel.setBackground(Color.WHITE);

		berechneButton = new JButton("Berechne");
		berechneButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				AusgabePanel.labels[ausgabePan.getArr()[0]][ausgabePan.getArr()[1]].setForeground(null);
				buttonBerechneClicked(ausgabePan);
			}

		});
		berechneButton.setActionCommand("berechne");
		aktionPanel.add(berechneButton);

		beendenButton = new JButton("Beenden");
		beendenButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				buttonBeendeClicked();
			}

		});
		beendenButton.setActionCommand("beenden");
		aktionPanel.add(beendenButton);

	}

	/**
	 * 
	 * In dieser Methode wird das Fenster durch eine Formel mittig festgelegt.
	 */

	public void demensio() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getSize().width) / 2, (d.height - getSize().height) / 2);

	}

}
