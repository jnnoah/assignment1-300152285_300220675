// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import java.io.*;
import java.util.Random;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTest3 
{
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java 
   * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param args[1] The value of X or RHO.
   * @param args[2] The value of Y or THETA.
   */
  public static void main(String[] args)
  {
    PointCP3 point;

    System.out.println();
    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    // Check if the user input coordinates from the command line
    // If he did, create the PointCP object from these arguments.
    // If he did not, prompt the user for them.
    try
    {
      point = new PointCP3(args[0].toUpperCase().charAt(0), 
        Double.valueOf(args[1]).doubleValue(), 
        Double.valueOf(args[2]).doubleValue());
    }
    catch(Exception e)
    {
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid
      if(args.length != 0)
        System.out.println("Invalid arguments on command line");

      try
      {
        point = getInput();
      }
      catch(IOException ex)
      {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }

    long n = 500;
    double rangeMin = -100000.0;
    double rangeMax = 100000.0;

    double rangeMinRotation = 0.0;
    double rangeMaxRotation = 360.0;
    Random r = new Random();

    long maxTimeCreateObject, maxTimeGetX, maxTimeGetY, maxTimeGetRho, maxTimeGetTheta, maxTimeGetDistance, maxTimeRotatePoint;
    maxTimeCreateObject = maxTimeGetX = maxTimeGetY = maxTimeGetRho = maxTimeGetTheta = maxTimeGetDistance = maxTimeRotatePoint = 0;

    long minTimeCreateObject, minTimeGetX, minTimeGetY, minTimeGetRho, minTimeGetTheta, minTimeGetDistance, minTimeRotatePoint;
    minTimeCreateObject = minTimeGetX = minTimeGetY = minTimeGetRho = minTimeGetTheta = minTimeGetDistance = minTimeRotatePoint = 1000000000; 

    // Cartesian test with random values (X, Y)
    for (int i=0; i<n; i++){
      double randomValueX = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
      double randomValueY = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
      
      long startTime = System.nanoTime();
      PointCP3 testPoint = new PointCP3('C', randomValueX, randomValueY);
      long endTime = System.nanoTime();
      long duration = (endTime - startTime);
      if (maxTimeCreateObject < duration) { maxTimeCreateObject = duration;} 
      if (minTimeCreateObject > duration) { if (duration>0) {minTimeCreateObject = duration;}} 
      
      startTime = System.nanoTime();
      testPoint.getX();
      endTime = System.nanoTime();
      duration = (endTime - startTime); 
      if (maxTimeGetX < duration) { maxTimeGetX = duration;} 
      if (minTimeGetX > duration) { if(duration>0) {minTimeGetX = duration;}} 
      

      startTime = System.nanoTime();
      testPoint.getY();
      endTime = System.nanoTime();
      duration = (endTime - startTime);  
      if (maxTimeGetY < duration) { maxTimeGetY = duration;} 
      if (minTimeGetY > duration) { if(duration>0) {minTimeGetY = duration;} }

      startTime = System.nanoTime();
      testPoint.getRho();
      endTime = System.nanoTime();
      duration = (endTime - startTime);  
      if (maxTimeGetRho < duration) { maxTimeGetRho = duration;} 
      if (minTimeGetRho > duration) { if(duration>0){minTimeGetRho = duration;} }

      startTime = System.nanoTime();
      testPoint.getTheta();
      endTime = System.nanoTime();
      duration = (endTime - startTime);  
      if (maxTimeGetTheta < duration) { maxTimeGetTheta = duration;} 
      if (minTimeGetTheta > duration) { if(duration>0){minTimeGetTheta = duration;}}

      randomValueX = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
      randomValueY = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
      PointCP2 testPointDistance = new PointCP2('C', randomValueX, randomValueY);
      startTime = System.nanoTime();
      testPoint.getDistance(testPointDistance);
      endTime = System.nanoTime();
      duration = (endTime - startTime);  
      if (maxTimeGetDistance < duration) { maxTimeGetDistance = duration;} 
      if (minTimeGetDistance > duration) { if(duration>0){minTimeGetDistance = duration;} }

      double randomRotation = rangeMinRotation + (rangeMaxRotation - rangeMinRotation) * r.nextDouble();
      startTime = System.nanoTime();
      testPoint.rotatePoint(randomRotation);
      endTime = System.nanoTime();
      duration = (endTime - startTime);  
      if (maxTimeRotatePoint < duration) { maxTimeRotatePoint = duration;} 
      if (minTimeRotatePoint > duration) { if(duration>0){minTimeRotatePoint = duration;}} 

    }

    // Cartesian test with random values (r, Theta)
    long maxTimeCreateObjectPolar, maxTimeGetXPolar, maxTimeGetYPolar, maxTimeGetRhoPolar, maxTimeGetThetaPolar, maxTimeGetDistancePolar, maxTimeRotatePointPolar;
    maxTimeCreateObjectPolar = maxTimeGetXPolar = maxTimeGetYPolar = maxTimeGetRhoPolar = maxTimeGetThetaPolar = maxTimeGetDistancePolar = maxTimeRotatePointPolar = 0;

    long minTimeCreateObjectPolar, minTimeGetXPolar, minTimeGetYPolar, minTimeGetRhoPolar, minTimeGetThetaPolar, minTimeGetDistancePolar, minTimeRotatePointPolar;
    minTimeCreateObjectPolar = minTimeGetXPolar = minTimeGetYPolar = minTimeGetRhoPolar = minTimeGetThetaPolar = minTimeGetDistancePolar = minTimeRotatePointPolar = 1000000000; 

    // Cartesian test with random values
    for (int i=0; i<n; i++){
      double randomValueR = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
      double randomValueTheta = rangeMinRotation + (rangeMaxRotation - rangeMinRotation) * r.nextDouble();
      
      long startTime = System.nanoTime();
      PointCP3 testPoint = new PointCP3('P', randomValueR, randomValueTheta);
      long endTime = System.nanoTime();
      long duration = (endTime - startTime);  
      if (maxTimeCreateObjectPolar < duration) { maxTimeCreateObjectPolar = duration;} 
      if (minTimeCreateObjectPolar > duration) { if(duration>0){minTimeCreateObjectPolar = duration;}} 

      startTime = System.nanoTime();
      testPoint.getX();
      endTime = System.nanoTime();
      duration = (endTime - startTime);  
      if (maxTimeGetXPolar < duration) { maxTimeGetXPolar = duration;}
      if (minTimeGetXPolar > duration) { if(duration>0){minTimeGetXPolar = duration;}} 
 

      startTime = System.nanoTime();
      testPoint.getY();
      endTime = System.nanoTime();
      duration = (endTime - startTime);  
      if (maxTimeGetYPolar < duration) { maxTimeGetYPolar = duration;}
      if (minTimeGetYPolar > duration) { if(duration>0){minTimeGetYPolar = duration;}} 
  

      startTime = System.nanoTime();
      testPoint.getRho();
      endTime = System.nanoTime();
      duration = (endTime - startTime);  
      if (maxTimeGetRhoPolar < duration) { maxTimeGetRhoPolar = duration;}
      if (minTimeGetRhoPolar > duration) { if(duration>0){minTimeGetRhoPolar = duration;}}

      startTime = System.nanoTime();
      testPoint.getTheta();
      endTime = System.nanoTime();
      duration = (endTime - startTime);  
      if (maxTimeGetThetaPolar < duration) { maxTimeGetThetaPolar = duration;}
      if (minTimeGetThetaPolar > duration) { if(duration>0){minTimeGetThetaPolar = duration;}}

      randomValueR = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
      randomValueTheta = rangeMinRotation + (rangeMaxRotation - rangeMinRotation) * r.nextDouble();
      PointCP2 testPointDistance = new PointCP2('P', randomValueR, randomValueTheta);
      startTime = System.nanoTime();
      testPoint.getDistance(testPointDistance);
      endTime = System.nanoTime();
      duration = (endTime - startTime);  
      if (maxTimeGetDistancePolar < duration) { maxTimeGetDistancePolar = duration;} 
      if (minTimeGetDistancePolar > duration) { if(duration>0){minTimeGetDistancePolar = duration;}}

      double randomRotation = rangeMinRotation + (rangeMaxRotation - rangeMinRotation) * r.nextDouble();
      startTime = System.nanoTime();
      testPoint.rotatePoint(randomRotation);
      endTime = System.nanoTime();
      duration = (endTime - startTime);  
      if (maxTimeRotatePointPolar < duration) { maxTimeRotatePointPolar = duration;} 
      if (minTimeRotatePointPolar > duration) { if(duration>0){minTimeRotatePointPolar = duration;}}


    }
    System.out.println();
    System.out.println("********************************************************************");
    System.out.println();
    System.out.println("Testing PointCP3");
    System.out.println();
    System.out.println("Doing " + n + " tests" );
    System.out.println("Random X values generated between: " + rangeMin + " and " + rangeMax);
    System.out.println("Random Y values generated between: " + rangeMin + " and " + rangeMax);
    System.out.println();
    System.out.println("Random R values generated between: " + rangeMin + " and " + rangeMax);
    System.out.println("Random Theta values generated between: " + rangeMinRotation + " and " + rangeMaxRotation);
    System.out.println();
    System.out.println("********************************************************************");
    System.out.println();
    System.out.println("With Cartesian Inputs");
    System.out.println();
    System.out.println("Create Object");
    System.out.println("Worst Case: " + maxTimeCreateObject + " ns");
    System.out.println("Best Case: " + minTimeCreateObject + " ns");
    System.out.println();
    System.out.println("getX()");
    System.out.println("Worst case: " + maxTimeGetX + " ns");
    System.out.println("Best case: " + minTimeGetX + " ns");
    System.out.println();
    System.out.println("getY()");
    System.out.println("Worst case: " + maxTimeGetY + " ns");
    System.out.println("Best case: " + minTimeGetY + " ns");
    System.out.println();
    System.out.println("getRho()");
    System.out.println("Worst case: " + maxTimeGetRho + " ns");
    System.out.println("Best case: " + minTimeGetRho + " ns");
    System.out.println();
    System.out.println("getTheta()");
    System.out.println("Worst case: " + maxTimeGetTheta + " ns");
    System.out.println("Best case: " + minTimeGetTheta + " ns");
    System.out.println();
    System.out.println("getDistance()");
    System.out.println("Worst case: " + maxTimeGetDistance + " ns");
    System.out.println("Best case: " + minTimeGetDistance + " ns");
    System.out.println();
    System.out.println("rotatePoint()");
    System.out.println("Worst case: " + maxTimeRotatePoint + " ns");
    System.out.println("Best case: " + minTimeRotatePoint + " ns");
    System.out.println();
    System.out.println("********************************************************************");
    System.out.println();
    System.out.println("With Polar Inputs");
    System.out.println();
    System.out.println("Create Object");
    System.out.println("Worst Case: " + maxTimeCreateObjectPolar + " ns");
    System.out.println("Best Case: " + minTimeCreateObjectPolar + " ns");
    System.out.println();
    System.out.println("getX()");
    System.out.println("Worst case: " + maxTimeGetXPolar + " ns");
    System.out.println("Best case: " + minTimeGetXPolar + " ns");
    System.out.println();
    System.out.println("getY()");
    System.out.println("Worst case: " + maxTimeGetYPolar + " ns");
    System.out.println("Best case: " + minTimeGetYPolar + " ns");
    System.out.println();
    System.out.println("getRho()");
    System.out.println("Worst case: " + maxTimeGetRhoPolar + " ns");
    System.out.println("Best case: " + minTimeGetRhoPolar + " ns");
    System.out.println();
    System.out.println("getTheta()");
    System.out.println("Worst case: " + maxTimeGetThetaPolar + " ns");
    System.out.println("Best case: " + minTimeGetThetaPolar + " ns");
    System.out.println();
    System.out.println("getDistance()");
    System.out.println("Worst case: " + maxTimeGetDistancePolar + " ns");
    System.out.println("Best case: " + minTimeGetDistancePolar + " ns");
    System.out.println();
    System.out.println("rotatePoint()");
    System.out.println("Worst case: " + maxTimeRotatePointPolar + " ns");
    System.out.println("Best case: " + minTimeRotatePointPolar + " ns");
    System.out.println();
    System.out.println("********************************************************************");
  }

  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP
   * object.
   *
   * @return A PointCP constructed using information obtained 
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static PointCP3 getInput() throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    char coordType = 'A'; // Temporary default, to be set to P or C
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 3; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid
          
        // Prompt the user
        if (i == 0) // First argument - type of coordinates
        {
          System.out.print("Enter the type of Coordinates you "
            + "are inputting ((C)artesian / (P)olar): ");
        }
        else // Second and third arguments
        {
          System.out.print("Enter the value of " 
            + (coordType == 'C' 
              ? (i == 1 ? "X " : "Y ")
              : (i == 1 ? "Rho " : "Theta ")) 
            + "using a decimal point(.): ");
        }

        // Get the user's input      
       
        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
        	buffer[k] = '\u0020';        
             
        System.in.read(buffer);
        theInput = new String(buffer).trim();
        
        // Verify the user's input
        try
        {
          if (i == 0) // First argument -- type of coordinates
          {
            if (!((theInput.toUpperCase().charAt(0) == 'C') 
              || (theInput.toUpperCase().charAt(0) == 'P')))
            {
              //Invalid input, reset flag so user is prompted again
              isOK = false;
            }
            else
            {
              coordType = theInput.toUpperCase().charAt(0);
            }
          }
          else  // Second and third arguments
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
          }
        }
        catch(Exception e)
        {
        	System.out.println("Incorrect input");
        	isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;
    }
    //Return a new PointCP object
    return (new PointCP3(coordType, a, b));
  }
}