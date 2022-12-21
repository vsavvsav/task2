package services.move;

import boar.Cell;
import boar.Direction;
import data.GameData;
import data.Player;
import shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class PawnMove implements Move{
    @Override
    public List<Cell> whereMove(GameData data, Player p, Cell sC) {
        Shape s = getShapeByPos(data, sC);
        Direction d = data.getPawnDirection().get(s.getC());
        List<Cell> cells = new ArrayList<>();


        Cell c = getNextCell(sC, d, null);
        if(c != null && !data.getCellShape().containsKey(c))
            cells.add(c);

        if(data.getDontMovedYet().contains(s)) {
            int count = 0;
            while (count < 2) {
                c = getNextCell(c, d, null);
                if (c == null)
                    break;
                if (!data.getCellShape().containsKey(c))
                    break;
                cells.add(c);
                count++;
            }
        }

        c = getNextCell(sC, d, 1, Direction.RIGHT, 1);
        if(c != null && data.getPlayerCells().get(getEnemy(data, p)).contains(c)){
            cells.add(c);
        }

        c = getNextCell(sC, d, 1, Direction.LEFT, 1);
        if(c != null && data.getPlayerCells().get(getEnemy(data, p)).contains(c)){
            cells.add(c);
        }

        return cells;
    }
}
