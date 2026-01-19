package Class_260119;

class A {
    A() {
        System.out.println("1) 부모 클래스 A 생성자 호출");
    }

}

class B extends A {
    B() {
        // super(); 가 생략되어 부모 생성자가 먼저 호출됨
        System.out.println("1) 자식 클래스 B 생성자 호출");
    }

    public void show() {
        System.out.println("2) 자식 클래스 B의 show() 실행 (오버라이딩)");
    }

    public void onlyB() {
        System.out.println("3) B 클래스에만 있는 특별한 메서드 실행");
    }
}

public class AMain {
    public static void main(String[] args) {

        System.out.println("=== 생성자 호출 순서 확인 ===");
        System.out.println();

        System.out.println("=== 업캐스팅과 오버라이딩 ===");

        B upcastedA = new B();

        upcastedA.show();
        System.out.println();

        System.out.println("=== instanceof 검사 및 다운캐스팅 ===");

        System.out.println("검사 결과: upcastedA는 B의 인스턴스가 맞습니다.");

        upcastedA.onlyB();
    }
}