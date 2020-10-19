package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Message extends JDialog {
    static final int WINDOW_X = GameWindow.WINDOW_X+120;
    static final int WINDOW_Y = GameWindow.WINDOW_Y+110;
    static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH-100;
    static final int WINDOW_HEIGHT = 450;

    public Message(Frame owner) {
        super(owner, "", true);

        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        add(new JLabel(Logic.winner), BorderLayout.CENTER);

        JButton ok = new JButton("Ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        setSize(260,160);
    }
}
