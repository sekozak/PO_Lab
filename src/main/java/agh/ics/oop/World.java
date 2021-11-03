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


//        Direction[] tab= strtotab(args);
//        run(tab);
//        System.out.println("Stop");

//        Vector2d v1 = new Vector2d(1,1);
//        Vector2d v2 = new Vector2d(2,2);
//        Vector2d v3 = new Vector2d(2,3);
//        if(u.precedes(v)) System.out.println("es");
//        else System.out.println("noes");
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));

//        Animal lion = new Animal();
//        System.out.println(lion.toString());
//
//        OptionsParser parser = new OptionsParser();
//        MoveDirection[] tablica = parser.parse(tabs);
//
//        for(MoveDirection q : tablica ) {
//            lion.move(q);
//            System.out.println(lion.toString());
//        }

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

    }
}