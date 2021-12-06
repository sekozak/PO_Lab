package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {
    private IWorldMap map;
    private Vector2d v1;
    private Vector2d v2;
    private Vector2d v3;


    @Test
    void canMoveTo() {
        Animal dog1 = new Animal(map,v1);
        Animal dog2 = new Animal(map,v2);
        map.place(dog1);
        map.place(dog2);

        assertFalse( map.canMoveTo(new Vector2d(7,8)) );
        assertFalse( map.canMoveTo(new Vector2d(7,7)) );
        assertFalse( map.canMoveTo(new Vector2d(7,6)) );
        assertTrue( map.canMoveTo(new Vector2d(6,7)) );
    }

    @Test
    void place() {
        Animal dog1 = new Animal(map,v1);
        Animal dog2 = new Animal(map,v2);

        assertTrue(map.place(dog1));
        assertTrue(map.place(dog2));
    }

    @Test
    void isOccupied() {
        Animal dog1 = new Animal(map,v1);
        map.place(dog1);

        assertTrue(map.isOccupied(v1));
        assertFalse(map.isOccupied(v2));
        assertFalse(map.isOccupied(v3));
    }

    @Test
    void objectAt() {
        Animal dog1 = new Animal(map,v1);
        Animal dog2 = new Animal(map,v2);
        map.place(dog1);
        map.place(dog2);

        assertEquals(map.objectAt(v1), dog1);
        assertEquals(map.objectAt(v2), dog2);
    }

    @BeforeEach
    void setUp() {
        map = new RectangularMap(7, 7);
        v1 =  new Vector2d(7,7);
        v2 = new Vector2d(7,6);
        v3 = new Vector2d(7,8);
    }
}