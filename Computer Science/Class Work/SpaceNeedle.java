public class SpaceNeedle {

   public static final String Colon = ":";
   public static final String Vertical = "|";
   public static final String Bslash = "\\";
   public static final String Fslash = "/";
   public static final String Percent = "%";
   public static final String Space = "__";
   public static final String Quotes = "\"";
   public static final String Empty = " ";
   public static final String Pole = Vertical + Vertical;
   public static final int SIZE = 4;  //Change this variable to 2 and 10 for different scaling 
   public static void main(String[] args) {
 
     
   //Pole
   for(int i = 0; i < SIZE; i++){
		for(int y = 0; y < 3 * SIZE; y++) {
      System.out.print(Empty);
      }
       System.out.println(Pole);
		 }
   
   //Cap
     for (double c = 1; c <= SIZE ; c++){
       for (double x = 3 * (SIZE + 1 - c) - 3; x >= 1; x--){
         System.out.print(Empty);
         }
        System.out.print(Space + Fslash);
         for (int h = 0; h < c -1; h++){
         System.out.print(Colon);
			System.out.print(Colon);
			System.out.print(Colon);
         }
         System.out.print(Pole);

         for (int p = 0 ; p < c - 1; p++){
         System.out.print(Colon);
			System.out.print(Colon);
			System.out.print(Colon);
         }
         System.out.println(Bslash + Space);     
   }
   
   //Observation Deck
   
      for(int z = 0; z < 1; z++){
		System.out.print(Vertical);
		for(int ad = 0; ad < 6 * SIZE; ad++) {
      System.out.print(Quotes); 
      }
      System.out.println(Vertical);
		}
      
   //Bottom
      for(int k = 0; k < SIZE; k++) {
        for (int u = SIZE * 3; u > (SIZE * 3) - (2 * k); u--) {
         System.out.print(" ");  
        }
        
      System.out.print(Bslash + "_");
         for(int l = 0; l < (3 * SIZE  - 1) - (2 * k); l++) {
           System.out.print(Fslash + Bslash);
     
         }
         System.out.println("_" + Fslash);
       }
     
     //pole 2 
         for(int i = 0; i < SIZE; i++){
		for(int y = 0; y < 3 * SIZE; y++) {
      System.out.print(Empty);
      }
       System.out.println(Pole);
		 }
      
      //Body
      for(int q = 1; q <= (SIZE * SIZE); q++){
         for (int i = 1; i <= 2 * SIZE + 1; i++) {
         System.out.print(" ");
         }
         for (int h = 0; h < 2; h++) {
         System.out.print(Vertical);
         for(int p = 0; p < SIZE - 2; p++) {
            System.out.print(Percent);
      }
      System.out.print(Vertical);
      }
      System.out.println();
      }
         
      //Base
     for (double c = 1; c <= SIZE ; c++){
       for (double x = 3 * (SIZE + 1 - c) - 3; x >= 1; x--){
         System.out.print(Empty);
         }
        System.out.print(Space + Fslash);
         for (int h = 0; h < c - 1; h++){
         System.out.print(Colon);
			System.out.print(Colon);
			System.out.print(Colon);
         }
         System.out.print(Pole);

         for (int p = 0 ; p < c - 1; p++){
         System.out.print(Colon);
			System.out.print(Colon);
			System.out.print(Colon);
         }
         System.out.println(Bslash + Space);     
   }
    for(int z = 0; z < 1; z++){
		System.out.print(Vertical);
		for(int ad = 0; ad < 6 * SIZE; ad++) {
      System.out.print(Quotes); 
      }
      System.out.println(Vertical);
		}
}
}


/*
             
             ||
             ||
             ||
             ||
          __/||\__
       __/:::||:::\__
    __/::::::||::::::\__
 __/:::::::::||:::::::::\__
 |""""""""""""""""""""""""|
 \_/\/\/\/\/\/\/\/\/\/\/\_/
   \_/\/\/\/\/\/\/\/\/\_/
     \_/\/\/\/\/\/\/\_/
       \_/\/\/\/\/\_/
             ||
             ||
             ||
             ||
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          |%%||%%|
          __/||\__
       __/:::||:::\__
    __/::::::||::::::\__
 __/:::::::::||:::::::::\__
 |""""""""""""""""""""""""|  */