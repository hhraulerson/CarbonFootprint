/**
Program that creates a CarbonFootprint interface.

@author Hiram Raulerson
@version 1.0
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: November 11, 2015.
 
COP5007	Project #: 5
File Name: CarbonFootprint.java
*/

public interface CarbonFootprint
{
   /**
	Returns the carbon footprint of the calling object.  This
   method is required to be implemented in classes that 
   implement this interface.
   @return the carbon footprint of the calling object
   */
   public double getCarbonFootprint();
}