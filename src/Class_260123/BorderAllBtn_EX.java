package Class_260123;

import javax.swing.*;
import java.awt.*;

public class BorderAllBtn_EX {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout 모든영역 실습");
        frame.setLayout(new BorderLayout());

        frame.add(new JLabel("헤더", SwingConstants.CENTER), BorderLayout.NORTH);
        frame.add(new JButton("확인"), BorderLayout.SOUTH);
        frame.add(new JTextField("입력"), BorderLayout.EAST);
        frame.add(new JCheckBox("선택"), BorderLayout.WEST);
        frame.add(new JTextArea(4, 12), BorderLayout.CENTER);

        frame.setSize(350, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}