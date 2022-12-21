package services.auxiliary;

import boar.Cell;
import data.GameData;
import services.move.Move;
import shape.Color;
import shape.Shape;
import shape.TypeOfShape;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class Show {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";

    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private static Map<Color, String> clrs = Map.of(Color.BLACK, ANSI_BLACK, Color.WHITE, ANSI_WHITE);
    private static Map<TypeOfShape, String> shps = Map.of(
            TypeOfShape.ROOK, "R",
            TypeOfShape.CHAMP, "C",
            TypeOfShape.ELEPHANT, "E",
            TypeOfShape.HORSE, "H",
            TypeOfShape.KING, "K",
            TypeOfShape.PAWN, "P",
            TypeOfShape.QUEEN, "Q",
            TypeOfShape.WIZARD, "W"
    );
    public static String[][] getBoard(){
        String[][] s = new String[10][10];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                s[i][j] = "#";
            }
        }
        return s;
    }

    public static void printBoard(String[][] board){
        System.out.print("  ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(" "+i+" ");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" "+board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static String[][] addShapes(GameData data, String[][] board){

        for (Cell c:data.getCellShape().keySet()) {

            Point p = Auxiliary.getIndexByCell(data.getBoard(), c);
            if(p == null)
                continue;
            Shape s = data.getCellShape().get(c);
            System.out.println(s);
            System.out.println();
            String clr = clrs.get(s.getC());
            String shp = shps.get(s.getT());

            board[p.x][p.y] = clr+shp+ANSI_RESET;
        }

        return board;
    }

    public static String[][] addOption(GameData data, String[][] board, List<Cell> options){
        for (Cell c:options) {
            Point p = Auxiliary.getIndexByCell(data.getBoard(), c);
            if(p == null)
                continue;

            if(data.getPlayerCells().get(data.getPlayers().peekLast()).contains(c)){
                Shape s = data.getCellShape().getOrDefault(c, null);
                if(s ==null)
                    continue;
                String shp = shps.get(s.getT());
                String clr = ANSI_RED;

                board[p.x][p.y] = clr+shp+ANSI_RESET;
            }else {
                board[p.x][p.y] = ANSI_GREEN+"#"+ANSI_RESET;
            }
        }
        return board;
    }

}
