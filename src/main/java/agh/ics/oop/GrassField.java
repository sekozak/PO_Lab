package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private final int fields;
    public static Vector2d VECTOR00 = new Vector2d(0, 0);
    private final List<Grass> grass;


    public GrassField(int fields) {
        this.fields = fields ;
        this.grass = new ArrayList<>();
    }


    public void border(Vector2d q ){
        if ( !q.precedes(ur) ) ur = q.upperRight(ur);
        if ( !q.follows(ll) ) ll = q.lowerLeft(ll);
    }

    public void dynamicborder(){
        ll = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        ur = new Vector2d(0,0);
        for (Animal a : animals){
            border( a.getPosition() );
        }
        for (Grass g : grass){
            border( g.getPosition() );
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
        animals.add(animal);
        return true;
    }


    public boolean place(Grass grass) {
        Vector2d q = grass.getPosition();
        if ( isOccupied(q) || !q.follows(VECTOR00) ) return false;
        this.grass.add(grass);
        return true;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        boolean bool = super.isOccupied(position);
        if( bool ) return true;
        for(Grass q : grass){
            if (q.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if( object instanceof Animal ) return object;
        for(Grass q : grass){
            if (q.getPosition().equals(position)) return q;
        }
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
