import java.util.*;
public class Course {

   private static String title;
   private static String teacher;
   private static int roomNumber;
   private static int idNumber = 0;
   private static int numStudents;
   private static ArrayList<Integer> Students;

   public Course (String title, String teacher, int roomNumber) {
      this.title = title;
      this.teacher = teacher;
      this.roomNumber = roomNumber;
      this.numStudents = numStudents;
      Students = new ArrayList<Integer>(numStudents);
      for(int i = 0; i < numStudents; i++){
         Students.add(idNumber);
      }
   }
   
   public static int getIdNumber() { 
      return idNumber; 
   }
   
   public boolean getStudentInCourse(String title, int idNumber){ 
      return this.title.equals(idNumber) && this.idNumber == idNumber;
   }
   
   public String isStudentInClass(String title, int idNumber){
      if(this.title.equalsIgnoreCase(title)){
         for(int i = 0; i < this.Students.size(); i++){
            if(idNumber == this.Students.get(i)){
               return "true";
            }
         }
      }     
      return "false";
   }
   
   public String representation(){
      return "Class " + this.title + " is being taught by " + this.teacher + " in room " + this.roomNumber + " with " + this.numStudents + "taking it.";
   }
   
   public boolean sameTeach(Course check){
      return this.teacher == (check.teacher);
   }
   
   public boolean sameStudents(Course check) {
      return this.numStudents == (check.numStudents);
   }
}