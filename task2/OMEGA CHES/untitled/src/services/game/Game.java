package services.game;

import boar.Cell;
import data.GameData;
import services.auxiliary.Auxiliary;
import services.auxiliary.Reposition;
import services.auxiliary.Show;
import shape.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public static void start(GameData d){

        int count = 15;


        while (count > 0){
            System.out.println("Moving: "+d.getPlayers().peekFirst().getName());

            Show.printBoard(Show.addShapes(d,Show.getBoard()));

            List<Cell> cells = new ArrayList<>();
            Cell cell1 = null;
            for (Cell c:d.getPlayerCells().get(d.getPlayers().getFirst())) {
                Shape s = d.getCellShape().get(c);
                if(d.getMove().get(s.getT()).whereMove(d, d.getPlayers().peekFirst(), c).size() != 0){
                    cells = d.getMove().get(s.getT()).whereMove(d, d.getPlayers().peekFirst(), c);
                    cell1 = c;
                    break;
                }
            }
            Point p = Auxiliary.getIndexByCell(d.getBoard(), cell1);
            System.out.println("From: "+p.x+" "+p.y);
            System.out.println();
            Show.printBoard(Show.addOption(d, Show.addShapes(d,Show.getBoard()), cells));
            Cell cell2 = cells.get(new Random().nextInt(cells.size()));
            p = Auxiliary.getIndexByCell(d.getBoard(), cell2);
            System.out.println("To: "+p.x+" "+p.y);
            System.out.println();
            System.out.println("_____________________________");
            Reposition.reposition(d, cell1, cell2);

        }


    }
}
