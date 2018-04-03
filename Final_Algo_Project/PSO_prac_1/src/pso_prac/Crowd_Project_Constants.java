/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso_prac;

/**
 *
 * @author Panchi
 */
public interface Crowd_Project_Constants {

    int HUMAN_PARTICLE_SIZE = 100;
    int NUMBER_OF_ITERATIONS = 100;
    int PROBLEM_DIMENSION = 2;

    double X_MIN = 1;
    double X_MAX = 2;
    double Y_MIN = -4;
    double Y_MAX = 1;
    double VEL_MIN = -1;
    double VEL_MAX = 1;
    double TARGET_X = 3;
    double TARGET_Y = 1;
    double COSTANT_1 = 2.0;
    double COSTANT_2 = 2.0;
    double UPPERBOUND = 1.0;
    double LOWERBOUND = 0.0;
    // WHEN TOLERANCE IS SMALL THE RESULTS ARE MORE ACCURATE 
    double ERR_TOLERANCE = 1E-20;

}
