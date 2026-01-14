package Class_260114;
import java.util.Scanner;
public class _1_ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 1번 문제: 나이 판별 ===");
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();

        if (age >= 65) {
            System.out.println("결과: 노년층");
        } else {
            System.out.println("결과: 일반");
        }
        System.out.println();


        System.out.println("=== 2번 문제: 메뉴 선택 ===");
        System.out.println("1.김밥  2.국밥  3.칼국수  4.국수");
        System.out.print("메뉴 번호를 선택하세요: ");
        int menu = sc.nextInt();

        switch (menu) {
            case 1:
                System.out.println("선택 메뉴: 김밥");
                break;
            case 2:
                System.out.println("선택 메뉴: 국밥");
                break;
            case 3:
                System.out.println("선택 메뉴: 칼국수");
                break;
            case 4:
                System.out.println("선택 메뉴: 국수");
                break;
            default:
                System.out.println("잘못된 번호입니다. 1~4번 중에서 골라주세요.");
        }
        System.out.println();


        System.out.println("=== 3번 문제: 등급 출력 ===");
        System.out.print("점수를 입력하세요(0~100): ");
        int score = sc.nextInt();
        String grade = "";

        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("당신의 등급은 " + grade + "입니다.");

        sc.close();
    }
}
