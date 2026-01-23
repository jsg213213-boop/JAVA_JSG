package Class_260123;

import javax.swing.*;
import java.io.*;

class MemberBase {
    protected String name;
    protected String email;
    protected String password;
    protected int age;

    public MemberBase(String name, String email, String password, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void showInfo() {
        System.out.println("이름: " + name + " | 이메일: " + email + " | 나이: " + age);
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public int getAge() { return age; }
}

class NormalMember extends MemberBase {
    public NormalMember(String name, String email, String password, int age) {
        super(name, email, password, age);
    }

    public void join() {
        System.out.println(name + "님이 일반 회원으로 가입되었습니다.");
    }
}

public class MainClass_GUI {
    private static final String FILE_NAME = "members.txt";
    private static final int MAX_MEMBERS = 5;
    private static MemberBase[] members = new MemberBase[MAX_MEMBERS];
    private static int count = 0;

    private static MemberBase loggedInMember = null;

    public static void main(String[] args) {
        count = loadMembers(members);

        JFrame frame = new JFrame("회원 관리 시스템 Pro");
        frame.setLayout(null);

        // --- UI 컴포넌트 ---
        JLabel statusLabel = new JLabel("상태: 로그아웃 중");
        statusLabel.setBounds(15, 5, 300, 25);
        frame.add(statusLabel);

        // 입력 필드들
        JLabel nameL = new JLabel("이름:"); nameL.setBounds(15, 40, 50, 25);
        JTextField nameF = new JTextField(); nameF.setBounds(70, 40, 100, 25);

        JLabel emailL = new JLabel("이메일:"); emailL.setBounds(15, 75, 50, 25);
        JTextField emailF = new JTextField(); emailF.setBounds(70, 75, 100, 25);

        JLabel pwL = new JLabel("비번:"); pwL.setBounds(15, 110, 50, 25);
        JPasswordField pwF = new JPasswordField(); pwF.setBounds(70, 110, 100, 25);

        JLabel ageL = new JLabel("나이:"); ageL.setBounds(15, 145, 50, 25);
        JTextField ageF = new JTextField(); ageF.setBounds(70, 145, 100, 25);

        JButton joinBtn = new JButton("회원가입"); joinBtn.setBounds(180, 40, 100, 25);
        JButton loginBtn = new JButton("로그인"); loginBtn.setBounds(180, 75, 100, 25);
        JButton logoutBtn = new JButton("로그아웃"); logoutBtn.setBounds(180, 110, 100, 25);
        JButton updateBtn = new JButton("정보수정"); updateBtn.setBounds(180, 145, 100, 25);
        JButton searchBtn = new JButton("회원검색"); searchBtn.setBounds(15, 190, 125, 30);
        JButton listBtn = new JButton("전체목록(콘솔)"); listBtn.setBounds(155, 190, 125, 30);
        joinBtn.setBackground(java.awt.Color.ORANGE);
        joinBtn.setOpaque(true);
        joinBtn.setBorderPainted(false);
        loginBtn.setBackground(java.awt.Color.GREEN);
        loginBtn.setOpaque(true);
        loginBtn.setBorderPainted(false);
        logoutBtn.setBounds(180, 110, 100, 25);
        logoutBtn.setBackground(java.awt.Color.RED);
        updateBtn.setBackground(java.awt.Color.BLUE);
        logoutBtn.setOpaque(true);
        logoutBtn.setBorderPainted(false);
        searchBtn.setBackground(new java.awt.Color(128, 0, 128));
        searchBtn.setForeground(java.awt.Color.WHITE);
        searchBtn.setOpaque(true);
        searchBtn.setBorderPainted(false);
        listBtn.setBackground(new java.awt.Color(144, 238, 144));
        listBtn.setForeground(java.awt.Color.BLACK);
        listBtn.setOpaque(true);
        listBtn.setBorderPainted(false);

        joinBtn.addActionListener(e -> {
            if (count >= MAX_MEMBERS) { JOptionPane.showMessageDialog(frame, "정원 초과!"); return; }
            try {
                members[count++] = new NormalMember(nameF.getText(), emailF.getText(), new String(pwF.getPassword()), Integer.parseInt(ageF.getText()));
                saveMembers(members, count);
                JOptionPane.showMessageDialog(frame, "가입 성공!");
            } catch (Exception ex) { JOptionPane.showMessageDialog(frame, "입력 값을 확인하세요."); }
        });

        loginBtn.addActionListener(e -> {
            if (loggedInMember != null) { JOptionPane.showMessageDialog(frame, "이미 로그인 상태입니다."); return; }
            String email = emailF.getText();
            String pw = new String(pwF.getPassword());
            for (int i = 0; i < count; i++) {
                if (members[i].getEmail().equals(email) && members[i].getPassword().equals(pw)) {
                    loggedInMember = members[i];
                    statusLabel.setText("상태: " + loggedInMember.getName() + "님 로그인 중");
                    JOptionPane.showMessageDialog(frame, loggedInMember.getName() + "님 환영합니다!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "이메일 또는 비번이 틀립니다.");
        });

        logoutBtn.addActionListener(e -> {
            if (loggedInMember == null) { JOptionPane.showMessageDialog(frame, "로그인 상태가 아닙니다."); return; }
            loggedInMember = null;
            statusLabel.setText("상태: 로그아웃 중");
            JOptionPane.showMessageDialog(frame, "로그아웃 되었습니다.");
        });

        updateBtn.addActionListener(e -> {
            if (loggedInMember == null) { JOptionPane.showMessageDialog(frame, "로그인이 필요합니다."); return; }
            try {
                loggedInMember.setName(nameF.getText());
                loggedInMember.setPassword(new String(pwF.getPassword()));
                loggedInMember.setAge(Integer.parseInt(ageF.getText()));
                saveMembers(members, count);
                statusLabel.setText("상태: " + loggedInMember.getName() + "님 로그인 중");
                JOptionPane.showMessageDialog(frame, "수정 완료!");
            } catch (Exception ex) { JOptionPane.showMessageDialog(frame, "수정 실패! 숫자를 입력하세요."); }
        });

        searchBtn.addActionListener(e -> {
            String keyword = JOptionPane.showInputDialog(frame, "검색할 이름 또는 이메일을 입력하세요:");
            if (keyword == null || keyword.isEmpty()) return;

            StringBuilder result = new StringBuilder("--- 검색 결과 ---\n");
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (members[i].getName().contains(keyword) || members[i].getEmail().contains(keyword)) {
                    result.append("이름: ").append(members[i].getName()).append(", 이메일: ").append(members[i].getEmail()).append("\n");
                    found = true;
                }
            }
            if (!found) JOptionPane.showMessageDialog(frame, "일치하는 회원이 없습니다.");
            else JOptionPane.showMessageDialog(frame, result.toString());
        });

        listBtn.addActionListener(e -> {
            System.out.println("\n--- 회원 목록 ---");
            for (int i = 0; i < count; i++) members[i].showInfo();
        });

        frame.add(nameL); frame.add(nameF); frame.add(emailL); frame.add(emailF);
        frame.add(pwL); frame.add(pwF); frame.add(ageL); frame.add(ageF);
        frame.add(joinBtn); frame.add(loginBtn); frame.add(logoutBtn); frame.add(updateBtn);
        frame.add(searchBtn); frame.add(listBtn);

        frame.setSize(310, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void saveMembers(MemberBase[] members, int count) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < count; i++) {
                MemberBase m = members[i];
                bw.write(String.format("%s,%s,%s,%d", m.getName(), m.getEmail(), m.getPassword(), m.getAge()));
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
            while ((line = br.readLine()) != null && loadCount < members.length) {
                String[] d = line.split(",");
                if (d.length == 4) members[loadCount++] = new NormalMember(d[0], d[1], d[2], Integer.parseInt(d[3]));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return loadCount;

    }
}