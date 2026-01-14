package Class_260114;
import java.util.Scanner;
public class _3_ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[5];
        System.out.println("숫자를 5개 입력해주세요: ");

        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 4; i >= 0; i--) {
            System.out.println("배열에서 요소 꺼내기 : " + arr[i]);
        }

        System.out.println("3x3 배열(테이블, 행렬, 이중 배열)을 만들어 모든 요소에 1~9 채우고 출력 ");

        int[][] grid = new int[3][3];


        int number = 1;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                grid[i][j] = number++;

            }
        }

        for (int[] row : grid) { // grid라는 행렬에서, 각 0행, 2행까지, 3개의 행을 꺼내기.
            for (int val : row) {
                System.out.println("배열의 요소 꺼내기 : " + val);
            }
        }

        System.out.println("문자열 배열을 메서드로 받아 가장 긴 문자열을 반환");

        String[] array = {"apple", "banana", "kiwi"};

        String result = getLongest(array);
        System.out.println("가장 긴 문자열은? " + result);

    }

    public static String getLongest(String[] words) {

        String longest = "";

        for(String word: words) { // words 배열안에 문자열 요소를 순회를 돌면서, 요소를 하나씩 꺼내기
            if(word.length() > longest.length()) {

                longest = word;
            }
        }

        return longest;
    }


}