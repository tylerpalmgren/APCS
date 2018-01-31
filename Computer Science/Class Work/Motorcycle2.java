class Motorcycle2 extends Vehicle {
   public Motorcycle2(boolean hasSidecar){
      super("Motorcycle", hasSidecar ? 2 : 1);
   }
   
   public void wheelie(){
      System.out.println(getType() + "WHEEEEEEELIE!!!!!");
   }
}