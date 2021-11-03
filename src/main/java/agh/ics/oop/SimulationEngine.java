package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class SimulationEngine implements IEngine {
    private MoveDirection[] directions;
    private IWorldMap map;
    private Vector2d[] positions;
    private List<Animal>  animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] tab1,IWorldMap map, Vector2d[] tab2){
        this.directions = tab1;
        this.map = map;
        this.positions = tab2;
    }

    public void addanimal() {
        for (Vector2d q : positions){
            Animal pet = new Animal( map , q );
            if( map.place(pet) ){
                animals.add(pet);
            }
        }
    }

    @Override
    public void run() {
        addanimal();

        int len = animals.size(), i=0;
        for (MoveDirection q : directions) {
            System.out.print(map);
            animals.get(i % len).move(q);
            i++;
        }
        System.out.print(map);
    }
}
