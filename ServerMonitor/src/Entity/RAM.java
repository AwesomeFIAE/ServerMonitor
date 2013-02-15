package Entity;

public class RAM {
	String description;
	// Speicherplatz in GB!
	double free, size;
	
	public RAM(String description) {
		this.description = description;
	}

	public double getFree() {
		return free;
	}

	public void setFree(double free) {
		this.free = free;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}
	
	
}
