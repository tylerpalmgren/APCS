import java.awt.*;

public class PicEdit {

   public static Picture grayscale(Picture p) {
      Color[][] pixels = p.getPixels();
      Color[][] pixels2 = new Color[pixels.length][pixels[0].length];
      for(int x = 0; x < pixels.length; x++) {
         for(int i = 0; i < pixels[0].length; i++){
            
            int red = pixels[x][i].getRed();
            int green = pixels[x][i].getGreen();
            int blue = pixels[x][i].getBlue();
            
            int grey = (red + green + blue) / 3;
            
            red = grey;
            green = grey;
            blue = grey;
            
            Color newColor = new Color (red, green, blue);
            
            pixels2[x][i] = newColor;
         }
      }
      Picture Greyscale = new Picture(pixels2);
      return Greyscale;
   }

   public static Picture invertColors(Picture p) {
      Color[][] pixels = p.getPixels();
      Color[][] pixels2 = new Color[pixels.length][pixels[0].length];
      for(int x = 0; x < pixels.length; x++) {
         for(int i = 0; i < pixels[0].length; i++) {    
               
            int red = pixels[x][i].getRed();
            int green = pixels[x][i].getGreen();
            int blue = pixels[x][i].getBlue();
               
            red = 255 - red;
            green = 255 - green;
            blue = 255 - blue;
               
            Color newColor = new Color (red, green, blue);
               
            pixels2[x][i] = newColor;
         }
      }
      Picture invert = new Picture(pixels2);
      return invert;
   }
      
   public static Picture changeContrastAndBrightness(Picture p, double contrAmt, double brightAmt) {
      int MaxColor = 255;
      int MinColor = 0;
      Color[][] pixels = p.getPixels();
      Color[][] pixels2 = new Color[pixels.length][pixels[0].length];
      for(int k = 0; k < pixels.length; k++) {
         for(int i = 0; i < pixels[0].length; i++) {
         
            double red = pixels[k][i].getRed();
            double green = pixels[k][i].getGreen();
            double blue = pixels[k][i].getBlue();
            
            red = contrAmt * (red - 128) + 128 + brightAmt;
            green = contrAmt * (green - 128) + 128 + brightAmt;
            blue = contrAmt * (blue - 128) + 128 + brightAmt;
            
            int red2 = (int)(red);
            int green2 = (int)(green);
            int blue2 = (int)(blue);
            
            //red
            if(red2 > MaxColor) {
               red2 = MaxColor; 
            } 
            if(red2 < MinColor) {
               red2 = MinColor;
            }
            //green   
            if (green2 > MaxColor) {
               green2 = MaxColor;
            } 
            if(green2 < MinColor) {
               green2 = MinColor;
            }
            //blue
            if (blue2 > MaxColor) {
               blue2 = MaxColor;
            } 
            if (blue2 < MinColor) {
               blue2 = MinColor;
            }
            Color newColor = new Color (red2, green2, blue2);
            pixels2[k][i] = newColor;
         }
      }
      Picture ContrastAndBrightness = new Picture(pixels2);
      return ContrastAndBrightness;
   }

   // returns a new Picture that results from running edge detection on p
   //
   // in the new image, pixels will all be either black or white
   // pixels on an "edge" (where the "color distance" is greater than
   //   threshold) will be black; all other pixels will be white
   // the "color distance" between two colors c1 and c2 is defined as the
   //   square root of:
   //     (c1.red - c2.red)^2 + (c1.green - c2.green)^2 + (c1.blue - c2.blue)^2
   public static Picture outline(Picture p, double threshold) {
      Color[][] pixels = p.getPixels();
      Color[][] pixels2 = new Color[pixels.length][pixels[0].length];
      Color black = new Color(0, 0, 0);
      Color white = new Color(255, 255, 255);
      for(int y = 0; y < pixels[0].length; y++) {
         for(int x = 0; x < pixels.length; x++) {   
            int check = 0;      
            int c1red = pixels[x][y].getRed();
            int c1green = pixels[x][y].getGreen();
            int c1blue = pixels[x][y].getBlue();
            
            //top left corner
            if (x == 0 && y == 0){
               for(int h = 0; h <= 1; h++) { //x
                  for(int t = 0; t <= 1; t++) {  //y
                     if ((h != 0 || t != 0 ) && (h != 1 || t != 1) ){
                        int c2red = pixels[x + h][y + t].getRed();
                        int c2green = pixels[x + h][y + t].getGreen();
                        int c2blue = pixels[x + h][y + t].getBlue();
                        double colorDistance = Math.sqrt(Math.pow((c1red - c2red), 2) + Math.pow((c1green - c2green), 2) + Math.pow((c1blue - c2blue), 2));
                        if (colorDistance > threshold){
                           check++;
                        }
                     }
                  }
               }
               if (check >= 1) {
                  pixels2[x][y] = black;
               } 
               else {
                  pixels2[x][y] = white;
               }
            }
            //top right corner
            else if (x == pixels.length -1 && y == 0){
               for(int h = -1; h <= 0; h++){
                  for(int t = 0; t <= 1; t++){
                     if ((h != 0 || t != 0) && (h != -1 || t != 1)){
                        int c2red = pixels[x + h][y + t].getRed();
                        int c2green = pixels[x + h][y + t].getGreen();
                        int c2blue = pixels[x + h][y + t].getBlue();
                        double colorDistance = Math.sqrt(Math.pow((c1red - c2red), 2) + Math.pow((c1green - c2green), 2) + Math.pow((c1blue - c2blue), 2));
                        if (colorDistance >  threshold){
                           check++;
                        }
                     }
                  }
               }
               if (check >= 1) {
                  pixels2[x][y] = black;
               } 
               else {
                  pixels2[x][y] = white;
               }
            } 
            //bottom left corner
            else if(x == 0 && y == pixels[0].length - 1){
               for(int h = 0; h <= 1; h++){
                  for(int t = -1; t <= 0; t++){
                     if ((h != 0 || t != 0) && (h != 1 || t != -1)){
                        int c2red = pixels[x + h][y + t].getRed();
                        int c2green = pixels[x + h][y + t].getGreen();
                        int c2blue = pixels[x + h][y + t].getBlue();
                        double colorDistance = Math.sqrt(Math.pow((c1red - c2red), 2) + Math.pow((c1green - c2green), 2) + Math.pow((c1blue - c2blue), 2));
                        if (colorDistance > threshold){
                           check++;
                        }
                     }
                  }
               }
               if (check >= 1) {
                  pixels2[x][y] = black;
               } 
               else {
                  pixels2[x][y] = white;
               }
            } 
            //bottom right corner
            else if (x == pixels.length - 1 && y == pixels[0].length - 1){
               for(int h = -1; h <= 0; h++){
                  for(int t = -1; t <= 0; t++){
                     if ((h != 0 || t != 0) && (h != -1 || t != -1)){
                        int c2red = pixels[x + h][y + t].getRed();
                        int c2green = pixels[x + h][y + t].getGreen();
                        int c2blue = pixels[x + h][y + t].getBlue();
                        double colorDistance = Math.sqrt(Math.pow((c1red - c2red), 2) + Math.pow((c1green - c2green), 2) + Math.pow((c1blue - c2blue), 2));
                        if (colorDistance > threshold){
                           check++;
                        }
                     }
                  }
               }
               if (check >= 1) {
                  pixels2[x][y] = black;
               } 
               else {
                  pixels2[x][y] = white;
               }
            } 
            //top row
            else if (y == 0) {
               for(int h = -1; h <= 1; h++){
                  for(int t = 0; t <= 1; t++){
                     if ((h != 0 || t != 0) && (h != -1 || t != 1) && (h != 1 || t != 1)){
                        int c2red = pixels[x + h][y + t].getRed();
                        int c2green = pixels[x + h][y + t].getGreen();
                        int c2blue = pixels[x + h][y + t].getBlue();
                        double colorDistance = Math.sqrt(Math.pow((c1red - c2red), 2) + Math.pow((c1green - c2green), 2) + Math.pow((c1blue - c2blue), 2));
                        if (colorDistance > threshold){
                           check++;
                        }
                     }
                  }
               }
               if (check >= 1) {
                  pixels2[x][y] = black;
               } 
               else {
                  pixels2[x][y] = white;
               }
            }
            //bottom row
            else if (y == pixels.length - 1) {
               for(int h = -1; h <= 1; h++){
                  for(int t = -1; t <= 0; t++){
                     if ((h != 0 || t != 0) && (h != -1 || t != -1) && (h != 1 || t != -1)){
                        int c2red = pixels[x + h][y + t].getRed();
                        int c2green = pixels[x + h][y + t].getGreen();
                        int c2blue = pixels[x + h][y + t].getBlue();
                        double colorDistance = Math.sqrt(Math.pow((c1red - c2red), 2) + Math.pow((c1green - c2green), 2) + Math.pow((c1blue - c2blue), 2));
                        if (colorDistance > threshold){
                           check++;
                        }
                     }
                  }
               }
               if (check >= 1) {
                  pixels2[x][y] = black;
               } 
               else {
                  pixels2[x][y] = white;
               }
            }
            // left side
            else if(x == 0){
               for(int h = 0; h <= 1; h++){
                  for(int t = -1; t <= 1; t++){
                     if ((h != 0 || t != 0) && (h != 1 || t != -1) && (h != 1 || t != 1)){
                        int c2red = pixels[x + h][y + t].getRed();
                        int c2green = pixels[x + h][y + t].getGreen();
                        int c2blue = pixels[x + h][y + t].getBlue();
                        double colorDistance = Math.sqrt(Math.pow((c1red - c2red), 2) + Math.pow((c1green - c2green), 2) + Math.pow((c1blue - c2blue), 2));
                        if (colorDistance > threshold){
                           check++;
                        }
                     }
                  }
               }
               if (check >= 1) {
                  pixels2[x][y] = black;
               } 
               else {
                  pixels2[x][y] = white;
               }
            }
            //right side
            else if (x == pixels.length - 1){
               for(int h = -1; h <= 0; h++){
                  for(int t = -1; t <= 0; t++){
                     if ((h != 0 && t != 0) && (h != -1 || t != -1) && (h != -1 || t != 1)){
                        int c2red = pixels[x + h][y + t].getRed();
                        int c2green = pixels[x + h][y + t].getGreen();
                        int c2blue = pixels[x + h][y + t].getBlue();
                        double colorDistance = Math.sqrt(Math.pow((c1red - c2red), 2) + Math.pow((c1green - c2green), 2) + Math.pow((c1blue - c2blue), 2));
                        if (colorDistance > threshold){
                           check++;
                        }
                     }
                  }
               }
               if (check >= 1) {
                  pixels2[x][y] = black;
               } 
               else {
                  pixels2[x][y] = white;
               }
            }
            //main picture
            else {
               for(int h = -1; h <= 1; h++){
                  for(int t = -1; t <= 1; t++){
                     if ((h != 0 || t != 0) && (h != -1 || t != -1) && (h != 1 || t != -1) && (h != -1 || t != 1) && (h != 1 && t != 1)){
                        int c2red = pixels[x + h][y + t].getRed();
                        int c2green = pixels[x + h][y + t].getGreen();
                        int c2blue = pixels[x + h][y + t].getBlue();
                        double colorDistance = Math.sqrt(Math.pow((c1red - c2red), 2) + Math.pow((c1green - c2green), 2) + Math.pow((c1blue - c2blue), 2));
                        if (colorDistance > threshold){
                           check++;
                        }
                     }
                  }
               }
               if (check >= 1) {
                  pixels2[x][y] = black;
               } 
               else {
                  pixels2[x][y] = white;
               }
            }
         }
      }
      Picture Outline = new Picture(pixels2);
      return Outline;
   } 
   
   public static Picture mirror(Picture p, char dir) {
   //       Color[][] pixels = p.getPixels();
   //       Color[][] pixels2 = new Color[pixels.length][pixels[0].length];
   //       for(int x = 0; x < pixels.length; x++){
   //          for(int y = 0; y < pixels[0].length; y++){
   //             if (dir == 'v') { 
   //                pixels2[x][y] = pixels[pixels.length - 1 - x][y];
   //             } 
   //             else {
   //                pixels2[x][y] = pixels[x][pixels[0].length - 1 - y];
   //             }   
   //          } 
   //       }
   //       Picture mirror = new Picture(pixels2);
   //       return mirror;
   //       
      Color[][] pixels = p.getPixels();
      Color[][] pixels2 = new Color[pixels.length][pixels[0].length];
      if(dir == 'v'){
         if (pixels.length % 2 == 0){
            for(int y = 0; y < pixels[0].length; y++){
               for(int x = 0; x < pixels.length / 2; x++){
                  pixels2[x][y] = pixels[x][y];
               }
            }
            for(int g = 0; g < pixels[0].length; g++){ //y
               for(int q = pixels.length / 2; q < pixels.length; q++){
                  pixels2[q][g] = pixels[pixels.length - q][g];
               }
            }
         }
         else {
            for(int y = 0; y < pixels[0].length; y++){
               for(int x = 0; x < pixels.length / 2; x++){
                  pixels2[x][y] = pixels[x][y];
                  pixels2[(pixels.length - 1) / 2][y] = pixels[(pixels.length  - 1) / 2][y];
               }
            }
            for(int q = 0; q < pixels[0].length; q++){
               for(int g = pixels.length / 2 + 1; g < pixels.length; g++){
                  pixels2[g][q] = pixels[(pixels.length - 1) - g][q];
               }
            }
         }
      }
      else { //dir == 'h'
         if(pixels[0].length % 2 == 0){
            for(int x = 0; x < pixels.length; x++){
               for(int y = 0; y < pixels[0].length / 2; y++){
                  pixels2[x][y] = pixels[x][y];
               }
            }
            for(int q = pixels[0].length / 2; q< pixels[0].length; q++){ //y
               for(int g = 0; g < pixels.length; g++){ //x
                  pixels2[g][q] = pixels[g][pixels[0].length - q];
               }
            }
         } 
         else { //pixels[0] % 2 != 0
            for(int y = 0; y < pixels[0].length / 2; y++){
               for(int x = 0; x < pixels.length; x++){
                  pixels2[x][y] = pixels[x][y];
                  pixels2[x][(pixels[0].length - 1) / 2] = pixels[x][(pixels[0].length - 1)/ 2];
               }
            }
            for(int q = pixels[0].length / 2; q < pixels[0].length; q++){ //y
               for(int g = 0; g < pixels.length; g++){  //x
                  pixels2[g][q] = pixels[g][q];
               }
            }
         }
      }
      Picture mirror = new Picture(pixels2);
      return mirror;
   }   
  
   // returns a new Picture that is a pixelated version of p
   //
   // to pixelate an image, each group of pixels up to radius away
   //   from a center pixel is set to the average of all pixels in txelate an image, each group of pixels up to radius away
   //   from a center pixel is set to the average of all pixels in the box
   // for example, if radius is 1, each of the nine pixels forming a box 
   //   centered at the original pixel is set to the average of all nine pixels
   // the average of a set of pixels is found by averaging the red, green,
   //   and blue components   
   public static Picture pixelate(Picture p, int radius) {
      Color[][] pixels = p.getPixels();
      Color[][] pixels2 = new Color[pixels.length][pixels[0].length];
   
      //Main picture
      for(int x = 0; x < pixels.length - (pixels.length % ((radius * 2) + 1)); x+= ((radius * 2) +1)){
         for(int y = 0; y < pixels[0].length - (pixels[0].length % ((radius * 2) + 1)); y+= ((radius * 2) + 1)){
            int red = 0;
            int green = 0;
            int blue = 0;
            double Average = Math.pow(((radius * 2) + 1), 2);
            for(int h = 0; h < ((radius * 2) + 1); h++){
               for(int t = 0; t < ((radius * 2) + 1); t++){
                  red += pixels[x + h][y + t].getRed();
                  green += pixels[x + h][y + t].getGreen();
                  blue += pixels[x + h][y + t].getBlue();
               }
            }
            red /= Average;
            green /= Average;
            blue /= Average;
            Color newColor = new Color(red, green, blue);
            for(int j = 0; j < ((radius * 2) + 1); j++){
               for(int k = 0; k < ((radius * 2) + 1); k++){
                  pixels2[x + j][y + k] = newColor;
               }
            }
         }
      }
      
      //Right wall
      if(pixels.length % ((radius * 2) + 1) != 0){
         for(int rightY = 0; rightY < pixels[0].length - (pixels[0].length % ((radius * 2) + 1)); rightY += ((radius * 2) + 1)){ //y
            int red = 0;
            int green = 0;
            int blue = 0;
            int Average = ((pixels.length % ((radius * 2) + 1)) * ((radius * 2) + 1));
            for(int q = 0; q < pixels.length % ((radius * 2) + 1); q++){ //x
               for(int u = 0; u < ((radius * 2) + 1); u++){ //y
                  red += pixels[((pixels.length - 1) - (pixels.length % ((radius * 2) + 1))) + q][rightY + u].getRed();
                  green += pixels[((pixels.length - 1) - (pixels.length % ((radius * 2) + 1))) + q][rightY + u].getGreen();
                  blue += pixels[((pixels.length - 1) - (pixels.length % ((radius * 2) + 1))) + q][rightY + u].getBlue();
               }
            }
            red /= Average;
            green /= Average;
            blue /= Average;
            Color newColor = new Color(red, green, blue);
            for(int j = pixels.length - ((radius * 2) + 1); j < pixels.length; j++){//x
               for(int k = 0; k < ((radius * 2) + 1); k++){ //y
                  pixels2[j][rightY +k] = newColor;
               }
            }
         }
      }
      
      //Bottom Wall
      if(pixels[0].length % ((radius * 2) + 1) != 0){
         for(int BottomX = 0; BottomX < pixels.length - (pixels.length % ((radius * 2) + 1)); BottomX += ((radius * 2) + 1)){
            int red = 0;
            int green = 0;
            int blue = 0;
            int Average = (((radius * 2) + 1) * (pixels[0].length % ((radius * 2) + 1)));
            for(int q = 0; q < ((radius * 2) + 1); q++){ //x
               for(int u = 0; u < pixels[0].length % ((radius * 2) + 1); u++){ //y
                  red += pixels[BottomX + q][(pixels[0].length - (pixels[0].length % ((radius * 2) + 1))) + u].getRed();
                  green += pixels[BottomX + q][(pixels[0].length - (pixels[0].length % ((radius * 2) + 1))) + u].getGreen();
                  blue += pixels[BottomX + q][(pixels[0].length - (pixels[0].length % ((radius * 2) + 1))) + u].getBlue();
               }
            }
            red /= Average;
            green /= Average;
            blue /= Average;
            Color newColor = new Color(red, green, blue);
            for(int j = 0; j < ((radius * 2) + 1); j++){ //x
               for(int k = pixels[0].length - ((radius * 2) + 1); k < pixels[0].length; k++){ //y
                  pixels2[BottomX + j][k] = newColor;
               }
            }
         }
      }
      //Bottom Corner
      if((pixels.length % ((radius * 2) + 1) != 0) && (pixels[0].length %((radius * 2) + 1) != 0)){
         for(int k = 0; k < 1; k++){
            int red = 0;
            int green = 0;
            int blue = 0;
            int Average = (pixels.length % ((radius * 2) + 1)) * (pixels[0].length % ((radius * 2) + 1));
            for(int CornerX = (pixels.length - (pixels.length % ((radius * 2) + 1))); CornerX < pixels.length; CornerX++){
               for(int CornerY = (pixels[0].length - (pixels[0].length % ((radius * 2) + 1))); CornerY < pixels[0].length; CornerY++){
                  red += pixels[CornerX][CornerY].getRed();
                  green += pixels[CornerX][CornerY].getGreen();
                  blue += pixels[CornerX][CornerY].getBlue();
               }
            }
            red /= Average;
            green /= Average;
            blue /= Average;
            Color newColor = new Color(red, green, blue);
            for(int CornerX2 = (pixels.length - (pixels.length % ((radius * 2) + 1))); CornerX2 < pixels.length; CornerX2++){
               for(int CornerY2 = (pixels[0].length - (pixels[0].length % ((radius * 2) + 1))); CornerY2 < pixels[0].length; CornerY2++){
                  pixels2[CornerX2][CornerY2] = newColor;
               }
            }
         }
      }
      
      Picture Pixelate = new Picture(pixels2);
      return Pixelate;
   }


   // **EXTRA CREDIT**
   //
   // returns a new Picture that scales down the amount of a given color in p
   // 
   // color will be one of 'r', 'g', or 'b' indicating with color to scale
   // amt will have 0 <= amt <= 1.0 indicating the percent of the given color
   //   to remain
   // for example, if color is 'g' t will have 0 <= amt <= 1.0 indicating the percent of the given color
   //   to remain
   // for example, if color is 'g' and amt is 0.75, then each pixel of the 
   //   Picture returned should have 75% as much green as that pixel of p
   public static Picture scaleColor(Picture p, char color, double amt) {
      return p;
   }
      
   // **EXTRA CREDIT**
   public static Picture flip(Picture p, char dir) {
      Color[][] pixels = p.getPixels();
      Color[][] pixels2 = new Color[pixels.length][pixels[0].length];
      for(int x = 0; x < pixels.length; x++){
         for(int y = 0; y < pixels[0].length; y++){
            if (dir == 'v') { 
               pixels2[x][y] = pixels[x][pixels[0].length - 1 - y];
            } 
            else {
               pixels2[x][y] = pixels[pixels.length - 1 - x][y];
            }   
         } 
      }
      Picture flip = new Picture(pixels2);
      return flip;
   }

     // **EXTRA CREDIT**
   //
   // returns a new Picture in which a box blur has been run on p
   //
   // in a box blur, each pixel is set to the average of the pixels up 
   //   to radius pixels away from it (including the original pixel)
   // for example, if radius is 1, each pixel is set to the average of
   //   the nine pixels forming a box centered at the original pixel
   // the average of a set of pixels is found by averaging the red, green,
   //   and blue components
   public static Picture blur(Picture p, int radius) {
      return p;
   } 
}