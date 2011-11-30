package de.fhb.defenderTouch.units.notmovable;

import java.util.Date;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import de.fhb.defenderTouch.gamelogic.DefenderControl;
import de.fhb.defenderTouch.gamelogic.Player;
import de.fhb.defenderTouch.units.movable.Tank;
import de.fhb.defenderTouch.units.root.BaseUnit;
import de.fhb.defenderTouch.units.root.Building;

public class Armory extends Building {

	public static final int PRICE = 70;
	protected int size = 0;

	private int timeTillNextSpawn = 6000;

	private long startingTime = new Date().getTime();
	private long tickerTime;

	public Armory(int x, int y, int mode, Player player, DefenderControl gamelogic) {
		super(x, y, mode, player, gamelogic);
	}

	public void drawFigure(Graphics graphics) {

		graphics.scale(1.0f, 1.0f);
		// graphics.rotate(0, 0, 180);

		switch (this.level) {
		case LEVEL_ONE:
			size = 18;
			break;
		case LEVEL_TWO:
			size = 20;
			break;
		case LEVEL_THREE:
			size = 22;
			break;
		}

		// graphics.drawLine(-size, +size, 0, -size);
		// graphics.drawLine(0, -size, +size, +size);
		// graphics.drawLine(+size, +size, -size, +size);

		graphics.drawOval(-15, -14, 30, 30);

		Image image = null;
		try {
			image = new Image("data/buildings/Armory.png");
			image = image.getScaledCopy(size, size);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		graphics.drawImage(image, -image.getHeight() / 2, -image.getWidth() / 2, size, size, 0f, 0f);
		graphics.resetTransform();

	}

	public void update() {
		tickerTime = new Date().getTime();

		if (createNewGroundUnit(startingTime, tickerTime)) {
			new Tank(generateRandomNumber((int) this.position.x), generateRandomNumber((int) this.position.y), BaseUnit.MODE_NORMAL, this.owner, gamelogic);
		}

	}

	public boolean createNewGroundUnit(long startingTime, long tickerTime) {
		long helpTime = tickerTime - startingTime;
		if (helpTime >= timeTillNextSpawn) {
			this.startingTime = new Date().getTime();
			return true;
		}
		return false;

	}

	public int generateRandomNumber(int x) {

		int help;

		if (Math.random() > 0.5)
			help = (int) (this.activateRadius * 2);
		else
			help = (int) -(this.activateRadius * 2);
		return x + help;
	}

}