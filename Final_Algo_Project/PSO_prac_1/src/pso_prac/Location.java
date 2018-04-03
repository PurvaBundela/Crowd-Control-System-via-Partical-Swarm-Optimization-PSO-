package pso_prac;




public class Location {

// store the Location in an array to accommodate multi human particles locations
	private double[] location;

	public Location(double[] location) {
		super();
		this.location = location;
	}

	public double[] getLocation() {
		return location;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}    
    
}
