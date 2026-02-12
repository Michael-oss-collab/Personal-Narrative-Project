import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {

  /** Instance Variables */
  private ImageFilter[][] players;
  
  /** Constructor */
  public SceneOne(ImageFilter[][] players) {
    this.players = players;
  }
  
  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene1() {
    drawTitleLogo();
    drawFavoritePlayerImages();
  }

  /**
   * Draws all images in first row of images using mirrorVertical()
   */
  public void drawTitleLogo() {
    for (ImageFilter img : players[0]) {
      clear("white");
      
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1.5);
      
      img.mirrorHorizontal();
      
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1.5);
    }
  }
  
  /**
   * Draws all images in first row of images using applySepia()
   */
  public void drawFavoritePlayerImages() {
    for (ImageFilter img : players[1]) {
      clear("white");

      if (img != null) {
        drawImage(img, 0, 0, 400, 400, 0);
        pause(1.5);
        
        img.applySepia();
        
        drawImage(img, 0, 0, 400, 400, 0);
        pause(1.5);
      }
      
    }
  }
  
}