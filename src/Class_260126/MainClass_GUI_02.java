package Class_260126;

import javax.swing.*;
import java.awt.*;
import java.io.*;

// 회원 정보 클래스
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

public class MainClass_GUI_02 {
    private static final String FILE_NAME = "members.txt";
    private static final int MAX_MEMBERS = 100;
    private static MemberBase[] members = new MemberBase[MAX_MEMBERS];
    private static int count = 0;
    private static MemberBase loggedInMember = null;

    public static void main(String[] args) {
        count = loadMembers(members);

        JFrame frame = new JFrame("회원 관리 시스템 ver 3.2(GUI버전)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());

        // 1. 상단 상태바
        JLabel statusLabel = new JLabel("로그인 상태 : 로그아웃 됨", SwingConstants.CENTER);
        statusLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        frame.add(statusLabel, BorderLayout.NORTH);

        // 2. 중앙 목록 영역
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("돋움체", Font.PLAIN, 13));
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // 3. 하단 메뉴 버튼 (2행 3열)
        JPanel menuPanel = new JPanel(new GridLayout(2, 3, 3, 3));
        String[] btnLabels = {"1 회원가입", "2 목록조회", "3 로그인", "4 로그아웃", "5 검색 및 수정", "6 회원탈퇴"};
        JButton[] buttons = new JButton[6];

        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton(btnLabels[i]);
            menuPanel.add(buttons[i]);
        }
        frame.add(menuPanel, BorderLayout.SOUTH);

        // --- 이벤트 구현 ---

        // 1. 회원가입
        buttons[0].addActionListener(e -> showMemberDialog(frame, null, "회원가입"));

        // 2. 목록조회 (콘솔 기록 포함)
        buttons[1].addActionListener(e -> {
            textArea.setText("===회원 목록====\n");
            System.out.println("\n[콘솔 기록] 전체 회원 목록 조회 결과:");
            for (int i = 0; i < count; i++) {
                String info = String.format("이름 : %-5s | 이메일 : %-18s | 나이 : %d",
                        members[i].getName(), members[i].getEmail(), members[i].getAge());
                textArea.append(info + "\n");
                System.out.println(info);
            }
        });

        // 3. 로그인 (이메일/패스워드만 입력)
        buttons[2].addActionListener(e -> {
            if (loggedInMember != null) { JOptionPane.showMessageDialog(frame, "이미 로그인 상태입니다."); return; }

            JPanel loginPanel = new JPanel(new GridLayout(0, 1));
            JTextField emailF = new JTextField();
            JPasswordField pwF = new JPasswordField();

            loginPanel.add(new JLabel("이메일 :")); loginPanel.add(emailF);
            loginPanel.add(new JLabel("패스워드 :")); loginPanel.add(pwF);

            if (JOptionPane.showConfirmDialog(frame, loginPanel, "로그인", 2) == 0) {
                String inputEmail = emailF.getText();
                String inputPw = new String(pwF.getPassword());

                for (int i = 0; i < count; i++) {
                    if (members[i].getEmail().equals(inputEmail) && members[i].getPassword().equals(inputPw)) {
                        loggedInMember = members[i];
                        statusLabel.setText("로그인 상태 : " + loggedInMember.getName() + "님 로그인 중");
                        System.out.println(loggedInMember.getName() + "님 로그인 성공!");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(frame, "이메일 또는 패스워드가 틀립니다.");
            }
        });

        // 4. 로그아웃
        buttons[3].addActionListener(e -> {
            if (loggedInMember != null) System.out.println(loggedInMember.getName() + "님 로그아웃.");
            loggedInMember = null;
            statusLabel.setText("로그인 상태 : 로그아웃 됨");
            JOptionPane.showMessageDialog(frame, "로그아웃 되었습니다.");
        });

        // 5. 검색 및 수정 (콘솔 기록 포함)
        buttons[4].addActionListener(e -> {
            String keyword = JOptionPane.showInputDialog(frame, "검색할 이름을 입력하세요:");
            if (keyword == null || keyword.isEmpty()) return;

            System.out.println("\n[콘솔 기록] '" + keyword + "' 검색 결과:");
            boolean found = false;
            textArea.setText("===검색 결과====\n");

            for (int i = 0; i < count; i++) {
                if (members[i].getName().contains(keyword)) {
                    String info = String.format("이름 : %-5s | 이메일 : %-18s | 나이 : %d",
                            members[i].getName(), members[i].getEmail(), members[i].getAge());
                    textArea.append(info + "\n");
                    System.out.println(info);
                    found = true;

                    int choice = JOptionPane.showConfirmDialog(frame,
                            "회원[" + members[i].getName() + "] 정보를 수정하시겠습니까?", "수정 확인", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        showMemberDialog(frame, members[i], "회원 정보 수정");
                    }
                }
            }
            if (!found) {
                System.out.println("일치하는 회원이 없습니다.");
                JOptionPane.showMessageDialog(frame, "일치하는 회원이 없습니다.");
            }
        });

        // 6. 회원탈퇴
        buttons[5].addActionListener(e -> {
            String email = JOptionPane.showInputDialog(frame, "탈퇴할 회원의 이메일을 입력하세요:");
            if (email == null || email.isEmpty()) return;

            for (int i = 0; i < count; i++) {
                if (members[i].getEmail().equals(email)) {
                    int confirm = JOptionPane.showConfirmDialog(frame,
                            members[i].getName() + "님을 정말 탈퇴시키겠습니까?", "탈퇴 확인", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        System.out.println("[콘솔 기록] 탈퇴 완료: " + members[i].getName() + " (" + members[i].getEmail() + ")");

                        for (int j = i; j < count - 1; j++) { members[j] = members[j + 1]; }
                        members[--count] = null;

                        saveMembers(members, count);
                        JOptionPane.showMessageDialog(frame, "탈퇴 처리가 완료되었습니다.");

                        if (loggedInMember != null && loggedInMember.getEmail().equals(email)) {
                            loggedInMember = null;
                            statusLabel.setText("로그인 상태 : 로그아웃 됨");
                        }
                        return;
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "해당 이메일의 회원을 찾을 수 없습니다.");
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // 가입/수정 다이얼로그 (수직 구조)
    private static void showMemberDialog(JFrame frame, MemberBase member, String title) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JTextField nF = new JTextField(member != null ? member.getName() : "");
        JTextField eF = new JTextField(member != null ? member.getEmail() : "");
        JPasswordField pF = new JPasswordField(member != null ? member.getPassword() : "");
        JTextField aF = new JTextField(member != null ? String.valueOf(member.getAge()) : "");

        panel.add(new JLabel("이름 :")); panel.add(nF);
        panel.add(new JLabel("이메일 :")); panel.add(eF);
        panel.add(new JLabel("패스워드 :")); panel.add(pF);
        panel.add(new JLabel("나이 :")); panel.add(aF);

        if (JOptionPane.showConfirmDialog(frame, panel, title, 2) == 0) {
            try {
                if (member == null) {
                    members[count++] = new NormalMember(nF.getText(), eF.getText(), new String(pF.getPassword()), Integer.parseInt(aF.getText()));
                    JOptionPane.showMessageDialog(frame, "가입 성공!");
                } else {
                    member.setName(nF.getText()); member.setPassword(new String(pF.getPassword()));
                    member.setAge(Integer.parseInt(aF.getText()));
                    JOptionPane.showMessageDialog(frame, "수정 성공!");
                }
                saveMembers(members, count);
            } catch (Exception ex) { JOptionPane.showMessageDialog(frame, "입력 오류!"); }
        }
    }

    public static void saveMembers(MemberBase[] members, int count) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < count; i++) {
                bw.write(members[i].getName() + "," + members[i].getEmail() + "," + members[i].getPassword() + "," + members[i].getAge());
                bw.newLine();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static int loadMembers(MemberBase[] members) {
        File file = new File(FILE_NAME);
        if (!file.exists()) return 0;
        int loadCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d.length == 4) members[loadCount++] = new NormalMember(d[0], d[1], d[2], Integer.parseInt(d[3]));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return loadCount;
    }
}