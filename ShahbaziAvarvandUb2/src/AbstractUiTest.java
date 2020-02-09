import static org.junit.Assert.assertNotNull;
import java.awt.event.KeyEvent;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.finder.JOptionPaneFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JOptionPaneFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

import view.Hauptfenster;

public class AbstractUiTest extends AssertJSwingJUnitTestCase {
	  // Eine "Referenz" auf die SwingAnwendung.
	  private FrameFixture window;
	  @Override
	  protected void onSetUp() {
	    // Starten der SwingAnwendung
		Hauptfenster frame = new Hauptfenster();
	    window = new FrameFixture(robot(), frame);
	    window.show();
	  }
	  @Override
	  protected void onTearDown() {
	    // Nach dem Beenden des Testfalls, alles Aufräumen.
	    // Das heißt, es werden alle Fenster geschlossen,
	    // es werden die Maustasten freigegeben,
	    // es wird der Bildschirm freigegeben.
	    window.cleanUp();
	  }
	  @Test
	  public void shouldBeShowInfodialog() {
	    // Das JTextField mit der Koerpergroeße suchen und merken.
	    JTextComponentFixture koerpergroesse = window.textBox("koerpergroesse");
	    // Wenn das Objekt nicht NULL ist dann gehts weiter...
	    assertNotNull(koerpergroesse);
	    //In das JTextField die Groeße 175 eingeben.
	    koerpergroesse.pressAndReleaseKeys(KeyEvent.VK_1, KeyEvent.VK_7, KeyEvent.VK_5);
	    // Das JTextField mit dem Namen "koerpergewicht" suchen und merken.
	    JTextComponentFixture koerpergewicht = window.textBox("koerpergewicht");
	    // Wenn das Objekt nicht NULL ist dann gehts weiter...
	    assertNotNull(koerpergewicht);
	    //In das JTextField das gewicht 65 eingeben.
	    koerpergewicht.pressAndReleaseKeys(KeyEvent.VK_6, KeyEvent.VK_5);
	    // Die Schaltfläche mit dem Namen "berechneButton" suchen und merken.
	    JButtonFixture berechneButton = window.button("berechneButton");
	    // Wenn das Objekt nicht NULL ist dann gehts weiter...
	    assertNotNull(berechneButton);
	    //Eine Klickaktion auf die Schaltfläche ausführen.
	    berechneButton.click();
	    JOptionPaneFixture optionPane = JOptionPaneFinder.findOptionPane().withTimeout(10).using(robot());
	    // Wenn das Objekt nicht NULL ist dann gehts weiter...
	    assertNotNull(optionPane);
	    // Wenn das Objekt "optionPane" nicht sichtbar ist dann wird eine Fehlermeldung "geworfen".
	    optionPane.requireVisible();
	    
	   
	    
	    // Die Schaltfläche mit dem Text "Abbrechen" suchen und merken.
	    JButtonFixture beendenButton = optionPane.buttonWithText("beendenButton");
	    // Wenn das Objekt nicht NULL ist dann gehts weiter...
	    assertNotNull(beendenButton);
	    //Eine Klickaktion auf die Schaltfläche ausführen.
	    beendenButton.click();
	  }
	}