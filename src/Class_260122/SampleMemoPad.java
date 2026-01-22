package Class_260122;
import javax.swing.*;
import java.awt.*;

public class SampleMemoPad {
    public static void main(String[] args) {
        JFrame frame = new JFrame("간단한 메모장");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea); // 내용이 많아질 경우를 대비해 스크롤 추가

        JPanel panel = new JPanel();
        JButton saveButton = new JButton("저장");

        saveButton.addActionListener(e -> {
            String content = textArea.getText();
            System.out.println("--- 저장된 내용 ---");
            System.out.println(content);
            System.out.println("-----------------");

            JOptionPane.showMessageDialog(frame, "콘솔에 저장되었습니다!");
        });

        panel.add(saveButton);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
