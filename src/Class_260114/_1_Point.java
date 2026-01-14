package Class_260114;

import java.util.Scanner;

public class _1_Point {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("현재 온도를 입력하세요: ");
        int temp = scanner.nextInt();


        if (temp > 30) {
            System.out.println("더움");
        } else if (temp <= 30 && temp >= 22) {
            System.out.println("적당함");
        } else {
            System.out.println("조금 쌀쌀함");
        }


        System.out.println("----------------");


        int month = 4;
        switch (month) {
            case 3: case 4: case 5:
                System.out.println("봄");
                break;
            case 6: case 7: case 8:
                System.out.println("여름");
                break;
            default:
                System.out.println("기타 계절");
        }

        scanner.close();
    }
}