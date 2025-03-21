package janggi.piece;

import janggi.setting.CampType;
import janggi.value.Position;
import java.util.List;

public class Gung implements Piece {

    private static final int score = 0;
    private static final int height = 1;
    private static final List<Integer> xPositions = List.of(4);

    private final PieceType pieceType;
    private final Position position;

    private Gung(final Position position) {
        this.pieceType = PieceType.GUNG;
        this.position = position;
    }

    public static Gung from(final Position position) {
        return new Gung(position);
    }

    public static List<Gung> generateInitialGung(final CampType campType) {
        int yPosition = Math.abs(campType.getStartYPosition() - height);
        return xPositions.stream()
                .map(xPosition -> new Gung(new Position(xPosition, yPosition)))
                .toList();
    }

    @Override
    public Gung move(final Position destination, final List<Piece> enemy, final List<Piece> allies) {
        boolean isAble = ableToMove(destination, enemy, allies);
        if (!isAble) {
            throw new IllegalArgumentException("[ERROR] 이동이 불가능합니다.");
        }
        return new Gung(destination);
    }

    @Override
    public boolean ableToMove(Position destination, List<Piece> enemy, List<Piece> allies) {
        if (!isRuleOfMove(destination)) {
            return false;
        }
        return isNotHurdle(destination, allies);
    }

    private boolean isRuleOfMove(Position destination) {
        return destination.equals(new Position(position.getX() - 1, position.getY()))
                || destination.equals(new Position(position.getX() + 1, position.getY()))
                || destination.equals(new Position(position.getX(), position.getY() - 1))
                || destination.equals(new Position(position.getX(), position.getY() + 1));
    }

    private boolean isNotHurdle(Position destination, List<Piece> allies) {
        return allies.stream()
                .noneMatch(piece -> piece.getPosition().equals(destination));
    }

    @Override
    public boolean checkPieceType(PieceType pieceType) {
        return this.pieceType == pieceType;
    }


    @Override
    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
