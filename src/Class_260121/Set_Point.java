package Class_260121;

import java.util.HashSet;

public class Set_Point {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);

        boolean isAdded = set.add(10);
        System.out.println("10 중복 추가 여부 확인 : " + isAdded);

        set.remove(10);
        set.add(100);

        System.out.println("20번 삭제함.");
        set.remove(20);

        System.out.println("=====전체 조회 =====");
        for (int num : set) {
            System.out.println("반복문으로 요소 확인 해보기. : " + num);
        }

        System.out.println("크기 조회 : " + set.size());

        System.out.println("100 있는지 여부 확인 : " + set.contains(100));


    }
}