package agh.ics.oop;


public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;

    @Override
    public String toString() {
        return "Animal{" + "position=" + position + ", orientation=" + orientation + '}';
    }

    public Vector2d border(Vector2d x, Vector2d y){
        if(y.precedes(new Vector2d(4,4)) && y.follows(new Vector2d(0,0)) ) return y;
        return x;
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case FORWARD -> position = border( position , position.add(orientation.toUnitVector()) );
            case BACKWARD -> position = border( position , position.subtract(orientation.toUnitVector()) );
            case LEFT -> orientation=orientation.previous();
            case RIGHT -> orientation=orientation.next();
        }
    }
}

