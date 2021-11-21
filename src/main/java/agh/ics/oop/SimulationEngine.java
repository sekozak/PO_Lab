package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;


class SimulationEngine implements IEngine {
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final List<Animal>  animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] directions,IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;

        for (Vector2d q : positions){
            Animal pet = new Animal( map , q );
            if( map.place(pet) ){ animals.add(pet);}
        }
    }


    @Override
    public void run() {

        int len = animals.size(), i=0;
        for (MoveDirection q : directions) {
            System.out.print(map);
            animals.get(i % len).move(q);
            i++;
        }
        System.out.print(map);

    }
}
