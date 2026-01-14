package Class_260114;
import java.util.Scanner;
public class _2_ex {
    public static void main(String[] args) {
        System.out.println("1부터 100까지의 합");
        runExample1();
        System.out.println();

        System.out.println("양수 입력 받기 (do-while)");
        runExample2();
        System.out.println();

        System.out.println("7의 배수 출력 (break 사용)");
        runExample3();
    }

    public static void runExample1() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1부터 100까지의 합: " + sum);
    }

    public static void runExample2() {
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print("양수를 입력하세요 (음수 입력 시 종료): ");
            number = scanner.nextInt();

            if (number >= 0) {
                System.out.println("입력하신 숫자: " + number);
            }
        } while (number >= 0);

        System.out.println("음수가 입력되어 프로그램을 종료합니다.");

    }

    public static void runExample3() {
        System.out.println("1~100 사이의 7의 배수 (69 넘으면 종료):");
        for (int i = 1; i <= 100; i++) {
            if (i > 69) {
                break;
            }
            if (i % 7 == 0) {
                System.out.println(i);
            }
        }
    }
}
