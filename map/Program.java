package map;

import states.*;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Program implements Runnable {

	private boolean running = false;
	private Thread thread;

	private Display display;
	private String title;
	private int width = (1024-14);
	private int height = (768-77);

	private BufferStrategy bs;
	private Graphics g;

	// Input
	private MouseManager mouseManager;

	// Handler
	private Handler handler;
	
	public Program(String title) {
		this.title = title;
	}

	private void init() {
		display = new Display(title, width, height);
		mouseManager = new MouseManager();
		handler = new Handler(this, display);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();

		State.setState(new MenuState(handler));
	}

	private void tick() {
		if (State.getState() != null)
			State.getState().tick();
	}

	private void render() {
		// adjust width and height
		if ((display.getWidth() != width) || (display.getHeight() != height)) {
			width = display.getWidth();
			height = display.getHeight();
			// print width and height
			System.out.println("Width: " + width + "   Height: " + height);
		}

		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		
		// Draw Here!

		if (State.getState() != null)
			State.getState().render(g);

		// End Drawing!
		
		bs.show();
		g.dispose();
	}

	public void run() {

		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();

	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public String getTitle() {
		return title;
	}

}
