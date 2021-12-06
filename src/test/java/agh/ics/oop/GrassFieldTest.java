package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    private GrassField map;
    private Vector2d v1;
    private Vector2d v2;
    private Vector2d v3;


    @Test
    void canMoveTo() {
        Animal dog1 = new Animal(map,v1);
        Animal dog2 = new Animal(map,v2);
        map.place(new Grass(v3));
        map.place(dog1);
        map.place(dog2);

        assertTrue( map.canMoveTo( v3 ) );
        assertFalse( map.canMoveTo( v1 ));
        assertFalse( map.canMoveTo( v2 ));
        assertTrue( map.canMoveTo(new Vector2d(6,7)) );
    }

    @Test
    void place() {
        Animal dog1 = new Animal(map,v1);
        Animal dog2 = new Animal(map,v2);
        Animal dog3 = new Animal(map,v3);

        assertTrue(map.place(new Grass(v1)));

        assertTrue(map.place(dog1));
        assertTrue(map.place(dog2));
        assertTrue(map.place(dog3));
    }

    @Test
    void isOccupied() {
        Animal dog1 = new Animal(map,v1);
        map.place(dog1);
        map.place(new Grass(v2));

        assertTrue(map.isOccupied(v1));
        assertTrue(map.isOccupied(v2));
        assertFalse(map.isOccupied(v2) && (map.objectAt(v2) instanceof Animal));
        assertFalse(map.isOccupied(v3) && (map.objectAt(v3) instanceof Animal));
    }

    @Test
    void objectAt() {
        Animal dog1 = new Animal(map,v1);
        Animal dog2 = new Animal(map,v2);
        Grass grass = new Grass(v3);
        map.place(dog1);
        map.place(dog2);
        map.place(new Grass(v2));
        map.place(grass);

        assertEquals(map.objectAt(v1), dog1);
        assertEquals(map.objectAt(v2), dog2);
        assertEquals(map.objectAt(v3), grass);
    }

    @BeforeEach
    void setUp() {
        map = new GrassField(10);
        v1 =  new Vector2d(7,7);
        v2 = new Vector2d(7,6);
        v3 = new Vector2d(7,8);
    }
}