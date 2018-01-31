import java.util.*;

public class ArrayListExploration {  //1

   public static void main(String[] args) {
   //  ArrayList myList = new ArrayList();  //2  Yes, it compiled
   
      ArrayList<String> myList = new ArrayList<String>(); //3  Yes, it compiled. It contains a String. I most 
                                                             //likely has a size of 0, since it's empty.
                                                             
      System.out.println(myList.size()); //4  it has a size of 0
      myList.add("hello"); //5
      
      System.out.println(myList.size()); //5  the size has gone up by 1, since we added a new String to it
      
      //myList.add(5); //6 it gives an error that states that there is "no suitable method found for add(int)"
                       //this is probably because we created myList as a String ArrayList, and not an Integer ArrayList
      myList.get(0); //7
      
      System.out.println(myList.get(0)); //7   1 didn't work, because arrays start with 0, not 1, even though the size
                                          //is 1. changing it to 0, and having it print that index works, and prints
                                          //out "hello" since that is in index 0.
          
      myList.add("goodbye"); //8
      System.out.println(myList.get(1)); //8  it prints out "goodbye" or course, assumming you use 1 as the second element, since 
                                            //it's in index 1. if you plugged in 2, the same thing that happened in #7 would happen again
                                            
     // myList.get(99); //9  it compiles, but when run produces an "IndexOutOfBoundsException: Index: 99, SizeL 2", showing that index 99 does not 
                         //exists
                         
      for(int x = 0; x < myList.size(); x++) { //10  you have to use myList.get(x) instead of myList[x] like you would for a normal array
         System.out.println(myList.get(x));
      }
      
      myList.set(0, "bye"); //11  the size stayed the same at 2, even though we added "hello" and "goodbye"
      System.out.println(myList.size());
      for(int x = 0; x < myList.size(); x++){ //it replaced the first element, "hello" with "bye", instead of  including it while keeping both 
         System.out.println(myList.get(x)); 
      }
      
      myList.add(1, "surprise");//12
      System.out.println(myList.size()); //the size changed to 3
      for(int x = 00; x < myList.size(); x++){//"surprise" was added into the 1st index, and was printed out second, because "bye" was still in the 0th index
         System.out.println(myList.get(x));
      }
      
   //   myList.add(99, "number13"); //13    it still throws the out of bounds exception, since there are 96 empty indexes between goodbye and the new string, throwing the program off
   
    //   myList.remove(0); //14  
   //       System.out.println(myList.size()); //it went down to 2, since we took one from the previous 3
   //       
   //       boolean check = myList.isEmpty();//15
   //       while (check == false) {
   //          myList.remove(0);
   //          check = myList.isEmpty();
   //       }
   //       System.out.println(myList.size()); // it dropped down to 0, since it's empty
   //       
   //       myList.clear();//16
   //       System.out.println(myList.size()); //it in fact cleared the array, leavign it empty with a size of 0
   //       
      //ArrayList<int> myNewList = new ArrayList<int>(); //17 it says it was an unexpected type, since we need to capitalize int, and write it out completely
      
      ArrayList<Integer> myNewList = new ArrayList<Integer>();//18 it compiles
      
      myNewList.add(1);//19
      myNewList.add(2);
      myNewList.add(3);
      System.out.println(myNewList.size()); // it says that the size is 3, which makes sense since there are only 3 ints added
      
      int x =5; //20
      myNewList.add(x); // it compiled, so i'm assumming it added x (5) to the end of the arraylist
      
      String n = myList.get(0);//21 
      System.out.println(n);// it printed out bye (if n = 0) or suprise (if n = 1)
      
      ArrayList<Double>ThirdList = new ArrayList<Double>();//22
      ArrayList<Character>FourthList = new ArrayList<Character>();
      
      //Problem #1
     // fill(arr);
      
      //Problem #2
      //ArrayListOfChars(charr);
   }
   
   //Problem #1
   public static ArrayList fill(int[] arr) {
      ArrayList<Integer>IntList = new ArrayList<Integer>();
      for(int x = 0; x < arr.length; x++){
         IntList.add(arr[x]);
      }
         return IntList;

   }
   
   //Problem #2
   public static String ArrayListOfChars(ArrayList<Character> charr) {
      String listString = "";
      for(int x = 0; x < charr.size(); x++) {
         listString += charr.get(x);
      }
      return listString;
   } 
}