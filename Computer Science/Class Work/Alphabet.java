import java.util.*;

public class Alphabet {
   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);  
      String user = kb.nextLine();
      
      int length = user.length();
   
     // int[] arr = new int[26];
      
      int a = 0;
      int b = 0;
      int c = 0;
      int d = 0;
      int e = 0;
      int f = 0;
      int g = 0;
      int h = 0;
      int i = 0;
      int j = 0;
      int k = 0;
      int l = 0;
      int m = 0;
      int n = 0;    //yep
      int o = 0;
      int p = 0;
      int q = 0;
      int r = 0;
      int s = 0;
      int t = 0;
      int u = 0;
      int v = 0;
      int w = 0;
      int x = 0;
      int y = 0;
      int z = 0;
      int other = 0;
      
      for (i = 0; i < length; i++) {
      
         String [] strs = user.split("");
      
         String [i] = strs[i];
      
         if (String [i] == a) {
            a++; 
         } 
         else if (String [i] == b) {
            b++; 
         } 
         else if (String [i] == c) {
            c++; 
         } 
         else if (String [i] == d) {
            d++; 
         } 
         else if (String [i] == e) {
            e++; 
         } 
         else if (String [i] == f) {
            f++; 
         } 
         else if (String [i] == g) {
            g++; 
         } 
         else if (String [i] == h) {
            h++; 
         } 
         else if (String [i] == i) {
            i++; 
         } 
         else if (String [i] == j) {
            j++; 
         } 
         else if (String [i] == l) {
            l++; 
         } 
         else if (String [i] == m) {
            m++; 
         } 
         else if (String [i] == n) {
            n++; 
         } 
         else if (String [i] == o) {
            p++; 
         } 
         else if (String [i] == p) {
            p++; 
         } 
         else if (String [i] == q) {
            q++; 
         } 
         else if (String [i] == r) {
            r++; 
         } 
         else if (String [i] == s) {
            s++; 
         } 
         else if (String [i] == t) {
            t++; 
         } 
         else if (String [i] == u) {
            u++; 
         } 
         else if (String [i] == v) {
            v++; 
         } 
         else if (String [i] == w) {
            w++; 
         } 
         else if (String [i] == x) {
            x++; 
         } 
         else if (String [i] == y) {
            y++; 
         } 
         else if (String [i] == z) {
            z++; 
         } 
         else
            other++;
      }
         
   }
      
}
