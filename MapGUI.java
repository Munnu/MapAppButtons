import java.awt.*;
import java.awt.event.*;
import javax.swing.*;        
import java.lang.reflect.*;   
/**
 *
 * Description: This program consists of one map that
 * can be offset and zoomed in/out by a push of a designated button,
 * When the user clicks on an area on the map, 
 * the map will center at that spot
 * 
 *  @author  Monique Blake
 *  @version 10 February 2011
 */
public class MapGUI {
  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from the
   * event-dispatching thread.
   */
  
  /** The map view that will be displayed */
  private static MapViewer view;
  
  public static MapGrid map;
  
  /** north south direction offset */
  int ns;
  
  /** north south direction offset */
  int ew;
  
  /** zoom in out magnification */
  int zoom;
  
  
  /** new X variable for centering */
  int viewX;
  
  /** new Y variable for centering */
  int viewY;
  
  
  
  public static void setupWindows() {
    // Make sure we have nice window decorations.
    JFrame.setDefaultLookAndFeelDecorated(true);
    
    // Create and set up the windows.
    JFrame frame = new JFrame("Map #1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Add components
    createComponents(frame.getContentPane());
    
    // Display the windows:
    frame.pack();
    frame.setVisible(true); 
  }
  
  /** 
   * @param pane is the pane that the map and the buttons are in
   */
  public static void createComponents(Container pane) {
    pane.setLayout(new FlowLayout(FlowLayout.CENTER));
    
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    
    JPanel panelIn = new JPanel();
    panelIn.setLayout(new BorderLayout());
    
    // sets size of overall mapgrid
    map = new MapGrid(400,400);
    
    //hortizonal road
    /** first parameter: startX value */
    /** second parameter: startY value */
    /** third parameter: dimension in the x direction */
    /** fourth parameter: dimension in the y direction  */
    /** fifth parameter: the color of the square */
    map.alterMap(0, 150, 400, 100, Color.gray);
    
    //vertical road
    map.alterMap(150, 0, 100, 400, Color.gray);
    
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
    
    //This is a pond
    map.alterMap(270, 270, 112, 110,  Color.blue);
    
    view = new MapViewer(map);
    
    // adds to pane
    pane.add(view);   
    
    // For buttons
    MapGUI b = new MapGUI();
    
    // NORTH (positive y offset)
    JButton northButton = new JButton("North");
    panel.add(northButton, BorderLayout.NORTH);
    northButton.addActionListener(b.new NorthListener());
    
    // SOUTH (negative y offset)
    JButton southButton = new JButton("South");
    panel.add(southButton, BorderLayout.SOUTH);
    southButton.addActionListener(b.new SouthListener());    
    
    // EAST (positive x offset)
    JButton eastButton = new JButton("East");
    panel.add(eastButton, BorderLayout.EAST);
    eastButton.addActionListener(b.new EastListener());
    
    // WEST (negative x offset)
    JButton westButton = new JButton("West");
    panel.add(westButton, BorderLayout.WEST);
    westButton.addActionListener(b.new WestListener());
    
    
    
    // ZOOM IN (multiplied Magnification)
    JButton zoomInButton = new JButton("Zoom In");
    panelIn.add(zoomInButton, BorderLayout.NORTH);
    zoomInButton.addActionListener(b.new ZoomInListener());   
    
    // ZOOM OUT (divided Magnification)
    JButton zoomOutButton = new JButton("Zoom Out");
    panelIn.add(zoomOutButton, BorderLayout.SOUTH);
    zoomOutButton.addActionListener(b.new ZoomOutListener());   
    
    
    // Adds button panel to the pane
    pane.add(panel);
    panel.add(panelIn);
    
    // Mouse Listeners...
    view.addMouseListener(b.new CenterMouseListener());
  }
  
  
  /** Event handler for North button */
  class NorthListener implements ActionListener {
    /**
     *  Offsets map north
     *
     *  @param e  Holds information about the button-push event
     */   
    public void actionPerformed(ActionEvent e) {
      ns = ns - 10;
      view.offset(view.getOffsetX(),ns);         
    }
  }
  
  /** Event handler for South button */
  class SouthListener implements ActionListener {
    /**
     *  Offsets map south
     *
     *  @param e  Holds information about the button-push event
     */
    public void actionPerformed(ActionEvent e) {
      ns = ns + 10;
      view.offset(view.getOffsetX(),ns);  
    }
  }  
  
  /** Event handler for East button */
  class EastListener implements ActionListener {
    /**
     *  Offsets map east
     *
     *  @param e  Holds information about the button-push event
     */
    public void actionPerformed(ActionEvent e) {
      ew = ew + 10;
      view.offset(ew,view.getOffsetY());
    }
  }
  
  /** Event handler for East button */
  class WestListener implements ActionListener {
    /**
     *  Offsets map west
     *
     *  @param e  Holds information about the button-push event
     */
    public void actionPerformed(ActionEvent e) {
      ew = ew - 10;
      view.offset(ew,view.getOffsetY());
    }
  }
  
  /** Event handler for ZoomIn button */
  class ZoomInListener implements ActionListener {
    /**
     *  Zooms in map
     *
     *  @param e  Holds information about the button-push event
     */
    public void actionPerformed(ActionEvent e) {
      zoom = 1;
      zoom = zoom * 2;
      
      int magiCenterX = ( (view.getOffsetX() + (map.getWidth()/(2*view.getMagnification()) - (map.getWidth()/(2*view.getMagnification()*zoom)))) );
      int magiCenterY = ( (view.getOffsetY() + (map.getHeight()/(2*view.getMagnification()) - (map.getHeight()/(2*view.getMagnification()*zoom)))) );
      
      view.offset( magiCenterX, magiCenterY );
      view.Magnification(view.getMagnification() * zoom);
    }
  }
  
  /** Event handler for ZoomOut button */
  class ZoomOutListener implements ActionListener {
    /**
     *  Zooms out map
     *
     *  @param e  Holds information about the button-push event
     */
    
    public void actionPerformed(ActionEvent e) {
      zoom = 2;
      
      if (view.getMagnification()== 1){
        view.Magnification(view.getMagnification());
      } else {       
        int magiCenterX = ( view.getOffsetX() - (map.getWidth()/(2*view.getMagnification())) );
        int magiCenterY = ( view.getOffsetY() - (map.getHeight()/(2*view.getMagnification())) );
        
        view.offset( magiCenterX, magiCenterY );
        view.Magnification(view.getMagnification() / zoom);
      }    
    }   
  }
  
  
  /** Mouse event handlers */
  public class CenterMouseListener extends MouseAdapter {
    
    /** Click event handler prints a message with the event location 
      * 
      * @param e Holds information about the mouse-click event
      */
    public void mouseClicked(MouseEvent e) {
      viewX = e.getX() - map.getWidth()/2;
      viewY = e.getY() - map.getHeight()/2;
      
      view.offset(((viewX)/view.getMagnification()) + view.getOffsetX(),
                  ((viewY)/view.getMagnification()) + view.getOffsetY());
    }
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


