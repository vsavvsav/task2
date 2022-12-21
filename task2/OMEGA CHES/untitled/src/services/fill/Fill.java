package services.fill;

import boar.Cell;
import boar.Direction;
import data.GameData;
import data.Player;
import services.move.*;
import shape.Color;
import shape.Shape;
import shape.TypeOfShape;

import java.util.*;

public class Fill {
    public static List<List<Cell>> createBoard(GameData data, int count){
        List<List<Cell>> cells = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cells.add(createHorisontalLine(count));
        }
        bindCells(cells);
        data.setBoard(cells.get(0).get(0));
        return cells;
    }

    public static void getData(GameData data){
        List<List<Cell>> cells = createBoard(data, 10);

        Player p1 = new Player("player1");
        Player p2 = new Player("player2");
        LinkedList<Player> ps = new LinkedList<>();
        ps.add(p1);
        ps.add(p2);

        data.setPlayers(ps);

        List<Cell> c1 = new ArrayList<>();
        c1.addAll(cells.get(0));
        c1.addAll(cells.get(1));

        List<Cell> c2 = new ArrayList<>();
        c2.addAll(cells.get(cells.size()-1));
        c2.addAll(cells.get(cells.size()-2));

        Map<Player, Color> pC = new HashMap<>();
        pC.put(p1, Color.BLACK);
        pC.put(p2, Color.WHITE);


        data.setPlayerSide(pC);

        Map<Player, List<Cell>> pCs = new HashMap<>();
        pCs.put(p1, c1);
        pCs.put(p2, c2);

        data.setPlayerCells(pCs);

        List<List<Cell>> cls = new ArrayList<>();

        cls.add(cells.get(1));
        cls.add(cells.get(0));

        List<Shape> dny = new ArrayList<>();

        data.setDontMovedYet(dny);

        Map<Cell, Shape> cS = new HashMap<>();

        arrangeFigure(data, cS, cls, p1);

        cls = new ArrayList<>();
        cls.add(cells.get(cells.size()-2));
        cls.add(cells.get(cells.size()-1));
        arrangeFigure(data, cS, cls, p2);

        data.setCellShape(cS);

        Map<Color, Direction> pD = new HashMap<>();

        pD.put(Color.BLACK, Direction.DOWN);
        pD.put(Color.WHITE, Direction.UP);

        data.setPawnDirection(pD);

        Map<Direction, List<Direction>> hD = new HashMap<>();

        hD.put(Direction.UP, List.of(Direction.LEFT, Direction.RIGHT));
        hD.put(Direction.DOWN, List.of(Direction.LEFT, Direction.RIGHT));
        hD.put(Direction.RIGHT, List.of(Direction.UP, Direction.DOWN));
        hD.put(Direction.LEFT, List.of(Direction.UP, Direction.DOWN));

        data.setHorseDirection(hD);


        Map<TypeOfShape, Map<Direction, Direction>> fd = new HashMap<>();

        fd.put(TypeOfShape.KING, Map.of(
                Direction.UP, Direction.RIGHT,
                Direction.RIGHT, Direction.DOWN,
                Direction.DOWN, Direction.LEFT,
                Direction.LEFT, Direction.UP));

        fd.put(TypeOfShape.ELEPHANT, Map.of(
                Direction.UP, Direction.RIGHT,
                Direction.RIGHT, Direction.DOWN,
                Direction.DOWN, Direction.LEFT,
                Direction.LEFT, Direction.UP));
        fd.put(TypeOfShape.ROOK, Map.of(
                Direction.UP, Direction.RIGHT,
                Direction.RIGHT, Direction.RIGHT,
                Direction.LEFT, Direction.RIGHT,
                Direction.DOWN, Direction.RIGHT
        ));
        fd.put(TypeOfShape.QUEEN, Map.of(
                Direction.UP, Direction.RIGHT,
                Direction.RIGHT, Direction.DOWN,
                Direction.DOWN, Direction.LEFT,
                Direction.LEFT, Direction.UP));

        data.setDirectionShapes(fd);

        Map<TypeOfShape, Move> move = new HashMap<>();


        move.put(TypeOfShape.QUEEN, new QueenMove());
        move.put(TypeOfShape.ROOK, new RookMove());
        move.put(TypeOfShape.KING, new KingMove());
        move.put(TypeOfShape.ELEPHANT, new ElephantMove());
        move.put(TypeOfShape.CHAMP, new ChempMove());
        move.put(TypeOfShape.HORSE, new HorseMove());
        move.put(TypeOfShape.WIZARD, new WizardMove());

        data.setMove(move);

    }

    public static List<Cell> createHorisontalLine(int count){
        List<Cell> cells = new ArrayList<>();

        cells.add(new Cell());

        for (int i = 1; i < count-1; i++) {
            Cell c = new Cell();
            c.add(cells.get(i-1), Direction.LEFT);
            cells.get(i-1).add(c, Direction.RIGHT);
            cells.add(c);
        }
        Cell c = new Cell();
        c.add(cells.get(cells.size()-1), Direction.LEFT);
        cells.get(cells.size()-1).add(c, Direction.RIGHT);
        cells.add(c);

        return cells;
    }

    public static void bindCells(List<List<Cell>> cells){
        for (int i = 1; i < cells.size(); i++) {
            for (int j = 0; j < cells.get(i).size(); j++) {
                Cell c1 = cells.get(i-1).get(j);
                Cell c2 = cells.get(i).get(j);
                c1.add(c2, Direction.DOWN);
                c2.add(c1, Direction.UP);
            }
        }
    }

    public static void arrangeFigure(GameData d, Map<Cell, Shape> cs, List<List<Cell>> cells, Player p){
        List<List<Shape>> shapes = new ArrayList<>();
        List<Shape> s = new ArrayList<>();
        Color c = d.getPlayerSide().get(p);
        for (int i = 0; i < 10; i++) {
            s.add(new Shape(TypeOfShape.PAWN, c));
        }
        shapes.add(s);
        d.getDontMovedYet().addAll(s);
        s = new ArrayList<>();

        s.add(new Shape(TypeOfShape.CHAMP, c));
        s.add(new Shape(TypeOfShape.ROOK, c));
        s.add(new Shape(TypeOfShape.HORSE, c));
        s.add(new Shape(TypeOfShape.ELEPHANT, c));
        s.add(new Shape(TypeOfShape.QUEEN, c));
        s.add(new Shape(TypeOfShape.KING, c));
        s.add(new Shape(TypeOfShape.ELEPHANT, c));
        s.add(new Shape(TypeOfShape.HORSE, c));
        s.add(new Shape(TypeOfShape.ROOK, c));
        s.add(new Shape(TypeOfShape.CHAMP, c));
        shapes.add(s);


        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < cells.get(i).size(); j++) {
                cs.put(cells.get(i).get(j), shapes.get(i).get(j));
            }
        }
    }

}
