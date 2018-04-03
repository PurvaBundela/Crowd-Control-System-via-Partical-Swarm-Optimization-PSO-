package pso_prac;
import java.util.Vector;
import  pso_prac.Crowd_Project_Constants.*;
import  pso_prac.Crowd_Project_Constants;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

/**
 *
 * @author Panchi
 */
public class Fitness_Human implements Crowd_Project_Constants{

   
    
    public  double calculate_fitness(Location location) {
		double result = 0;
		double x = location.getLocation()[0]; // the "x" part of the location
		double y = location.getLocation()[1]; // the "y" part of the location
		
		result =  Math.sqrt(Math.pow(TARGET_X-x, 2)+Math.pow(TARGET_Y-y, 2));
		
		return result;
	}
    
    
    
   

}
