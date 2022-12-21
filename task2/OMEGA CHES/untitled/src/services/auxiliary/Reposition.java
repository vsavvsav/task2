package services.auxiliary;

import boar.Cell;
import data.GameData;
import data.Player;
import shape.Shape;

public class Reposition {
    public static void reposition(GameData data, Cell c1, Cell c2){
        if(c1 == null)
            return;
        if(c2 == null)
            return;
        data.getDontMovedYet().remove(data.getCellShape().get(c1));
        if(data.getPlayerCells().get(data.getPlayers().peekLast()).contains(c2)){
            data.getPlayerCells().get(data.getPlayers().peekLast()).remove(c2);
            data.getCellShape().remove(c2);
        }
        Shape s = data.getCellShape().get(c1);
        data.getCellShape().remove(c1);
        data.getCellShape().put(c2, s);
        data.getPlayers().addLast(data.getPlayers().pollFirst());
    }
}
