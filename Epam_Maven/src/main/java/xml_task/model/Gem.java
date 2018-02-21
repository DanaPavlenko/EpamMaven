package xml_task.model;

public class Gem {

	private int gemNo;

	private String name;

	private Preciousness presiousness;

	private String origin;

	private VisualParameters parameters;

	private int value;

	public Gem() {
	}

	public Gem(int gemNo, String name, Preciousness presiousness, String origin, VisualParameters parameters,
			int value) {
		this.gemNo = gemNo;
		this.name = name;
		this.presiousness = presiousness;
		this.origin = origin;
		this.parameters = parameters;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Preciousness getPresiousness() {
		return presiousness;
	}

	public void setPresiousness(Preciousness presiousness) {
		this.presiousness = presiousness;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public VisualParameters getParameters() {
		return parameters;
	}

	public void setParameters(VisualParameters parameters) {
		this.parameters = parameters;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getGemNo() {
		return gemNo;
	}

	public void setGemNo(int gemNo) {
		this.gemNo = gemNo;
	}

	@Override
	public String toString() {
		return "Gem [gemNo=" + gemNo + ", name=" + name + ", presiousness=" + presiousness + ", origin=" + origin
				+ ", parameters=" + parameters + ", value=" + value + "]";
	}

}
