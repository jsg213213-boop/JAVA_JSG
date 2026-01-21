package Class_260121;

import java.util.HashSet;

public class LottoManager {
    public static void main(String[] args) {

        HashSet<Integer> lottoSet = new HashSet<>();

        lottoSet.add(5);
        lottoSet.add(12);
        lottoSet.add(5);  // 중복 발생
        lottoSet.add(20);
        lottoSet.add(12); // 중복 발생
        lottoSet.add(7);

        System.out.println("현재 세트의 크기: " + lottoSet.size());

        lottoSet.remove(20);

        boolean hasFive = lottoSet.contains(5);
        System.out.println("숫자 5 포함 여부: " + hasFive);

        System.out.println("--- 현재 세트의 모든 숫자 ---");
        for (Integer num : lottoSet) {
            System.out.println(num);
        }
    }
}