import java.util.ArrayList;

public class Tile {
    
    int charactersConquering;
    int owningPlayer = -1;
    int mountain;
    ArrayList<Tile> connectingTiles;
    HitBox hitBox;
    public Tile(int x, int y, int width, int height, int characters, int mountain){
        hitBox = new HitBox(x, y,width, height);
        charactersConquering = characters;
        this.mountain = mountain;
    }
    public void addNode(Tile node){
        connectingTiles.add(node);
    }
    

    
}
