package Class_260121;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {
    public static void main(String[] args) {

        HashMap<String, Integer> menuMap = new HashMap<>();

        menuMap.put("김밥", 3000);
        menuMap.put("라면", 4500);
        menuMap.put("떡볶이", 5000);

        System.out.println("라면의 가격: " + menuMap.get("라면") + "원");

        menuMap.put("김밥", 3500);
        System.out.println("김밥 가격 수정 완료 (3000 -> 3500)");

        boolean hasDonkatsu = menuMap.containsKey("돈까스");
        System.out.println("돈까스 메뉴 존재 여부: " + (hasDonkatsu ? "있음" : "없음"));

        System.out.println("\n--- 현재 메뉴판 전체 목록 ---");
        for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
            System.out.println("메뉴: " + entry.getKey() + ", 가격: " + entry.getValue() + "원");
        }
    }
}