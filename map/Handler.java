package map;

public class Handler {

	private Program program;
	private Display display;

	public Handler(Program program, Display display) {
		this.program = program;
		this.display = display;
	}

	public MouseManager getMouseManager() {
		return program.getMouseManager();
	}

	public KeyManager getKeyManager() {
		return program.getKeyManager();
	}

	public int getWidth() {
		return program.getWidth();
	}

	public int getHeight() {
		return program.getHeight();
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Display getDisplay() {
		return display;
	}

}