package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import map.Handler;

public class BackButton extends UIObject {

	private float x, y, width, height;
	private Map map;
	private boolean printBack;
	private Handler handler;
	private int sampleRoomWidth = 984;

	public BackButton(float x, float y, float width, float height, Handler handler, boolean printBack, ClickListener clicker, Map map) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.clicker = clicker;
		this.map = map;
		this.printBack = printBack;
		this.handler = handler;

		setBounds(x, y, width, height);
	}
	
	public BackButton(float x, float y, float width, float height, Handler handler, boolean printBack, ClickListener clicker, Map map, int sampleRoomWidth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.clicker = clicker;
		this.map = map;
		this.printBack = printBack;
		this.handler = handler;
		this.sampleRoomWidth = sampleRoomWidth;

		setBounds(x, y, width, height);
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		//ratios are determined using sample values
		
		//set x and y coordinates
		x = map.getX() + map.getWidth() * (8f/972);
		y = map.getY() + map.getHeight() * (9.5f/538);
		
		// set size
		width = map.getWidth() * (211.5f/984);
		height = map.getHeight() * (50.5f/538);
		
		setBounds(x, y, width, height);

		// draw
		Graphics2D g2 = (Graphics2D) g;
		
		if(printBack) {
			width = handler.getWidth() * (100f/1024f);
			height = handler.getHeight()* (50f/728f);
			x = 10;
			y = 10;
			setBounds(x, y, width, height);
			
			int fontSize = 40;
			if (((float) height / (float) 50) > ((float) width / (float) 100)) {
				fontSize = (int) ((width * (40f/100f)) );
			} else {
				fontSize = (int) ((height) );
			}
			
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.black);
			g2.drawRect((int) x, (int) y, (int) width, (int) height);
			g2.setColor(Color.red);
			
			g2.setFont(new Font("Dialog", Font.PLAIN, fontSize));
			g2.drawString("Back", x + 2, height);
		}
		
		g2.setColor(Color.red);
		if (hovering) {
			//relative thickness so it does not look weird if small
			g2.setStroke(new BasicStroke(4 + 2 * ( (float) map.getWidth()/sampleRoomWidth)));
			g2.drawRect((int) x, (int) y, (int) width, (int) height);
		}
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

	// Getters and setters

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setBounds(float x, float y, float width, float height) {
		bounds = new Rectangle((int) x, (int) y, (int) width, (int) height);
	}
	
}