package Class_260122;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameInputApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("입력 및 종료 예제");
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        JLabel label = new JLabel("이름 입력:");
        JTextField textField = new JTextField(15); // 약 15글자 너비

        JButton exitButton = new JButton("나가기");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 프로그램 종료 대화상자 (선택 사항)
                int confirm = JOptionPane.showConfirmDialog(frame,
                        "정말 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0); // 프로그램 종료
                }
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(exitButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
