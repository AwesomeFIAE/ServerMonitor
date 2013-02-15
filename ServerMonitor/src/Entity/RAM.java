package Entity;

public class RAM {
	String description;
	// Speicherplatz in MB!
	double used, total;
	
	public RAM(String description) {
		this.description = description;
	}

	public double getUsed() {
		return used;
	}

	public void setUsed(double used) {
		this.used = used;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
