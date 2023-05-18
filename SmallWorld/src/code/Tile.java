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
    boolean farmland = false;
    boolean forest = false;
    String race = "lostTribe";
    String ability ="";
    public Tile(int x, int y, int width, int height, int characters, boolean mountain, boolean edgePiece, boolean waterPiece, boolean farmland, boolean forest){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        hitBox = new HitBox(x, y,width, height);
        charactersConquering = characters;
        this.mountain = mountain;
        this.edgePiece = edgePiece;
        this.waterPiece =waterPiece;
        this.farmland  = farmland;
        this.forest  = forest;
    }
    public void addNode(Tile node){
         connectingTiles.add(node);
    }
    public void setRace(String race){
        this.race =race;
       
    }
    public int amountToCaptue(String race, String ability, int reinforcements){
        
        int amount = 2+charactersConquering;
        if(mountain){
            
        amount++;
        }
        if(ability.equals("commando")){ 
        amount--;
        }
        if(race!=null){
        if(race.equals("tritons")){
            for(int i = 0; i<connectingTiles.size(); i++ ){
                if(connectingTiles.get(i).waterPiece){
                    amount--;
                    break;
                }
            }
            
        }

    }
    amount-=reinforcements;
            if(amount < 1){
                amount =1;
            }
        return amount;
    }
    public int collectMoney(String ability, String race){
        int money = 1;

        if(race.equals("humans") && farmland){
money++;
        }
        if(ability.equals("forest") && forest){
            money++;
        }
        return money;
    }
    public void removeCharacters(int amount){
        charactersConquering-=amount;
        if(charactersConquering <= 0){
            owningPlayer = -1;
        }
    }
    

    
}
