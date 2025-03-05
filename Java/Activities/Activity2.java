package activities;

import java.util.Arrays;

public class Activity2 {
	    public static void main(String[] args) {
	    	
	    	Activity2 actObj = new Activity2();
	        //Initialize the array
	        int[] inputArr = {10, 77, 10, 54, -11, 10};
	        System.out.println("Original Array: " + Arrays.toString(inputArr));
	        
	        //Set constants
	        int searchNum = 10;
	        int finalSum = 30;

	        //Print result
	        System.out.println("Does the sum euql to 30?: " + actObj.result(inputArr, searchNum, finalSum));
	    }

	    public static boolean result(int[] numbers, int searchNum, int fixedSum) {
	        int temp_sum = 0;
	        //Loop through array
	        for (int number : numbers) {
	            //If value is 10
	            if (number == searchNum) {
	                //Add them
	                temp_sum += searchNum;
	            }

	            //Sum should not be more than 30
	            if (temp_sum > fixedSum) {
	                break;
	            }
	        }

	        //Return true if condition satisfies
	        return temp_sum == fixedSum;
	    }
	}

