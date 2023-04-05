

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
    int turn =1;
    //1 = selecting
    //2= Conquering
    //3 = Redeployment
    int phase =1;
    ArrayList<Tile> borders = new ArrayList<Tile>();
    ArrayList<Tile> tilesOwned1 = new ArrayList<Tile>();
    ArrayList<Tile> bord = new ArrayList<Tile>();

    String type1;
    int charactersAvailable1 =0;
   

    //Constructor
    //-------------------------------------------------------
    public ArcadeDemo()
    {   //Enter the name and width and height.  
        
        super("ArcadeDemo", 1200+23, 500+57);
        Tile water1 = new Tile(0, 0, 180, 100, 0, false, true,true);
        Tile field1 = new Tile(218, 0, 120, 176, 0, false, true,false);
        Tile forest1 = new Tile(357, 0, 126, 106, 0, false, true,false);
        Tile swamp1 = new Tile(511, 0, 136, 80, 0, false, true,false);
        Tile grass1 = new Tile(696, 0, 104, 69, 0, false, true,false);
        Tile grass2 = new Tile(252, 195, 140, 79, 0, false, true,false);
        water1.addNode(field1);
        field1.addNode(water1);
        field1.addNode(forest1);
        field1.addNode(grass2);
        forest1.addNode(field1);
        forest1.addNode(swamp1);
        forest1.addNode(grass2);
        swamp1.addNode(forest1);
        swamp1.addNode(grass1);
        grass2.addNode(field1);
        grass2.addNode(forest1);
         bord.add(field1);
         bord.add(water1);
         bord.add(swamp1);
         bord.add(grass1);
         bord.add(grass2);
         bord.add(forest1);


       
    }
    public void updateBorders(){
        borders.clear();
        for(int i = 0; i<tilesOwned1.size(); i++ ){
           
            for(int j =0; j<tilesOwned1.get(i).connectingTiles.size(); j++){
                borders.add(tilesOwned1.get(i).connectingTiles.get(j));
            }
        }
    }
    
    
    
    //The renderFrame method is the one which is called each time a frame is drawn.
    //-------------------------------------------------------
    protected void renderFrame(Graphics g) 
    {   frameNumber ++;
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, 1200, 900);
       
        
        //draws background
        g.drawImage(map, 0, 0, this);
        g.drawImage(ratmanSelector, 800, 0, this);
            for(int i =0; i<charactersAvailable1; i++){
                g.drawImage(ratmanPiece, 1100-(i*8), 300, this);
            }
            g.drawString(mouseX+","+mouseY, 100,100);
            for(int i =0; i<bord.size(); i++){
                for(int j =0; j<bord.get(i).charactersConquering; j++){
                    g.drawImage(ratmanPiece, bord.get(i).x+(bord.get(i).width/3)+2*j,bord.get(i).y+(bord.get(i).height/2),this);
                }
            }
    }//--end of renderFrame method--
    
    //-------------------------------------------------------
    //Respond to Mouse Events
    //-------------------------------------------------------
    public void mouseClicked(MouseEvent e)  
    { 
        if(phase == 1){
            if(new HitBox(800, 0, 400, 200).intersects(mouseX, mouseY)){
                type1 = "ratman";
                charactersAvailable1 = 8;
                phase++;
                System.out.println("true");
            }
        }
        if(phase == 2){
           if(tilesOwned1.size()==0){
            for(int i =0; i<bord.size(); i++){
                if(bord.get(i).edgePiece && charactersAvailable1>=bord.get(i).amountToCaptue() && bord.get(i).hitBox.intersects(mouseX, mouseY)){
                    charactersAvailable1-=bord.get(i).amountToCaptue();
                    bord.get(i).charactersConquering = bord.get(i).amountToCaptue();
                    tilesOwned1.add(bord.get(i));
                    updateBorders();
                }
            }
           }
           else{
            for(int i =0; i<borders.size(); i++){
                if(borders.get(i).edgePiece && charactersAvailable1>=borders.get(i).amountToCaptue() && borders.get(i).hitBox.intersects(mouseX, mouseY)){
                    charactersAvailable1-=borders.get(i).amountToCaptue();
                    borders.get(i).charactersConquering = borders.get(i).amountToCaptue();
                    tilesOwned1.add(borders.get(i));
                    updateBorders();
                    break;
                }
            }
           }
           
        }
        
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
    Image ratmanPiece;
    public void initGraphics() 
    {      
        Toolkit toolkit = Toolkit.getDefaultToolkit();
       map = toolkit.getImage("src/images/Map.png").getScaledInstance(800, 500, 0);
       ratmanSelector = toolkit.getImage("src/images/RatmanSelector.png").getScaledInstance(400, 200, 0);

        ratmanPiece =  toolkit.getImage("src/images/RatManPiece.png").getScaledInstance(100, 100, 0);
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
//         themeMusic = loadClip("src/audio/theme.wav");
        
//         if(themeMusic != null)
// //            themeMusic.start(); //This would make it play once!
//             themeMusic.loop(20); //This would make it loop 2 times.
    }

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}//--end of ArcadeDemo class--

