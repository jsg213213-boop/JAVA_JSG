package Class_260127;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// 1. 회원 정보 클래스
class MemberBase {
    protected String name, email, password;
    protected int age;

    public MemberBase(String name, String email, String password, int age) {
        this.name = name; this.email = email; this.password = password; this.age = age;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public int getAge() { return age; }
    public void setName(String name) { this.name = name; }
    public void setPassword(String password) { this.password = password; }
    public void setAge(int age) { this.age = age; }
}

class NormalMember extends MemberBase {
    public NormalMember(String name, String email, String password, int age) {
        super(name, email, password, age);
    }
}

// 2. 메인 GUI 클래스
public class MainClass_GUI_03 {
    private static MemberBase loggedInMember = null;
    private static JFrame frame;
    private static JTextArea textArea;
    private static JLabel statusLabel;
    private static JButton[] buttons = new JButton[6];

    public static void main(String[] args) {
        // 프로그램 시작 시 UI 구성
        initGUI();
    }

    private static void initGUI() {
        frame = new JFrame("회원 관리 시스템 v4.0 (완전 DB 연동)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 600);
        frame.setLayout(new BorderLayout());

        statusLabel = new JLabel("로그인 상태 : 로그아웃 됨", SwingConstants.CENTER);
        statusLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        frame.add(statusLabel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("돋움체", Font.PLAIN, 13));
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel menuPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        String[] btnLabels = {"회원가입", "목록조회", "로그인", "로그아웃", "검색 및 수정", "회원탈퇴"};

        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton(btnLabels[i]);
            int index = i;
            buttons[i].addActionListener(e -> handleMenu(index));
            menuPanel.add(buttons[i]);
        }
        frame.add(menuPanel, BorderLayout.SOUTH);

        updateUIState();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void handleMenu(int index) {
        switch (index) {
            case 0 -> showMemberDialog(null, "회원가입");
            case 1 -> listMembers();
            case 2 -> login();
            case 3 -> logout();
            case 4 -> searchAndEdit();
            case 5 -> deleteMember();
        }
    }

    // --- 비즈니스 로직 (모두 DB 기반으로 작동) ---

    private static void listMembers() {
        textArea.setText("=== [DB 실시간 데이터] 전체 회원 목록 ===\n");
        // ★ 파일 대신 DB에서 직접 데이터를 긁어옵니다.
        ArrayList<MemberBase> dbList = MemberDAO.selectAll();

        if (dbList.isEmpty()) {
            textArea.append("등록된 회원이 없습니다.\n");
        } else {
            for (MemberBase m : dbList) {
                String info = String.format("이름 : %-5s | 이메일 : %-18s | 나이 : %d",
                        m.getName(), m.getEmail(), m.getAge());
                textArea.append(info + "\n");
            }
        }
    }

    private static void login() {
        JPanel loginPanel = new JPanel(new GridLayout(0, 1));
        JTextField emailF = new JTextField();
        JPasswordField pwF = new JPasswordField();
        loginPanel.add(new JLabel("이메일 :")); loginPanel.add(emailF);
        loginPanel.add(new JLabel("패스워드 :")); loginPanel.add(pwF);

        if (JOptionPane.showConfirmDialog(frame, loginPanel, "로그인", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            String inputEmail = emailF.getText();
            String inputPw = new String(pwF.getPassword());

            // 로그인도 DB 리스트를 불러와서 확인합니다.
            ArrayList<MemberBase> dbList = MemberDAO.selectAll();
            for (MemberBase m : dbList) {
                if (m.getEmail().equals(inputEmail) && m.getPassword().equals(inputPw)) {
                    loggedInMember = m;
                    updateUIState();
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "정보가 올바르지 않습니다.");
        }
    }

    private static void logout() {
        loggedInMember = null;
        updateUIState();
        JOptionPane.showMessageDialog(frame, "로그아웃 되었습니다.");
    }

    private static void searchAndEdit() {
        String keyword = JOptionPane.showInputDialog(frame, "검색할 이름을 입력하세요:");
        if (keyword == null || keyword.isEmpty()) return;

        textArea.setText("=== 검색 결과 ===\n");
        ArrayList<MemberBase> dbList = MemberDAO.selectAll();
        for (MemberBase m : dbList) {
            if (m.getName().contains(keyword)) {
                textArea.append(String.format("이름 : %-5s | 이메일 : %-18s\n", m.getName(), m.getEmail()));
            }
        }
    }

    private static void deleteMember() {
        String email = JOptionPane.showInputDialog(frame, "탈퇴할 이메일을 입력하세요:");
        if (email == null || email.isEmpty()) return;

        if (JOptionPane.showConfirmDialog(frame, email + " 회원을 탈퇴시키겠습니까?", "탈퇴 확인", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // ★ DB에서 삭제 수행
            MemberDAO.deleteMember(email);
            JOptionPane.showMessageDialog(frame, "탈퇴 처리가 완료되었습니다.");
            listMembers(); // 목록 갱신
        }
    }

    private static void updateUIState() {
        boolean isLogged = (loggedInMember != null);
        statusLabel.setText(isLogged ? "로그인 상태 : " + loggedInMember.getName() + "님 로그인 중" : "로그인 상태 : 로그아웃 됨");
        buttons[1].setEnabled(isLogged); // 목록조회
        buttons[2].setEnabled(!isLogged); // 로그인
        buttons[3].setEnabled(isLogged);  // 로그아웃
        buttons[4].setEnabled(isLogged); // 검색
    }

    private static void showMemberDialog(MemberBase member, String title) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JTextField nF = new JTextField();
        JTextField eF = new JTextField();
        JPasswordField pF = new JPasswordField();
        JTextField aF = new JTextField();

        panel.add(new JLabel("이름 :")); panel.add(nF);
        panel.add(new JLabel("이메일 :")); panel.add(eF);
        panel.add(new JLabel("패스워드 :")); panel.add(pF);
        panel.add(new JLabel("나이 :")); panel.add(aF);

        if (JOptionPane.showConfirmDialog(frame, panel, title, JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            try {
                MemberBase newMember = new NormalMember(nF.getText(), eF.getText(), new String(pF.getPassword()), Integer.parseInt(aF.getText()));
                // ★ DB에 저장
                MemberDAO.insertMember(newMember);
                updateUIState();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "입력 오류!");
            }
        }
    }
}