import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;

public class PicEditMain {
   private JFrame frame;
   private JSlider red, green, blue;
   private JSlider brightness, contrast;
   private JTextField edgeThreshold, blurRadius, pixelateRadius;
   private Picture p;
   private Picture orig;
   private Picture flipped;
   
   private static PicEditMain singleton = new PicEditMain();

   public static void main(String[] args) {
//       Scanner kb = new Scanner(System.in);
//       
//       String filePath;
//       do {
//          System.out.print("Enter image file path: ");
//          filePath = kb.nextLine();
//       
//          try {
//             singleton.p = new Picture(filePath);
//             singleton.orig = singleton.p;
//          } catch (RuntimeException ex) {
//             System.out.println("Error: " + ex.getMessage());
//             System.out.println("Please try again...\n");
//          }
//       } while (singleton.p == null);
      singleton.chooseFile();
   }
   
   private void chooseFile() {
      String dir = System.getProperty("user.dir");
      if (p != null && p.getFilename() != null) {
         dir = new File(p.getFilename()).getParentFile().getAbsolutePath();
      }
      JFileChooser fileChooser = new JFileChooser(dir);
      int result = -1;
      fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files (.jpg, .gif, .png)", "jpg", "gif", "png"));
      result = fileChooser.showOpenDialog(null);
      if (result == JFileChooser.APPROVE_OPTION) {
         orig = flipped = p = new Picture(fileChooser.getSelectedFile());
    
         createWindow();
         update();
      }
   }
      
   private void createWindow() {
      if (frame != null) {
         frame.setVisible(false);
         frame.dispose();
      }
      frame = new JFrame();
      frame.setContentPane(new JPanel(new BorderLayout(15, 15)));
      // frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle(p.getFilename());

      JPanel left = new JPanel();
      left.setLayout(new BoxLayout(left, BoxLayout.X_AXIS));
      addButtons(left);
      left.add(Box.createRigidArea(new Dimension(20, 0)));
      addSliders(left);
      frame.getContentPane().add(left, BorderLayout.WEST);   

      frame.getContentPane().add(p.getJLabel(), BorderLayout.CENTER);
      update();
   }
   
   private void addButtons(JPanel top) {
      JPanel buttons = new JPanel();
      buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
      
      JButton grayButton = new JButton("Grayscale");
      grayButton.addActionListener(new ButtonAction('g'));
      buttons.add(grayButton);
      
      JButton invertButton = new JButton("Invert");
      invertButton.addActionListener(new ButtonAction('i'));
      buttons.add(invertButton);
      
      buttons.add(Box.createRigidArea(new Dimension(0, 30)));
      
      JButton flipH = new JButton("Flip Horiz");
      flipH.addActionListener(new ButtonAction('f', 'h'));
      buttons.add(flipH);
      
      JButton flipV = new JButton("Flip Vert");
      flipV.addActionListener(new ButtonAction('f', 'v'));
      buttons.add(flipV);
      
      JButton mirrorH = new JButton("Mirror Horiz");
      mirrorH.addActionListener(new ButtonAction('m', 'h'));
      buttons.add(mirrorH);
      
      JButton mirrorV = new JButton("Mirror Vert");
      mirrorV.addActionListener(new ButtonAction('m', 'v'));
      buttons.add(mirrorV);

      buttons.add(Box.createRigidArea(new Dimension(0, 30)));
      
      JPanel edge = new JPanel();
      edge.setLayout(new BoxLayout(edge, BoxLayout.X_AXIS));
      edge.setAlignmentX(Component.LEFT_ALIGNMENT);
      
      JButton edgeButton = new JButton("Outline");
      edgeButton.addActionListener(new ButtonAction('e'));
      edgeButton.setToolTipText("Smaller values detect more edges");      
      edge.add(edgeButton);
      
      edgeThreshold = new JTextField("25", 2);
      edgeThreshold.setMaximumSize(new Dimension(25, 27));
      edge.add(edgeThreshold);
      
      buttons.add(edge);
      
      JPanel blur = new JPanel();
      blur.setLayout(new BoxLayout(blur, BoxLayout.X_AXIS));
      blur.setAlignmentX(Component.LEFT_ALIGNMENT);
      
      JButton blurButton = new JButton("Blur");
      blurButton.addActionListener(new ButtonAction('b'));
      blurButton.setToolTipText("Larger values create more blur");
      blur.add(blurButton);
      
      blurRadius = new JTextField("1", 1);
      blurRadius.setMaximumSize(new Dimension(15, 27));
      blur.add(blurRadius);
      
      buttons.add(blur);

      JPanel pixel = new JPanel();
      pixel.setLayout(new BoxLayout(pixel, BoxLayout.X_AXIS));
      pixel.setAlignmentX(Component.LEFT_ALIGNMENT);
      
      JButton pixelateButton = new JButton("Pixelate");
      pixelateButton.addActionListener(new ButtonAction('p'));
      pixelateButton.setToolTipText("Larger values create larger pixels");
      pixel.add(pixelateButton);
      
      pixelateRadius = new JTextField("5", 2);
      pixelateRadius.setMaximumSize(new Dimension(25, 27));      
      pixel.add(pixelateRadius);
      
      buttons.add(pixel);
            
      buttons.add(Box.createRigidArea(new Dimension(0, 30)));
      
      JButton reset = new JButton("Reset");
      reset.addActionListener(new ButtonAction('x'));
      buttons.add(reset);
      
      JButton open = new JButton("Open");
      open.addActionListener(new ButtonAction('o'));
      buttons.add(open);      
      
      JButton save = new JButton("Save");
      save.addActionListener(new ButtonAction('s'));
      buttons.add(save);

      top.add(buttons);
   }
   
   private void addSliders(JPanel top) {
      JPanel sliders = new JPanel();
      sliders.setLayout(new BoxLayout(sliders, BoxLayout.Y_AXIS));
      
      JLabel brightLabel = new JLabel("Brightness");
      brightness = new JSlider(-100, 100, 0);
      brightness.setMajorTickSpacing(50);
      brightness.setMinorTickSpacing(10);
      brightness.setPaintTicks(true);
      brightness.setPaintTrack(true);
      brightness.setPaintLabels(false);
      brightness.addChangeListener(new SliderAction('t'));
      sliders.add(brightLabel);
      sliders.add(brightness);
      
      sliders.add(Box.createRigidArea(new Dimension(0, 15)));

      JLabel contrastLabel = new JLabel("Contrast");
      contrast = new JSlider(0, 200, 100);
      contrast.setMajorTickSpacing(50);
      contrast.setMinorTickSpacing(10);
      contrast.setPaintTicks(true);
      contrast.setPaintTrack(true);
      contrast.setPaintLabels(false);
      contrast.addChangeListener(new SliderAction('c'));
      sliders.add(contrastLabel);
      sliders.add(contrast);
      
      sliders.add(Box.createRigidArea(new Dimension(0, 40)));      
      
      JLabel redLabel = new JLabel("Red");
      red = new JSlider(0, 100, 100);
      red.setMajorTickSpacing(50);
      red.setMinorTickSpacing(10);
      red.setPaintTicks(true);
      red.setPaintTrack(true);
      red.setPaintLabels(true);
      red.addChangeListener(new SliderAction('r'));
      sliders.add(redLabel);
      sliders.add(red);
      
      sliders.add(Box.createRigidArea(new Dimension(0, 15)));

      JLabel greenLabel = new JLabel("Green");
      green = new JSlider(0, 100, 100);
      green.setMajorTickSpacing(50);
      green.setMinorTickSpacing(10);
      green.setPaintTicks(true);
      green.setPaintTrack(true);
      green.setPaintLabels(true);
      green.addChangeListener(new SliderAction('g'));
      sliders.add(greenLabel);
      sliders.add(green);

      sliders.add(Box.createRigidArea(new Dimension(0, 15)));

      JLabel blueLabel = new JLabel("Blue");
      blue = new JSlider(0, 100, 100);
      blue.setMajorTickSpacing(50);
      blue.setMinorTickSpacing(10);
      blue.setPaintTicks(true);
      blue.setPaintTrack(true);
      blue.setPaintLabels(true);
      blue.addChangeListener(new SliderAction('b'));
      sliders.add(blueLabel);
      sliders.add(blue);

      top.add(sliders); 
   }
   
   
   private void update() {
      frame.getContentPane().remove(frame.getContentPane().getComponent(1));
      frame.getContentPane().add(p.getJLabel(), BorderLayout.CENTER);
      frame.setResizable(false);
      frame.pack();
      frame.setVisible(true);
      frame.repaint();
   }
   
   private class ButtonAction implements ActionListener {
      private char cmd;
      private char arg;
      
      public ButtonAction(char cmd) { this.cmd = cmd; }
      public ButtonAction(char cmd, char arg) { this.cmd = cmd; this.arg = arg; }

      public void actionPerformed(ActionEvent e) {
         switch (cmd) {
            case 'i': {
               flipped = p = PicEdit.invertColors(p);
               break;
            }
            case 'g': {
               flipped = p = PicEdit.grayscale(p);
               break;
            }
            case 'e': {
               try {
                  flipped = p = PicEdit.outline(p, Integer.parseInt(edgeThreshold.getText()));
               } catch (NumberFormatException ex) { }
               break;
            }
            case 'b': {
               try {
                  flipped = p = PicEdit.blur(p, Integer.parseInt(blurRadius.getText()));
               } catch (NumberFormatException ex) { }
               break;
            }
            case 'p': {
               try {
                  flipped = p = PicEdit.pixelate(p, Integer.parseInt(pixelateRadius.getText()));
               } catch (NumberFormatException ex) { }
               break;
            }
            case 'f': {
               flipped = p = PicEdit.flip(p, arg);
               break;
            }
            case 'm': {
               flipped = p = PicEdit.mirror(p, arg);
               break;
            }            
            case 'x': {
               red.setValue(100);
               green.setValue(100);
               blue.setValue(100);
               brightness.setValue(0);
               contrast.setValue(100);
               flipped = p = orig;
               break;
            }
            case 'o': {
               chooseFile();
               break;
            }
            case 's': {
              FileDialog chooser = new FileDialog(frame,
                                   "Use a .png or .jpg extension", FileDialog.SAVE);
              chooser.setFile(p.getFilename());
              chooser.setVisible(true);
              if (chooser.getFile() != null) {
                  p.save(chooser.getDirectory() + File.separator + chooser.getFile());
              }               
            }
         }
         
         update();
      }
   }
   
   private class SliderAction implements ChangeListener {
      private char cmd;
      
      public SliderAction(char cmd) { this.cmd = cmd; }
   
      public void stateChanged(ChangeEvent e) {
         JSlider source = (JSlider)e.getSource();
         switch (cmd) {
            case 'r':
            case 'g':
            case 'b':
               p = PicEdit.scaleColor(resetColor(cmd), cmd, source.getValue() / 100.0);
               break;
            case 't':
            case 'c':
               p = PicEdit.changeContrastAndBrightness(resetColor(cmd), contrast.getValue() / 100.0, brightness.getValue());
               break;
         }
         update();
      }
      
      private Picture resetColor(char colorChange) {
         Picture newP = new Picture(p);
         Color c, origC;
         for (int x = 0; x < p.getWidth(); x++) {
            for (int y = 0; y < p.getHeight(); y++) {
               c = p.get(x, y);
               origC = flipped.get(x, y);
               
               switch (colorChange) {
                  case 'r' : newP.set(x, y, new Color(origC.getRed(), c.getGreen(), c.getBlue())); break;
                  case 'g' : newP.set(x, y, new Color(c.getRed(), origC.getGreen(), c.getBlue())); break;
                  case 'b' : newP.set(x, y, new Color(c.getRed(), c.getGreen(), origC.getBlue())); break;
                  default: newP.set(x, y, new Color(origC.getRed(), origC.getGreen(), origC.getBlue())); break;
               }
            }
         }
         
         return newP;
      }
   }
}