import java.util.*;

public class SongCollection{

   private ArrayList<Song> songs;

    //Create a SongCollection containing the songs in the given ArrayList
   public SongCollection(ArrayList<Song> songs){
      this.songs = songs;
   }
   
//-----------------------------------------------------------------------------------------------------------------------------------------------------------   
//Filtering--------------------------------------------------------------------------------------------------------------------------------------------------   

   //Remove all songs from this collection whose year does not match the given range
   
   public void filterYear(Range r){
      ArrayList<Song> temp = new ArrayList<Song>();
      for(int a = 0; a < songs.size(); a++){
         if(songs.get(a).getYear() >= r.getMin() && songs.get(a).getYear() <= r.getMax()){
            temp.add(songs.get(a));
         }
      }
      songs.clear();
      songs.addAll(temp);
   }
   
//--------------------------------------------------------------------------------------------------------------------------------------------------   
   
   //Remove all songs from this collection whose rank does not match the given range
   
   public void filterRank(Range r){
      ArrayList<Song> temp = new ArrayList<Song>();
      for(int a = 0; a < songs.size(); a++){
         if(songs.get(a).getRank() >= r.getMin() && songs.get(a).getRank() <= r.getMax()){
            temp.add(songs.get(a));
         }
      }
      songs.clear();
      songs.addAll(temp);
   }
   
//--------------------------------------------------------------------------------------------------------------------------------------------------   
   
   //Remove all songs from this collection whose artist does not contain the given string(case-insensitive)   
   public void filterArtist(String s){
      ArrayList<Song> temp = new ArrayList<Song>();
      if(s.contains("\"")){
         String newS = s.substring(1, s.length() -1);
         s = newS;
      } 
      else{
         System.out.println("Looks like you didn't type in quotes into your input. \nLets try again in the next run");
         System.exit(0);
      }
      for(int a = 0; a < songs.size(); a++){
         if(songs.get(a).getArtist().toLowerCase().contains(s.toLowerCase())){
            temp.add(songs.get(a));
         }
      }
      songs.clear();
      songs.addAll(temp);
   }
   
//--------------------------------------------------------------------------------------------------------------------------------------------------   

   //Remove all songs from this collecction whose title does not conatain the given string(case-insensitive)
   public void filterTitle(String s){
      ArrayList<Song> temp = new ArrayList<Song>();
      if(s.contains("\"")){
         String newS = s.substring(1, s.length() -1);
         s = newS;
      } 
      else{
         System.out.println("Looks like you didn't type in quotes into your input. \nLets try again in the next run");
         System.exit(0);
      }
      for(int a = 0; a < songs.size(); a++){
         if(songs.get(a).getTitle().toLowerCase().contains(s.toLowerCase())){
            temp.add(songs.get(a));
         }
      }
      songs.clear();
      songs.addAll(temp);
   }
//---------------------------------------------------------------------------------------------------------------------------------------------------------
//Sorting--------------------------------------------------------------------------------------------------------------------------------------------------   
                
   //Order the songs in this collection by year(ascending)
   public void sortYear(){
      splitYear(0, this.songs.size() - 1);
   }
   
   public void splitYear(int firstIndex, int lastIndex){
      if(firstIndex < lastIndex && (lastIndex - firstIndex) >= 1){
         int middle = (lastIndex + firstIndex) / 2;
         splitYear(firstIndex, middle);
         splitYear(middle + 1, lastIndex);
         
         mergeYear(firstIndex, middle, lastIndex);
      }
   }
   
   public void mergeYear(int firstIndex, int midIndex, int lastIndex){
      ArrayList<Song> mergedArray = new ArrayList<Song>();
      
      int leftIndex = firstIndex;
      int rightIndex = midIndex + 1;
      
      while(leftIndex <= midIndex && rightIndex <= lastIndex){
         if(songs.get(leftIndex).getYear() <= songs.get(rightIndex).getYear()){
            mergedArray.add(songs.get(leftIndex));     
            leftIndex++;
         } 
         else{
            mergedArray.add(songs.get(rightIndex));
            rightIndex++;
         }
      }
      
      while(leftIndex <= midIndex){
         mergedArray.add(songs.get(leftIndex));
         leftIndex++;
      }
      
      while(rightIndex <= lastIndex){
         mergedArray.add(songs.get(rightIndex));
         rightIndex++;
      }
      
      int i = 0; 
      int j = firstIndex;
      
      while(i < mergedArray.size()){
         songs.set(j, mergedArray.get(i++));
         j++;
      }
   }
    
//--------------------------------------------------------------------------------------------------------------------------------------------------   
   
   //Order the songs in this collecction by rank(ascending)
   public void sortRank(){
      splitRank(0, this.songs.size() - 1);
   }
   
   public void splitRank(int firstIndex, int lastIndex){
      if(firstIndex < lastIndex && (lastIndex - firstIndex) >= 1){
         int middle = (lastIndex + firstIndex) / 2;
         splitRank(firstIndex, middle);
         splitRank(middle + 1, lastIndex);
         
         mergeRank(firstIndex, middle, lastIndex);
      }
   }
   
   public void mergeRank(int firstIndex, int midIndex, int lastIndex){
      ArrayList<Song> mergedArray = new ArrayList<Song>();
      
      int leftIndex = firstIndex;
      int rightIndex = midIndex + 1;
      
      while(leftIndex <= midIndex && rightIndex <= lastIndex){
         if(songs.get(leftIndex).getRank() <= songs.get(rightIndex).getRank()){
            mergedArray.add(songs.get(leftIndex));     
            leftIndex++;
         } 
         else{
            mergedArray.add(songs.get(rightIndex));
            rightIndex++;
         }
      }
      
      while(leftIndex <= midIndex){
         mergedArray.add(songs.get(leftIndex));
         leftIndex++;
      }
      
      while(rightIndex <= lastIndex){
         mergedArray.add(songs.get(rightIndex));
         rightIndex++;
      }
      
      int i = 0; 
      int j = firstIndex;
      
      while(i < mergedArray.size()){
         songs.set(j, mergedArray.get(i++));
         j++;
      }
   }
   
//--------------------------------------------------------------------------------------------------------------------------------------------------   
   
   //Order the songs in this collection lexicographically by artist(ascending, case-insensitive)
   public void sortArtist(){
      splitArtist(0, this.songs.size() - 1);
   }
   
   public void splitArtist(int firstIndex, int lastIndex){
      if(firstIndex < lastIndex && (lastIndex - firstIndex) >= 1){
         int middle = (lastIndex + firstIndex) / 2;
         splitArtist(firstIndex, middle);
         splitArtist(middle + 1, lastIndex);
         
         mergeArtist(firstIndex, middle, lastIndex);
      }
   }
   
   public void mergeArtist(int firstIndex, int midIndex, int lastIndex){
      ArrayList<Song> mergedArray = new ArrayList<Song>();
      
      int leftIndex = firstIndex;
      int rightIndex = midIndex + 1;
      
      while(leftIndex <= midIndex && rightIndex <= lastIndex){
         if(songs.get(leftIndex).getArtist().compareTo(songs.get(rightIndex).getArtist()) < 0){
            mergedArray.add(songs.get(leftIndex));     
            leftIndex++;
         } 
         else{
            mergedArray.add(songs.get(rightIndex));
            rightIndex++;
         }
      }
      
      while(leftIndex <= midIndex){
         mergedArray.add(songs.get(leftIndex));
         leftIndex++;
      }
      
      while(rightIndex <= lastIndex){
         mergedArray.add(songs.get(rightIndex));
         rightIndex++;
      }
      
      int i = 0; 
      int j = firstIndex;
      
      while(i < mergedArray.size()){
         songs.set(j, mergedArray.get(i++));
         j++;
      }
   }
         
//--------------------------------------------------------------------------------------------------------------------------------------------------   
   
   //Order the songs in this collection lexicographically by title(ascending, case-insensitive)
   public void sortTitle(){
      splitTitle(0, this.songs.size() - 1);
   }
   
   public void splitTitle(int firstIndex, int lastIndex){
      if(firstIndex < lastIndex && (lastIndex - firstIndex) >= 1){
         int middle = (lastIndex + firstIndex) / 2;
         splitTitle(firstIndex, middle);
         splitTitle(middle + 1, lastIndex);
         
         mergeTitle(firstIndex, middle, lastIndex);
      }
   }
   
   public void mergeTitle(int firstIndex, int midIndex, int lastIndex){
      ArrayList<Song> mergedArray = new ArrayList<Song>();
      
      int leftIndex = firstIndex;
      int rightIndex = midIndex + 1;
      
      while(leftIndex <= midIndex && rightIndex <= lastIndex){
         if(songs.get(leftIndex).getTitle().compareTo(songs.get(rightIndex).getTitle()) < 0){
            mergedArray.add(songs.get(leftIndex));     
            leftIndex++;
         } 
         else{
            mergedArray.add(songs.get(rightIndex));
            rightIndex++;
         }
      }
      
      while(leftIndex <= midIndex){
         mergedArray.add(songs.get(leftIndex));
         leftIndex++;
      }
      
      while(rightIndex <= lastIndex){
         mergedArray.add(songs.get(rightIndex));
         rightIndex++;
      }
      
      int i = 0; 
      int j = firstIndex;
      
      while(i < mergedArray.size()){
         songs.set(j, mergedArray.get(i++));
         j++;
      }
   }
   
//----------------------------------------------------------------------------------------------------------------------------------------------------------   
//toString--------------------------------------------------------------------------------------------------------------------------------------------------

   //Return a string representation of their collection - the string representation of each Song, in the current order, separated by newlines
   public String toString(){
      String toString = "";
      for(int i = 0; i < songs.size(); i++){
         toString += songs.get(i) + "/n";
      }
      return toString;
   }
}