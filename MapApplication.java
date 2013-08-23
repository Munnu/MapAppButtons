import java.awt.*;
import javax.swing.*;        
import java.lang.reflect.*;   
/**
 *  This file provides the skeleton of a Java Swing application
 *  for assignment 2 of CSC 212.  It is intended to create two windows
 *  with differing views of a map.
 *
 *  @author  Monique Blake
 *  @version 10 February 2011
 */
public class MapApplication {
  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from the
   * event-dispatching thread.
   */
  public static void setupWindows() {
    // Make sure we have nice window decorations.
    JFrame.setDefaultLookAndFeelDecorated(true);
    
    // Create and set up the windows.
    JFrame frame1 = new JFrame("Map #1");
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JFrame frame2 = new JFrame("Map #2");
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Set up map:
    MapGrid map;
    MapViewer view1, view2;
    // sets size of overall mapgrid
    map = new MapGrid(400,400);
    
    //hortizonal road
    map.alterMap(150, 0, 100, 400, Color.gray);
    
    //vertical road
    map.alterMap(0, 150, 400, 100, Color.gray);
    
    //Outer area of house                                       
    map.alterMap(270, 20, 112, 110, Color.red);
    
    //Inner area of house                                                    
    map.alterMap(290, 35, 75, 80, Color.orange);
    
    // grass area
    map.alterMap(17, 270, 117, 110,  Color.green);
    
    // flowers
    map.alterMap(22, 290, 108, 10,  Color.pink);
    map.alterMap(22, 305, 108, 10,  Color.pink);
    map.alterMap(22, 320, 108, 10,  Color.pink);
    map.alterMap(22, 335, 108, 10,  Color.pink);
    map.alterMap(22, 350, 108, 10,  Color.pink);
    
    //Tombstone Squares
    /** first parameter: startX value */
    /** second parameter: startY value */
    /** third parameter: dimension in the x direction */
    /** fourth parameter: dimension in the y direction  */
    /** fifth parameter: the color of the square */
    map.alterMap(17, 25, 20, 20,  Color.gray);
    map.alterMap(17, 50, 20, 20,  Color.gray);
    map.alterMap(17, 75, 20, 20,  Color.gray);
    map.alterMap(17, 100, 20, 20,  Color.gray);
    map.alterMap(42, 25, 20, 20,  Color.gray);
    map.alterMap(67, 25, 20, 20,  Color.gray);
    map.alterMap(92, 25, 20, 20,  Color.gray);
    map.alterMap(117, 25, 20, 20,  Color.gray);
    map.alterMap(42, 50, 20, 20,  Color.gray);
    map.alterMap(42, 75, 20, 20,  Color.gray);
    map.alterMap(42, 100, 20, 20,  Color.gray);
    map.alterMap(67, 50, 20, 20,  Color.gray);
    map.alterMap(92, 50, 20, 20,  Color.gray);
    map.alterMap(117, 50, 20, 20,  Color.gray);
    map.alterMap(117, 75, 20, 20,  Color.gray);
    map.alterMap(117, 100, 20, 20,  Color.gray);
    map.alterMap(67, 75, 20, 20,  Color.gray);
    map.alterMap(67, 100, 20, 20,  Color.gray);
    map.alterMap(92, 75, 20, 20,  Color.gray);
    map.alterMap(92, 100, 20, 20,  Color.gray);
    
    // Road dividers Vertical
    map.alterMap(198, 0, 2, 20,  Color.white);
    map.alterMap(198, 40, 2, 20,  Color.white);
    map.alterMap(198, 80, 2, 20,  Color.white);
    map.alterMap(198, 120, 2, 20,  Color.white);
    map.alterMap(198, 160, 2, 20,  Color.white);
    map.alterMap(198, 200, 2, 20,  Color.white);
    map.alterMap(198, 240, 2, 20,  Color.white);
    map.alterMap(198, 280, 2, 20,  Color.white);
    map.alterMap(198, 320, 2, 20,  Color.white);
    map.alterMap(198, 360, 2, 20,  Color.white);
    //map.alterMap(198, 394 , 2, 20,  Color.white);
    
    // Road dividers Horizontal
    map.alterMap(0, 198, 20, 2,  Color.white);
    map.alterMap(40, 198, 20, 2,  Color.white);
    map.alterMap(80, 198, 20, 2,  Color.white);
    map.alterMap(120, 198, 20, 2,  Color.white);
    map.alterMap(160, 198, 20, 2,  Color.white);
    map.alterMap(220, 198, 20, 2,  Color.white);
    map.alterMap(260, 198, 20, 2,  Color.white);
    map.alterMap(300, 198, 20, 2,  Color.white);
    map.alterMap(340, 198, 20, 2,  Color.white);
    map.alterMap(374, 198, 20, 2,  Color.white);
    //map.alterMap(399, 198, 20, 2,  Color.white);
    
    //This is a pond
    map.alterMap(270, 270, 112, 110,  Color.blue);
    
    view1 = new MapViewer(map);
    view1.Magnification(1);
    view2 = new MapViewer(map);
    view2.Magnification(2);
    view2.offset(15,15);
    frame1.getContentPane().add(view1);
    frame2.getContentPane().add(view2);
    
    // Display the windows:
    frame1.pack();
    frame1.setVisible(true);
    frame2.pack();
    frame2.setVisible(true);
  }
  public static void main(String[] args) throws Throwable {
    // set up windows with viewers:
    try {
      javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
          setupWindows();
        }
      });
    } catch (InterruptedException e) {
      System.out.println("Couldn't create GUI.");
      System.exit(-1);
    } catch (InvocationTargetException e) {
      throw(e.getTargetException());
    }
  }
}


