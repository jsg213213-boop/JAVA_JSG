package Class_260123;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlowLayout_Ex {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout 실습");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);

        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel label = new JLabel("이름");
        JTextField textField = new JTextField(8);
        JButton searchBtn = new JButton("검색");

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                System.out.println("검색어: " + input);
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(searchBtn);

        frame.setVisible(true);
    }
}