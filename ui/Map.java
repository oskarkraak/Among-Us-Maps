package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import map.Handler;

public class Map extends UIObject {

	private Handler handler;
	private BufferedImage img;
	
	private int width, height;
	private float x, y;

	public Map(BufferedImage image, Handler handler) {
		this.handler = handler;
		img = image;
		bounds = new Rectangle(0, 0, 1, 1);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		// set size
		setHeight(handler.getProgram().getHeight() -65);
		setWidth(handler.getProgram().getWidth() -40);

		// keep the aspect ratio
		if (((float) height / (float) img.getHeight()) > ((float) width / (float) img.getWidth())) {
			setHeight(width * img.getHeight() / img.getWidth());
		} else {
			setWidth(height * img.getWidth() / img.getHeight());
		}
		x = (int) ((handler.getWidth() / 2f - width / 2f));
		y = (int) ((handler.getHeight() / 2f - height / 2f)) * 0.5f;

		bounds = new Rectangle((int) x, (int) y, width, height);

		// draw
		g.drawImage(img, (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {}

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

	public BufferedImage getImage() {
		return img;
	}

}
