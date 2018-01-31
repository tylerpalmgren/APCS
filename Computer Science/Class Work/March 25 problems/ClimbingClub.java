import java.util.*;

public class ClimbingClub
{
   /** The list of climbs completed by members of the club.
   * Guaranteed not to be null. Contains only non-null references.
   */
   private ArrayList<ClimbInfo> climbList;
   private String Name;
   private int climbs;
   
   /** Creates a new ClimbingClub object. */
   public ClimbingClub(){ 
      climbList = new ArrayList<ClimbInfo>(); 
      this.Name = Name;
      this.climbs = climbs;
   }
   
   /** Adds a new climb with name peakName and time climbTime to the list of climbs.
   * @param peakName the name of the mountain peak climbed
   * @param climbTime the number of minutes taken to complete the climb
   */
   public void addClimb(String peakName, int climbTime){
    /* to be implemented in part (a) with ClimbInfo objects in the order they were added */
      ClimbingClub hikerClub = new ClimbingClub();
      hikerClub.addClimb("Monadnock", 274);
      hikerClub.addClimb("Whiteface", 301);
      hikerClub.addClimb("Algonquin", 225);
      hikerClub.addClimb("Monadnock", 344);
       
     /* to be implemented in part (b) with ClimbInfo objects in alphabetical order by name */
      for(int i = 0; i < hikerClub.size(); i++){
         int value =  ((hikerClub.get(i)).getName()).compareTo((hikerClub.get(i + 1)).getName());
         for(int j = i + 1; j < hikerClub.size(); j++){
            if(value > 0){
               ClimbingClub temp = hikerClub.get(i);
               hikerClub.set(i) = hikerClub.get(i + 1);
               hikerClub.set(i + 1) = temp;
            }
         }
      }
   }
   /** @return the number of distinct names in the list of climbs */
   public int distinctPeakNames(){ 
   /* implementation shown in part (c) */ 
      if (climbList.size() == 0)
      {
         return 0;
      }
      ClimbInfo currInfo = climbList.get(0);
      String prevName = currInfo.getName();
      String currName = null;
      int numNames = 1;
      for (int k = 1; k < climbList.size(); k++)
      {
         currInfo = climbList.get(k);
         currName = currInfo.getName();
         if (prevName.compareTo(currName) != 0)     // i 
                                                      //NO it will not since the ArrayList isn't sorted, because it wouldn't be ompensating for duplicates that aren't next to each other
         {
            numNames++;
            prevName = currName;                    //ii
         }                                               //YES, since the arrayList is sorted by name, so any duplicates will be next to each other, and won't be counted twice
      }
      return numNames; 
   }
}