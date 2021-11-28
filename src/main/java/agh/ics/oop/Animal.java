package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;

public class Animal {
    private Vector2d position;
    private MapDirection orientation;
    private final IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
        this.map = map;
    }

    @Override
    public String toString() {
        return this.orientation.toString();
    }


    public void move(MoveDirection direction){
        switch (direction) {
            case FORWARD -> {
                if( map.canMoveTo(position.add(orientation.toUnitVector())) ) {
                    Vector2d oldposition=position;
                    position = position.add(orientation.toUnitVector());
                    positionChanged(oldposition,position);
                }
            }
            case BACKWARD -> {
                if( map.canMoveTo(position.subtract(orientation.toUnitVector())) ){
                    Vector2d oldposition=position;
                    position=position.subtract(orientation.toUnitVector());
                    positionChanged(oldposition,position);
                }
            }
            case LEFT -> orientation=orientation.previous();
            case RIGHT -> orientation=orientation.next();
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver q: observers){
            q.positionChanged(oldPosition,newPosition);
        }
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }
}

