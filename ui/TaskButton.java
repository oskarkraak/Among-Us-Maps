package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import map.Assets;
import map.Handler;

public class TaskButton extends UIObject {

	private Circle circle;
	private float x, y, sampleX, sampleY,
				  sampleRadius = 20,
				  radius;
	private Map map;
	private Handler handler;
	private int mapNr, roomNr, taskNr;

	public TaskButton(float x, float y, Map map, int mapNr, int roomNr, int taskNr, Handler handler) {
		this.map = map;
		this.x = x;
		this.y = y;
		sampleX = x;
		sampleY = y;
		circle = new Circle(x, y, radius);
		this.mapNr = mapNr;
		this.roomNr = roomNr;
		this.taskNr = taskNr;
		this.handler = handler;
	}

	@Override
	public void render(Graphics g) {
		// set location and radius
		x = (int) (map.getX() + map.getWidth() * ((sampleX - Assets.roomImageSamples[mapNr][0][roomNr]) / Assets.roomImageSamples[mapNr][2][roomNr]));
		y = (int) (map.getY() + map.getHeight() * ((sampleY - Assets.roomImageSamples[mapNr][1][roomNr]) / Assets.roomImageSamples[mapNr][3][roomNr]));
		radius = sampleRadius * ( (float) map.getWidth() / (float) Assets.roomImageSamples[mapNr][2][roomNr]);
		setCircle(x, y, radius);
		
		//draw task sign
		g.drawImage(Assets.task, (int) (x - radius), (int) (y - radius), (int) (2*radius), (int) (2*radius), null);
		
		if (hovering) {
			// write name of task in the title
			handler.getDisplay().setTitle(Assets.taskNames[mapNr][roomNr][taskNr]);
			
			// draw image of the task
			BufferedImage img = Assets.tasks[mapNr][roomNr][taskNr];
			int taskHeight = (int) (handler.getHeight() * 0.7f);
			int taskWidth = (int) (handler.getWidth() * 0.7f);
			if (((float) handler.getHeight() / (float) img.getHeight()) > ((float) handler.getWidth() / (float) img.getWidth())) {
				taskHeight = (int) ((float) taskWidth * (float) img.getHeight() / (float) img.getWidth());
			} else {
				taskWidth = (int) ((float) taskHeight * (float) img.getWidth() / (float) img.getHeight());
			}
			int taskX = (int) ((handler.getWidth() / 2 - taskWidth / 2));
			int taskY = (int) ((handler.getHeight() / 2 - taskHeight / 2) * 0.5f);
			
			g.drawImage(img, (int) taskX, (int) taskY, taskWidth, taskHeight, null);
		}
	}

	@Override
	public void onMouseMove(MouseEvent e) {
		if (circle.contains(e.getX(), e.getY()))
			hovering = true;
		else
			hovering = false;
	}

	@Override
	public void tick() {
	}

	@Override
	public void onClick() {
	}

	public void setCircle(float x, float y, float r) {
		circle.setCenterX(x);
		circle.setCenterY(y);
		circle.setRadius(r);
	}

}
