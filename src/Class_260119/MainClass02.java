package Class_260119;

import java.util.Scanner;

public class MainClass02 {
    public static void main(String[] args) {
        MemberBase[] members = new MemberBase[5];
        int count = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n============= 회원 관리 시스템 ver 1.1 =============");
            System.out.println("1. 회원가입  2. 목록조회  3. 로그인  4. 종료");
            System.out.print("메뉴 선택 >> ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ 숫자로 입력해주세요.");
                continue;
            }

            switch (choice) {
                case 1:
                    if (count >= members.length) {
                        System.out.println("❌ 정원 초과입니다.");
                        break;
                    }
                    System.out.print("이름: ");
                    String name = sc.nextLine();
                    System.out.print("이메일: ");
                    String email = sc.nextLine();
                    System.out.print("비밀번호: ");
                    String pw = sc.nextLine();
                    System.out.print("나이: ");
                    int age = Integer.parseInt(sc.nextLine());

                    NormalMember newMember = new NormalMember(name, email, pw, age);
                    members[count] = newMember;
                    newMember.join();
                    count++;
                    break;

                case 2:
                    System.out.println("\n--- 전체 회원 목록 ---");
                    if (count == 0) System.out.println("등록된 회원이 없습니다.");
                    for (int i = 0; i < count; i++) {
                        members[i].showInfo();
                    }
                    break;

                case 3:
                    System.out.println("\n--- 로그인 ---");
                    System.out.print("이메일 입력: ");
                    String inputEmail = sc.nextLine();
                    System.out.print("비밀번호 입력: ");
                    String inputPw = sc.nextLine();

                    boolean loginSuccess = false;
                    for (int i = 0; i < count; i++) {
                        // 저장된 이메일과 비밀번호가 입력값과 일치하는지 확인
                        if (members[i].getEmail().equals(inputEmail) &&
                                members[i].getPassword().equals(inputPw)) {
                            System.out.println("👉 " + members[i].name + "님, 로그인 성공!");
                            loginSuccess = true;
                            break;
                        }
                    }

                    if (!loginSuccess) {
                        System.out.println("❌ 정보가 불일치해서 로그인 안됩니다.");
                    }
                    break;

                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}