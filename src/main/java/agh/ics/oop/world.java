package agh.ics.oop;
import java.util.Scanner;

public class world {
    public static Direction[] strtotab(String arg){
        int c=0,i=0;

        char[] charArray = new char[arg.length()];
        arg.getChars(0, arg.length(), charArray, 0);

        for( char q : charArray){
            if(q=='f' || q=='b' || q=='r' || q=='l') c++;
        }
        Direction[] newtab = new Direction[c];
        for( char q : charArray){
            switch(q){
                case 'f':
                    newtab[i]=Direction.FORWARD;
                    break;
                case 'b':
                    newtab[i]=Direction.BACKWARD;
                    break;
                case 'r':
                    newtab[i]=Direction.RIGHT;
                    break;
                case 'l':
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

//        System.out.println("Start");
//        Scanner thingdo = new Scanner(System.in);
//        String str = thingdo.nextLine();
//        Direction[] newtab=strtotab(str);
//        run(newtab);
//        System.out.println("Stop");

        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(2,3);

//        if(u.precedes(v)) System.out.println("es");
//        else System.out.println("noes");
//
//        v.toString();
//        u.toString();

//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));

//        MapDirection polnoc = MapDirection.NORTH;
//        System.out.println(polnoc.toString());
//        System.out.println(polnoc.next());
//        System.out.println(polnoc.previous());
//        System.out.println(polnoc.toUnitVector());


    }
}