package data;

import boar.Cell;
import boar.Direction;
import services.move.Move;
import shape.Color;
import shape.Shape;
import shape.TypeOfShape;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameData {
    private Cell board;//+
    private LinkedList<Player> players;//+
    private Map<Player, List<Cell>> playerCells;//+
    private Map<Cell, Shape> cellShape;//+
    private Map<TypeOfShape, Map<Direction, Direction>> directionShapes;//+

    private Map<Direction, List<Direction>> horseDirection;//+

    private Map<Color, Direction> pawnDirection;//+

    private Map<Player, Color> playerSide;//+

    private List<Shape> dontMovedYet;//+

    private Map<TypeOfShape, Move> move;

    public GameData() {
    }

    public Map<TypeOfShape, Move> getMove() {
        return move;
    }

    public void setMove(Map<TypeOfShape, Move> move) {
        this.move = move;
    }

    public Cell getBoard() {
        return board;
    }

    public void setBoard(Cell board) {
        this.board = board;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public Map<Player, List<Cell>> getPlayerCells() {
        return playerCells;
    }

    public void setPlayerCells(Map<Player, List<Cell>> playerCells) {
        this.playerCells = playerCells;
    }

    public Map<Cell, Shape> getCellShape() {
        return cellShape;
    }

    public void setCellShape(Map<Cell, Shape> cellShape) {
        this.cellShape = cellShape;
    }

    public List<Shape> getDontMovedYet() {
        return dontMovedYet;
    }

    public void setDontMovedYet(List<Shape> dontMovedYet) {
        this.dontMovedYet = dontMovedYet;
    }

    public Map<TypeOfShape, Map<Direction, Direction>> getDirectionShapes() {
        return directionShapes;
    }

    public void setDirectionShapes(Map<TypeOfShape, Map<Direction, Direction>> directionShapes) {
        this.directionShapes = directionShapes;
    }

    public Map<Direction, List<Direction>> getHorseDirection() {
        return horseDirection;
    }

    public void setHorseDirection(Map<Direction, List<Direction>> horseDirection) {
        this.horseDirection = horseDirection;
    }

    public Map<Color, Direction> getPawnDirection() {
        return pawnDirection;
    }

    public void setPawnDirection(Map<Color, Direction> pawnDirection) {
        this.pawnDirection = pawnDirection;
    }

    public Map<Player, Color> getPlayerSide() {
        return playerSide;
    }

    public void setPlayerSide(Map<Player, Color> playerSide) {
        this.playerSide = playerSide;
    }
}
