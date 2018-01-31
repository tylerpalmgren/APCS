public class Exploration{
   public static void main(String[] args) { 
      Bird bird = new Bird(); // 1.Nothing
      Penguin penguin = new Penguin();
      penguin.layEgg();// 3. It doesn't compile because there is no ".layEgg();" in Penguin class
                       // 4. It means that a penguin is a bird, but a bird isn't every type of bird, so we need to use extends for our Penguin class
                       // 5. After adding the extends Bird, the two classes are linked, since Penguin has now inherited the bird characteristics
                       // 6. It now compiles, now that Penguin has the same traits as a bird now
                       // 7. It produces the output "The bird layed an egg."
                       // 8. It's getting the layEgg method from the Bird class, since penguin has inherited bird's traits
                       // 9. Yes, since Penguin has the traits of a Bird, like do stuff and fly
      penguin.fly();
      penguin.doStuff();
                       // 10. It compiles and runs, outputting egg, then fly, then do stuff, the fly and egg again, since the do stuff includes those two lines
                       // 11. It says the bird flies, which is not correct, since penguins do not fly
                       // 13. Since Penguin now has its own fly method, it uses that instead of bird's, resulting in it swimming instead of flying
      bird.fly();
                       // 14. The bird.fly() states that the bird is flying, and not swimming
      penguin.doStuff();
                       // 15. It ways the penuguin is swimming, not flying, because Penguin now has its own fly method, resulting in it swimming instead of flying when it's doing stuff
      bird.doStuff();
                       // 16. It uses the bird's version of fly, resulting in it flying, since it has its own fly method, so it doesn't have to use penguin's
                       // 17. If we call the swim method now in Penguin, it should just output "The penguin swam" since it has access to it, and doesn't use swim() from bird, beacuse that doesn't exist in bird
      penguin.swim();
                       // 18. It prints out "The penguin swam", so yes
      penguin.doStuff();
                       // 19. It now prints out that the penguin swam instead of flying, since it now has its own doStuff, and it doesn't need Bird anymore
      penguin.eats();
      bird.eats();                 
                       // 22. It prints out two lines of "The animal eats" now at the bottom
                       // 23. It now prints out whether the bird is happy or not when they do a certain action
                       // 24. Like the bird, it prints out whether the penguin is happy or not when it swims or tires to fly
                       // 25. this shows that protected allows a variable to only be seen and used by the package it was declared in, and can be seen by subclasses or nother package member
   }     
}