package agh.ics.oop;


public class Animal {
    private Vector2d position;
    private MapDirection orientation;
    private IWorldMap map;
    public Animal(IWorldMap map) {
        this.position = new Vector2d(2,2);
        this.orientation = MapDirection.NORTH;
        this.map =map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
        this.map =map;
    }

    @Override
    public String toString() {
        return this.orientation.toString();
    }


    public void move(MoveDirection direction){
        switch (direction) {
            case FORWARD -> {
                if( map.canMoveTo(position.add(orientation.toUnitVector())) ) position=position.add(orientation.toUnitVector());
            }
            case BACKWARD -> {
                if( map.canMoveTo(position.subtract(orientation.toUnitVector())) ) position=position.subtract(orientation.toUnitVector());
            }
            case LEFT -> orientation=orientation.previous();
            case RIGHT -> orientation=orientation.next();
        }
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }
}

