package Class_260114;
import java.util.Scanner;
public class _4_ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("합계와 평균 구하기");
        int[] numbers = new int[5];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            System.out.print((i + 1) + "번째 정수를 입력하세요: ");
            numbers[i] = sc.nextInt();
            sum += numbers[i]; // 입력받으면서 바로 합계에 더함
        }

        double average = (double) sum / numbers.length;
        System.out.println("합계: " + sum);
        System.out.println("평균: " + average);
        System.out.println();

        System.out.println("4x4 대각선 배열 출력");
        int[][] matrix = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        System.out.println("배열에서 최대값 찾기");
        int[] sampleArray = {100, 200, 300, 50, 450, 120}; // 테스트용 샘플 배열

        int max = getMaxValue(sampleArray);
        System.out.println("샘플 배열: {100, 200, 300, 50, 450, 120}");
        System.out.println("가장 큰 수: " + max);
    }

    // 최대값을 찾아 반환하는 메서드
    public static int getMaxValue(int[] arr) {
        int maxVal = arr[0]; // 첫 번째 값을 기준값으로 설정

        for (int num : arr) {
            if (num > maxVal) {
                maxVal = num; // 현재 숫자가 더 크면 기준값 교체
            }
        }
        return maxVal;
    }
}
