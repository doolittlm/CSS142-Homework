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

class DrawRocket {
	public static final int HALF_ROCKET_WIDTH = 10; //Half way point of the rocket (to the 2 stars) is 10 spaces.  It's the same as the height of different sections of the rocket (10).
  
	public static void main(String[] args) {
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
	
	public static void rocketTopAndBottom() { //Makes the triangular top and bottom portion of the rocket, which are the same
  		for (int iter = 0; iter < HALF_ROCKET_WIDTH; iter++) { //
			for (int spacesIter = 0; spacesIter < HALF_ROCKET_WIDTH - iter; spacesIter++) {
				System.out.print(" "); // Left side spaces from 10 down to none
     			}
   			for (int forwardSlashesIter = 0; forwardSlashesIter < iter; forwardSlashesIter++){
  			 	System.out.print("/"); // Left side slashes from 0 up to 9.
   			} 
   			System.out.print("**"); //Center stars.
   			for (int backSlashesIter = 0; backSlashesIter < iter; backSlashesIter++) {
   	 			System.out.print("\\"); //Right side slashes  0 up to 9.
     		}
    		System.out.println(); // Start a new line
		}
	}
  
	public static void plusEquals() { //Spacers between rocket portions.
 		System.out.println("+=*=*=*=*=*=*=*=*=*=*+");
	}
  
   	public static void pyramid() { 
   	//Makes the Upright Pyramid portion of the rocket with dots on the outside of HALF_ROCKET_WIDTH / 2 - iter (iter =line of pyramid),
    	//and iter # of triangles.
    		for (int iter = 0; iter < HALF_ROCKET_WIDTH/2; iter++) { //Iterate half the width due to repeat in pattern
        		System.out.print("|");	 //Outer wall of the rocket.
        		for(int halfRocketIter = 0; halfRocketIter < 2; halfRocketIter++) { //Iterates through one quarter of the rocket twice because it's samesies.
                		for (int dotIter = 0; dotIter < HALF_ROCKET_WIDTH/2 - iter - 1; dotIter++) { //Prints beginning dots, 4 to 0.
              				System.out.print(".");
           			}
        			for (int slashIter = 0; slashIter <= iter; slashIter++){ //Prints slashes, n = row number, prints n triangles per row.
          				System.out.print("/\\");
            			}
          			for (int dotIter = 0; dotIter < HALF_ROCKET_WIDTH/2 - iter - 1; dotIter++) { //Prints ending dots, 4 to 0.
              				System.out.print(".");
           	 		}
            		}
          		System.out.print("|"); //End the great victory rocket
			System.out.println(); //Start a new line
        	}    	
  	}
  
	public static void invertedPyramid() {
  	//Makes the interted portion of the pyramid with HALF_ROCKET_WIDTH / 2 - iter (iter = line of inverted pyramid) # of triangles and n = dots.
    	//Pattern repeats twice before ending.
    		for (int iter = 0; iter < HALF_ROCKET_WIDTH/2; iter++) { //Iterate half of the width due to repeat in pattern
        		System.out.print("|");	//Outer wall of the rocket.
        		for(int halfRocketIter = 0; halfRocketIter < 2; halfRocketIter++) { //Make both halfs of the rocket by repeating pattern
            			for (int dotIter = 0; dotIter < iter; dotIter++){ //Prints beginning dots, 1 per iter.
                			System.out.print(".");
                		}  
                		for (int slashIter = 0; slashIter < HALF_ROCKET_WIDTH/2 - iter; slashIter++) { //Prints inverted triangles for inverted pyramid.
              				System.out.print("\\/");
           			}
          			for (int dotIter = 0; dotIter < iter; dotIter++) { //Prints dots at the end of the pattern.
              				System.out.print(".");
           	 		}
            		}
          		System.out.print("|");
			System.out.println();
        	}  		  
    	}
}
