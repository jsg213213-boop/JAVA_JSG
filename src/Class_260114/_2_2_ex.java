package Class_260114;
import java.util.Scanner;
public class _2_2_ex {
    public static void main(String[] args) {
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
        scanner.close();
    }

}
