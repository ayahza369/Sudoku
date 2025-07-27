// Ayah Zaheraldeen
// CS 143
// HW #0: Setting up your Dev Environment

import java.util.*;

public class HW0_DevEnv {
   public static void main(String[] args){
      //Creates a new scanner object
      Scanner input = new Scanner(System.in);
      // Loop 5 times to print "Hello World!"
      for (int i = 0; i<5; i++){
         System.out.println("Hello World!"); //Print "Hello World!" to console
      }
      //Asks user whether they like to print the output again
      System.out.println("Would you like to see Hello again?");
      String response = input.nextLine();//Takes the input (response) from user (yes or no)
      //response must be "yes", case sensitive, for this block to execute
      while (response.equalsIgnoreCase("yes")){
         for (int i = 0; i<5; i++){//Loops 5 times to print "Hello World!"
         System.out.println("Hello World!");//Print "Hello World!" to console

         }
      //Printed statement asking user whether they like to continue seeing "Hello"
      System.out.println("Would you like to see Hello again?");
      response = input.nextLine(); //Takes the input (response) from user (yes or no)

      }
   input.close(); //Closes the scanner object

   }
}

// Hello World!
// Hello World!
// Hello World!
// Hello World!
// Hello World!
//Would you like to see Hello again?