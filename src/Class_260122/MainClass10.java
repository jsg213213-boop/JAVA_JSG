package Class_260122;
import java.io.*;
import java.util.Scanner;

public class MainClass10 {
    private static final String FILE_NAME = "members.txt";
    private static final int MAX_MEMBERS = 5;

        public static void main(String[] args) {
            MemberBase[] members = new MemberBase[MAX_MEMBERS];
            int count = loadMembers(members); // 프로그램 시작 시 데이터 불러오기

            MemberBase loggedInMember = null;
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n============= 회원 관리 시스템 ver 1.3 (MainClass10) ============= ");
                if (loggedInMember != null) {
                    System.out.println("[ 현재 로그인: " + loggedInMember.getEmail() + " (" + loggedInMember.getName() + ") ]");
                }
                System.out.println("1. 회원가입  2. 목록조회  3. 로그인  4. 로그아웃  5. 정보수정  6. 회원검색  7. 종료");
                System.out.print("메뉴 선택 >> ");

                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ 메뉴 번호는 숫자로만 입력해주세요.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        if (count >= MAX_MEMBERS) {
                            System.out.println("❌ 정원 초과! 더 이상 가입할 수 없습니다.");
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
                            saveMembers(members, count); // 즉시 저장
                        } catch (NumberFormatException e) {
                            System.out.println("⚠️ 나이는 숫자로 입력해야 합니다.");
                        }
                        break;

                    case 2: // 목록조회
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
                            System.out.println("이미 로그인 중입니다.");
                            break;
                        }
                        System.out.print("이메일: "); String inEmail = sc.nextLine();
                        System.out.print("패스워드: "); String inPw = sc.nextLine();

                        boolean found = false;
                        for (int i = 0; i < count; i++) {
                            if (members[i].getEmail().equals(inEmail) && members[i].getPassword().equals(inPw)) {
                                loggedInMember = members[i];
                                System.out.println("✅ " + loggedInMember.getName() + "님, 환영합니다!");
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

                    case 5: // 정보 수정
                        if (loggedInMember == null) {
                            System.out.println("❌ 로그인 후 본인 정보를 수정할 수 있습니다.");
                            break;
                        }
                        try {
                            System.out.println("\n--- [" + loggedInMember.getName() + "]님의 정보 수정 ---");
                            System.out.print("새 이름: "); loggedInMember.setName(sc.nextLine());
                            System.out.print("새 패스워드: "); loggedInMember.setPassword(sc.nextLine());
                            System.out.print("새 나이: "); loggedInMember.setAge(Integer.parseInt(sc.nextLine()));

                            System.out.println("✅ 정보가 성공적으로 업데이트되었습니다.");
                            saveMembers(members, count); // 변경사항 파일 저장
                        } catch (NumberFormatException e) {
                            System.out.println("⚠️ 나이는 숫자로 입력해주세요. 수정이 중단되었습니다.");
                        }
                        break;

                    case 6:
                        if (count == 0) {
                            System.out.println("조회할 데이터가 없습니다.");
                            break;
                        }
                        System.out.print("검색어 입력 (이름 또는 이메일): ");
                        String keyword = sc.nextLine();
                        boolean isMatch = false;

                        System.out.println("\n--- '" + keyword + "' 검색 결과 ---");
                        for (int i = 0; i < count; i++) {
                            if (members[i].getName().contains(keyword) || members[i].getEmail().contains(keyword)) {
                                members[i].showInfo();
                                isMatch = true;
                            }
                        }
                        if (!isMatch) System.out.println("일치하는 회원이 없습니다.");
                        break;

                    case 7: // 종료
                        System.out.println("프로그램을 종료합니다.");
                        sc.close();
                        return;

                    default:
                        System.out.println("메뉴를 다시 선택해주세요.");
                }
            }
        }

        public static void saveMembers(MemberBase[] members, int count) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (int i = 0; i < count; i++) {
                    MemberBase m = members[i];
                    bw.write(String.format("%s,%s,%s,%d", m.getName(), m.getEmail(), m.getPassword(), m.getAge()));
                    bw.newLine();
                }
                System.out.println("💾 변경사항이 파일에 저장되었습니다.");
            } catch (IOException e) {
                System.err.println("파일 저장 중 오류: " + e.getMessage());
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
                System.out.println("📂 파일에서 " + loadCount + "명의 데이터를 불러왔습니다.");
            } catch (Exception e) {
                System.err.println("데이터 로드 중 오류: " + e.getMessage());
            }
            return loadCount;
        }
    }