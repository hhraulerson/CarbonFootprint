/**
Program that creates an Auto class that is used
to construct different automobiles and is able 
to calculate each automobile's carbon footprint.  
This class implements the CarbonFootprint interface.

@author Hiram Raulerson
@version 1.5
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: November 22, 2015.
 
COP5007	Project #: 5
File Name: Auto.java
*/

import java.text.DecimalFormat;

public class Auto implements CarbonFootprint
{ 
   /**
   Stores the make of the vehicle
   */
   private String make;
   
   /**
   Stores the model of the vehicle
   */
   private String model;
   
   /**
   Stores the number of miles the vehicle is driven per week
   */
   private double milesPerWeek;
   
   /**
   Stores the fuel efficiency of the vehicle
   */
   private double vehicleFuelEfficiency;
   
   /**
   Creates a constant - the number of weeks in a year (for use 
   in the calculation of the vehicle's carbon emission)
   */
   private final int WEEKS_IN_YEAR = 52;
   
   /**
   Creates a constant - the pounds of CO2 the vehicle emits per gallon 
   (for use in the calculation of the vehicle's carbon emission)
   */
   private final double LBS_CO2_EMITTED_PER_GALLON = 19.4;
   
   /**
   Creates a constant - the vehicle's emission rate of gases other 
   than CO2 (for use in the calculation of the vehicle's carbon emission)
   */
   private final double OTHER_GAS_EMISSIONS = 100 / 95;
   
   /**
   Creates a constant - this variable stores the type that an object is
   */
   private final String TYPE = "Auto";
   
   /**
   Creates a DecimalFormat object to format a vehicle's carbon emissions
   */
   private DecimalFormat formatter;
   
   /**
   Default constructor creates an Auto object with default values for 
   all instance variables.  The DecimalFormat object is also initialized 
   to format the vehicle's carbon emission.
   */
   public Auto()
   {
      setMake(null);
      setModel(null);
      setMilesPerWeek(0);
      setVehicleEfficiency(0);
      formatter = new DecimalFormat(".00");
   }
   
   /**
   Constructs an Auto object with the vehicle's make equal to the 
   first parameter, the vehicle's model equal to the second parameter,
   the miles the auto is driven per week equal to the third parameter, 
   and the fuel efficiency of the vehicle set equal to the last paramter. 
   The DecimalFormat object is also initialized to format the 
   vehicle's carbon emission.
   @param theMake the vehicle's make
   @param theModel the vehicle's model
   @param miles the number of miles the vehicle is driven/week
   @param mpg the vehicle's fuel efficiency (i.e., miles per gallon)
   */
   public Auto(String theMake, String theModel, double miles, double mpg)
   {
      setMake(theMake);
      setModel(theModel);
      setMilesPerWeek(miles);
      setVehicleEfficiency(mpg);
      formatter = new DecimalFormat(".00");
   }
   
   /**
   Sets the miles a person drives their vehicle per week equal to 
   the parameter value
   @param miles the number of miles driven per week that a person drives 
   their automobile
   */
   public void setMilesPerWeek(double miles)
   {
      if (miles <= 0)
      {
         milesPerWeek = 200.0;
      }
      else
      {
         milesPerWeek = miles;
      }
   }
   
   /**
   Returns the number of miles/week that a person drives their vehicle
   @return the miles/week that a person drives their vehicle
   */
   public double getMilesPerWeek()
   {
      return milesPerWeek;
   }
   
   /**
   Sets the vehicle's make equal to the parameter value
   @param theMake the vehicle's make
   */
   public void setMake(String theMake)
   {
      if (theMake == null || theMake.equals(""))
      {
         make = "Ford";
      }
      else
      {
         make = theMake;
      }
   }
   
   /**
   Returns the vehicle's make
   @return the automobile's make/manufacturer
   */
   private String getMake()
   {
      return make;
   }
   
   /**
   Sets the vehicle's model equal to the parameter value
   @param theModel the vehicle's model
   */
   public void setModel(String theModel)
   {
      if (theModel == null || theModel.equals(""))
      {
         model = "Taurus";
      }
      else
      {
         model = theModel;
      }
   }
   
   /**
   Returns the vehicle's model
   @return the automobile's model
   */
   private String getModel()
   {
      return model;
   }
   
   public String getMakeAndModel()
   {
      return (getMake() + " " + getModel());
   }
   
   /**
   Sets the vehicle's fuel efficiency equal to the parameter value
   @param mpg the vehicle's fuel efficiency (miles per gallon in the US)
   */
   public void setVehicleEfficiency(double mpg)
   {
      if (mpg <= 0)
      {
         vehicleFuelEfficiency = 20.0;
      }
      else
      {
         vehicleFuelEfficiency = mpg;
      }
   }
   
   /**
   Returns the vehicle's fuel efficiency
   @return the vehicle's fuel efficiency
   */
   public double getVehicleEfficiency()
   {
      return vehicleFuelEfficiency;
   }
   
   /**
   Returns the type of the object
   @return the object's type
   */
   public String getType()
   {
      return TYPE;
   }
   
   /**
   Returns the carbon footprint for the automobile
   @return the vehicle's carbon emission in lbs/year
   */
   public double getCarbonFootprint()
   {
      return (((getMilesPerWeek() * WEEKS_IN_YEAR) / getVehicleEfficiency()) * LBS_CO2_EMITTED_PER_GALLON * OTHER_GAS_EMISSIONS );
   }
   
   /**
	Returns a nicely formatted String composed of all of the 
   automobile's details
	@return the details of a vehicle
   */
   public String toString()
   {
      return ("\nMy " + getMakeAndModel() + "'s carbon footprint is " + 
      formatter.format(getCarbonFootprint()) + " lbs/year.");   
   }
}  