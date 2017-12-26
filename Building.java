/**
Program that creates a Building class that is used
to construct different building objects and is able 
to calculate each building's carbon footprint.  
This class implements the CarbonFootprint interface.

@author Hiram Raulerson
@version 1.2
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: November 15, 2015.
 
COP5007	Project #: 5
File Name: Building.java
*/

import java.text.DecimalFormat;

public class Building implements CarbonFootprint
{
   /**
   Stores the building's average monthly electric bill
   */
   private double avgElectricBill;
   
   /**
   Stores the building specific details (i.e, hospital, school)
   */
   private String buildingDetails;
   
   /**
   Stores the annual electric bill for the building which is calculated 
   with the average monthly electric bill and the number of months
   */
   private double annualElectricBill;
   
   /**
   Creates a constant - the price per KWH for electricty (for use 
   in the calculation of the building's carbon emission)
   */
   private final double PRICE_PER_KWH = 0.25;

   /**
   Creates a constant - emissions factor for electricity (for use 
   in the calculation of the building's carbon emission)
   */
   private final double ELECTRICITY_EF = 1.37;
   
   /**
   Creates a constant - the number of months in a year (for use 
   in the calculation of the building's carbon emission)
   */
   private final int MONTHS_IN_YEAR = 12;
   
   /**
   Creates a constant - this variable stores the type that an object is
   */
   private final String TYPE = "Building";
   
   /**
   Creates a DecimalFormat object to format a building's carbon emissions
   */
   private DecimalFormat formatter;
   
   /**
   Default constructor creates a Building object with default values for 
   all instance variables.  The DecimalFormat object is also initialized 
   to format the building's carbon emission.
   */
   public Building()
   {
      setBuildingDetails("");
      setMonthlyBill(0);
      formatter = new DecimalFormat(".00");
   }
   
   /**
   Constructs a Building object with the building's details equal to the 
   first parameter and the buildings's average monthly electric bill equal to 
   the second parameter. The DecimalFormat object is also initialized 
   to format the building's carbon emission.
   @param details the specifics about a building, including its type (i.e., school)
   @param bill the building's average monthly electric bill
   */
   public Building(String details, double bill)
   {
      setBuildingDetails(details);
      setMonthlyBill(bill);
      formatter = new DecimalFormat(".00");
   }
   
   /**
   Sets the building's details equal to the parameter value or
   sets the details to an office building, if the parameter is the
   empty string or is null
   @param details more specific information about the building
   */
   public void setBuildingDetails(String details)
   {
      if (details == null || details.equals(""))
      {
         buildingDetails = "office Building";
      }
      else
      {
         buildingDetails = details;
      }
   }
   
   /**
   Returns the details about the the Building object
   @return the building's details
   */
   public String getBuildingDetails()
   {
      return buildingDetails;
   }
   
   /**
   Sets the average monthly electricity bill for the building 
   object to the parameter value
   @param bill the average monthly electricity bill for the building object
   */
   public void setMonthlyBill(double bill)
   {
      if (bill <= 0)
      {
         avgElectricBill = 100;
      }
      else
      {
         avgElectricBill = bill;
      }
   }
   
   /**
   Returns the average monthly electricity bill for the building
   @return the average monthly electricity bill for the building
   */
   private double getMonthlyBill()
   {
      return avgElectricBill;
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
   Prints the annual electric bill for the building based on the
   average monthly electric bill and the number of months in the year
   @return the building's annual electric bill
   */
   public String calculateAnnualBill()
   {
      return ("The estimated annual electric bill for the " + 
              getBuildingDetails() + " building is $" +
              formatter.format((MONTHS_IN_YEAR * getMonthlyBill())) +  
              " per year.");
   }
   
   
   /**
   Returns the carbon footprint for the building
   @return the building's carbon emission in lbs/year
   */
   public double getCarbonFootprint()
   {
      return ((getMonthlyBill() / PRICE_PER_KWH) * ELECTRICITY_EF * MONTHS_IN_YEAR);
   }
   
   /**
	Returns a nicely formatted String composed of all of the 
   building's details
	@return the details of a building
   */
   public String toString()
   {
      return ("\nMy " + getBuildingDetails() + "'s carbon footprint is " + 
              formatter.format(getCarbonFootprint()) + " lbs/year." +
              "\n" + calculateAnnualBill());   
   }
}

