package de.fhb.defenderTouch.units.movable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import de.fhb.defenderTouch.gamelogic.DefenderControl;
import de.fhb.defenderTouch.gamelogic.Player;
import de.fhb.defenderTouch.units.amunition.ShootWithRange;
import de.fhb.defenderTouch.units.root.Unit;

public class Fighter extends Unit {

	protected int size = 0;

	public Fighter(int x, int y, int mode, Player player, DefenderControl gamelogic) {
		super(x, y, mode, player, gamelogic);
		damagePerHit = 40;
		attackRange = 250;
		healthpointsMax = 50;
		healthpointsStat = 50;
		movementSpeed = 2f;
	}

	public void drawFigure(Graphics graphics) {

		graphics.scale(1.0f, 1.0f);
		size = 20;
		
		graphics.drawOval(-15, -17, 30, 30);
		
		Image image = null;
		try {
			image = new Image("data/units/Fighter.png");
			image = image.getScaledCopy(size, size);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		image.rotate(180);
		graphics.drawImage(image, -image.getHeight() / 2, -image.getWidth() / 2, size, size, 0f, 0f);
		graphics.resetTransform();
	}

	protected void startShoot(Unit destinationUnit) {
		new ShootWithRange((int) this.position.x, (int) this.position.y, Unit.MODE_NORMAL, this.gamelogic.getPlayerSystem(), destinationUnit, this.damagePerHit, gamelogic);
	}
}
