package states;

import java.awt.Graphics;

import map.Assets;
import map.Handler;
import ui.*;

public class RoomState extends State {

	public RoomState(Handler handler, int mapNr, int roomNr) {
		super(handler);

		// set title
		handler.getDisplay().setTitle(Assets.roomNames[mapNr][roomNr]);

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
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
