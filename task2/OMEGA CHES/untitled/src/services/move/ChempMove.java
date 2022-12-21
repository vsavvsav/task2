package services.move;

import boar.Cell;
import boar.Direction;
import data.GameData;
import data.Player;
import shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChempMove implements Move{
    @Override
    public List<Cell> whereMove(GameData data, Player p, Cell sC) {
        Shape s = getShapeByPos(data, sC);
        Map<Direction, Direction> direction = data.getDirectionShapes().get(s.getT());

        List<Cell> cells = new ArrayList<>();

        for (Direction d:direction.keySet()) {
            Cell c = getNextCell(sC, d, null);
            if(c != null && !data.getPlayerCells().get(p).contains(c))
                cells.add(c);
            c = getNextCell(c, d, null);
            if(c != null && !data.getPlayerCells().get(p).contains(c))
                cells.add(c);

            c = getNextCell(sC, d, 2, direction.get(d), 2);

            if(c != null && !data.getPlayerCells().get(p).contains(c))
                cells.add(c);
        }
        return cells;
    }
}
