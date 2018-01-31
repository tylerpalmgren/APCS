public class March18Problems{

   public int findHourseSpace(String name) { 
      for(int i = 0; i < spaces.length; i++){
         if (spaces [i] != null && spaces[i].getName().equals(name)){
            return i;
         }
      }
      return -1;
   }
   
   public void consolidate(){
      for(int i = 0; i < spaces.length; i++){ //first option
         if (spaces[i] == null){
            for(int j = i + 1; j < spaces.length; j++){
               if(spaces[j] != null){
                  spaces[i] = spaces[j];
                  spaces[j] = null;
                  break;
               }
            }
         }
      }
      for(int h = 0; h < spaces.length; h++){  //second option
         for(int i = 0; i < spaces.length -1; i++){
            if(spaces[i] == null){
               spaces[i] = spaces[i + 1];
               spaces[i + 1] = null;
            }
         }
      }
   } 
}