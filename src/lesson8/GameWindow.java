package lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame{ // расширяется от класса для создания окна
    static final int WINDOW_X = 300;
    static final int WINDOW_Y = 150;
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555; // задаю параметры размеров

    private SettingsWindow settings;
    private BattleField gamePanel;

    public GameWindow() {
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // инициализирую основные настройки

        settings = new SettingsWindow(this); // передаю ссылки и инициалиирую окно
        gamePanel = new BattleField(this); // ссылки для того чтобы потом управлять окном

        add(gamePanel, BorderLayout.CENTER); // добавляю игровое поле в центр

        JPanel panel = new JPanel(new GridLayout(1,2)); // отдельная панель для кнопок
        JButton buttonStartGame = new JButton("Start new game"); // создание кнопки с описанием
        panel.add(buttonStartGame); // добавляю кнопку в панель
        buttonStartGame.addActionListener(e -> {
            settings.setVisible(true); // функция кнопки
        });

        JButton buttonExit = new JButton("Exit game");
        panel.add(buttonExit);
        buttonExit.addActionListener(e -> {
            System.exit(0);
        });

        add(panel, BorderLayout.SOUTH); // добавляю панель вниз

        setVisible(true); // видимость окна
    }

    public void newGame(boolean playerVsComp, int size, int wins) {
        gamePanel.newGame( playerVsComp, size, wins);
    }

    public void callMessage() {
        JDialog dialog = new Message(this);
        dialog.setVisible(true);
    }
}
