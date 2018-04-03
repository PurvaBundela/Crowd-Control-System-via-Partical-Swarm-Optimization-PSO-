/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso_prac;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *
 * @author panchi
 */
public class MainClass {
double[] xcoords;
double[] ycoords;
//ArrayList<double[] x> a;
public static void main(String[] args) throws InterruptedException{
    //create instances of classes
    
    new Crowd_Manager().execute();
     
    
    Crowd_Manager p = new Crowd_Manager();
    ArrayList<Double[]> xcord = Crowd_Manager.xArray;
    ArrayList<Double[]> ycord = Crowd_Manager.yArray;
    
    Graphic_Representation myPlots=new Graphic_Representation();
    MainClass myMain=new MainClass();
    
    //initialize coordinates
    myMain.xcoords=new double[30];
    myMain.ycoords=new double[30];
    
     
//double x[] = ArrayUtils.toPrimitive(doubles);
    //Create a plotter. Plot
    //to draw points defined by: (xcoords[i],ycoords[i])
//    for(int i=0;i<xcord.size();i++){
//        double[] unboxedX = Stream.of(xcord.get(i)).mapToDouble(Double::doubleValue).toArray();
//        double[] unboxedY = Stream.of(xcord.get(i)).mapToDouble(Double::doubleValue).toArray();
//    myPlots.drawPoints(unboxedX, unboxedY);
//    }
myPlots.drawPoints(xcord, ycord);

    //Please do this!       
}
}