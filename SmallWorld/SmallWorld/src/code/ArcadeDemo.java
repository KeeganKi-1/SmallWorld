

/**
 * Class ArcadeDemo
 * This class contains demos of many of the things you might
 * want to use to make an animated arcade game.
 * 
 * Adapted from the AppletAE demo from years past. 
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.sound.sampled.Clip;


public class ArcadeDemo extends AnimationPanel 
{
    int turn = 1;
    //1 selection
    //2 conquer
    //3 redeploy
    int phase = 1;

    //Constructor
    //-------------------------------------------------------
    public ArcadeDemo()
    {   //Enter the name and width and height.  
        
        super("ArcadeDemo", 1200+23, 500+57);
        

       
       
    }
    
    
    int counter = 0;
    //The renderFrame method is the one which is called each time a frame is drawn.
    //-------------------------------------------------------
    protected void renderFrame(Graphics g) 
    {   frameNumber ++;
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, 1200, 900);
        //draws background
        g.drawImage(map, 0, 0, this);
        g.drawImage(ratmanSelector, 800, 0, this);

    }//--end of renderFrame method--
    
    //-------------------------------------------------------
    //Respond to Mouse Events
    //-------------------------------------------------------
    public void mouseClicked(MouseEvent e)  
    { 
        
    }
    
    //-------------------------------------------------------
    //Respond to Keyboard Events
    //-------------------------------------------------------
    public void keyTyped(KeyEvent e) 
    {
        char c = e.getKeyChar();
       
       
    }
    
    public void keyPressed(KeyEvent e)
    {
        int v = e.getKeyCode();
        if(v == KeyEvent.VK_SHIFT){
        

        }
        
        
    }

    public void keyReleased(KeyEvent e)
    {
        int v = e.getKeyCode();
        
       
    }
    
    
    //-------------------------------------------------------
    //Initialize Graphics
    //-------------------------------------------------------
//-----------------------------------------------------------------------
/*  Image section... 
 *  To add a new image to the program, do three things.
 *  1.  Make a declaration of the Image by name ...  Image imagename;
 *  2.  Actually make the image and store it in the same directory as the code.
 *  3.  Add a line into the initGraphics() function to load the file. 
//-----------------------------------------------------------------------*/
    Image ballImage;        
    Image starImage;
    Image map;
    Image ratmanSelector;
    public void initGraphics() 
    {      
        Toolkit toolkit = Toolkit.getDefaultToolkit();
       map = toolkit.getImage("src/images/Map.png").getScaledInstance(800, 500, 0);
       ratmanSelector = toolkit.getImage("src/images/RatmanSelector.png").getScaledInstance(400, 200, 0);
    } //--end of initGraphics()--
    
    //-------------------------------------------------------
    //Initialize Sounds
    //-------------------------------------------------------
//-----------------------------------------------------------------------
/*  Music section... 
 *  To add music clips to the program, do four things.
 *  1.  Make a declaration of the AudioClip by name ...  AudioClip clipname;
 *  2.  Actually make/get the .wav file and store it in the same directory as the code.
 *  3.  Add a line into the initMusic() function to load the clip. 
 *  4.  Use the play(), stop() and loop() functions as needed in your code.
//-----------------------------------------------------------------------*/
    Clip themeMusic;
    Clip bellSound;
    
    public void initMusic() 
    {
        themeMusic = loadClip("src/audio/theme.wav");
        
        if(themeMusic != null)
//            themeMusic.start(); //This would make it play once!
            themeMusic.loop(20); //This would make it loop 2 times.
    }

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}//--end of ArcadeDemo class--

