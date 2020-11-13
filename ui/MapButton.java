package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import map.Handler;

public class MapButton extends UIObject {

	private BufferedImage img;
	private Handler handler;

	private int width, height;
	private float x, y,
				  posX, posY;

	public MapButton(float x, float y, int width, int height, BufferedImage image, ClickListener clicker, Handler handler) {
		this.x = x;
	    this.y = y;
	    this.width = width;
	    this.height = height;
		this.clicker = clicker;
		this.handler = handler;
		img = image;
		posX = x;
		posY = y;
		
		bounds = new Rectangle((int) x, (int) y, width, height);
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		// set size
		setHeight(handler.getProgram().getHeight() / 2 - 50);
		setWidth(handler.getProgram().getWidth() / 2 - 50);

		// keep the aspect ratio
		if (( (float)height / (float)img.getHeight()) > ( (float)width / (float)img.getWidth()))
			setHeight(width * img.getHeight() / img.getWidth());
		else
			setWidth(height * img.getWidth() / img.getHeight());

		// calculate x and y coordinates
		setX(posX * width + 20 * (posX + 1));
		setY(posY * height + 20 * (posY + 1));

		bounds = new Rectangle((int) x, (int) y, width, height);

		// draw
		g.drawImage(img, (int) x, (int) y, width, height, null);
		
		if (hovering) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(5));
			g2.setColor(Color.red);
			g2.drawRect((int) x, (int) y, width, height);
		}
	}

	  @Override
	  public void onClick() {
	    clicker.onClick();
	  }
	
	@Override
	public void onMouseMove(MouseEvent e){
	    if(bounds.contains(e.getX(), e.getY()))
	      hovering = true;
	    else
	      hovering = false;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
