package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class MapBoundary  implements IPositionChangeObserver{
    private int leftx = Integer.MAX_VALUE;
    private int rightx = 0;
    private int bottomy = Integer.MAX_VALUE;
    private int uppery = 0;
    private final Map<Vector2d, Animal> animalsmap = new HashMap<>();
    private Vector2d llgrass;
    private Vector2d urgrass;


    public MapBoundary() {
        this.llgrass = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        this.urgrass = new Vector2d(0,0);
    }


    public void border(Vector2d v){
        if( v.x>rightx ) rightx=v.x;
        else if( v.x<leftx ) leftx=v.x;
        if( v.y>uppery ) uppery=v.y;
        else if( v.y<bottomy ) bottomy=v.y;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal q = animalsmap.get(oldPosition);
        animalsmap.remove(oldPosition,q);
        animalsmap.put(newPosition,q);
        if( oldPosition.x==leftx || oldPosition.x==rightx || oldPosition.y==bottomy || oldPosition.y==uppery){
            if( newPosition.x>leftx || newPosition.x<rightx || newPosition.y>bottomy || newPosition.y<uppery) dynamicborder();
            else border(newPosition);
        }
    }

    public void grassborder(Map<Vector2d, Grass> grassmap){
        for (Vector2d q : grassmap.keySet()) {
            if (!q.precedes(urgrass)) urgrass = q.upperRight(urgrass);
            if (!q.follows(llgrass)) llgrass = q.lowerLeft(llgrass);
        }
    }

    public void dynamicborder(){
        leftx = Integer.MAX_VALUE;
        rightx = 0;
        bottomy = Integer.MAX_VALUE;
        uppery = 0;
        for (Vector2d v : animalsmap.keySet()){
            border(v);
        }
    }

    public void addAnimal(Animal a){
        animalsmap.put(a.getPosition(),a);
        border(a.getPosition());
    }


    public Vector2d lowLeft(){
        return llgrass.lowerLeft(new Vector2d(leftx,bottomy));
    }

    public Vector2d uppRight(){
        return urgrass.upperRight(new Vector2d(rightx,uppery));
    }
}
