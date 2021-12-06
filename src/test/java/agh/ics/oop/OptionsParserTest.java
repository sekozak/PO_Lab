package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    private OptionsParser parser;
    private String[] args;
    private MoveDirection[] res;


    @Test
    void parse() {

        int i = 0;
        MoveDirection[] tab3 = parser.parse(args);
        for(MoveDirection q : tab3 ){
            assertEquals(q , res[i]);
            i++;
        }

    }

    @BeforeEach
    void setUp() {
        parser = new OptionsParser();
        args = new String[]{"forward", "b", "right", "l"};

        res = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
    }
}