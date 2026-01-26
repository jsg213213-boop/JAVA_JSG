package Class_260126;

import javax.swing.*;
import java.awt.*;

class Subway {
    String lineName;
    String lineColor;
    String operator;
    String models;
    String inverter;
    String trainRange;

    public Subway(String lineName, String lineColor, String operator, String models, String inverter, String trainRange) {
        this.lineName = lineName;
        this.lineColor = lineColor;
        this.operator = operator;
        this.models = models;
        this.inverter = inverter;
        this.trainRange = trainRange;
    }

    public String getInfoString() {
        return "--- " + lineName + " [" + operator + "] ---\n" +
                "노선 색상 : " + (lineColor != null ? lineColor : "정보 없음") + "\n" +
                "제어 소자 : " + inverter + "\n" +
                "주요 차종 : " + models + "\n" +
                "편성 정보 : " + trainRange + "\n" +
                "------------------------------------------\n";
    }
}

public class CapitalAreaSubway_GUI extends JFrame {
    private JTextField searchField;
    private JTextArea resultArea;
    private Subway[] subways;
    private Font guiFont = new Font("맑은 고딕", Font.PLAIN, 13);

    public CapitalAreaSubway_GUI() {
        initializeSubwayData();

        setTitle("수도권 지하철 정보 시스템 (노선 완전 분리판)");
        setSize(950, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        JLabel label = new JLabel("노선 이름 입력: ");
        label.setFont(guiFont);
        searchField = new JTextField();
        JButton searchButton = new JButton("검색");
        searchButton.setFont(guiFont);

        topPanel.add(label, BorderLayout.WEST);
        topPanel.add(searchField, BorderLayout.CENTER);
        topPanel.add(searchButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 2, 2));
        String[] quickButtons = {
                "1호선", "2호선", "3호선", "4호선", "5호선", "6호선", "7호선", "8호선", "9호선",
                "인천 1호선", "인천 2호선", "신분당선", "수인분당선", "경의중앙선", "경춘선", "경강선", "서해선",
                "공항철도", "김포골드선", "우이신설선", "에버라인", "GTX-A"
        };

        for (String btnText : quickButtons) {
            JButton btn = new JButton(btnText);
            btn.setFont(guiFont);
            btn.addActionListener(e -> {
                searchField.setText(btnText);
                searchSubway(btnText); // 버튼 텍스트와 정확히 일치하는 것만 검색
            });
            buttonPanel.add(btn);
        }

        JScrollPane buttonScroll = new JScrollPane(buttonPanel);
        buttonScroll.setPreferredSize(new Dimension(180, 0));

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(guiFont);
        JScrollPane mainScroll = new JScrollPane(resultArea);
        mainScroll.setBorder(BorderFactory.createTitledBorder("상세 제원 정보"));

        add(topPanel, BorderLayout.NORTH);
        add(buttonScroll, BorderLayout.WEST);
        add(mainScroll, BorderLayout.CENTER);

        searchButton.addActionListener(e -> searchSubway(searchField.getText().trim()));
        searchField.addActionListener(e -> searchSubway(searchField.getText().trim()));

        setVisible(true);
    }

    private void searchSubway(String keyword) {
        if (keyword.isEmpty()) return;
        resultArea.setText("");
        boolean found = false;

        for (Subway s : subways) {
            if (s.lineName.equals(keyword)) {
                String info = s.getInfoString();
                resultArea.append(info + "\n");
                System.out.print(info);
                found = true;
            }
        }

        if (!found) {
            for (Subway s : subways) {
                if (s.lineName.contains(keyword)) {
                    String info = s.getInfoString();
                    resultArea.append(info + "\n");
                    System.out.print(info);
                    found = true;
                }
            }
        }

        if (!found) resultArea.setText("정보를 찾을 수 없습니다.");
        resultArea.setCaretPosition(0);
    }

    private void initializeSubwayData() {
        subways = new Subway[]{
                new Subway("1호선", "남색/빨간색", "서울교통공사", "개조저항, VVVF-GTO",
                        "GTO & 저항제어", "101~116"),
                new Subway("1호선", "남색/빨간색", "코레일", "뱀눈이 동글이 납작이",
                        "GTO & IGBT","311x01~311x90/312x01~312x09"),
                new Subway("2호선", "초록색", "서울교통공사", "로템/다원시스/GEC",
                        "IGBT/GEC-Chopper", "201~295"),
                new Subway("3호선", "주황색", "서울교통공사/코레일", "로템/GEC/미쓰비시",
                        "IGBT/GEC-Chopper/GTO", "301~388"),
                new Subway("4호선", "파란색", "서울교통공사/코레일", "현대/대우/동글이",
                        "GTO/IGBT", "401~463, 341x01~341x59"),
                new Subway("5호선", "보라색", "서울교통공사", "현대정공/로템",
                        "GTO(ABB) & IGBT", "501~580"),
                new Subway("6호선", "봉숭아색", "서울교통공사", "현대정공",
                        "IGBT", "601~639"),
                new Subway("7호선", "진녹색", "서울교통공사", "현대/대우/로템",
                        "알스톰 GTO & IGBT", "701~770"),
                new Subway("8호선", "분홍색", "서울교통공사", "현대/대우",
                        "알스톰 GTO & IGBT", "801~820"),
                new Subway("9호선", "황금색", "메트로9호선", "현대로템",
                        "IGBT", "901~953"),
                new Subway("인천 1호선", "하늘색", "인천교통공사", "대우/로템",
                        "알스톰 GTO & IGBT", "101~134"),
                new Subway("인천 2호선", "주황색", "인천교통공사", "현대로템",
                        "IGBT", "201~237"),
                new Subway("신분당선", "빨간색", "신분당선(주)", "현대로템",
                        "IGBT", "D01~D23"),
                new Subway("수인분당선", "노란색", "코레일", "뱀눈이/동글이/납작이",
                        "GTO/IGBT", "351x01~351x79"),
                new Subway("경의중앙선", "코레일블루/빨간색", "코레일", "뱀눈이",
                        "IGBT", "321x01~321x29/331x01~331x27"),
                new Subway("경춘선", "청록색/파란색", "코레일", "뱀눈이/ITX",
                        "IGBT", "361x01~361x15"),
                new Subway("경강선", "청강색", "코레일", "뱀눈이",
                        "IGBT", "371x01~371x15"),
                new Subway("서해선", "연두색", "서해철도/코레일", "뱀눈이/다원시스",
                        "IGBT", "391x01~391x17"),
                new Subway("공항철도", "바다색", "공항철도(주)", "현대로템",
                        "IGBT", "101~122 / 201~219"),
                new Subway("김포골드선", "금색", "김포골드라인", "현대로템 K-AGT",
                        "IGBT", "1001~1023"),
                new Subway("우이신설선", "연두색", "우이신설경전철", "우진산전 K-AGT",
                        "IGBT", "UL01~UL18"),
                new Subway("에버라인", "연한 녹색", "용인경량전철", "봄바디어",
                        "IGBT", "101~130"),
                new Subway("GTX-A", "보라색", "SG레일/코레일", "현대로템",
                        "IGBT", "A01~A20")
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CapitalAreaSubway_GUI::new);
    }
}