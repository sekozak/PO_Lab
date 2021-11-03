package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;
    List<Animal>  animals;


    public RectangularMap(int x, int y){
        this.width=x;
        this.height=y;
        this.animals = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(new Vector2d(this.width, this.height)) && position.follows(new Vector2d(0, 0)) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if ( isOccupied(animal.getPosition()) ) return false;
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
        return new MapVisualizer(this).draw(new Vector2d(0,0), new Vector2d(width, height));
    }
}
