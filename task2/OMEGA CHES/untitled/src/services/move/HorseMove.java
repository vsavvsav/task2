package services.move;

import boar.Cell;
import boar.Direction;
import data.GameData;
import data.Player;
import shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HorseMove implements Move{
    @Override
    public List<Cell> whereMove(GameData data, Player p, Cell sC) {
        Shape s = getShapeByPos(data, sC);
        Map<Direction, List<Direction>> direction = data.getHorseDirection();

        List<Cell> cells = new ArrayList<>();

        for (Direction d1:direction.keySet()) {
            for (Direction d2:direction.get(d1)) {
                Cell c = getNextCell(sC, d1, 2, d2, 1);
                if(c != null && !data.getPlayerCells().get(p).contains(c)){
                    cells.add(c);
                }
            }
        }

        return cells;
    }
}
