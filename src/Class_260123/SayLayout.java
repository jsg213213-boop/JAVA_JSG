package Class_260123;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SayLayout {
    public static void main(String[] args) {

        JFrame frame = new JFrame("배치 연습");
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("이름");
        nameLabel.setBounds(15, 15, 50, 25);

        JLabel ageLabel = new JLabel("나이");
        ageLabel.setBounds(15, 50, 50, 25);

        JTextField nameField = new JTextField();
        nameField.setBounds(70, 15, 100, 25);

        JTextField ageField = new JTextField();
        ageField.setBounds(70, 50, 100, 25);

        JButton confirmBtn = new JButton("확인");
        confirmBtn.setBounds(110, 90, 100, 30);


        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String age = ageField.getText();

                System.out.println("이름: " + name);
                System.out.println("나이: " + age);
                System.out.println("-----------------");
            }
        });

        frame.add(nameLabel);
        frame.add(ageLabel);
        frame.add(nameField);
        frame.add(ageField);
        frame.add(confirmBtn);

        frame.setSize(250, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}