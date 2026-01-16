package Class_260116;

public class Animalmain_ex {
    public static void main(String[] args) {
        Animalcat_ex cat1 = new Animalcat_ex();
        cat1.name = "야옹이"; // 부모 클래스의 변수
        cat1.speak(); // 부모 클래스의 메서드 이용.
        cat1.bark(); // 자식 클래스의 (본인) 메서드
        System.out.println("cat의 이름 : " + cat1.name);
    }
}
