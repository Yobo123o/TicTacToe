/**
 * TicTacToeGame handles game logic and controls the turn cycle.
 */
public class TicTacToeGame {
    private String currentPlayer;
    private boolean gameOver;
    private final TicTacToeBoard board;

    public TicTacToeGame(TicTacToeBoard board) {
        this.board = board;
        resetGame();
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void resetGame() {
        currentPlayer = "X";
        gameOver = false;
        board.clearBoard();
    }

    public void playTurn(int row, int col) {
        if (!gameOver && board.getTileText(row, col).equals(" ")) {
            board.setTileText(row, col, currentPlayer);
            if (board.checkWin(currentPlayer)) {
                gameOver = true;
                board.showMessage("Player " + currentPlayer + " wins!");
            } else if (board.isBoardFull()) {
                gameOver = true;
                board.showMessage("It's a tie!");
            } else {
                togglePlayer();
            }
        }
    }

    private void togglePlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }
}
