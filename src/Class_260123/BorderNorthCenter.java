package Class_260123;

import javax.swing.*;
import java.awt.*;

public class BorderNorthCenter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout 일부영역");
        frame.setLayout(new BorderLayout());

        frame.add(new JLabel("제목", SwingConstants.CENTER), BorderLayout.NORTH);
        frame.add(new JTextArea(5, 20), BorderLayout.CENTER);

        frame.setSize(300, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}