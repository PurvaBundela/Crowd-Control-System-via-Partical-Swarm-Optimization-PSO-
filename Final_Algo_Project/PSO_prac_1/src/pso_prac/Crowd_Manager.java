package pso_prac;




import static pso_prac.Crowd_Project_Constants.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Crowd_Manager implements Crowd_Project_Constants {
	private Vector<Human_Particle> swarm;
        private Human_Particle_Initialization hmi = new Human_Particle_Initialization();
	private double[] pBest = new double[HUMAN_PARTICLE_SIZE];
	private Vector<Location> pBestLocation = new Vector<Location>();
	private double gBest;
        
        private Fitness_Human ps = new Fitness_Human();
	private Location gBestLocation;
	private double[] fitnessValueList = new double[HUMAN_PARTICLE_SIZE];
        public static ArrayList<Double[]> xArray = new ArrayList<>();
        public static ArrayList<Double[]> yArray = new ArrayList<>();
        
	
	Random generator = new Random();
	
	public void execute() {
		swarm = hmi.initializeSwarm();
		updateFitnessList();
		for(int i=0; i<HUMAN_PARTICLE_SIZE; i++) {
			pBest[i] = fitnessValueList[i];
			pBestLocation.add(swarm.get(i).getLocation());
		}
		
                
		int t = 0;
		double w;
		double err = 9999;
		
		while(t < NUMBER_OF_ITERATIONS && err > ERR_TOLERANCE) {
			// step 1 - update pBest
                        Double[] x = new Double[HUMAN_PARTICLE_SIZE];
                        Double[] y = new Double[HUMAN_PARTICLE_SIZE];
			for(int i=0; i<HUMAN_PARTICLE_SIZE; i++) {
				if(fitnessValueList[i] < pBest[i]) {
					pBest[i] = fitnessValueList[i];
					pBestLocation.set(i, swarm.get(i).getLocation());
				}
			}
				
			// step 2 - update gBest
			int bestParticleIndex = Get_Min_Position.getMinPos(fitnessValueList);
			if(t == 0 || fitnessValueList[bestParticleIndex] < gBest) {
				gBest = fitnessValueList[bestParticleIndex];
				gBestLocation = swarm.get(bestParticleIndex).getLocation();
			}
			
			w = UPPERBOUND - (((double) t) / NUMBER_OF_ITERATIONS) * (UPPERBOUND - LOWERBOUND);
			
			for(int i=0; i<HUMAN_PARTICLE_SIZE; i++) {
                                
				double r1 = generator.nextDouble();
				double r2 = generator.nextDouble();
				
				Human_Particle p = swarm.get(i);
				
				// step 3 - update velocity
				double[] newVel = new double[PROBLEM_DIMENSION];
				newVel[0] = (w * p.getVelocity().getPos()[0]) + 
							(r1 * COSTANT_1) * (pBestLocation.get(i).getLocation()[0] - p.getLocation().getLocation()[0]) +
							(r2 * COSTANT_2) * (gBestLocation.getLocation()[0] - p.getLocation().getLocation()[0]);
				newVel[1] = (w * p.getVelocity().getPos()[1]) + 
							(r1 * COSTANT_1) * (pBestLocation.get(i).getLocation()[1] - p.getLocation().getLocation()[1]) +
							(r2 * COSTANT_2) * (gBestLocation.getLocation()[1] - p.getLocation().getLocation()[1]);
				Velocity vel = new Velocity(newVel);
				p.setVelocity(vel);
				
				// step 4 - update location
				double[] newLoc = new double[PROBLEM_DIMENSION];
				newLoc[0] = p.getLocation().getLocation()[0] + newVel[0];
				newLoc[1] = p.getLocation().getLocation()[1] + newVel[1];
                                x[i]= newLoc[0]*200;
                                y[i]= newLoc[1]*200;
				Location loc = new Location(newLoc);
				p.setLocation(loc);
			}
			xArray.add(x);
                        yArray.add(y);
                        
			err = ps.calculate_fitness(gBestLocation) - 0; // minimizing the functions means it's getting closer to 0
			
			
			System.out.println("ITERATION " + t + ": ");
			System.out.println("     Best X: " + gBestLocation.getLocation()[0]);
			System.out.println("     Best Y: " + gBestLocation.getLocation()[1]);
			System.out.println("     Value: " + ps.calculate_fitness(gBestLocation));
			
			t++;
			updateFitnessList();
		}
		
		System.out.println("\nSolution found at iteration " + (t - 1) + ", the solutions is:");
		System.out.println("     Best X: " + gBestLocation.getLocation()[0]);
		System.out.println("     Best Y: " + gBestLocation.getLocation()[1]);
	}
	
//	public void initializeSwarm() {
//		Human_Particle p;
//		for(int i=0; i<HUMAN_PARTICLE_SIZE; i++) {
//			p = new Human_Particle();
//			
//			// randomize location inside a space defined in Problem Set
//			double[] loc = new double[PROBLEM_DIMENSION];
//			loc[0] = LOC_X_LOW + generator.nextDouble() * (LOC_X_HIGH - LOC_X_LOW);
//			loc[1] = LOC_Y_LOW + generator.nextDouble() * (LOC_Y_HIGH - LOC_Y_LOW);
//			Location location = new Location(loc);
//			
//			// randomize velocity in the range defined in Problem Set
//			double[] vel = new double[PROBLEM_DIMENSION];
//			vel[0] =VEL_LOW + generator.nextDouble() * (VEL_HIGH - VEL_LOW);
//			vel[1] = VEL_LOW + generator.nextDouble() * (VEL_HIGH - VEL_LOW);
//			Velocity velocity = new Velocity(vel);
//			
//			p.setLocation(location);
//			p.setVelocity(velocity);
//			swarm.add(p);
//		}
//	}
	
	public void updateFitnessList() {
		for(int i=0; i<HUMAN_PARTICLE_SIZE; i++) {
			fitnessValueList[i] = swarm.get(i).getFitnessValue();
		}
	}
}
