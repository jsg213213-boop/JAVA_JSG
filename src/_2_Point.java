import java.util.Scanner;

public class _2_Point {
 public static void main(String[] args) {
     int number = 100;
     Scanner scanner = new Scanner(System.in);
     System.out.println(("반지름 입력: "));
     double radius = scanner.nextDouble();
     System.out.println("원의 넓이" + (3.14*radius*radius));
     scanner.nextLine();
     System.out.println("==============================");
     System.out.println("Scanner로 문자열 입력 받기");
     System.out.println("이름 입력: ");
     String name = scanner.nextLine();
     System.out.println("당신의 이름은 : " +name + "입니다.~~");
     scanner.close();
 }
}
