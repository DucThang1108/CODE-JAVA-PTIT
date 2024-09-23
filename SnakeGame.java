
package code.ptitv2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class SnakeGame extends JFrame implements ActionListener, KeyListener {
    private static final int GRID_SIZE = 20;
    private static final int TILE_SIZE = 20;

    private Timer timer;
    private LinkedList<Point> snake;
    private Point food;

    private int direction; // 0: right, 1: down, 2: left, 3: up

    public SnakeGame() {
        setTitle("Snake Game");
        setSize(GRID_SIZE * TILE_SIZE, GRID_SIZE * TILE_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        snake = new LinkedList<>();
        snake.add(new Point(5, 5));
        direction = 0;

        spawnFood();

        timer = new Timer(100, this);
        timer.start();

        addKeyListener(this);
        setFocusable(true);
    }

    private void spawnFood() {
        int x = (int) (Math.random() * GRID_SIZE);
        int y = (int) (Math.random() * GRID_SIZE);
        food = new Point(x, y);
    }

    private void move() {
        Point head = snake.getFirst();

        switch (direction) {
            case 0:
                head = new Point((head.x + 1) % GRID_SIZE, head.y);
                break;
            case 1:
                head = new Point(head.x, (head.y + 1) % GRID_SIZE);
                break;
            case 2:
                head = new Point((head.x - 1 + GRID_SIZE) % GRID_SIZE, head.y);
                break;
            case 3:
                head = new Point(head.x, (head.y - 1 + GRID_SIZE) % GRID_SIZE);
                break;
        }

        if (head.equals(food)) {
            snake.addFirst(food);
            spawnFood();
        } else {
            snake.addFirst(head);
            snake.removeLast();
        }
    }

    private boolean checkCollision() {
        Point head = snake.getFirst();
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                return true; // Snake collided with itself
            }
        }
        return false;
    }

    private void checkGameOver() {
        if (checkCollision()) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    private void checkWin() {
        if (snake.size() == GRID_SIZE * GRID_SIZE) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "You Win!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        checkGameOver();
        checkWin();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && (direction != 0)) {
            direction = 2;
        } else if ((key == KeyEvent.VK_RIGHT) && (direction != 2)) {
            direction = 0;
        } else if ((key == KeyEvent.VK_UP) && (direction != 1)) {
            direction = 3;
        } else if ((key == KeyEvent.VK_DOWN) && (direction != 3)) {
            direction = 1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0, 0, getWidth(), getHeight());

        // Draw snake
        g.setColor(Color.GREEN);
        for (Point point : snake) {
            g.fillRect(point.x * TILE_SIZE, point.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        // Draw food
        g.setColor(Color.RED);
        g.fillRect(food.x * TILE_SIZE, TILE_SIZE * food.y, TILE_SIZE, TILE_SIZE);

        Toolkit.getDefaultToolkit().sync();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SnakeGame game = new SnakeGame();
            game.setVisible(true);
        });
    }
}