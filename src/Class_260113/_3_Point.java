package Class_260113;

import java.util.Scanner;
public class _3_Point {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("정수 1 : ");

        int a = scanner.nextInt();

        System.out.println("정수 2 : ");

        int b = scanner.nextInt();
        System.out.println("===============================");
        System.out.println("몫(/) : " + (a/b));
        System.out.println("나머지(%) : " + (a%b));
        System.out.println("===============================");



    }
}
