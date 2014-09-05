package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

	
	 public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
	       
	        System.out.println("How many numbers do you want to enter?");
	        int num = input.nextInt();

	        int array[] = new int[num];

	        System.out.println("Enter the " + num + " numbers now with space between them.");

	        for (int i = 0 ; i < array.length; i++ ) {
	           array[i] = input.nextInt();
	        }

	        System.out.println("These are the numbers you have entered.");
	        printArray(array);
	        int pivot = array[array.length-1];
	        
		 System.out.println("Bigger element in the array  :"+pivot);
		 int sum = 0;
		 for ( int i = 0; i < array.length; i++) {
			    
			 System.out.println("the element "+array[i]+"    difference with pivot element : "+(pivot-array[i]));
			 sum = sum + (pivot-array[i]);
			
			 
			}
		 System.out.println( "Your output :  "+sum);
	 }
	 public static void printArray(int arr[]){
		  Arrays.sort(arr);
	        int n = arr.length;
	        for (int i = 0; i < n; i++) {
	            System.out.println(arr[i] + " ");
	        }
	    }
	
}
