package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIObject {

	protected boolean hovering = false;
	protected Rectangle bounds;
	protected ClickListener clicker;

	public UIObject() {}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract void onClick();

	public void onMouseMove(MouseEvent e) {
		if (bounds.contains(e.getX(), e.getY()))
			hovering = true;
		else
			hovering = false;
	}

	public void onMouseRelease(MouseEvent e) {
		if (hovering)
			onClick();
	}

	// Getters and Setters

	public boolean isHovering() {
		return hovering;
	}

	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}

}