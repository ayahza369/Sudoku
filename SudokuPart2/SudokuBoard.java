import java.util.*;
import java.io.*;

// Ayah Zaheraldeen
// CS 143
// Sudoku Board part 2
//
// This program will read a file containing the characters to go on a sudoku board, will generate a sudoku board and print it and will check the validity and whether it has been solved

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
//Helper Method for IsValid
  private char[][] miniSquare(int spot) {
      char[][] mini = new char[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            // whoa - wild! This took me a solid hour to figure out (at least)
            // This translates between the "spot" in the 9x9 Sudoku board
            // and a new mini square of 3x3
            mini[r][c] = contents[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }
   //Helper function for isValid
   //Pre: none
   //Post: returns true if all rows have non-duplicating numbers from 1-9
   private boolean checkRow(){
       for (int i=0;i<contents.length;i++){//iterates through the columns
              Map<Character,Integer> myMap = new HashMap<Character,Integer>();//a new map is created to store the characters and their frequency

         for (int j =0; j<contents[i].length;j++){//iterating through row contents
         
            char c = contents[i][j];//character c is obtained
           
            if (c!='.' &&  Character.isDigit(c)){//if it's not empty and is of digit form
               if (myMap.containsKey(contents[i][j])){//if the number in the j position of the row is in the map
                  
                  return false;//return false, there's a duplicate
            } else if (c!='.' && !Character.isDigit(c))  {//if it's not a digit and is not just an empty space
               return false;
            }else{
               myMap.put(contents[i][j],1);//if not existent yet, it's added to the map
            }
         }
           
         }
         
        }
        
        return true;//true returned once there are no duplicates
       
        
}
//Pre: none
//Post: returns true if all columns have non-duplicating numbers from 1-9

 private boolean checkColumn(){
     for (int i=0;i<contents.length;i++){//iterating through column contents

      Map<Character, Integer> myMap = new HashMap<>();//new map created
         for (int j =0; j<9;j++){//iterating through row contents
            if(contents[i][j]!='.' && !Character.isDigit(contents[i][j])){//if it's not a digit and is not just an empty space

               return false;//false returned
            }

            if (myMap.containsKey(contents[j][i])){//if the number in the j position of the column is in the map
               myMap.put(contents[j][i],myMap.get(contents[j][i])+1);//its frequency is increased by 1
            } else {
               myMap.put(contents[j][i],1);//if not existent yet, it's added to the map
            }
         }
      for(Character key : myMap.keySet()){//iterating through keys in the map
         if (!key.equals('.') && myMap.get(key)>1){//if it's not empty, and its frequency is more than 1
            
            return false;//false is returned
            
         }
      }
    
      }
      
      return true; //true returned, no duplicates found
        
}     //Helper Function to isValid
      //Pre: none
      //Post: returns true if the mini square is valid 
      private boolean checkMini(){
           
               for (int i = 1; i<=9; i++){//iterates through the different spots 
                  char[][] mini = miniSquare(i);//catches the square and stores it in a 2D Array 'mini'
                  Map<Character,Integer> myMap = new HashMap<Character,Integer>();//empty map created

               for (int k=0;k<mini.length;k++){//iterating through rows of mini
                  for (int j =0; j<mini[k].length;j++){//iterating through columns of mini
                     char c = mini[k][j];//each character stored in c 
                     if (c!='.' && !Character.isDigit(c)){//if it's not a digit and is not just an empty space
                        return false;//false returned
                     }
                     if (myMap.containsKey(mini[k][j]) && c!='.'){//if it's not an empty character and contains a duplicate                        
                        return false;//duplicate is found, false is returned
                  } else {
                     myMap.put(mini[k][j],1);//if not existent yet, it's added to the map
                  }
                  }
              }
           
          
       } 
       
       return true;//true returned if no duplicates found
       
    }        
    //Pre: none
    //Post: return true if the sudoku board is valid, false otherwise 
    public boolean isValid(){
      return checkColumn() && checkRow() && checkMini();//boolean zen-return the boolean value of a combined row, column, minisquare validity
    }
    //Pre: none
    //Post: returned true if the board is solved, false if otherwise 
    public boolean isSolved(){
      Map<Character,Integer> myMap = new HashMap<Character,Integer>();//new map created 
      for (int i =0; i<contents.length;i++){//iterates through rows of the board
         for(int j=0;j<contents[i].length;j++){//iterates through columns of the board
            if (myMap.containsKey(contents[i][j])){//if the number in the j position of the row is in the map
               myMap.put(contents[i][j],myMap.get(contents[i][j])+1);//its frequency is increased by 1
            } else {
               myMap.put(contents[i][j],1);//if not existent yet, it's added to the map
            }
         }
      }
      char[] myCharacters = {'1','2','3','4','5','6','7','8','9'};//generic array of valid characters
      for (char i:myCharacters){//for every character in 'myCharacters'
         if (myMap.containsKey(i)){// if the map contains the key from myCharacters
            if(myMap.get(i)!=9){//if the frequency is not 9
               
               return false;
            }
            else{
            ;//if not, nothing is done
            }
         }else{
            

            return false;//false is returned if the key is not found in the first place
         }
      
      
      
      }
      return isValid();//if all characters found, return the validity of the board
      }

            
}
//    Checking empty board...passed.
 // Checking incomplete, valid board...passed.
 // Checking complete, valid board...passed.
 // Checking dirty data board...passed.
 // Checking row violating board...passed.
 // Checking col violating board...passed.
 // Checking row&col violating board...passed.
 Checking mini-square violating board...passed.
 **** HORRAY: ALL TESTS PASSED ****