import java.awt. *;
import javax.swing. *;

/**
 * Description: MapViewer is responsible for displaying a particular
 * view of MapGrid.
 *
 * @author Monique Blake
 * @version 10 February 2011
 *
 */

class MapViewer extends JComponent{
  /** grid gets the MapGrid file  information */
  private MapGrid grid;
  
  /** magnification is the amount the objects on the screen will be magnified by */
  private int magnification = 1;
  
  /** Sets the offset in the X direction  */
  private int offsetX;
  
  /** Sets the offset in the Y direction  */
  private int offsetY;
  
  /** @param grid passes in the grid from the previous program MapGrid */
  public MapViewer(MapGrid grid){
    this.grid = grid;
  }  
  
  /** Two int fields for offset
    * @param offsetX is the offset value in the x direction.
    * @param offsetY is the offset value in the y direction.
    */  
  public void offset(int offsetX , int offsetY){
    this.offsetX = offsetX;
    this.offsetY = offsetY;
    repaint();
  }
  
  /** @returns the offsetX value */ 
  public int getOffsetX()
  {
    return this.offsetX; 
  }
  
  /** @returns the offsetY value */   
  public int getOffsetY()
  {
    return this.offsetY; 
  }    
  
  /**
   * @param magnification is the amount of times you will multiply height and width.  
   */
  public void Magnification(int magnification){
    this.magnification = magnification;
    repaint();
  }
  
  
  /** @returns the magnification */ 
  public int getMagnification()
  {
    return magnification; 
  }
  
  /** The component will look bad if it is sized smaller than this 
    * @returns the minimum dimensions 
    */
  public Dimension getMinimumSize(){
    return new Dimension(grid.getWidth() , grid.getHeight() );
  }
  
  /** The component will look best at this size, same size as getMinimumSize
    * @returns The preferred dimension.
    */
  public Dimension getPreferredSize(){
    return new Dimension(grid.getWidth() , grid.getHeight() );
  }
  
  /**
   * @param Graphics g passes in the graphics package
   */
  public void paintComponent(Graphics g){
    for (int i = 0; i <  grid.getWidth();  i++) {
      for (int j = 0; j <  grid.getHeight(); j++){
        g.setColor(grid.getColor(i,j));
        g.fillRect((i - offsetX) * magnification, (j - offsetY) * magnification, magnification, magnification);
      }
    }
  }
}