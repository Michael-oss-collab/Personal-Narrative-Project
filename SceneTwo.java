import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

  /** Instance Variables */
  private ImageFilter[][] stats;
  
  /** Constructor */
  public SceneTwo(ImageFilter[][] stats) {
    this.stats = stats;
  }
  
  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene2() {
    drawCareerHighPoints();
  }


  
  /**
   * Draws all images in first row of images using adjustContrast(5)
   */
  public void drawCareerHighPoints() {
    for (ImageFilter img : stats[0]) {
      clear("white");

      drawImage(img, 0, 0, 400, 400, 0);
      pause(1.5);
      
      img.adjustContrast(5);
      
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1.5);
    }
  }


  
}