/* Stephanie Liu
Make the below happen using only static functions and for loops.
         /**\
        //**\\
       ///**\\\
      ////**\\\\
     /////**\\\\\
    //////**\\\\\\
   ///////**\\\\\\\
  ////////**\\\\\\\\
 /////////**\\\\\\\\\
+=*=*=*=*=*=*=*=*=*=*+
|..../\......../\....|
|.../\/\....../\/\...|
|../\/\/\..../\/\/\..|
|./\/\/\/\../\/\/\/\.|
|/\/\/\/\/\/\/\/\/\/\|
|\/\/\/\/\/\/\/\/\/\/|
|.\/\/\/\/..\/\/\/\/.|
|..\/\/\/....\/\/\/..|
|...\/\/......\/\/...|
|....\/........\/....|
+=*=*=*=*=*=*=*=*=*=*+
|\/\/\/\/\/\/\/\/\/\/|
|.\/\/\/\/..\/\/\/\/.|
|..\/\/\/....\/\/\/..|
|...\/\/......\/\/...|
|....\/........\/....|
|..../\......../\....|
|.../\/\....../\/\...|
|../\/\/\..../\/\/\..|
|./\/\/\/\../\/\/\/\.|
|/\/\/\/\/\/\/\/\/\/\|
+=*=*=*=*=*=*=*=*=*=*+
          /**\
         //**\\
        ///**\\\
       ////**\\\\
      /////**\\\\\
     //////**\\\\\\
    ///////**\\\\\\\
   ////////**\\\\\\\\
  /////////**\\\\\\\\\
*/

class DrawRocket 
{
	//Half way point of the rocket (to the 2 stars) is 10 spaces.  It's the same as the height of different sections of the rocket (10).
	public static final int HALF_ROCKET_WIDTH = 10; 
  
	public static void main(String[] args)
	{
		rocketTopAndBottom();
		plusEquals();
		pyramid();
		invertedPyramid();
		plusEquals();
		invertedPyramid();
		pyramid();
		plusEquals();
		rocketTopAndBottom();
	}
	
	/* rocketTopAndBottom() Makes the triangular top and bottom portion of the rocket, which are the same
	 * Left side spaces from HALF_ROCKET_WIDTH * 2 down to none
	 * Left side slashes from 0 up to HALF_ROCKET_WIDTH * 2 - 1.
	 * 2 center stars **
	 * Right side slashes  0 up to HALF_ROCKET_WIDTH * 2 - 1.
	 * Starts a new line at the end of each iteration for each line of the rocket.
	 */
	public static void rocketTopAndBottom()
	{ 
  		for (int iter = 0; iter < HALF_ROCKET_WIDTH; iter++)
		{
			for (int spacesIter = 0; spacesIter < HALF_ROCKET_WIDTH - iter; spacesIter++)
			{
				System.out.print(" "); 
     			}
   			for (int forwardSlashesIter = 0; forwardSlashesIter < iter; forwardSlashesIter++)
			{
  			 	System.out.print("/"); 
   			} 
   			System.out.print("**"); 
   			for (int backSlashesIter = 0; backSlashesIter < iter; backSlashesIter++) 
			{
   	 			System.out.print("\\");
     			}
    			System.out.println();
		}
	}
  	/*
	 * plusEquals() provides the spacers between each large iterative segment of the rocket.  Prints a single line.
	 */
	public static void plusEquals() 
	{ 
 		System.out.println("+=*=*=*=*=*=*=*=*=*=*+");
	}
	
  	/* Makes the Upright Pyramid portion of the rocket with dots on the outside of HALF_ROCKET_WIDTH / 2 - iter (iter = line of pyramid),
    	 * and iter # of triangles.
	 * First prints outer wall of rocket.
	 * Repeats pattern twice due to repetition at midpoint.
	 * Iterates HALF_ROCKET_WIDTH due to repetition in pattern.
	 * Prints beginning dots, HALF_ROCKET_WIDTH / 2 - 1 to 0.
	 * Prints slashes, iter = row number, prints iter triangles per row.
	 * Prints ending dots, HALF_ROCKET_WIDTH / 2 - 1
	 * Ends the victory rocket at end of loop with |, then makes a new line for each iter.
	 */
   	public static void pyramid() 
	{ 
    		for (int iter = 0; iter < HALF_ROCKET_WIDTH / 2; iter++)
		{ 
        		System.out.print("|");
        		for(int halfRocketIter = 0; halfRocketIter < 2; halfRocketIter++) 
			{
                		for (int dotIter = 0; dotIter < HALF_ROCKET_WIDTH / 2 - iter - 1; dotIter++)
				{ 
              				System.out.print(".");
           			}
        			for (int slashIter = 0; slashIter <= iter; slashIter++)
				{
          				System.out.print("/\\");
            			}
          			for (int dotIter = 0; dotIter < HALF_ROCKET_WIDTH / 2 - iter - 1; dotIter++)
				{
              				System.out.print(".");
           	 		}
            		}
          		System.out.print("|"); 
			System.out.println();
        	}    	
  	}
  
	/* Makes the interted portion of the pyramid with HALF_ROCKET_WIDTH / 2 - iter (iter = line of inverted pyramid) # of triangles and n = dots.
    	 * Pattern repeats twice before ending.
	 * Iterate half of the width due to repeat in pattern
	 * Outer wall of the rocket prints first.
	 * Midway point of rocket is a repeat, so iterate through the rocket 2 times for each line.
	 * Print dots first, one per iter
	 * Prints inverted triangles for inverted pyramid, HALF_ROCKET_WIDTH / 2 - iter (decreases per row)
	 * Prints dots at the end of the pattern, one per iter
	 */
	
	public static void invertedPyramid() 
	{
    		for (int iter = 0; iter < HALF_ROCKET_WIDTH / 2; iter++) 
		{
        		System.out.print("|");
        		for(int halfRocketIter = 0; halfRocketIter < 2; halfRocketIter++) 
			{
            			for (int dotIter = 0; dotIter < iter; dotIter++)
				{
                			System.out.print(".");
                		}  
                		for (int slashIter = 0; slashIter < HALF_ROCKET_WIDTH / 2 - iter; slashIter++) 
				{
              				System.out.print("\\/");
           			}
          			for (int dotIter = 0; dotIter < iter; dotIter++) 
				{ 
              				System.out.print(".");
           	 		}
            		}
          		System.out.print("|");
			System.out.println();
        	}  		  
    	}
}
