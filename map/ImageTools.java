/**
 * Some methods for working with images.
 * 
 * @author Oskar Kraak
 */

package map;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageTools {

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageTools.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	public static BufferedImage crop(BufferedImage img, int x, int y, int width, int height) {
		return img.getSubimage(x, y, width, height);
	}

	public static BufferedImage flipHorizontally(BufferedImage img) {
		int w = img.getWidth();
		int h = img.getHeight();
		BufferedImage img2 = new BufferedImage(w, h, img.getType());
		Graphics2D g = img2.createGraphics();
		g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
		g.dispose();
		return img2;
	}

	public static BufferedImage flipVertically(BufferedImage img) {
		int w = img.getWidth();
		int h = img.getHeight();
		BufferedImage img2 = new BufferedImage(w, h, img.getType());
		Graphics2D g = img2.createGraphics();
		g.drawImage(img, 0, 0, w, h, 0, h, w, 0, null);
		g.dispose();
		return img2;
	}

	public static BufferedImage rotateImage(BufferedImage image, double angle) {
		angle = Math.toRadians(angle);
		double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
		int w = image.getWidth(), h = image.getHeight();
		int neww = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h * cos + w * sin);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
		Graphics2D g = result.createGraphics();
		g.translate((neww - w) / 2, (newh - h) / 2);
		g.rotate(angle, w / 2, h / 2);
		g.drawRenderedImage(image, null);
		g.dispose();
		return result;
	}

}