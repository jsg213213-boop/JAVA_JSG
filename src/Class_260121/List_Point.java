package Class_260121;
import java.util.ArrayList;

public class List_Point {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("사과");
        list.add("바나나");
        list.add("딸기");

        System.out.println("ArrayList<String> list의 list.get(0): " + list.get(0));
        System.out.println("ArrayList<String> list의 list.get(1): " + list.get(1));
        System.out.println("ArrayList<String> list의 list.get(2): " + list.get(2));

        list.set(0, "사과2 수정");
        System.out.println("list.set(0,\"사과2 수정\"); 수정 후 , list.get(0): " + list.get(0));

        list.remove(2);

        list.clear();

        boolean isEmpty = true;
        System.out.println("list의 비어 있는지 여부 확인. :" + isEmpty);

        list.add("사과");
        list.add("바나나");
        list.add("딸기");
        list.add("apple");
        System.out.println("향상된 for 문 이용 전체 출력  ");
        for (String fruit : list) {
            System.out.println("list 요소 확인 : " + fruit);
        }

        boolean check = list.contains("사과");
        System.out.println("검색 방법1,list.contains(\"사과\"): 있는지 여부 확인 :  " + check);

        int appleIndex = list.indexOf("사과");
        int berryIndex = list.lastIndexOf("딸기");
        System.out.println("appleIndex 의 위치: " + appleIndex);
        System.out.println("berryIndex 의 위치: " + berryIndex);

        String foundFruit = null;
        for (String fruit : list) {
            if (fruit.startsWith("사")) {
                foundFruit = fruit;
                break;
            }
        }
        System.out.println("사로 시작하는 과일 : " + foundFruit);
    }
}