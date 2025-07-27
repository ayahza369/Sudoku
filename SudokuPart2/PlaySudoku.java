import java.io.*;
// Ayah Zaheraldeen
// CS 143
// PlaySudoku part 1
//
// This program will allow users to play the sudoku game
// pre: and post: comments before each method in your class
//Main class to play the sudoku game
public class PlaySudoku {
   public static void main(String[] args)throws FileNotFoundException{
      
      SudokuBoard sudoku = new SudokuBoard("data.sdk");//creating a new object of the board using data from data.sdk
      System.out.println(sudoku);//printing the board
   }
 }
 //Output
 //------------------
//|2 . . 1 . 5 . . 3 |
//|. 5 4 . . . 7 1 . |
//|. 1 . 2 . 3 . 8 . |
//|6 . 2 8 . 7 3 . 4 |
//|. . . . . . . . . |
//|1 . 5 3 . 9 8 . 6 |
//|. 2 . 7 . 1 . 6 . |
//|. 8 1 . . . 2 4 . |
//|7 . . 4 . 2 . . 1 |
//------------------