package xml_task.model;

public class VisualParameters {

	private Color color;

	private int transparency;

	private int numberOfEdges;

	public VisualParameters() {
	}

	public VisualParameters(Color color, int transparency, int numberOfEdges) {
		this.color = color;
		this.transparency = transparency;
		this.numberOfEdges = numberOfEdges;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getTransparency() {
		return transparency;
	}

	public void setTransparency(int transparency) {
		this.transparency = transparency;
	}

	public int getNumberOfEdges() {
		return numberOfEdges;
	}

	public void setNumberOfEdges(int numberOfEdges) {
		this.numberOfEdges = numberOfEdges;
	}

	@Override
	public String toString() {
		return "VisualParameters [color=" + color + ", transparency=" + transparency + ", numberOfEdges="
				+ numberOfEdges + "]";
	}

}
