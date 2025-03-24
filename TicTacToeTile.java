import javax.swing.JButton;

/**
 * TicTacToeTile represents a single cell on the Tic Tac Toe board.
 */
public class TicTacToeTile extends JButton {
    private final int row;
    private final int col;

    public TicTacToeTile(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        this.setText(" ");
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
