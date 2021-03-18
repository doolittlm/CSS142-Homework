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
	public static void rocketTopAndBottom() {
  		for (int i = 1; i <= 10; i++) {
			for (int j = 10; j > i; j--) {
				System.out.print(" "); // Left side spaces
     		}
    
   			for (int k = 1; k <= i; k++){
  			 	System.out.print("/"); // Left side repetition
   			 }
      
   			System.out.print("**"); //Center
      
   			for (int l = 1; l <= i; l++) {
   	 			System.out.print("\\"); //Right side repetition
     		}
    	
    		System.out.println(); // Start a new line
		}
	}
  
	public static void plusEquals() {
 		System.out.println("+=*=*=*=*=*=*=*=*=*=*+");
	}
  
   	public static void pyramid() {
    	  
    	for (int i = 1; i <= 5; i++) {
        	System.out.print("|");	
        	for(int j =1; j <= 2; j++) {
                for (int k = 5; k > i; k--) {
              		System.out.print(".");
           		}
        		for (int l =1; l <= i; l++){
          			System.out.print("/\\");
            	}
          		for (int m = 5; m > i; m--) {
              	System.out.print(".");
           	 	}
            }
          	System.out.print("|");
			System.out.println();
        }
      	
  	}
  
	public static void invertedPyramid() {
    	for (int i = 1; i <= 5; i++) {
        	System.out.print("|");	
        	for(int j = 1; j <= 2; j++) {
            	for (int l = 1; l < i; l++){
                  System.out.print(".");
                }  
                for (int k = 5; k >= i; k--) {
              		System.out.print("\\/");
           		}
          		for (int m = 1; m < i; m++) {
              		System.out.print(".");
           	 	}
            }
          	System.out.print("|");
			System.out.println();
        }
      		  
    }
  
}
