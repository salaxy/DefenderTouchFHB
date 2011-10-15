package de.fhb.defenderTouch.menu;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;
import TUIO.TuioCursor;
import TUIO.TuioObject;
import TUIO.TuioProcessing;
import TUIO.TuioTime;
import de.fhb.defenderTouch.units.movable.BaseUnit;

public class MenueTest extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TuioProcessing tuioClient;

	// these are some helper variables which are used
	// to create scalable graphical feedback
	float cursor_size = 15;
	float object_size = 60;
	int width = 1024;
	int height = 600;
	PFont font;
	BaseUnit test;
	Menu menue;

	// zum testen
	private ArrayList<BaseUnit> units = new ArrayList<BaseUnit>();

	public void setup() {
		size(width, height); // size of window
		noStroke(); // draw no borders

		loop(); // loop the draw-methode
		frameRate(25);

		hint(ENABLE_NATIVE_FONTS); // render fonts faster
		font = createFont("Arial", 18);

		tuioClient = new TuioProcessing(this); // listens to port 3333

		menue = new Menu(this);

		// kantengl�ttung aktivieren
		this.smooth();
		this.rectMode(CENTER);
	}

	/**
	 * within the draw method we retrieve a Vector (List) of TuioObject and
	 * TuioCursor (polling) from the TuioProcessing client and then loop over
	 * both lists to draw the graphical feedback.
	 * 
	 */
	public void draw() {
		background(200);
		textFont(font, 15);

		textAlign(CENTER);
		text("Dein aktuelles Gold: 200", width / 2, 15);

		// create menue for building options
		menue.drawMenu();

	}

	// these callback methods are called whenever a TUIO event occurs

	// called when an object is added to the scene
	public void addTuioObject(TuioObject tobj) {
		println("add object " + tobj.getSymbolID() + " (" + tobj.getSessionID()
				+ ") " + tobj.getX() + " " + tobj.getY() + " "
				+ tobj.getAngle());

	}

	// called when an object is removed from the scene
	public void removeTuioObject(TuioObject tobj) {
		println("remove object " + tobj.getSymbolID() + " ("
				+ tobj.getSessionID() + ")");
	}

	// called when an object is moved
	public void updateTuioObject(TuioObject tobj) {
		println("update object " + tobj.getSymbolID() + " ("
				+ tobj.getSessionID() + ") " + tobj.getX() + " " + tobj.getY()
				+ " " + tobj.getAngle() + " " + tobj.getMotionSpeed() + " "
				+ tobj.getRotationSpeed() + " " + tobj.getMotionAccel() + " "
				+ tobj.getRotationAccel());
	}

	// called when a cursor is added to the scene
	public void addTuioCursor(TuioCursor tcur) {
		println("add cursor " + tcur.getCursorID() + " (" + tcur.getSessionID()
				+ ") " + tcur.getX() + " " + tcur.getY());

		PVector vector = new PVector(tcur.getScreenX(width),
				tcur.getScreenY(height));
		boolean wurdeEbendAktiviert = false;
		boolean warSchonAktiv = false;

		for (BaseUnit u : units) {

			// wenn eine unit aktiviert wird dann die anderen deaktiveren
			if (!wurdeEbendAktiviert) {

				// wenn bereits aktiv dann deaktivieren
				warSchonAktiv = u.isActive();
				wurdeEbendAktiviert = u.isInner(vector);

				if (wurdeEbendAktiviert && warSchonAktiv) {
					u.deactivate();
				}

			} else {
				u.deactivate();
			}
		}

		// neues Ziel setzen wenn unit aktiv
		for (BaseUnit u : units) {
			if (u.isActive()) {
				u.commandDestination(vector);
			}
		}
	}

	// called when a cursor is moved
	public void updateTuioCursor(TuioCursor tcur) {
		println("update cursor " + tcur.getCursorID() + " ("
				+ tcur.getSessionID() + ") " + tcur.getX() + " " + tcur.getY()
				+ " " + tcur.getMotionSpeed() + " " + tcur.getMotionAccel());
	}

	// called when a cursor is removed from the scene
	public void removeTuioCursor(TuioCursor tcur) {
		println("remove cursor " + tcur.getCursorID() + " ("
				+ tcur.getSessionID() + ")");
	}

	// called after each message bundle
	// representing the end of an image frame
	public void refresh(TuioTime bundleTime) {
		redraw();
	}

	/** Start PApplet as a Java program (can also be run as an applet). */
	static public void main(String args[]) {
		PApplet.main(new String[] { "de.fhb.defenderTouch.menu.MenueTest" });
	}

	// mausclick ueberschreiben
	public void mouseClicked() {
		PVector clickVector = new PVector(this.mouseX, this.mouseY);

		if (this.mouseButton == LEFT) {

			// if menu is not already open, just open it
			// if its open, dont do anything
			if (menue.isMenuOpen() == false) {
				menue.showMenuPoint(clickVector);
				System.out.println("menu offen");
			}
			
			//building a Building
			if (menue.isMenuOpen() && menue.isInnerGroundUnit(clickVector)) {
				System.out.println("Building a Ground Unit if enough Gold");
				menue.createGroundUnit();
				
			}
			

		}

		if (this.mouseButton == RIGHT) {

			// if menu is open und click in menu point -> close it
			if (menue.isMenuOpen() == true && menue.isInner(clickVector)) {
				menue.setMenuOpen(false);
				System.out.println("menu geschlossen");
			}

		}

	}

}