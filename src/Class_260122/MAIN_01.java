package Class_260122;

import javax.swing.*;

public class MAIN_01 {
    public static void main(String[] args) {
        // 프레임(창) 생성
        JFrame frame = new JFrame("Hello GUI");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 버튼 추가
        JButton button = new JButton("클릭하세요");
        frame.add(button);

        // 화면에 표시
        frame.setVisible(true);
    }
}