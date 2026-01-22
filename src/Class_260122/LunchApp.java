package Class_260122;
import javax.swing.*;

public class LunchApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("오늘의 점심 메뉴");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel label = new JLabel("오늘 점심: 한우소고기국밥");
        panel.add(label);

        JButton button = new JButton("메뉴 결정!");
        panel.add(button);

        frame.add(panel);

        frame.setVisible(true);
    }
}
