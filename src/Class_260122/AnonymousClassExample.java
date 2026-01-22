package Class_260122;

import javax.swing.*;
import java.awt.event.*;

public class AnonymousClassExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("익명 클래스 예시");
        JButton button = new JButton("Exit");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(button);
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}