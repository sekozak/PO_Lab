package agh.ics.oop;

import static java.lang.System.exit;

public class World {

    public static void main(String[] args) {

        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            GrassField object = new GrassField(10);
            object.plantgrass();
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 7)};
            IEngine engine = new SimulationEngine(directions, object, positions);
            engine.run();
        }
        catch (IllegalArgumentException ex){
            System.out.print(ex);
            exit(0);
        }

    }
}

//f b r l f f r r f f f f f f f f
//./gradlew run --args="..."