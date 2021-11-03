package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    IWorldMap map = new RectangularMap(4,4);

    @Test
    void position() {
        Animal dog = new Animal(map);
        assertEquals(new Vector2d(2,2), dog.getPosition());
        dog.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,3), dog.getPosition());
        dog.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4), dog.getPosition());
        dog.move(MoveDirection.RIGHT);
        dog.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3,4), dog.getPosition());
        dog.move(MoveDirection.LEFT);
        dog.move(MoveDirection.LEFT);
        dog.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4), dog.getPosition());
    }

    @Test
    void orientation() {
        Animal cat = new Animal(map);
        assertEquals(MapDirection.NORTH, cat.getOrientation());
        cat.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, cat.getOrientation());
        cat.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, cat.getOrientation());
        cat.move(MoveDirection.RIGHT);
        cat.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, cat.getOrientation());
    }

    @Test
    void border() {
        Animal dog = new Animal(map);
        assertEquals(new Vector2d(2,2), dog.getPosition());
        dog.move(MoveDirection.FORWARD);//(2,3)
        dog.move(MoveDirection.FORWARD);//(2,4)
        dog.move(MoveDirection.FORWARD);//(2,4)
        assertEquals(new Vector2d(2,4), dog.getPosition());
        dog.move(MoveDirection.RIGHT);
        dog.move(MoveDirection.FORWARD);//(3,4)
        dog.move(MoveDirection.FORWARD);//(4,4)
        dog.move(MoveDirection.FORWARD);//(4,4)
        assertEquals(new Vector2d(4,4), dog.getPosition());
        dog.move(MoveDirection.BACKWARD);//(3,4)
        dog.move(MoveDirection.BACKWARD);//(2,4)
        dog.move(MoveDirection.BACKWARD);//(1,4)
        dog.move(MoveDirection.BACKWARD);//(0,4)
        dog.move(MoveDirection.BACKWARD);//(0,4)
        assertEquals(new Vector2d(0,4), dog.getPosition());
        dog.move(MoveDirection.RIGHT);
        dog.move(MoveDirection.FORWARD);//(0,3)
        dog.move(MoveDirection.FORWARD);//(0,2)
        dog.move(MoveDirection.FORWARD);//(0,1)
        dog.move(MoveDirection.FORWARD);//(0,0)
        dog.move(MoveDirection.FORWARD);//(0,0)
        assertEquals(new Vector2d(0,0), dog.getPosition());
    }
}