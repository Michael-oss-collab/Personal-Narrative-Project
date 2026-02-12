import org.code.theater.*;
import org.code.media.*;


public class ImageFilter extends ImagePlus {

  /** Constructor */
public ImageFilter (String filename){
  super (filename);
}



    /**
   * The adjustContrast method changes the brightness so the difference in brightness between the lightest and darkest parts of an image becomes more visible. 
   * A high contrast image has a greater difference between the lightest and darkest parts, while a low contrast image has a smaller difference.
   */
  public void adjustContrast(int multiplier) {
    Pixel [][] pixels = getImagePixels();
    for ( Pixel[] row : pixels){
      for (Pixel pixel : row){
        pixel.setBlue(pixel.getBlue() * multiplier);
        pixel.setRed(pixel.getRed() * multiplier);
        pixel.setGreen(pixel.getGreen() * multiplier);

        if (pixel.getBlue() > 255){
          pixel.setBlue(255);
        }

        if (pixel.getRed() > 255){
          pixel.setRed(255);
        }

        if(pixel.getGreen() > 255){
          pixel.setGreen(255);
        }
      }
    }
  }




   // The applySepia method gives an image a warm, antique tone by shifting the color balance toward browns and golds. 
   public void applySepia() {
Pixel[][] pixels = getImagePixels();
    for(Pixel[] row: pixels){
      for(Pixel pixel: row){
        int newRed = (int)(0.393 * pixel.getRed() + 0.769 * pixel.getGreen() + 0.189 * pixel.getBlue());
        int newGreen = (int)(0.349 * pixel.getRed() + 0.686 * pixel.getGreen() + 0.168 * pixel.getBlue());
        int newBlue = (int) (0.272 * pixel.getRed() + 0.534 * pixel.getGreen() + 0.131 * pixel.getBlue());
        pixel.setRed(newRed);
        pixel.setGreen(newGreen);
        pixel.setBlue(newBlue);
      }
    }
  }



    /**
   * The threshold method converts an image to a black and white image by comparing the grayscale value of each pixel to a threshold value.
   */
   public void threshold(int value) {
Pixel[][] pixels = getImagePixels();
    for(Pixel[] row: pixels){
      for(Pixel pixel: row){
int average = (int)((pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3);
        if (average < value){
          pixel.setRed(0);
          pixel.setBlue(0);
          pixel.setGreen(0);
        }else {
          pixel.setRed(255);
          pixel.setBlue(255);
          pixel.setGreen(255);
        }
      }
    }    
  }


  
   /**
   *  The colorize method changes the color of an image based on its original grayscale values. The grayscale value of each pixel is 
   *  converted, which is then used to apply a specific color to the pixel.
   */
  public void colorize() {
  Pixel[][] pixels = this.getImagePixels();
    for (Pixel[] row : pixels) {
        for (Pixel pixel : row) {
int average = (int)((pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3);
          if (average < 85) {
            pixel.setRed(255);
            pixel.setBlue(0);
            pixel.setGreen(0);
          } else if (average <170){
            pixel.setRed(0);
            pixel.setBlue(0);
            pixel.setGreen(255);
          }else {
            pixel.setRed(0);
            pixel.setBlue(255);
            pixel.setGreen(0);
          }
  }
}
  }

  

    // The mirrorVertical method reflects an image across the vertical axis
  public void mirrorVertical() {
    Pixel[][] pixels = getImagePixels();
    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels[0].length / 2; c++) {
        pixels[r][c].setColor(pixels[r][pixels[0].length - 1 - c].getColor());
        
  }
      }
    }


   // The mirrorHorizontal method reflects an image across the horizontal axis
  public void mirrorHorizontal() {
    Pixel[][] pixels = getImagePixels();
    for ( int r = 0; r<pixels.length/2; r++){
      for ( int c = 0; c < pixels[0].length; c++){
        pixels [r][c].setColor(pixels[pixels.length-1-r][c].getColor());
      }
    }
  }
}