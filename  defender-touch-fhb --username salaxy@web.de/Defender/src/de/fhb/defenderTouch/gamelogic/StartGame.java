package de.fhb.defenderTouch.gamelogic;

import processing.core.PApplet;


/**
 * Klasse zum Start des Programms
 * @author Salaxy
 *
 */

public class StartGame {

    static public void main(String args[]) {	
        System.out.println("Spiel startet");
        PApplet.main(new String[] { "de.fhb.defenderTouch.display.DefenderPApplet" });
    }
}