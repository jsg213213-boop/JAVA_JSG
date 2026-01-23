package Class_260123;

import javax.swing.*;
import java.awt.*;

public class Grid3x1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("3x1 Grid");
        JPanel panel = new JPanel(new GridLayout(3, 1));

        panel.add(new JLabel("이름"));
        panel.add(new JTextField(8));
        panel.add(new JButton("확인"));
        frame.add(panel);

        frame.setSize(250, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}