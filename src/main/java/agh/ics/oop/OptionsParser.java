package agh.ics.oop;

public class OptionsParser {

    public MoveDirection[] parse(String[] args){
        int count = args.length;
        int i = 0;

        MoveDirection[] tab = new MoveDirection[count];

        for(String q : args ) {
            switch (q) {
                case "f", "forward" -> tab[i] = MoveDirection.FORWARD;
                case "b", "backward" -> tab[i] = MoveDirection.BACKWARD;
                case "r", "right" -> tab[i] = MoveDirection.RIGHT;
                case "l", "left" -> tab[i] = MoveDirection.LEFT;
                default ->  throw new IllegalArgumentException(q + " is not legal move specification");
            }
            i++;
        }
        return tab;
    }
}
