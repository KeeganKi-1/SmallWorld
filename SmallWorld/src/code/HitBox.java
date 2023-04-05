

public class HitBox {
   int x;
   int y;
   int width;
   int height;
    public HitBox(int x, int y,int width, int height){
 this.x = x;
 this.y = y;
 this.width = width;
 this.height = height ;
    }

    public boolean intersects(int x, int y){
      
      if((x-this.x<width && x-this.x>0) && (y-this.y<height && y-this.y>0)){
         return true;
      }
      return false;
    }
}
