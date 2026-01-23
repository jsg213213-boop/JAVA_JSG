package Class_260123;

import javax.swing.*;
import java.awt.*;

public class FlowLeftGap {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout 왼쪽정렬+간격");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));

        panel.add(new JButton("A"));
        panel.add(new JButton("B"));
        panel.add(new JButton("C"));

        frame.add(panel);
        frame.setSize(350, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
