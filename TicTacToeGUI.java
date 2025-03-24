import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TicTacToeGUI builds and displays the window, setting up the game.
 */
public class TicTacToeGUI extends JFrame {
    private final TicTacToeBoard board;
    private final TicTacToeGame game;
    private final JButton playAgainButton;

    public TicTacToeGUI() {
        super("Tic Tac Toe - OOP");
        board = new TicTacToeBoard();
        game = new TicTacToeGame(board);
        playAgainButton = new JButton("Play Again");
        setupUI();
    }

    private void setupUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                TicTacToeTile tile = board.getTile(row, col);
                gridPanel.add(tile);
                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!game.isGameOver() && tile.getText().equals(" ")) {
                            game.playTurn(tile.getRow(), tile.getCol());
                            if (game.isGameOver()) {
                                playAgainButton.setEnabled(true);
                            }
                        }
                    }
                });
            }

        playAgainButton.setEnabled(false); // Only enabled after game ends
        playAgainButton.addActionListener(e -> {
            game.resetGame();
            playAgainButton.setEnabled(false);
        });

        add(gridPanel, BorderLayout.CENTER);
        add(playAgainButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}
