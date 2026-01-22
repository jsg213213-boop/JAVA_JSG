package Class_260122;
import javax.swing.*;
public class MAIN_03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Label Example");
        JLabel label = new JLabel("Hello, Swing!");
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
