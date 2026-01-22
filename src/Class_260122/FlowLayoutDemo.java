package Class_260122;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Demo");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JButton("A"));
        panel.add(new JButton("B"));
        panel.add(new JButton("C"));
        frame.add(panel);
        frame.setSize(300, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}