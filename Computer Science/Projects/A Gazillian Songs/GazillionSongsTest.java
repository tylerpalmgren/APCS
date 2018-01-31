import java.util.*;

public class GazillionSongsTest {
   public static void main(String[] args){
    
      ArrayList<Song> unsortedArray = new ArrayList<Song>();
         
      unsortedArray.add(new Song(2008, 50, "Ashley Tisdale", "He Said, She Said"));
      unsortedArray.add(new Song(2008, 351, "Flo Rida", "Low"));
      unsortedArray.add(new Song(2007, 311, "The-Dream", "Shawty Is A 10"));
      unsortedArray.add(new Song(2007, 308, "Kenny Chesney", "Don't Blink"));
      unsortedArray.add(new Song(1999, 282, "Randy Travis", "A Man Ain't Made Of Stone"));
      unsortedArray.add(new Song(1992, 302, "Lidell Townsell & M.T.F.", "Get With U"));
      unsortedArray.add(new Song(1960, 514, "Jack Scott", "Cool Water"));   
      SongCollection TestArray = new SongCollection(unsortedArray);
      Range yearRange = new Range(1998, 2007);
      Range range = new Range(1, 350);
      String name = "Jack Scott";
      String title = "Low";
         
      System.out.println("---------Initial Unsorted Array---------");
      for(int i = 0; i < unsortedArray.size(); i++){
         System.out.println(unsortedArray.get(i) + " ");
      }
   
      TestArray.sortYear();
      
         
      System.out.println("\n------------Sorted Array------------");
      for(int k = 0; k < unsortedArray.size(); k++){
         System.out.println(unsortedArray.get(k) + " ");
      }
   }
}