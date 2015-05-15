package modelo;

public class ComboItem {
	private String value;
	private String label;
	
	public ComboItem (String value, String label){
		this.label=label;
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
	public String toString() {
		return label;
	}
}
