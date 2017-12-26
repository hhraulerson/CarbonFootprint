/**
Program that creates a Food class that is used
to construct different food objects, in different
food categories, and is able to calculate each food's
carbon footprint.  This class implements the 
CarbonFootprint interface.

@author Hiram Raulerson
@version 1.5
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: November 22, 2015.
 
COP5007	Project #: 5
File Name: Food.java
*/

import java.text.DecimalFormat;

public class Food implements CarbonFootprint
{
   /**
   Stores the average monthly amount (in dollars) spent a particular food
   */
   private double avgMonthlyBill;
   
   /**
   Stores the category of food that a particular food belongs in
   */
   private String foodCategory;
   
   /**
   Stores the food's name
   */
   private String foodName;
   
   /**
   Stores the emission factor of the food which is based on the
   category that the food belongs to
   */
   private int emissionsFactor;
   
   /**
   Creates a constant - the number of months in a year (for use 
   in the calculation of the food's carbon emission)
   */
   private final int MONTHS_IN_YEAR = 12;
   
   /**
   Creates a constant - the factor used to convert grams to pounds 
   (for use in the calculation of the food's carbon emission)
   */
   private final double GRAMS_TO_POUNDS = 0.0022;
   
   /**
   Creates a constant - the emission factor for the Meat, Fish, and
   Eggs category (for use in the calculation of the food's 
   carbon emission)
   */
   private final int MEAT_FISH_EGGS_EF = 1452;
   
   /**
   Creates a constant - the emission factor for the Cereals and Bakery
   category (for use in the calculation of the food's carbon emission)
   */
   private final int CEREALS_BAKERY_EF = 741;
   
   /**
   Creates a constant - the emission factor for the Dairy category 
   (for use in the calculation of the food's carbon emission)
   */
   private final int DAIRY_EF = 1911;
   
   /**
   Creates a constant - the emission factor for the Fruits and Vegetables
   category (for use in the calculation of the food's carbon emission)
   */
   private final int FRUITS_VEGETABLES_EF = 1176;
   
   /**
   Creates a constant - the emission factor for the Eating or Dining Out 
   category (for use in the calculation of the food's carbon emission)
   */
   private final int EATING_OUT_EF = 368;
   
   /**
   Creates a constant - the emission factor for the Other Foods category 
   (for use in the calculation of the food's carbon emission)
   */
   private final int OTHER_FOODS_EF = 467;
   
   /**
   Creates a constant - this variable stores the type that an object is
   */
   private final String TYPE = "Food";
   
   /**
   Creates a DecimalFormat object to format a food's carbon emissions
   */
   private DecimalFormat formatter;
   
   /**
   Default constructor creates a Food object with default values for 
   all instance variables.  The DecimalFormat object is also initialized 
   to format the building's carbon emission.
   */
   public Food()
   {
      setFoodCategory(null);
      setFoodName(null);
      setMonthlyBill(0);
      setEmissionsFactor(getFoodCategory());
      formatter = new DecimalFormat(".00");
   }
   
   /**
   Constructs a Food object with the food's category equal to the 
   first parameter, the food's name equal to the second parameter,
   and the food's average amount spent on the food per month equal to 
   the second parameter. The DecimalFormat object is also initialized 
   to format the food's carbon emission.
   @param category the category that the food falls into
   @param food the food's name
   @param bill the average amount spent on the food for a month (in dollars)
   */
   public Food(String category, String food, double bill)
   {
      setFoodCategory(category);
      setFoodName(food);
      setMonthlyBill(bill);
      setEmissionsFactor(getFoodCategory());
      formatter = new DecimalFormat(".00");
   }
   
   /**
   Sets the food category equal to the parameter value or
   sets the category to other foods, if the parameter is the
   empty string or is null
   @param category the category of food that the item is placed in to calculate
   it's carbon footprint
   */
   public void setFoodCategory(String category)
   {
      if (category == null || category.equals(""))
      {
         foodCategory = "Other Foods";
      }
      else
      {
         foodCategory = category;
      }
   }
   
   /**
   Returns the category that the Food object belongs in
   @return the category that the food belongs to
   */
   private String getFoodCategory()
   {
      return foodCategory;
   }
   
   /**
   Sets the average monthly bill for the Food object
   to the parameter value
   @param bill the average monthly bill for the Food object
   */
   public void setMonthlyBill(double bill)
   {
      if (bill <= 0)
      {
         avgMonthlyBill = 100;
      }
      else
      {
         avgMonthlyBill = bill;
      }
   }

   /**
   Returns the average monthly bill for the Food object
   @return the average monthly bill for the Food object
   */
   private double getMonthlyBill()
   {
      return avgMonthlyBill;
   }
   
   /**
   Sets the name/type of the food 
   @param food the name/type of the food
   */
   public void setFoodName(String food)
   {
      if (food == null || food.equals(""))
      {
         foodName = "Mystery food";
      }
      else
      {
         foodName = food;
      }
   }
   
   /**
   Returns the name/type of the food 
   @return the name/type of the food
   */
   public String getFoodName()
   {
      return foodName;
   }
   
   /**
   Sets the emissions factor based on the category
   of food the object falls into 
   @param category the food's category
   */
   public void setEmissionsFactor(String category)
   {
      String categoryLowerCase = category.toLowerCase();
      String meatFishEggs = "Meat, Fish, and Eggs";
      String cerealsBakery = "Cereals and Bakery";
      String dairy = "Dairy";
      String fruitsVeggies = "Fruits and Vegetables";
      String eatingOut = "Eating or Dining Out";
      
      if (meatFishEggs.toLowerCase().contains(categoryLowerCase))
      {
         emissionsFactor = MEAT_FISH_EGGS_EF;
         setFoodCategory(meatFishEggs);
      }
      else if (cerealsBakery.toLowerCase().contains(categoryLowerCase))
      {
         emissionsFactor = CEREALS_BAKERY_EF;
         setFoodCategory(cerealsBakery);
      }
      else if (dairy.toLowerCase().contains(categoryLowerCase))
      {
         emissionsFactor = DAIRY_EF;
         setFoodCategory(dairy);
      }
      else if (fruitsVeggies.toLowerCase().contains(categoryLowerCase))
      {
         emissionsFactor = FRUITS_VEGETABLES_EF;
         setFoodCategory(fruitsVeggies);
      }
      else if (eatingOut.toLowerCase().contains(categoryLowerCase))
      {
         emissionsFactor = EATING_OUT_EF;
         setFoodCategory(eatingOut);
      }
      else
      {
         emissionsFactor = OTHER_FOODS_EF;
         setFoodCategory(eatingOut);
      }
   }
   
   /**
   Returns the emissions factor for the Food object
   @return the food's emissions factor
   */
   public int getEmissionsFactor()
   {
      return emissionsFactor;
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
   Returns the carbon footprint for the Food object
   based on the food's category
   @return the food's carbon emission in lbs/year
   */
   public double getCarbonFootprint()
   {
      return ((getMonthlyBill() * getEmissionsFactor() * MONTHS_IN_YEAR) *  GRAMS_TO_POUNDS);
   }
   
   /**
	Returns a nicely formatted String composed of all of the 
   food object's details
	@return the details of a food
   */
   public String toString()
   {
      return ("\nThe food \"" + getFoodName() + "\" falls into the " + getFoodCategory() +
              " category and its carbon footprint is " + formatter.format(getCarbonFootprint()) +
              " lbs/year.");      
   }
   
   
}