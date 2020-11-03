package edu.westga.cs.schoolgrades;

import java.net.URL;
import edu.westga.cs.schoolgrades.views.Gui;

/**
 * Main class for the Babble project
 * 
 * @author lewisb
 * @version cs6241
 */
public class Main {

	private static final String GUI_RESOURCE = "edu/westga/cs/schoolgrades/views/GradesGui.fxml";

    /**
     * Start point for the appliction.
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        Gui schoolgrades = new Gui();
        schoolgrades.setVisible(true);
    }

}