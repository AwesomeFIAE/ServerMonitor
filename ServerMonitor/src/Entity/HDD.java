package Entity;

public class HDD {
	String description;
	// Speicherplatz in GB!
	double free, size;
	
	public HDD(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public double getFree() {
		return free;
	}

	public double getSize() {
		return size;
	}

	public void setFree(double free) {
		this.free = free;
	}

	public void setSize(double size) {
		this.size = size;
	}
	
	public void setFree(String free) {
		char unit = free.substring(free.length() - 1).toCharArray()[0];
		this.free = Integer.parseInt(free.substring(0, free.length() - 1));
		
		switch (unit) {
		case 'M':
			this.free /= 1024;
			break;
		}
	}

	public void setSize(String size) {
		char unit = size.substring(size.length() - 1).toCharArray()[0];
		this.size = Integer.parseInt(size.substring(0, size.length() - 1));
		
		switch (unit) {
		case 'M':
			this.size /= 1024;
			break;
		}
	}
	
	
	
	
}
