package ui;

public class Circle {

	private float r, x, y;

	public Circle(float x, float y, float r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public void setCenterX(float x) {
		this.x = x;
	}

	public void setCenterY(float y) {
		this.y = y;
	}

	public void setRadius(float r) {
		this.r = r;
	}

	public boolean contains(int x, int y) {
		//distance point - center
		float dx = Math.abs(x - this.x);
		float dy = Math.abs(y - this.y);
		float d = (float) Math.sqrt( Math.pow(dx, 2) + Math.pow(dy, 2) );

		if (d <= r) {
			return true;
		} else {
			return false;
		}
	}

}