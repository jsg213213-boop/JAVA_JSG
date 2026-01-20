package Class_260120;

import java.util.Scanner;

public class MainClass04 {
    public static void main(String[] args) {
        MemberBase[] members = new MemberBase[5];
        int count = 0 ; // 현재 저장된 회원 수 (배열 인덱스 관리용)
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=============회원 관리 시스템 ver 1.0=======");
            System.out.println("1. 회원가입 2. 목록조회 3. 종료");
            System.out.println("메뉴 선택 >>");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
                // 콘솔에 숫자가 아닌 다른 문자등을 입력시에는, 반복문이
                // 종료되지 않고, 계속 동작 하게끔 설정.
                continue;
            }

            switch(choice) {
                case 1:
                    if(count >= members.length) {
                        System.out.println("정원초과, 가입 불가입니다.");
                        break;
                    }
                    System.out.println("이름: ");
                    String name = sc.nextLine();

                    System.out.println("이메일: ");
                    String email = sc.nextLine();

                    System.out.println("비밀번호: ");
                    String password = sc.nextLine();

                    System.out.println("나이: ");
                    int age = Integer.parseInt(sc.nextLine());
                    NormalMember newMember = new NormalMember(name,email, password, age);
                    members[count] = newMember;
                    newMember.join();
                    count++;
                    break;
                case 2:
                    if(count == 0) {
                        System.out.println("가입된 회원이 없습니다. ");
                    } else {
                        System.out.println("\n 총회원수 : " + count + "명입니다.");
                        for(int i = 0; i < count; i++) {
                            members[i].showInfo(); // 다형성 (오버라이딩된 메서드 실행)
                        }
                    }
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다. ");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");


            }


        }

    }
}
