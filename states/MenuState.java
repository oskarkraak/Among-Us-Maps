package states;

import java.awt.Graphics;

import map.Assets;
import map.Handler;
import ui.*;

public class MenuState extends State {


	public MenuState(Handler handler) {
		super(handler);
		
		//set title
		handler.getDisplay().setTitle(handler.getProgram().getTitle());

		// add MapButton objects
		// (x and y values are assigned to define the objects position)
		uiManager.addObject(new MapButton(0f, 0f, 10, 10, Assets.maps[0], new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(new MapState(handler, 0));
			}}, handler));

		uiManager.addObject(new MapButton(1f, 0f, 10, 10, Assets.maps[1], new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(new MapState(handler, 1));
			}}, handler));

		uiManager.addObject(new MapButton(0f, 1f, 10, 10, Assets.maps[2], new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(new MapState(handler, 2));
			}}, handler));

	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
