package lesson8;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    static final int WINDOW_X = GameWindow.WINDOW_X+50;
    static final int WINDOW_Y = GameWindow.WINDOW_Y+50;
    static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH-100;
    static final int WINDOW_HEIGHT = 450;

    private int MIN_SIZE = 3;
    private int MAX_SIZE = 10;

    private GameWindow link;

    private JRadioButton jrbHvsComp;
    private JRadioButton jrbHvsH;
    private ButtonGroup buttonGroupGameMode;
    private JSlider slidSize;
    private JSlider slidWins;

    public SettingsWindow(GameWindow mainWindow) {
        this.link = mainWindow;
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Game settings");

        setLayout(new GridLayout(8, 1)); // параметры располжения (Layout)
        add(new JLabel("Game mode setup:")); // заголовок

        jrbHvsComp = new JRadioButton("Player vs Computer", true);
        jrbHvsH = new JRadioButton("Player vs Player");
        buttonGroupGameMode = new ButtonGroup(); // нужно для объединения радиокнопок в группу
        slidSize = new JSlider(MIN_SIZE, MAX_SIZE, MIN_SIZE); // инициализация слайдера для размера поля
        slidWins = new JSlider(MIN_SIZE, MIN_SIZE, MIN_SIZE);
        JButton btnSend = new JButton("Ok");

        slidSize.setMajorTickSpacing(1);
        slidSize.setPaintLabels(true);
        slidSize.setPaintTicks(true); // задаваемые настройки слайдера

        slidWins.setMajorTickSpacing(1);
        slidWins.setPaintLabels(true);
        slidWins.setPaintTicks(true);

        slidSize.addChangeListener(e -> {
            slidWins.setMaximum(slidSize.getValue());
        }); // устанавливаем максимальное значение для dots to win поля за счет изменения выбранного значения размера

        add(jrbHvsComp); // добавить кнопку в окно
        add(jrbHvsH);

        buttonGroupGameMode.add(jrbHvsComp);
        buttonGroupGameMode.add(jrbHvsH);

        //jrbHvsH.setEnabled(false); // не дает возможность выбрать вариант

        add(new JLabel("Field size setup:"));
        add(slidSize);

        add(new JLabel("Dots to win setup:"));
        add(slidWins);

        add(btnSend);
        btnSend.addActionListener(e -> {
            boolean playerVsComp = jrbHvsComp.isSelected();
            int size = slidSize.getValue();
            int wins = slidWins.getValue();

            Logic.mapInit(playerVsComp, size, wins);

            link.newGame(playerVsComp, size, wins);
            setVisible(false);
        });

        setVisible(false);
    }
}
