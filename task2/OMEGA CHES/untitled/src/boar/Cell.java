package boar;

import java.util.Map;
import java.util.TreeMap;

public class Cell {
    private Map<Direction, Cell> neighbors = new TreeMap<>();

    public Cell(Map<Direction, Cell> neighbors) {
        this.neighbors = neighbors;
    }

    public Cell() {
        this.neighbors = new TreeMap<>();
        for (Direction d:Direction.values()) {
            neighbors.put(d, null);
        }
    }

    public void add(Cell c, Direction d){
        neighbors.put(d, c);
    }
    public Cell get(Direction d){
        return neighbors.get(d);
    }
    public Map<Direction, Cell> getNeighbors() {
        return neighbors;
    }
}
