package Class_260126;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// 기존 Car 클래스 유지 (출력 방식만 GUI에 맞게 응용 가능)
class Car {
    String modelName;
    int modelYear;
    String category;

    public Car(String modelName, int modelYear, String category) {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.category = category;
    }

    // 정보를 문자열로 반환하는 메서드 추가 (GUI 출력용)
    public String getInfo() {
        return String.format("--- 모델 상세 정보 ---\n모델명 : %s\n연식   : %d년형\n차종   : %s\n",
                modelName, modelYear, category);
    }
}

public class _1_Hyundai_GUI extends JFrame {
    private JTextArea displayArea; // 정보를 보여줄 공간

    public _1_Hyundai_GUI() {
        // 1. 기본 프레임 설정
        setTitle("현대자동차 모델 조회 시스템");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 2. 자동차 데이터 리스트 생성
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("스타리아", 2026, "승합차"));
        carList.add(new Car("코나", 2026, "소형 SUV"));
        carList.add(new Car("팰리세이드", 2026, "대형 SUV"));
        carList.add(new Car("투싼", 2026, "준중형 SUV"));
        carList.add(new Car("싼타페", 2026, "중형 SUV"));
        carList.add(new Car("아이오닉5", 2026, "준중형 SUV(전기차)"));
        carList.add(new Car("아이오닉6", 2026, "중형 세단(전기차)"));
        carList.add(new Car("제네시스G80", 2026, "대형 세단"));
        carList.add(new Car("베뉴", 2026, "소형 SUV"));
        carList.add(new Car("캐스퍼", 2026, "경형 SUV"));
        carList.add(new Car("그랜저", 2026, "대형 세단"));
        carList.add(new Car("아반떼", 2026, "준중형 세단"));
        carList.add(new Car("쏘나타", 2026, "중형 세단"));

        // 3. 버튼을 배치할 패널 (Grid Layout 사용)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 3, 5, 5)); // 3열로 자동 배치

        // 4. 중앙 출력창 설정
        displayArea = new JTextArea("조회하고 싶은 모델 버튼을 클릭하세요.\n");
        displayArea.setEditable(false);
        displayArea.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // 5. 반복문을 통해 버튼 생성 및 이벤트 연결
        for (Car car : carList) {
            JButton button = new JButton(car.modelName);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 버튼 클릭 시 콘솔에 출력
                    System.out.println(car.getInfo());
                    // 버튼 클릭 시 GUI 텍스트 영역에 출력
                    displayArea.setText(car.getInfo());
                }
            });
            buttonPanel.add(button);
        }

        // 6. 컴포넌트 배치
        add(new JLabel("현대자동차 라인업 (2026)", SwingConstants.CENTER), BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // 하단 텍스트 영역 크기 조절
        scrollPane.setPreferredSize(new Dimension(600, 150));

        setVisible(true);
    }

    public static void main(String[] args) {
        // GUI 실행
        SwingUtilities.invokeLater(() -> new _1_Hyundai_GUI());
    }
}
