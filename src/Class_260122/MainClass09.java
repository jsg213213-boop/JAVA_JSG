package Class_260122;

import java.io.*;
import java.util.Scanner;

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

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public void showInfo() {
        System.out.println("이름: " + name + " | 이메일: " + email + " | 나이: " + age);
    }
}

class NormalMember extends MemberBase {
    public NormalMember(String name, String email, String password, int age) {
        super(name, email, password, age);
    }
    public void join() {
        System.out.println("🎉 " + name + "님의 가입을 환영합니다!");
    }
}

public class MainClass09 {
    private static final String FILE_NAME = "members.txt";
    private static final int MAX_MEMBERS = 5;

    public static void main(String[] args) {
        MemberBase[] members = new MemberBase[MAX_MEMBERS];
        int count = loadMembers(members); // 로드 함수 호출

        MemberBase loggedInMember = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n============= 회원 관리 시스템 ver 1.2 ============= ");
            if (loggedInMember != null) {
                System.out.println("[ 로그인 중: " + loggedInMember.getEmail() + " (" + loggedInMember.getName() + ") ]");
            }
            System.out.println("1. 회원가입  2. 목록조회  3. 로그인  4. 로그아웃  5. 정보수정  6. 종료");
            System.out.print("메뉴 선택 >> ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ 숫자만 입력 가능합니다.");
                continue;
            }

            switch (choice) {
                case 1:
                    if (count >= MAX_MEMBERS) {
                        System.out.println("❌ 정원 초과입니다.");
                        break;
                    }
                    try {
                        System.out.print("이름: "); String name = sc.nextLine();
                        System.out.print("이메일: "); String email = sc.nextLine();
                        System.out.print("패스워드: "); String password = sc.nextLine();
                        System.out.print("나이: "); int age = Integer.parseInt(sc.nextLine());

                        NormalMember newMember = new NormalMember(name, email, password, age);
                        members[count++] = newMember;
                        newMember.join();
                        saveMembers(members, count);
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ 나이는 숫자로 입력하세요.");
                    }
                    break;

                case 2:
                    if (count == 0) System.out.println("등록된 회원이 없습니다.");
                    else {
                        for (int i = 0; i < count; i++) members[i].showInfo();
                    }
                    break;

                case 3:
                    if (loggedInMember != null) { System.out.println("이미 로그인 중입니다."); break; }
                    System.out.print("이메일: "); String inEmail = sc.nextLine();
                    System.out.print("패스워드: "); String inPw = sc.nextLine();

                    for (int i = 0; i < count; i++) {
                        if (members[i].getEmail().equals(inEmail) && members[i].getPassword().equals(inPw)) {
                            loggedInMember = members[i];
                            System.out.println("✅ 로그인 성공!");
                            break;
                        }
                    }
                    if (loggedInMember == null) System.out.println("❌ 정보를 확인하세요.");
                    break;

                case 4:
                    loggedInMember = null;
                    System.out.println("로그아웃 되었습니다.");
                    break;

                case 5:
                    if (loggedInMember == null) { System.out.println("❌ 로그인 후 이용하세요."); break; }
                    try {
                        System.out.print("새 이름: "); loggedInMember.setName(sc.nextLine());
                        System.out.print("새 패스워드: "); loggedInMember.setPassword(sc.nextLine());
                        System.out.print("새 나이: "); loggedInMember.setAge(Integer.parseInt(sc.nextLine()));
                        System.out.println("✅ 수정 완료!");
                        saveMembers(members, count);
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ 수정 실패: 나이는 숫자여야 합니다.");
                    }
                    break;

                case 6:
                    System.out.println("종료합니다.");
                    sc.close();
                    return;
            }
        }
    }

    public static void saveMembers(MemberBase[] members, int count) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < count; i++) {
                MemberBase m = members[i];
                bw.write(String.format("%s,%s,%s,%d\n", m.getName(), m.getEmail(), m.getPassword(), m.getAge()));
            }
        } catch (IOException e) {
            System.err.println("저장 오류: " + e.getMessage());
        }
    }

    public static int loadMembers(MemberBase[] members) {
        File file = new File(FILE_NAME);
        if (!file.exists()) return 0;
        int loadCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null && loadCount < members.length) {
                String[] d = line.split(",");
                if (d.length == 4) {
                    members[loadCount++] = new NormalMember(d[0], d[1], d[2], Integer.parseInt(d[3]));
                }
            }
        } catch (Exception e) {
            System.err.println("로드 오류: " + e.getMessage());
        }
        return loadCount;
    }
}