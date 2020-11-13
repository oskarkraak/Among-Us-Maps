package map;

public class Launcher {
	
	//light version (images are lower quality)
	
	static String version = "1.0";
	
	static String title = "Among Us Maps               - version " + version;

	public static void main(String[] args) {
		Program program = new Program(title);
		program.start();
	}

}
