package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    private int i=0;

    private OptionsParser parser;
    private String[] args1;
    private String[] args2;
    private String[] args3;
    private MoveDirection[] res1;
    private MoveDirection[] res2;
    private MoveDirection[] res3;

    @Test
    void parse() {
        MoveDirection[] tab1 = parser.parse(args1);
        for(MoveDirection q : tab1 ){
            assertEquals(q , res1[i]);
            i++;
        }

        i=0;
        MoveDirection[] tab2 = parser.parse(args2);
        for(MoveDirection q : tab2 ){
            assertEquals(q , res2[i]);
            i++;
        }

        i=0;
        MoveDirection[] tab3 = parser.parse(args3);
        for(MoveDirection q : tab3 ){
            assertEquals(q , res3[i]);
            i++;
        }
    }

    @BeforeEach
    void setUp() {
        parser = new OptionsParser();
        args1 = new String[]{"f", "r", "r", "l", "l", "b", "c"};
        args2 = new String[]{"f", "f", "b", "q", "w", "b", "a"};
        args3 = new String[]{"forward", "b", "right", "l"};

        res1 = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.BACKWARD};
        res2 = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD};
        res3 = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
    }
}