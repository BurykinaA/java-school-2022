package Task19;//package week8.task19;

import javax.swing.*;
import java.awt.*;

public class Task19 {
    public static void main(String[] args) {
        JFrame window = new JFrame("Вывод информации не в консоль");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(500, 600));
        window.setVisible(true);

        JPanel panel = new JPanel();
        panel.setVisible(true);
        window.add(panel);

        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(400, 500));
        label.setText("<html>"
                + "<h3>Hello World</h3>"
                + "</html>");
        panel.add(label);

        window.pack();
        label.setVisible(true);

        //window.pack();

    }
}