import java.util.*;
import java.io.*;

/*
Extra Credit: (maybe)
-checking for typos in command inputs:
   -spaces or lackof in any input
   -semi colons or lackof colon
   -lack of quotation marks on string related input
   -incorrect input of commands
   -incorrect commands
   -incorrect input for confirmation of output overwrite
-checking for empty output files
-checking for empty input files
*/

public class GazillionSongs {
   public static void main(String[] args)  throws IOException {
   
   //file input---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
   System.out.println("Howdy, I'm the GazillionSongs program! \nI can sort and filter large databases of popular songs. \nJust give me a list to work with in the proper format!");
      Scanner kb = new Scanner(System.in);
      System.out.println("Please enter the name of your input file:");  //takes in user input file
      String inFile = kb.nextLine();
      System.out.println();
      
      File in = new File(inFile);
      if(!in.exists()){ //checks to see if input file exists
         System.out.println("Input file is missing. Terminating");
         return;
      }
      
      
      Scanner input = new Scanner(in);
      ArrayList<Song> songs = new ArrayList<Song>();
      
      while(input.hasNextLine()){  //creates Song object
         Song song = Song.parse(input.nextLine());
         songs.add(song);
      }
      if(songs.size() == 0){ //checks to see if input file is empty
         System.out.println("It looks like your input file was empty. \nGo enter a few songs and we'll try it again, ok?");
         return;
      }
      
      SongCollection Songs = new SongCollection(songs); //turns Song object into a SongCollection object
      
   //command input---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      
      Scanner cm = new Scanner(System.in);
      System.out.println("What do you want me to do with your list?");
      String command = cm.nextLine(); //takes in user command
      
      System.out.println();
      
      String[] temp = command.split(" -");  //splits input at every " -"
      ArrayList<String> delim = new ArrayList<String>();
      
      for(int i = 0; i < temp.length; i++){
         String[] temp2 = temp[i].split(":"); //splits input at every ":", resultitng in one element being the filter or sortBy, and the other being the parameter for the sort/filter
         if((temp2.length % 2 == 0) == false){
            System.out.println("Looks like you typed something in wrong...\nlets try again in the next run");
            return;
         }
         delim.add(temp2[0]);
         delim.add(temp2[1]);
      }
      if(delim.get(0).contains("-") == false){  //checks if multiple command inputs don't have "-" between the commands
         System.out.println("Looks like you typed something in wrong...\nlets try again in the next run");
         return;
      }
      String correction = delim.get(0).substring(1, delim.get(0).length()); //edits command input by getting rid of first "-" since the first input doesn't have a " "
      delim.set(0, correction);
   
      for(int z = 0; z < delim.size(); z += 2){  //checks for a command other than a filter or a sort
         if((delim.get(z).equals("rank") == false && delim.get(z).equals("year") == false && delim.get(z).equals("artist") == false && delim.get(z).equals("title") == false && delim.get(z).equals("sortBy") == false)){
            System.out.println("Looks like you entered something odd... \nWell this is awkward...\nI'm just gonna go now...bye...");
            return;
         }
      }   
      
      for(int u = 0; u < delim.size(); u++){  //checks for multiple of the same input, like "-rank:20 -rank:300", which results in the program running only "-rank:300"
         for(int k = 0; k < delim.size(); k += 2){
            for(int t = k + 2; t < delim.size(); t+= 2){ 
               if(delim.get(k).equals(delim.get(t))){  
                  delim.remove(k);
                  delim.remove(k);
               }
            }   
         }
      }
      
      for(int h = 0; h < delim.size(); h += 2){  //chooses whether to filter or to sort
         if(delim.get(h).contains("year")){
            Range range = Range.parse(delim.get(h + 1));
            Songs.filterYear(range);
         } 
         else if(delim.get(h).contains("rank")){
            Range range = Range.parse(delim.get(h + 1));
            Songs.filterRank(range);
         } 
         else if(delim.get(h).contains("title")){
            Songs.filterTitle(delim.get(h + 1));
         } 
         else if(delim.get(h).contains("artist")) {
            Songs.filterArtist(delim.get(h +1));
         } 
         else if(delim.get(h).contains("sortBy")){
            Sorting(delim.get(h + 1), Songs);
         }
         else { // invalid input
            System.out.println("Sorry, you put in an invalid input.\nLet's try this again in the next run.");
            return;
         }
      }
      
   //output file-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            
      System.out.println("Please enter the name of your output file:");
      String outFile = kb.nextLine();  //takes in output file name
      
      File out = new File(outFile);
      
      if(out.exists()){ //checks if output file already exists, and promps the user to confirm to overwrite it or not
         Scanner overwrite = new Scanner(System.in);
         System.out.println("\nOk, I see that your output file exists,\ndo you want me to overwrite it? \n YES     NO");
         String Overwrite = overwrite.nextLine();
         if(Overwrite.toLowerCase().equals("no")){
            System.out.println("Ok, terminating");
            return;
         } 
         else if(Overwrite.toLowerCase().equals("no") == false && Overwrite.toLowerCase().equals("yes") == false){ //checks for a confirmation other than "yes" or "no"
            System.out.println("You didn't enter a valid responce. Terminating");
            return;
         }
      }
      
      String line = " ";
      int count = 0;
      if(songs.size() == 0){ //checks to see if the output file length is zero, meaning that no songs met the user's command
         System.out.println("I could not find any songs with your specifications \nare you sure you typed in a valid parameter? \nI suggest you try again.");
         return;
      }
      
      PrintStream output = new PrintStream(out);
   
      while(count < songs.size()){ //outupts to output file
         line = songs.get(count).toString();
         output.println(line);
         count++;
      }
      System.out.println();
      System.out.println("Ok, your new output file has now been created!");
   }
   
   //---------------------------------------------------------------------------------------------------------------------------------------------------------------
   //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
   public static void Sorting(String s, SongCollection Songs){  //decides which sort to do
      if(s.contains("year")){
         Songs.sortYear();
      } 
      else if(s.contains("artist")){
         Songs.sortArtist();
      } 
      else if(s.contains("title")){
         Songs.sortTitle();
      } 
      else if(s.contains("rank")){
         Songs.sortRank();
      } 
      else {
         System.out.println("Sorry, you put in an invalid input. \nLet's try this again in the next run.");
         return;
      }
   }
}