package services.auxiliary;

import boar.Cell;
import boar.Direction;
import data.GameData;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Auxiliary {

    public static Cell getCellByIndex(Cell cell, int row, int col){
        class Inner{
            Cell result = null;
            Set<Cell> visited = new HashSet<>();

            void search(Cell tmpCell, int tmpRow, int tmpCol){
                if(tmpCell == null || visited.contains(tmpCell))
                    return;
                if (tmpRow == row && tmpCol == col){
                    result = tmpCell;
                    return;
                }
                visited.add(tmpCell);
                search(tmpCell.get(Direction.UP), tmpRow-1, tmpCol);
                search(tmpCell.get(Direction.DOWN), tmpRow+1, tmpCol);
                search(tmpCell.get(Direction.RIGHT), tmpRow, tmpCol+1);
                search(tmpCell.get(Direction.LEFT), tmpRow, tmpCol-1);

            }
            void search() {
                search(cell, 0, 0);
            }
        }

        Inner i = new Inner();
        i.search();
        return i.result;
    }


    public static Point getIndexByCell(Cell start, Cell cell){
        class Inner{
            Point p = null;
            Set<Cell> visited = new HashSet<>();
            void search(Cell tmpCell, int tmpRow, int tmpCol){
                if(tmpCell == null || visited.contains(tmpCell))
                    return;

                if (cell.hashCode() == tmpCell.hashCode()){
                    p = new Point(tmpRow, tmpCol);
                    return;
                }
                visited.add(tmpCell);
                search(tmpCell.get(Direction.UP), tmpRow-1, tmpCol);
                search(tmpCell.get(Direction.DOWN), tmpRow+1, tmpCol);
                search(tmpCell.get(Direction.RIGHT), tmpRow, tmpCol+1);
                search(tmpCell.get(Direction.LEFT), tmpRow, tmpCol-1);

            }
            void search() {
                search(start, 0, 0);
            }
        }

        Inner i = new Inner();
        i.search();

        return i.p;
    }
}
