package de.fhb.defenderTouch.units.movable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import de.fhb.defenderTouch.gamelogic.DefenderControl;
import de.fhb.defenderTouch.gamelogic.Player;
import de.fhb.defenderTouch.units.amunition.ShootWithRange;
import de.fhb.defenderTouch.units.root.Unit;

public class Tank extends Unit {

	protected int size = 0;

	public Tank(int x, int y, int mode, Player player, DefenderControl gamelogic) {
		super(x, y, mode, player, gamelogic);	
		damagePerHit = 60;
		attackRange = 250;
		healthpointsMax = 120;
		healthpointsStat = 120;
		movementSpeed = 1.5f;
	}

	public void drawFigure(Graphics graphics) {

		graphics.scale(1.0f, 1.0f);
		size = 20;
		
		graphics.drawOval(-15, -17, 30, 30);
		Image image = null;
		try {
			image = new Image("data/units/Tank.png");
			image = image.getScaledCopy(size, size);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		graphics.drawImage(image, -image.getHeight() / 2, -image.getWidth() / 2, size, size, 0f, 0f);
		graphics.resetTransform();
	}

	protected void startShoot(Unit destinationUnit) {
		new ShootWithRange((int) this.position.x, (int) this.position.y, Unit.MODE_NORMAL, this.gamelogic.getPlayerSystem(), destinationUnit, this.damagePerHit, gamelogic);
	}
	
	protected void drawTail(Player player, Graphics graphics){
		//tail aus
	}
}
