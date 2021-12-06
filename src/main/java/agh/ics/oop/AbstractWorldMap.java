package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animalsmap = new HashMap<>();

    protected Vector2d ll;
    protected Vector2d ur;

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal q = animalsmap.get(oldPosition);
        animalsmap.remove(oldPosition,q);
        animalsmap.put(newPosition,q);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d q = animal.getPosition();
        if ( isOccupied(q) || !q.precedes(ur) || !q.follows(ll) ) throw new IllegalArgumentException(q + " already occupied or not in map");
        animalsmap.put(q,animal);
        animal.addObserver(this);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animalsmap.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if( isOccupied(position) ) return animalsmap.get(position);
        return null;
    }


    @Override
    public String toString() {
        return new MapVisualizer(this).draw(ll,ur);
    }
}
