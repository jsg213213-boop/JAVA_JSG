package Class_260123;

import javax.swing.*;
import java.awt.*;

public class NullPanel {
    public static void main(String[] args) {

        JFrame frame = new JFrame("패널 좌표배치");

        frame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.ORANGE);

        panel.setPreferredSize(new Dimension(180,50));

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.RED);
        panel2.setPreferredSize(new Dimension(180,50));

        JLabel lbl = new JLabel("Label");
        lbl.setBounds(15, 10, 60, 25);
        JButton btn = new JButton("버튼");
        btn.setBounds(80, 10, 80, 25);

        panel.add(lbl);
        panel.add(btn);

        JLabel lbl2 = new JLabel("Label");
        lbl2.setBounds(30, 10, 60, 25);
        JButton btn2 = new JButton("버튼");
        btn2.setBounds(80, 10, 80, 25);

        panel2.add(lbl2);
        panel2.add(btn2);

        frame.add(panel);
        frame.add(panel2);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}