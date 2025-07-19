import java.io.*;

public class PlaySudoku {
   public static void main(String[] args)throws FileNotFoundException{
      
      SudokuBoard sudoku = new SudokuBoard("data1-1-1.sdk");
      System.out.println(sudoku);
   }
 }