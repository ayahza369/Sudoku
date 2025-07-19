import java.util.*;
import java.io.*;


public class SudokuBoard{
   public char[][] contents = new char[9][9];   
   public SudokuBoard(String fileName)throws FileNotFoundException{
      Scanner console = new Scanner(new File(fileName));
      int counter = 0;
      while(console.hasNextLine()){
         
         String line = console.nextLine();
         for (int i = 0; i<line.length(); i++){
            contents[counter][i] = line.charAt(i);
         }
         counter+=1;
      }  
      
   }
   public String toString(){
      String board = "------------------\n";
      
      for (int i=0;i<contents.length;i++){
         board+="|";
         for (int j =0; j<contents[i].length;j++){
            board+=contents[i][j];
            board+=" ";
         }
         board+="|\n";
      }
      board+="------------------";
      return board;

}
}