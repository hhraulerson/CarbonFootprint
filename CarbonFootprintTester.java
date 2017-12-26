/**
Program that creates a CarbonFootprint interface.

@author Hiram Raulerson
@version 1.4
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: November 22, 2015.
 
COP5007	Project #: 5
File Name: CarbonFootprintTester.java
*/

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class CarbonFootprintTester
{
   public static void main(String[] args)
   {
      ArrayList<CarbonFootprint> list = new ArrayList<CarbonFootprint>();
      
      String type = null;
      Auto genericVehicle = null;
      Building genericBuilding = null;
      Food genericFood = null;
      
      Scanner inputStream = null;
      
      try
      {
         inputStream = new Scanner(new FileInputStream("data.txt"));
         inputStream.useDelimiter("#");
      }
      catch (FileNotFoundException e)
      {
         System.out.println("\nProblems finding or opening the file data.txt.");
      }
      
      while (inputStream.hasNext() || inputStream.hasNextDouble())
      {
         type = inputStream.next().toLowerCase();
         
         if (type.equals("auto"))
         {
            String make = inputStream.next();
            String model = inputStream.next();
            double miles = inputStream.nextDouble();
            double mpg = inputStream.nextDouble();
            
            genericVehicle = new Auto(make, model, miles, mpg);
            
            list.add(genericVehicle);
         }
         else if (type.equals("building"))
         {
            String details = inputStream.next();
            double bill = inputStream.nextDouble();
            
            genericBuilding = new Building(details, bill);
            
            list.add(genericBuilding);
         }
         else if (type.equals("food"))
         {
            String category = inputStream.next();
            String food = inputStream.next();
            double bill = inputStream.nextDouble();
            
            genericFood = new Food(category, food, bill);
            
            list.add(genericFood);
         }
         else
         {
            System.out.println("\nError reading the file data correctly.  Exiting program.");
            System.exit(0);
         }
      }
      
      for (CarbonFootprint e : list)
      {
         System.out.println("\n" + e.toString());
      }               
   }
}