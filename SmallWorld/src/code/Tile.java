import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tile {
    
    int charactersConquering;
    int owningPlayer = -1;
    boolean mountain;
    ArrayList<Tile> connectingTiles = new ArrayList<Tile>();
    HitBox hitBox;
    boolean edgePiece;
    boolean waterPiece;
    int x;
    int width;
    int height;
    int y;
    public Tile(int x, int y, int width, int height, int characters, boolean mountain, boolean edgePiece, boolean waterPiece){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        hitBox = new HitBox(x, y,width, height);
        charactersConquering = characters;
        this.mountain = mountain;
        this.edgePiece = edgePiece;
        this.waterPiece =waterPiece;
    }
    public void addNode(Tile node){
         connectingTiles.add(node);
    }
    public int amountToCaptue(){
        return 2;
    }
    

    
}
