public class HighSchoolStudent {
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