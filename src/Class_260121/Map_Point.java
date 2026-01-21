package Class_260121;

import java.util.HashMap;

public class Map_Point {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("user1", 90);
        map.put("user2", 85);
        map.put("user3", 100);

        System.out.println("map.get(\"user2\") 하나 조회 : " + map.get("user2"));

        map.put("user2", 90);
        System.out.println("map.get(\"user2\") 수정 후 조회 : " + map.get("user2"));

        System.out.println("user2 번 삭제함.");
        map.remove("user2");
        System.out.println("map.get(\"user2\") 삭제 후 조회 : " + map.get("user2"));

        boolean hasKey = map.containsKey("user1");
        System.out.println("키로 검색 map.containsKey(\"user1\") 결과: " + hasKey);

        boolean hasValue = map.containsValue(100);
        System.out.println("값으로 검색 map.containsValue(100) 결과: " + hasValue);

        System.out.println("===전체출력===");
        for( String key : map.keySet()){
            System.out.println("키 : " + key + ", 값: " + map.get(key));
        }

        for (int num : map.values()) {
            System.out.println("값들만 뽑아서 출력 반복 : " + num);
        }
    }
}