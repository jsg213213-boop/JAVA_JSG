package Class_260114;

public class _2_3_ex {
    public static void main(String[] args) {
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
