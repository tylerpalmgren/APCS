import java.util.*;
import java.io.*;

public class FileIO{
   public static void main(String[] args) throws IOException {
      Scanner kb = new Scanner(System.in);
      System.out.println("Input file?");
      String inFile = kb.nextLine();
      
      System.out.println("Output file?");
      String outFile = kb.nextLine();
      
      File in = new File(inFile);
      if(!in.exists()){
         System.out.println("Input file missing. Terminating.");
         return;
      }
      
      Scanner input = new Scanner(in);
      File out = new File(outFile);
   
      PrintStream output = new PrintStream(out);
   
      if(out.exists()) {
         String line = " ";
      
         while(input.hasNextLine()){
            line = input.nextLine();
            output.println(line);
         }           
         System.out.println("Output file exists and has been overwritten");
      }
   }
}