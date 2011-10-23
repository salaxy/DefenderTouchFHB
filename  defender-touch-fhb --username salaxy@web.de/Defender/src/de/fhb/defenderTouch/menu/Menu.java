package de.fhb.defenderTouch.menu;

import java.util.ArrayList;
import java.util.HashMap;

import de.fhb.defenderTouch.graphics.GraphicTools;
import de.fhb.defenderTouch.units.movable.BaseUnit;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PMatrix;
import processing.core.PVector;

public class Menu {

	/**
	 * Ist das Applet auf dem die Einheiten zugeordnet sind
	 */
	protected PApplet mainPoint;
	// protected PApplet mainPoints;

	/**
	 * aktuelle Position der Einheit
	 */
	protected PVector position;

	/**
	 * aktuelle Position der Einheit
	 */
	protected PVector menue1;

	/**
	 * aktuelle Position der Einheit
	 */
	protected PVector menue2;

	/**
	 * aktuelle Position der Einheit
	 */
	protected PVector menue3;

	/**
	 * aktuelle Position der Einheit
	 */
	protected PVector menue4;

	/**
	 * aktuelle Position der Einheit
	 */
	protected PVector menue5;

	/**
	 * aktuelle Position der Einheit
	 */
	protected PVector menue6;

	/**
	 * 
	 */
	protected PApplet builtBuildings;
	ArrayList<PVector> bBuildings = new ArrayList<PVector>();

	/**
	 * aktuelle Sichtbarkeit
	 */
	protected boolean menuOpen = false;

	/**
	 * aktuelle Sichtbarkeit
	 */
	protected boolean menuCloseClicked = false;

	/**
	 * Aktivierungsradius eines Menupunkts
	 */
	protected float activatediameterMenu = 38;

	/**
	 * Aktivierungsradius eines Menupunkts
	 */
	protected float activateRadiusBuildings = 35;

	/**
	 * Aktivierungsradius eines Menupunkts
	 */
	protected final int DISTANCE = -40;

	/**
	 * Nummer des geb�udes
	 */
	protected int number = 0;

	/**
	 * Konstruktor
	 */
	public Menu(PApplet display) {
		this.position = new PVector(0, 0);
		this.mainPoint = display;
		this.builtBuildings = display;

		menue1 = new PVector(-100, -100);
		menue2 = new PVector(-100, -100);
		menue3 = new PVector(-100, -100);
		menue4 = new PVector(-100, -100);
		menue5 = new PVector(-100, -100);
		menue6 = new PVector(-100, -100);

	}

	/**
	 * Menupunkt anzeigen
	 */
	public void showMenuPoint(PVector position) {
		this.position = position;
		this.menuOpen = true;
	}

	/**
	 * is always been done
	 */
	@SuppressWarnings("deprecation")
	public void drawMenu() {

		mainPoint.ellipseMode(PConstants.CENTER);
		// mainPoint.translate(this.position.x, this.position.y);

		if (menuOpen) {

			mainPoint.noFill();
			mainPoint.stroke(100);

			float drehung = 0f;
			float drehungProUntermenue = PApplet.TWO_PI / 6;

			// for(;drehung<PApplet.TWO_PI;){
			// mainPoint.translate(this.position.x, this.position.y);
			// System.out.println(drehung+"");
			// mainPoint.rotate(drehung);
			// PVector v=new PVector(0,-40);
			// v.rotate(drehung);
			// v.add(position);
			//
			// System.out.println(v+"");
			// mainPoint.ellipse(0, -40, 38, 38);
			// drehung=drehung+drehungProUntermenue;
			// mainPoint.resetMatrix();
			//
			// }

			mainPoint.translate(this.position.x, this.position.y);
			// System.out.println(drehung+"");
			mainPoint.rotate(0);
			menue1 = new PVector(0, DISTANCE);
			menue1.rotate(0);
			menue1.add(position);
			// System.out.println(menue1+"");
			mainPoint.ellipse(0, DISTANCE, 38, 38);
			mainPoint.triangle(-5, DISTANCE + 5, 0, DISTANCE - 5, +5, DISTANCE + 5);
			drehung = drehung + drehungProUntermenue;
			mainPoint.resetMatrix();

			mainPoint.translate(this.position.x, this.position.y);
			// System.out.println(drehung+"");
			mainPoint.rotate(PApplet.TWO_PI / 6);
			menue2 = new PVector(0, DISTANCE);
			menue2.rotate(PApplet.TWO_PI / 6);
			menue2.add(position);
			// System.out.println(menue2+"");
			mainPoint.ellipse(0, DISTANCE, 38, 38);
			ArrayList<PVector> vektoren1 = new ArrayList<PVector>();
			vektoren1.add(new PVector(-4, DISTANCE - 4));
			vektoren1.add(new PVector(4, DISTANCE - 4));
			vektoren1.add(new PVector(0, DISTANCE - 4));
			vektoren1.add(new PVector(0, DISTANCE - 8));
			vektoren1.add(new PVector(0, DISTANCE + 4));
			vektoren1.add(new PVector(4, DISTANCE + 4));
			vektoren1.add(new PVector(-4, DISTANCE + 4));
			mainPoint.ellipse(0, DISTANCE - 4, 8, 8);
			GraphicTools.zeicheFigurNachVektoren(vektoren1, mainPoint);
			drehung = drehung + drehungProUntermenue;
			mainPoint.resetMatrix();

			mainPoint.translate(this.position.x, this.position.y);
			// System.out.println(drehung+"");
			mainPoint.rotate(PApplet.TWO_PI / 6 * 2);
			menue3 = new PVector(0, DISTANCE);
			menue3.rotate(PApplet.TWO_PI / 6 * 2);
			menue3.add(position);
			// System.out.println(menue3+"");
			mainPoint.ellipse(0, DISTANCE, 38, 38);
			ArrayList<PVector> vektoren2 = new ArrayList<PVector>();
			vektoren2.add(new PVector(0, DISTANCE - 8));
			vektoren2.add(new PVector(0, DISTANCE + 8));
			vektoren2.add(new PVector(0, DISTANCE));
			vektoren2.add(new PVector(8, DISTANCE));
			vektoren2.add(new PVector(-8, DISTANCE));
			GraphicTools.zeicheFigurNachVektoren(vektoren2, mainPoint);
			drehung = drehung + drehungProUntermenue;
			mainPoint.resetMatrix();

			mainPoint.translate(this.position.x, this.position.y);
			// System.out.println(drehung+"");
			mainPoint.rotate(PApplet.TWO_PI / 6 * 3);
			menue4 = new PVector(0, DISTANCE);
			menue4.rotate(PApplet.TWO_PI / 6 * 3);
			menue4.add(position);
			// System.out.println(menue4+"");
			mainPoint.ellipse(0, DISTANCE, 38, 38);
			drehung = drehung + drehungProUntermenue;
			mainPoint.resetMatrix();

			mainPoint.translate(this.position.x, this.position.y);
			// System.out.println(drehung+"");
			mainPoint.rotate(PApplet.TWO_PI / 6 * 4);
			menue5 = new PVector(0, DISTANCE);
			menue5.rotate(PApplet.TWO_PI / 6 * 4);
			menue5.add(position);
			// System.out.println(menue5+"");
			mainPoint.ellipse(0, DISTANCE, 38, 38);
			drehung = drehung + drehungProUntermenue;
			mainPoint.resetMatrix();

			mainPoint.translate(this.position.x, this.position.y);
			mainPoint.rotate(PApplet.TWO_PI / 6 * 5);
			menue6 = new PVector(0, DISTANCE);
			menue6.rotate(PApplet.TWO_PI / 6 * 5);
			menue6.add(position);
			mainPoint.ellipse(0, DISTANCE, 38, 38);
			drehung = drehung + drehungProUntermenue;
			mainPoint.resetMatrix();

			// mainPoint.rotate((float) Math.PI);
			//
			// // Menupoint
			// mainPoint.ellipse(0, 0, 20, 20);
			// // Groundunit Point
			// mainPoint.translate(-35, -15);
			// mainPoint.triangle(-5,+5, 0, -5, +5, +5);
			// mainPoint.ellipse(0, 0, 30, 30);
			//
			//
			// //mainPoints.triangle(-20, -10, -15, -20, -10, -10);
			// // Supportunit Point
			// mainPoint.translate(35, -20);
			// //Punkte hinzufuegen
			// ArrayList<PVector> vektoren=new ArrayList<PVector>();
			// vektoren.add(new PVector(0, -8));
			// vektoren.add(new PVector(0, 8));
			// vektoren.add(new PVector(0, 0));
			// vektoren.add(new PVector(8,0));
			// vektoren.add(new PVector(-8, 0));
			//
			// //zeichnen
			// //GraphicTools.zeicheFigurNachVektoren(vektoren,display);
			// mainPoint.ellipse(0, 0, 30, 30);
			// // Defenceunit Point
			// mainPoint.translate(35, 20);
			// mainPoint.ellipse(0, 0, 30, 30);

			// mainPoint.translate(-35, -15);

			// System.out.println(this.position.x + " und " + this.position.y);
		} else {
			// bBuildings.translate(this.position.x, this.position.y);
			// mainPoint.translate(this.position.x, this.position.y);
			// builtBuildings.show();

			// bBuildings.add(new PVector(-4,4));
			// mainPoint.ellipse(0,DISTANCE-4 , 8, 8);
			// GraphicTools.zeicheFigurNachVektoren(bBuildings,mainPoint);
			// // builtBuildings.triangle(-5,+5, 0, -5, +5, +5);

			// TODO
		}

	}

	/**
	 * 
	 * @param clickVector
	 * @return 	false - if click is not inner circle
	 * 			true  - if click is inner circle
	 */
	public boolean isInnerMainElement(PVector clickVector) {

		if (this.position.dist(clickVector) < this.activatediameterMenu / 2) {
			System.out.println("Menu close choosed");
			number = 0;
			setMenuOpen(false);
			return true;
		}
		return false;

	}

	/**
	 * 
	 * @param clickVector
	 * @return false - if
	 */
	public boolean isInnerMenuElement(PVector clickVector) {

		if (this.menue1.dist(clickVector) < this.activatediameterMenu / 2) {
			System.out.println("Menue 1");
			number = 0;
			setMenuOpen(false);
			return true;
		}

		if (this.menue2.dist(clickVector) < this.activatediameterMenu / 2) {
			System.out.println("Menue 2");
			number = 1;
			setMenuOpen(false);
			return true;
		}

		if (this.menue3.dist(clickVector) < this.activatediameterMenu / 2) {
			System.out.println("Menue 3");
			number = 2;
			setMenuOpen(false);
			return true;
		}

		if (this.menue4.dist(clickVector) < this.activatediameterMenu / 2) {
			System.out.println("Menue 4");
		}

		if (this.menue5.dist(clickVector) < this.activatediameterMenu / 2) {
			System.out.println("Menue 5");
		}

		if (this.menue6.dist(clickVector) < this.activatediameterMenu / 2) {
			System.out.println("Menue 6");
		}

		return false;

	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setMenuOpen(boolean menuOpen) {
		this.menuOpen = menuOpen;
	}

	public boolean isMenuOpen() {
		return menuOpen;
	}

	public int getNumber() {
		return number;
	}

	public float getPositionX() {
		return position.x;
	}

	public float getPositionY() {
		return position.y;
	}

}
