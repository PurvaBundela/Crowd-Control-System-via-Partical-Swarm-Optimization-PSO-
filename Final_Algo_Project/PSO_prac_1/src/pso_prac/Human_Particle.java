package pso_prac;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Human_Particle {
	private double fitnessValue;
	private Velocity velocity;
	private Location location;
        private Fitness_Human ps = new Fitness_Human();
	
	public Human_Particle() {
		super();
	}

	public Human_Particle(double fitnessValue, Velocity velocity, Location location) {
		super();
		this.fitnessValue = fitnessValue;
		this.velocity = velocity;
		this.location = location;
	}

	public Velocity getVelocity() {
		return velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public double getFitnessValue() {
		fitnessValue = ps.calculate_fitness(location);
		return fitnessValue;
	}
}

