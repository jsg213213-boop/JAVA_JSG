package Class_260123;

import javax.swing.*;
import java.awt.*;

public class Grid3x2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("3행 폼 만들기 (GridLayout)");

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        for (int i = 1; i <= 3; i++) {
            panel.add(new JLabel("항목 " + i));
            panel.add(new JTextField(5));
        }

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // 화면 중앙에 표시
        frame.setVisible(true);
    }
}