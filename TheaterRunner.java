import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Create any 2D arrays & variables to be passed as parameters to constructor
ImageFilter[][] players = {
      // row 0 --> NBA Logo
      { new ImageFilter("download-(5)-(1).png")},
      // row 1 --> sports (no second image so put null)
      { new ImageFilter("download-(1)-(1).png"), new ImageFilter("download-(2)-(1).png"), new ImageFilter("download-(3).png"), new ImageFilter("download-(4).png") }
      // row 2 --> Most Points in a game per Player
};
    
  ImageFilter[][] stats ={
    { new ImageFilter("download-(6).png"), new ImageFilter("download-(5)-(2).png"),
     new ImageFilter("download-(8).png"), new ImageFilter("download-(7).png") }
    };

    // Instantiate Scene subclass objects
    SceneOne scene1 = new SceneOne(players);
    SceneTwo scene2 = new SceneTwo(stats);
    // Call drawScene methods in each subclass
    scene1.drawScene1();
    scene2.drawScene2();
    
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(scene1, scene2);
    
  }
}