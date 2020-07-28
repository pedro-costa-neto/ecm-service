package br.com.softdigital.ecm.domains.enums;

public enum ControlIncrement {
	VERSION (1, "Version"), 
	REVIEW (0, "Review");

	private int id;
	private String description;

	private ControlIncrement(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public String getDescription() {
		return this.description;
	}

	public static ControlIncrement toEnum(Integer id) {

		if (id == null) {
			return null;
		}

		for (ControlIncrement x : ControlIncrement.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid id: " + id);
	}
}
