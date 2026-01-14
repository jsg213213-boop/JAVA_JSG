package Class_260114;

public class _2_Point {
    public static void main(String[] args) {

        System.out.println("--- 1부터 5까지 출력 ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }


        System.out.println("\n--- 1~10 중 홀수만 출력 ---");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }


        System.out.println("\n--- 1~10 중 6 전에서 멈추기 ---");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break;
            }
            System.out.println(i);
        }

    }
}

