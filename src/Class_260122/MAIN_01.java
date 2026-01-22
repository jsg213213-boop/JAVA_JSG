package Class_260122;

import javax.swing.*;

public class MAIN_01 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Hello GUI");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("클릭하세요");
        frame.add(button);

        frame.setVisible(true);
    }
}