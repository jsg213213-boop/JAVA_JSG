package Class_260121;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MainClass06 {

    private static final String FILE_NAME = "members.txt";
    private static Scanner sc = new Scanner(System.in);
    private static MemberBase loggedInMember = null;

    public static void main(String[] args) {
        List<MemberBase> members = new ArrayList<>();

        loadMembers(members);

        while (true) {
            System.out.println("\n==================회원 관리 시스템 ver 1.0======");

            if (loggedInMember != null) {
                System.out.println("-------------------------------------------");
                System.out.println("로그인 한 유저 : " + loggedInMember.getEmail());
                System.out.println("-------------------------------------------");
            }

            System.out.print("1. 회원가입  2. 목록조회  3. 로그인  4. 종료 : ");
            String menu = sc.nextLine();

            if (menu.equals("1")) {

            } else if (menu.equals("2")) {
                System.out.println("\n 총 회원수 : " + members.size() + "명입니다.");
                for (MemberBase m : members) {
                    m.showInfo();
                }
            } else if (menu.equals("3")) {

                System.out.println("\n====로그인=====");
                System.out.print("이메일 : ");
                String inputEmail = sc.nextLine();
                System.out.print("패스워드 : ");
                String inputPassword = sc.nextLine();

                boolean isLogin = false;
                for (MemberBase member : members) {
                    if (member.getEmail().equals(inputEmail) && member.getPassword().equals(inputPassword)) {
                        System.out.println("로그인 성공!! 환영합니다, " + member.getName() + "님");
                        isLogin = true;
                        loggedInMember = member;
                        break;
                    }
                }
                if (!isLogin) {
                    System.out.println("로그인 실패: 정보가 일치하지 않습니다.");
                }
            } else if (menu.equals("4")) {
                System.out.println("프로그램을 종료합니다.");
                sc.close();
                return;
            }
        }
    }

    public static void loadMembers(List<MemberBase> members) {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[0].trim();
                    String email = data[1].trim();
                    String pwd = data[2].trim();
                    int age = Integer.parseInt(data[3].trim());

                    members.add(new NormalMember(name, email, pwd, age));
                }
            }
            System.out.println("파일 불러오기 완료: " + members.size() + "명의 정보 로드.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("파일 불러오기 실패: " + e.getMessage());
        }
    }
}

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
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public int getAge() { return age; }

    public void showInfo() {
        System.out.println("이름: " + name + ", 이메일: " + email + ", 나이: " + age);
    }
}

class NormalMember extends MemberBase {
    public NormalMember(String name, String email, String password, int age) {
        super(name, email, password, age);
    }

    @Override
    public void showInfo() {
        System.out.print("[일반회원] ");
        super.showInfo();
    }

    public void join() {
        System.out.println(this.name + "님이 일반 회원으로 가입되었습니다.");
    }
}