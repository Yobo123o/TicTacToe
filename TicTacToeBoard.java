import javax.swing.JOptionPane;

/**
 * TicTacToeBoard manages the 3x3 grid of TicTacToeTiles.
 */
public class TicTacToeBoard {
    private final TicTacToeTile[][] tiles = new TicTacToeTile[3][3];

    public TicTacToeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                tiles[row][col] = new TicTacToeTile(row, col);
            }
        }
    }

    public TicTacToeTile getTile(int row, int col) {
        return tiles[row][col];
    }

    public String getTileText(int row, int col) {
        return tiles[row][col].getText();
    }

    public void setTileText(int row, int col, String text) {
        tiles[row][col].setText(text);
    }

    public void clearBoard() {
        for (TicTacToeTile[] row : tiles)
            for (TicTacToeTile tile : row)
                tile.setText(" ");
    }

    public boolean isBoardFull() {
        for (TicTacToeTile[] row : tiles)
            for (TicTacToeTile tile : row)
                if (tile.getText().equals(" ")) return false;
        return true;
    }

    public boolean checkWin(String player) {
        return checkRows(player) || checkCols(player) || checkDiagonals(player);
    }

    private boolean checkRows(String player) {
        for (int row = 0; row < 3; row++)
            if (tiles[row][0].getText().equals(player) &&
                    tiles[row][1].getText().equals(player) &&
                    tiles[row][2].getText().equals(player))
                return true;
        return false;
    }

    private boolean checkCols(String player) {
        for (int col = 0; col < 3; col++)
            if (tiles[0][col].getText().equals(player) &&
                    tiles[1][col].getText().equals(player) &&
                    tiles[2][col].getText().equals(player))
                return true;
        return false;
    }

    private boolean checkDiagonals(String player) {
        return (tiles[0][0].getText().equals(player) &&
                tiles[1][1].getText().equals(player) &&
                tiles[2][2].getText().equals(player)) ||

                (tiles[0][2].getText().equals(player) &&
                        tiles[1][1].getText().equals(player) &&
                        tiles[2][0].getText().equals(player));
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
