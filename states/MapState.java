package states;

import java.awt.Graphics;

import map.Handler;
import map.Assets;
import ui.*;

public class MapState extends State {

	public MapState(Handler handler, int nr) {
		super(handler);

		// set title
		handler.getDisplay().setTitle(Assets.mapNames[nr]);

		// create map object
		Map map = new Map(Assets.maps[nr], handler);
		// add map object to uiManager
		uiManager.addObject(map);

		// add BackButton
		uiManager.addObject(new BackButton(0f, 0f, 10, 10, handler, false, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(new MenuState(handler));
			}
		}, map));

		// add RoomButtons
		int i = 0;
		for (int[][] room : Assets.roomCoordinates[nr]) {
			int a = i;
			uiManager.addObject(new RoomButton(room[0], room[1], nr, new ClickListener() {
				@Override
				public void onClick() {
					handler.getMouseManager().setUIManager(null);
					State.setState(new RoomState(handler, nr, a));
				}
			}, map));
			i++;
		}
	}

	@Override
	public void tick() {
		uiManager.tick();

		if (handler.getKeyManager().escape) {
			handler.getMouseManager().setUIManager(null);
			State.setState(new MenuState(handler));
		}
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
