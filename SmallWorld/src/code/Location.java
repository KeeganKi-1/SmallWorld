


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
public class Location {
    Color colour = Color.BLACK;
    int x;
    int y;
    boolean filled =false;
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Location(int x, int y,Color colour, boolean filled){
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.filled = filled;
    }
    public void changeLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

}
