package services.move;

import boar.Cell;
import boar.Direction;
import data.GameData;
import data.Player;
import shape.Shape;

import java.util.List;

public interface Move {
    List<Cell> whereMove(GameData data, Player p, Cell sC);

    /**
     * получение экземпл€ра фигуры по ее клетке
     * @param data игрова€ инфа
     * @param c клетка фигуры
     * @return фигура
     */
    default Shape getShapeByPos(GameData data, Cell c){
        return data.getCellShape().getOrDefault(c, null);
    }

    default boolean notMoved(GameData data, Cell c){
        return data.getDontMovedYet().contains(getShapeByPos(data, c));
    }
    default boolean notMoved(GameData data, Shape s){
        return data.getDontMovedYet().contains(s);
    }


    default Player getEnemy(GameData data, Player p){
        for (Player e: data.getPlayers()) {
            if(!p.equals(e))
                return e;
        }
        return null;
    }

    default Cell getNextCell(Cell c, Direction d1, Direction d2){
        if(c == null)
            return null;

        if(d1 == null)
            return c.getNeighbors().get(d2);

        if(d2 == null)
            return c.getNeighbors().get(d1);

        Cell res = c.getNeighbors().get(d1);

        if(res == null)
            return null;

        return res.getNeighbors().get(d2);
    }

    default Cell getNextCell(Cell c, Direction d1, int c1, Direction d2, int c2){


        Cell res = c;

        while (c1 > 0){
            if(res == null)
                return null;
            res = res.getNeighbors().get(d1);
            c1--;
        }
        while (c2 > 0){
            if(res == null)
                return null;
            res = res.getNeighbors().get(d2);
            c2--;
        }
        return res;
    }
}
