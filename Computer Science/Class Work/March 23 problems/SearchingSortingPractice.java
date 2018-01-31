import java.util.*;

public class SearchingSortingPractice {
   ArrayList<HighSchoolStudent> Students = new ArrayList<HighSchoolStudent>();
   

   public class HighSchoolStudent {   //Exercise 1
      private String lastName;
      private String firstName;
      private double GPA;
   
      public HighSchoolStudent(String lastName, String firstName, double GPA){
         this.lastName = lastName;
         this.firstName = firstName;
         this.GPA = GPA;
      }
   
      public double getGPA(){
         return GPA;
      }
   
      public String getFirstName(){
         return firstName;
      }
   
      public String getLastName(){
         return lastName;
      }
   }


   public static String FindSmartKid(ArrayList<HighSchoolStudent> Students){  //Exercise 2
      double highest = (Students.get(0)).getGPA();
      int student = 0;
         
      for(int i = 1; i < Students.size(); i++){
         if(((Students.get(i)).getGPA()) > highest){
            highest = ((Students.get(i)).getGPA());
            student = i;
         }
      }
      return ((Students.get(student)).getLastName()) + ", " + ((Students.get(student)).getFirstName()) + " has the highest GPA at " + highest;
   }
   
   
   public static void LastNameSort(ArrayList<HighSchoolStudent> Students){  //Exercise 3  Bubble sort
      for(int i = 0; i < Students.size(); i++) {
         int value = ((Students.get(i)).getLastName()).compareTo((Students.get(i + 1)).getLastName());
         for(int j = i + 1; j < Students.size(); j++){
            if(value > 0){   // a,b: <0     // b,a: >0
               HighSchoolStudent temp = Students.get(i);
               Students.set(i, Students.get(i + 1));
               Students.set(i + 1, temp);
            }
         }
      }
   }
   
   
   public static HighSchoolStudent grabStudent(ArrayList<HighSchoolStudent> Students, String Name){  //Exercise 4 as a binary search
      int low = 0;
      int high = Students.size() - 1;
      while(low <= high){
         int mid = (high - low) / 2;
         int value = ((Students.get(mid)).getLastName()).compareTo(Name);
         if(value == 0){
            return Students.get(mid);
         }
         else if(value < 0){
            low = mid + 1;
         } 
         else {
            high = mid - 1;
         }
      }
      return null;
   }
}