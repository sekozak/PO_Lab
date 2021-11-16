package agh.ics.oop;

public class World {
    public static void run(Direction[] args) {
        System.out.println("Zwierzak idzie:");
        for(Direction q : args ) {
            switch (q) {
                case FORWARD -> System.out.println("Do przodu");
                case BACKWARD -> System.out.println("Do tyłu");
                case RIGHT -> System.out.println("W prawo");
                case LEFT -> System.out.println("W lewo");
                default -> System.out.println("postoj");
            }
        }
    }

    public static void main(String[] args) {

        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField object = new GrassField(10);
        object.plantgrass();
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, object, positions);
        engine.run();

    }
}

//f b r l f f r r f f f f f f f f
//./gradlew run --args="..."