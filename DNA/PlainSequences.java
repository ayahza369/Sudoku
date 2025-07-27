//Ayah Zaheraldeen 
//CS143
//Implement class for manipulating DNA sequence in plain format

import java.util.*;
import java.io.*;

public class PlainSequences implements Sequences {
   private List<String> descriptions;//variable to store file names
   private List<String> sequences;//variable to store sequences
   
   public PlainSequences() {
      descriptions = new ArrayList<String>();//initialization of descriptions into an empty ArrayList of String objects
      sequences = new ArrayList<String>();//initialization of descriptions into an empty ArrayList of String objects
   }
   //Pre: none
   //Post: returns the descriptions variable
   public List<String> getDescriptions(){ 
      return this.descriptions;
   }
   //Pre: none
   //Post: returns the sequences variable
   public List<String> getSequences(){
      return this.sequences;
   }
   //Pre: filename must be valid and within the repository
   //Post: reads the sequences stored in the file, otherwise throws a FileNotFoundException
   public void readSequences(String fileName) throws FileNotFoundException{
      Scanner input = new Scanner(new File(fileName));//New Scanner object created using the file
      String sequence = "";
      while (input.hasNext()) { //while the file contains more characters
         sequence = sequence + input.nextLine();//characters are added to the sequence
         System.out.println(sequence);//sequence is printed
      }
      
      descriptions.add(fileName);//file name added to the descriptions ArrayList
      sequences.add(sequence);//sequence added to the sequences ArrayList
   }
   //Pre: none
   //Post: returns true if the sequence at the given index is valid (all letters), false otherwise
   public boolean isValidSequence(int index){
      String sequence = sequences.get(index); //fetches the sequence from the specified index
      for (int i = 0; i<sequence.length(); i++) {//iterates over characters of respective sequence
         if (!Character.isLetter(sequence.charAt(i))){//conditional checking the char at index i
            return false; //false is returned if it is not a letter
         }
      }
      return true; //true returned otherwise
   }
//Pre: none
//Post: returns the sequence formatted into basesPerGroup characters per group, with groupsPerLine number of groups before moving to the next line                  
public String formatInGroups(int index, int basesPerGroup, int groupsPerLine) {
    String sequence = sequences.get(index);//sequence fetched from respective index
    String result = "";
    int sequenceLength = sequence.length();//length of char in sequence
    int i = 0;

    int totalGroups = (int) Math.ceil((double) sequenceLength / basesPerGroup);//total groups required is calculated
    int totalLines = (int) Math.ceil((double) totalGroups / groupsPerLine);//total lines required is calculated

    int lineCount = 0;

    while (i < sequenceLength) {//while i is less than the length of char in sequence
        String line = "";//line is initialized
        int groupsAdded = 0;//groupsAdded is initialized
        lineCount++;
        //iterates over groupsPerLine and sequenceLength
        for (int g = 0; g < groupsPerLine && i < sequenceLength; g++) {
            String group = "";//group initialized
            //iterates over characters per group and the sequenceLength
            for (int b = 0; b < basesPerGroup && i < sequenceLength; b++) {
                group += sequence.charAt(i++);//adds the character to the group
            }
               
            if (!group.isEmpty()) {//if there is at least a character in the group
                if (groupsAdded > 0) {//if the groupsAdded are more than 1
                    line += " ";//add space to the line
                }
                line += group;//add the group to the line
                groupsAdded++;//number of groups added is increased
            }
        }

        result += line;//adding each line to the result after each iteration

       
            result += "\n";//new line character added
        
    }

    return result.replaceAll("\\s+$", "");//;ast line stripped from new line character and result is returned

}
}