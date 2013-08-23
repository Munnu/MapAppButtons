import java.awt.*;

/**
 * Description: A grid that holds a default color and size and other data that helps create a map.
 * It is essentially the frame for the map.
 * 
 * @author Monique Blake
 * @version 10 February 2011
 */
public final class MapGrid {
  /** "height" is the height for the entire grid. */
  private int height;
  
  /** "width" is the width for the entire grid.  */
  private int width;
  
  /** the color you want to paint the individual squares  */
  public Color imagecolor;
  
  /** This is a 2D array of color that holds the default color of the grid. */
  Color[][] colorgrid;
  
  /** Assigns a default color to the 2D array. 
    * @param "height" is the height of the grid.
    * @param "width" is the width of the grid.
    */
  public MapGrid(int width, int height){
    this.height = height;
    this.width = width;
    colorgrid = new Color[width][height];
    for (int i = 0; i<colorgrid.length; i++){
      for (int j = 0; j<colorgrid[i].length; j++){
        colorgrid[i][j] = Color.black; 
      }
    }
  }
  /** @returns the height of the grid. */
  public int getHeight(){
    return height;
  }
  
  /** @returns the width of the grid. */
  public int getWidth(){
    return width;
  }
  
  
  
  /** @returns the color of a specific index.
    *  @param passes in the column of the array (height) second dimension
    *  @param passes in the row of the array (width) first dimension
    */
  
  public Color getColor(int r, int c){  
    return colorgrid[r][c];
  }
  /** @param "startX" is the starting x value of the section to be filled. 
    *  @param "startY" is the starting y value of the section to be filled.
    * @param "endX" is the ending x value of the section to be filled.
    * @param "endY" is the ending y value of the section to be filled.
    * @param "imagecolor" is the color of the new section to be filled.
    */ 
  public void alterMap(int startX, int startY, int endX, int endY, Color imagecolor){
    for (int i = startX; i<startX + endX; i++){
      for (int j = startY; j<startY + endY; j++){        
        colorgrid[i][j] = imagecolor;
      }
    }
  }
}
