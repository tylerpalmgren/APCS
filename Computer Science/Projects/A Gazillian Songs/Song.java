public class Song {
   
   private int year;
   private int rank;
   private String artist;
   private String title;
   
   public Song (int year, int rank, String artist, String title){  //Year\tRank\tArtist\tTitle
      this.year = year;
      this.rank = rank;
      this.artist = artist;
      this.title = title;
   }

//Parse a string of the form “Year\tRank\tArtist\tTitle” and create a Song object with the given values
   public static Song parse(String s){
      String[] delim = s.split("\t");
      
      int year = Integer.parseInt(delim[0]);
      int rank = Integer.parseInt(delim[1]);
      String artist = delim[2];
      String title = delim[3];
      
      Song song = new Song(year, rank, artist, title);
      return song;
   }
    
   //Return the year of this song
   public int getYear(){
      return year;
   }
   
   //Return the rank of this song
   public int getRank(){
      return rank;
   }
   
   //Return the artist of this song
   public String getArtist(){
      return artist;
   }
   
   //Return the title of this song
   public String getTitle(){
      return title;
   } 
      
   //Return a string representation of this song
   public String toString(){
      return getYear() + "\t" + getRank() + "\t" + getArtist() + "\t" + getTitle();
   }
}