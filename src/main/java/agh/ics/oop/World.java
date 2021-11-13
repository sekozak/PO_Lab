package agh.ics.oop;
import java.util.Objects;

public class World {
    public static Direction[] strtotab(String[] arg){
        int c=0,i=0;

        for( String q : arg){
            if(q.equals("f") || q.equals("b") || q.equals("r") || q.equals("l")) c++;
        }
        Direction[] newtab = new Direction[c];
        for( String q : arg){
            switch(q){
                case "f":
                    newtab[i]=Direction.FORWARD;
                    break;
                case "b":
                    newtab[i]=Direction.BACKWARD;
                    break;
                case "r":
                    newtab[i]=Direction.RIGHT;
                    break;
                case "l":
                    newtab[i]=Direction.LEFT;
                    break;
                default: i--;
            }
            i++;
        }
        return newtab;
    }

    public static void run(Direction[] args) {
        System.out.println("Zwierzak idzie:");
        for(Direction q : args ) {
            switch (q) {
                case FORWARD:
                    System.out.println("Do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Do tyłu");
                    break;
                case RIGHT:
                    System.out.println("W prawo");
                    break;
                case LEFT:
                    System.out.println("W lewo");
                    break;
                default:
                    System.out.println("postoj");
            }
        }
    }

    public static void main(String[] args) {


        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();


    }
}

//f b r l f f r r f f f f f f f f
//./gradlew run --args="..."