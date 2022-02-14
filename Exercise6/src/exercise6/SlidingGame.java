package exercise6;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class SlidingGame implements Configuration {

    public static final int N = 3, SIZE = N * N, HOLE = SIZE;
    /**
     * The board is represented by a 2-dimensional array; the position of the
     * hole is kept in 2 variables holeX and holeY
     */
    private final int[][] board;
    private int holeX, holeY;
    private final Configuration parent;

    /**
     * A constructor that initializes the board with the specified array
     *
     * @param start: a one dimensional array containing the initial board. The
     * elements of start are stored row-wise.
     * @param parent: a sliding game containing the previous board-state
     */
    public SlidingGame(int[] start, Configuration parent) {
        board = new int[N][N];
        this.parent = parent;

        assert start.length == N * N : "Length of specified board incorrect";

        for (int p = 0; p < start.length; p++) {
            board[p % N][p / N] = start[p];
            if (start[p] == HOLE) {
                holeX = p % N;
                holeY = p / N;
            }
        }
    }

    /**
     * Converts a board into a printable representation. The hole is displayed
     * as a space
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int puzzel = board[col][row];
                buf.append(puzzel == HOLE ? "  " : puzzel + " ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    @Override
    public boolean equals(Object o) { //
        if (o instanceof SlidingGame) {
            SlidingGame slide = SlidingGame.class.cast(o);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != slide.getBoard()[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public int[][] getBoard() {
        return this.board;
    }

    @Override
    public boolean isSolution() {
        int counter = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != counter && (i != N - 1 || j != N - 1)) {
                    return false;
                }
                counter++;
            }
        }
        return true;
    }

    @Override
    public Collection<Configuration> successors() {
        //Q: GOAL is a final int, but a successor doesn't have its hole on 
        //position SIZE, so how do we edit that? Do we make a class "successor"
        //which is just a copy of slidingGame but with a different constructor?
        //Or are we allowed to put a second constructor in here which also has
        //a parent configuration?
        ArrayList<Configuration> successors = new ArrayList<>();
        ArrayList<Direction> legalDirections = new ArrayList<>();
        if (holeX > 0) {
            legalDirections.add(Direction.WEST);
        }
        if (holeX < N - 1) {
            legalDirections.add(Direction.EAST);
        }
        if (holeY > 0) {
            legalDirections.add(Direction.NORTH);
        }
        if (holeY < N - 1) {
            legalDirections.add(Direction.SOUTH);
        }

        for (int i = 0; i < legalDirections.size(); i++) {
            successors.add(new SlidingGame(move(legalDirections.get(i)), this));
        }
        return successors;
    }

    public int[] move(Direction direction) {
        int[] temp = new int[N * N];
        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                temp[counter] = board[j][i];
                counter++;
            }
        }

        temp[N * holeY + holeX] = temp[N * (holeY + direction.getDY()) + holeX + direction.getDX()];
        temp[N * (holeY + direction.getDY()) + holeX + direction.getDX()] = SIZE;

        return temp;
    }

    @Override
    public int compareTo(Configuration g) { //why is this function exist?
        throw new UnsupportedOperationException("compareTo : not supported yet.");
    }

    @Override
    public Configuration parent() { //How do you do this, isn't it easier to 
        //make parent an attribute?
        return this.parent;
    }

}
