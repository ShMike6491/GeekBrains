package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;

    private boolean playerVsComp;
    private int size;
    private int wins;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;

    public BattleField( GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.BLACK);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if(!Logic.endGame) {
                    Logic.player( cellX, cellY);
                    if(Logic.endGame) {
                        gameWindow.callMessage();
                    }
                }

                repaint();
            }
        });
    }

    public void newGame(boolean playerVsComp, int size, int wins) {
        this.playerVsComp = playerVsComp;
        this.size = size;
        this.wins = wins;
        this.isInit = true;
        repaint(); // обновляет поле игры
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(!isInit) {
            return;
        }

        int panelWidth = getWidth(); // получаю ширену окна
        int panelHeight = getHeight();
        cellWidth = panelWidth/size; // нахожу параметры одной клетки
        cellHeight = panelHeight/size;

        int x, y;
        for (int i = 1; i < size; i++) {
            y = i * cellHeight;
            g.drawLine(0,y,panelWidth,y);

            x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if(Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }
    }

    void drawX(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        ((Graphics2D)g).setStroke(new BasicStroke(5));
        g.drawLine(x * cellWidth, y * cellHeight, (x+1) * cellWidth, (y+1) * cellHeight);
        g.drawLine((x+1)*cellWidth, y*cellHeight, x * cellWidth, (y+1) * cellHeight);
    }
    void drawO(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        ((Graphics2D)g).setStroke(new BasicStroke(5));
        g.drawOval(x * cellWidth, y * cellHeight,  cellWidth, cellHeight);
    }
}
