/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso_prac;

import java.util.Random;
import java.util.Vector;
import static pso_prac.Crowd_Project_Constants.*;


/**
 *
 * @author Panchi
 */
public class Human_Particle_Initialization {
    
    
    
    Random generator = new Random();
    private Vector<Human_Particle> swarm = new Vector<Human_Particle>();
    public Vector<Human_Particle> initializeSwarm() {
		Human_Particle p;
		for(int i=0; i<HUMAN_PARTICLE_SIZE; i++) {
			p = new Human_Particle();
			
			// randomize location inside a space defined in Problem Set
			double[] loc = new double[PROBLEM_DIMENSION];
			loc[0] = X_MIN + generator.nextDouble() * (X_MAX - X_MIN);
			loc[1] = Y_MIN + generator.nextDouble() * (Y_MAX - Y_MIN);
			Location location = new Location(loc);
			
			// randomize velocity in the range defined in Problem Set
			double[] vel = new double[PROBLEM_DIMENSION];
			vel[0] =VEL_MIN + generator.nextDouble() * (VEL_MAX - VEL_MIN);
			vel[1] = VEL_MIN + generator.nextDouble() * (VEL_MAX - VEL_MIN);
			Velocity velocity = new Velocity(vel);
			
			p.setLocation(location);
			p.setVelocity(velocity);
			swarm.add(p);
		}
                return swarm;
	}
    
}
