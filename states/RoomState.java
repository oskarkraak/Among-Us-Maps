package states;

import java.awt.Graphics;

import map.Assets;
import map.Handler;
import ui.*;

public class RoomState extends State {

	int mapNr;
	String title = "";

	int updated = 0;
	boolean esc = false;

	public RoomState(Handler handler, int mapNr, int roomNr) {
		super(handler);
		this.mapNr = mapNr;

		// set title
		title = Assets.roomNames[mapNr][roomNr] + "   -   " + Assets.mapNames[mapNr];
		setTitle(title);

		// initialize map object (room)
		Map room = new Map(Assets.rooms[mapNr][roomNr], handler);
		// add map object to uiManager
		uiManager.addObject(room);

		// add BackButton
		uiManager.addObject(new BackButton(0f, 0f, 10, 10, handler, true, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(new MapState(handler, mapNr));
			}
		}, room, Assets.roomImageSamples[mapNr][2][roomNr]));

		// add TaskButtons
		for (int taskNr = 0; taskNr < Assets.tasks[mapNr][roomNr].length; taskNr++) {
			uiManager.addObject(new TaskButton((float) Assets.taskCoordinates[mapNr][roomNr][0][taskNr],
					(float) Assets.taskCoordinates[mapNr][roomNr][1][taskNr], room, mapNr, roomNr, taskNr, handler));
		}

	}

	@Override
	public void tick() {
		uiManager.tick();

		// limit number of updates to prevent flickering (changing back and forth)
		if (updated == 18) {
			setTitle(title);
			updated = 0;
		}
		updated++;

		// make sure it does not take the same esc again in MapState
		if (updated > 0 && handler.getKeyManager().escape) {
			esc = true;
			updated = -1;
		}

		if (updated > 0 && esc) {
			handler.getMouseManager().setUIManager(null);
			State.setState(new MapState(handler, mapNr));
		}
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

	public void setTitle(String t) {
		handler.getDisplay().setTitle(t);
	}

}
