package agh.ics.oop;


public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int x, int y){
        this.ll = new Vector2d(0,0);
        this.ur = new Vector2d(x,y);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(ur) && position.follows(ll) && !isOccupied(position);
    }
}
