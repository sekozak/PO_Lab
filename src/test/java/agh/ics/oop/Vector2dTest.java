package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    Vector2d v1 = new Vector2d(1,2);
    Vector2d v2 = new Vector2d(0,5);
    Vector2d v3 = new Vector2d(7,7);

    @Test
    void testEquals() {
        assertFalse( v1.equals("false") );
        assertFalse( v1.equals(false) );
        assertFalse( v1.equals(v2) );
        assertTrue( v1.equals(v1) );
        assertTrue( v3.equals(new Vector2d(7,7)) );
    }

    @Test
    void testToString() {
        assertEquals( v3.toString(), "(7,7)" );
    }

    @Test
    void precedes() {
        assertTrue( v2.precedes(v3) );
        assertFalse( v1.precedes(v2) );
    }

    @Test
    void follows() {
        assertTrue( v3.follows(v2) );
        assertFalse( v1.precedes(v2) );
    }

    @Test
    void upperRight() {
        assertEquals(v1.upperRight(v2),new Vector2d(1,5));
    }

    @Test
    void lowerLeft() {
        assertEquals(v1.lowerLeft(v2),new Vector2d(0,2));
    }

    @Test
    void add() {
        assertEquals(v1.add(v2),new Vector2d(1,7));
    }

    @Test
    void substract() {
        assertEquals(v1.subtract(v2),new Vector2d(1,-3));
    }

    @Test
    void opposite() {
        assertEquals(v1.opposite(),new Vector2d(-1,-2));
    }
}