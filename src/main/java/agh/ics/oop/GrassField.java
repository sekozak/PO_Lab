package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private final int fields;
    public static Vector2d VECTOR00 = new Vector2d(0, 0);
    private final Map<Vector2d, Grass> grassmap;


    public GrassField(int fields) {
        this.fields = fields ;
        this.grassmap = new HashMap<>();
    }


    public void border(Vector2d q ){
        if ( !q.precedes(ur) ) ur = q.upperRight(ur);
        if ( !q.follows(ll) ) ll = q.lowerLeft(ll);
    }

    public void dynamicborder(){
        ll = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        ur = new Vector2d(0,0);
        for (Vector2d a : animalsmap.keySet()){
            border( a );
        }
        for (Vector2d g : grassmap.keySet()){
            border( g );
        }
    }

    @Override
    public String toString() {
        dynamicborder();
        return super.toString();
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!position.follows(VECTOR00)) return false;
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d q = animal.getPosition();
        if ( objectAt(q) instanceof Animal || !q.follows(VECTOR00) ) return false;
        animalsmap.put(q,animal);
        animal.addObserver(this);
        return true;
    }


    public boolean place(Grass grass) {
        Vector2d q = grass.getPosition();
        if ( isOccupied(q) || !q.follows(VECTOR00) ) return false;
        grassmap.put(q,grass);
        return true;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        boolean bool = super.isOccupied(position);
        if( bool ) return true;
        return grassmap.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if( object instanceof Animal ) return object;
        if( isOccupied(position) ) return grassmap.get(position);
        return null;
    }



    public void plantgrass(){
        Random generator = new Random();
        for ( int i=0; i<fields; i++) {
            int a = generator.nextInt((int) sqrt(fields*10));
            int b = generator.nextInt((int) sqrt(fields*10));
            Vector2d q = new Vector2d(a,b);
            if ( !place(new Grass(q)) ) {
                i--;
            }
        }
    }
}
