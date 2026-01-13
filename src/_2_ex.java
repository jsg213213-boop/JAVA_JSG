import java.util.Scanner;
public class _2_ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1) 저녁 메뉴 정보 입력");
        System.out.print("오늘 저녁 먹고 싶은 메뉴(문자열)? ");
        String dinnerMenu = scanner.nextLine();

        System.out.print("어디서 먹을까요(문자열)? ");
        String dinnerLoc = scanner.nextLine();

        System.out.print("저녁 가격은 얼마 예상하나요(숫자로만)? ");
        int dinnerPri = scanner.nextInt();
        scanner.nextLine(); // 숫자 입력 후 남은 엔터(개행문자)를 제거하기 위해 추가

        System.out.println("출력 : 오늘은 " + dinnerMenu + " " + dinnerLoc + " 예상가격: " + dinnerPri + "원입니다.");
        System.out.println("----------------------------------");


        System.out.println("2) 정수 합과 평균 구하기");
        System.out.print("정수1 (숫자,int): ");
        int num1 = scanner.nextInt();

        System.out.print("정수2 (숫자,int): ");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;
        // 평균을 소수점까지 정확히 구하기 위해 2.0(double)으로 나누어줍니다.
        double avg = sum / 2.0;

        System.out.println("출력 : 합: [" + sum + "] , 평균 [" + avg + "]");
        System.out.println("----------------------------------");


        System.out.println("3) 성별 입력 받기");
        System.out.print("성별(M/F) : ");
        // Scanner에는 nextChar()가 없으므로 문자열을 받고 0번째 글자를 가져옵니다.
        char gender = scanner.next().charAt(0);

        System.out.println("출력 : 입력한 성별은: " + gender);

        scanner.close();
    }
}
