import java.util.*;
import java.io.*;

// Ayah Zaheraldeen
// CS 143
// Sudoku Board part 1
//
// This program will read a file containing the characters to go on a sudoku board, will generate a sudoku board and print it

//Initializing the class

public class SudokuBoard{
   public char[][] contents = new char[9][9];//a 2D Array to store the characters   
   //Constructor 
   //Pre: file name must be valid, else a FileNotFound Exception is thrown
   public SudokuBoard(String fileName)throws FileNotFoundException{      
   Scanner console = new Scanner(new File(fileName));//scanner object created using the file
      int counter = 0;
      while(console.hasNextLine()){//while there is still a line to be read in the file
         
         String line = console.nextLine();//new line is read
         for (int i = 0; i<line.length(); i++){//iterating over the characters in the line
            contents[counter][i] = line.charAt(i);//adding the character to a correct position in the 2D array
         }
         counter+=1;//counter increased by 1
      }  
      
   }
   //Pre: none
   //Post: prints out the board on the screen
   public String toString(){
      String board = "------------------\n";//top line encompassing the board
      
      for (int i=0;i<contents.length;i++){//iterates over 2D array's rows
         board+="|";//adds a formatting style before each first character of the line
         for (int j =0; j<contents[i].length;j++){//iterates over the contents of each row (columns) 
            board+=contents[i][j];//board is constructed by adding the elements
            board+=" ";//space after each character added 
         }
         board+="|\n";//after last element, adds a formatting style and new line
      }
      board+="------------------";//formatting line added
      return board;//board returned 

}
}