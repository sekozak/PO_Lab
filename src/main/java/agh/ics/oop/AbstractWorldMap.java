package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();

    protected Vector2d ll;
    protected Vector2d ur;


    @Override
    public boolean place(Animal animal) {
        Vector2d q = animal.getPosition();
        if ( isOccupied(q) || !q.precedes(ur) || !q.follows(ll) ) return false;
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal q : animals){
            if (q.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal q : animals){
            if (q.getPosition().equals(position)) return q;
        }
        return null;
    }


    @Override
    public String toString() {
        return new MapVisualizer(this).draw(ll,ur);
    }
}
