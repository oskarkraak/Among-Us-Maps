package ui;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;

import map.Assets;

public class RoomButton extends UIObject{

	private int[] x, y,
				  sampleX, sampleY;
	private Polygon walls;
	private Map map;
	private int mapNr;

	public RoomButton(int[] x, int[] y, int mapNr, ClickListener clicker, Map map) {
		this.map = map;
		this.clicker = clicker;
		sampleX = x.clone();
		sampleY = y.clone();
		this.x = x.clone();
		this.y = y.clone();
		this.mapNr = mapNr;
		setBounds(x, y);
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		if(hovering) {
			//set point locations
			for (int i = x.length - 1; i >= 0; i--) {
				x[i] = (int) (map.getX() + map.getWidth() * ((sampleX[i] - Assets.sampleMapX[mapNr]) / 984f)); //
				y[i] = (int) (map.getY() + map.getHeight() * ((sampleY[i] - Assets.sampleMapY[mapNr]) / 553f)); //
			}
		
			setBounds(x, y);

			// draw
			Graphics2D g2 = (Graphics2D) g;
			// relative thickness so it does not look weird if small
			g2.setStroke(new BasicStroke(3 + 1 * (map.getWidth()/984)));
			g2.setColor(Color.red);
			g2.drawPolygon(walls);
		}
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

	@Override
	public void onMouseMove(MouseEvent e) {
		if (walls.contains(e.getX(), e.getY()))
			hovering = true;
		else
			hovering = false;
	}

	// Getters and setters

	public int[] getX() {
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}
	
	public void setBounds(int[] x, int[] y) {
		walls = new Polygon(x, y, x.length);
	}

}
