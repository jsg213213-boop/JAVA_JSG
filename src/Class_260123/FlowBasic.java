package Class_260123;

import javax.swing.*;
import java.awt.*;

public class FlowBasic {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout 기본");
        JPanel panel = new JPanel(new FlowLayout());

        JButton eventBtn = new JButton("이벤트 버튼");

        panel.add(new JButton("하나"));
        panel.add(new JButton("둘"));
        panel.add(new JButton("셋"));

        panel.add(eventBtn);
        eventBtn.addActionListener(e -> {
            System.out.println("이벤트 버튼 액션(트리거) 동작 확인. ");
        });

        frame.add(panel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}