package services.move;

import boar.Cell;
import boar.Direction;
import data.GameData;
import data.Player;
import shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RookMove implements Move{
    @Override
    public List<Cell> whereMove(GameData data, Player p, Cell sC) {
        Shape s = getShapeByPos(data, sC);
        Map<Direction, Direction> direction = data.getDirectionShapes().get(s.getT());

        List<Cell> cells = new ArrayList<>();
        for (Direction d:direction.keySet()) {
            Cell c = sC.getNeighbors().get(d);
            while (true) {
                if (c != null) {
                    if (data.getPlayerCells().get(p).contains(c)) {
                        break;
                    }
                    cells.add(c);
                    if (data.getPlayerCells().get(getEnemy(data, p)).contains(c)){
                        break;
                    }
                    c = c.getNeighbors().get(d);
                }else {
                    break;
                }
            }
        }


        return cells;
    }
}
