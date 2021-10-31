package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    private int i=0;

    @Test
    void parsetest() {
        String[] tab1 = new String[]{"f","r","left","7","b"};
        MoveDirection[] tab2 = new MoveDirection[]{MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.BACKWARD};

        OptionsParser parser = new OptionsParser();
        MoveDirection[] tab3 = parser.parse(tab1);

        for(MoveDirection q : tab3 ){
            assertEquals(q , tab2[i]);
            i++;
        }
    }
}