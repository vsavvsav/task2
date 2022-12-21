package services.move;

import boar.Cell;
import data.GameData;
import data.Player;

import java.util.List;

public class QueenMove implements Move{
    @Override
    public List<Cell> whereMove(GameData data, Player p, Cell sC) {
        List<Cell> cells = new ElephantMove().whereMove(data, p, sC);

        for (Cell c:new RookMove().whereMove(data, p, sC)) {
            if(!cells.contains(c))
                cells.add(c);
        }
        return cells;

    }
}
