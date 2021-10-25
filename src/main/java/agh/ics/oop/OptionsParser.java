package agh.ics.oop;

public class OptionsParser {
    private int count=0, i=0;

    public MoveDirection[] parse(String[] args){
        for(String q : args ) {
            if ( q.equals("f") || q.equals("forward") || q.equals("b") || q.equals("backward") ||
                    q.equals("r") || q.equals("right") || q.equals("l") || q.equals("left") ) count++;
        }

        MoveDirection[] tab = new MoveDirection[count];

        for(String q : args ) {
            switch (q) {
                case "f", "forward" -> tab[i] = MoveDirection.FORWARD;
                case "b", "backward" -> tab[i] = MoveDirection.BACKWARD;
                case "r", "right" -> tab[i] = MoveDirection.RIGHT;
                case "l", "left" -> tab[i] = MoveDirection.LEFT;
                default -> i--;
            }
            i++;
        }
        return tab;
    }

}
