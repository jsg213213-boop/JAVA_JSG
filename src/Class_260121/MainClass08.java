package Class_260121;
import java.io.*;
import java.util.Scanner;
public class MainClass08 {
    private static final String FILE_NAME = "members.txt";
    private static final int MAX_MEMBERS = 5; // 최대 인원 상수로 관리

    public static void main(String[] args) {
        MemberBase[] members = new MemberBase[MAX_MEMBERS];
        int count = 0;

        count = loadMembers(members);

        MemberBase loggedInMember = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n============= 회원 관리 시스템 ver 1.1 ============= ");
            if (loggedInMember != null) {
                System.out.println("[ 로그인 중: " + loggedInMember.getEmail() + " (" + loggedInMember.getName() + ") ]");
            }
            System.out.println("1. 회원가입  2. 목록조회  3. 로그인  4. 로그아웃  5. 종료");
            System.out.print("메뉴 선택 >> ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ 메뉴 번호를 숫자로 입력해주세요.");
                continue;
            }

            switch (choice) {
                case 1: // 회원가입
                    if (count >= members.length) {
                        System.out.println("❌ 정원 초과! 더 이상 가입할 수 없습니다.");
                        break;
                    }
                    try {
                        System.out.print("이름: ");
                        String name = sc.nextLine();
                        System.out.print("이메일: ");
                        String email = sc.nextLine();
                        System.out.print("패스워드: ");
                        String password = sc.nextLine();
                        System.out.print("나이: ");
                        int age = Integer.parseInt(sc.nextLine());

                        NormalMember newMember = new NormalMember(name, email, password, age);
                        members[count++] = newMember;
                        newMember.join();

                        saveMembers(members, count); // 가입 즉시 파일 저장
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ 나이는 숫자로 입력해야 합니다. 처음부터 다시 시도해주세요.");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("등록된 회원이 없습니다.");
                    } else {
                        System.out.println("\n--- 전체 회원 목록 (총 " + count + "명) ---");
                        for (int i = 0; i < count; i++) {
                            members[i].showInfo();
                        }
                    }
                    break;

                case 3:
                    if (loggedInMember != null) {
                        System.out.println("이미 로그인 상태입니다.");
                        break;
                    }
                    System.out.print("이메일: ");
                    String inputEmail = sc.nextLine();
                    System.out.print("패스워드: ");
                    String inputPassword = sc.nextLine();

                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (members[i].getEmail().equals(inputEmail) && members[i].getPassword().equals(inputPassword)) {
                            loggedInMember = members[i];
                            System.out.println("✅ 로그인 성공! " + loggedInMember.getName() + "님 환영합니다.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("❌ 로그인 실패: 이메일 또는 비밀번호를 확인하세요.");
                    break;

                case 4:
                    if (loggedInMember != null) {
                        System.out.println(loggedInMember.getName() + "님이 로그아웃 되었습니다.");
                        loggedInMember = null;
                    } else {
                        System.out.println("로그인 상태가 아닙니다.");
                    }
                    break;

                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    public static void saveMembers(MemberBase[] members, int count) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < count; i++) {
                MemberBase m = members[i];
                String line = String.format("%s,%s,%s,%d", m.getName(), m.getEmail(), m.getPassword(), m.getAge());
                bw.write(line);
                bw.newLine();
            }
            System.out.println("💾 데이터가 '" + FILE_NAME + "'에 안전하게 저장되었습니다.");
        } catch (IOException e) {
            System.err.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }

    public static int loadMembers(MemberBase[] members) {
        File file = new File(FILE_NAME);
        if (!file.exists()) return 0;

        int loadCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null && loadCount < members.length) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    members[loadCount++] = new NormalMember(data[0], data[1], data[2], Integer.parseInt(data[3]));
                }
            }
            System.out.println("📂 데이터를 불러왔습니다. (로드된 회원: " + loadCount + "명)");
        } catch (IOException | NumberFormatException e) {
            System.err.println("파일 로드 중 오류 발생: " + e.getMessage());
        }
        return loadCount;
    }
}

