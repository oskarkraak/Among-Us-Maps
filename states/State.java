package states;
import map.Handler;
import ui.UIManager;

import java.awt.Graphics;

public abstract class State {

	private static State currentState = null;

	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

	// CLASS

	protected Handler handler;
	protected UIManager uiManager;

	public State(Handler handler) {
		this.handler = handler;
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
	}

	public abstract void tick();

	public abstract void render(Graphics g);

}