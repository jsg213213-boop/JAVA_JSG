package Class_260119;

class A {
    A() {
        System.out.println("1) 부모 클래스 A 생성자 호출");
    }

    public void show() {
        System.out.println("부모 클래스 A의 show() 실행");
    }
}

class B extends A {
    B() {
        // super(); 가 생략되어 부모 생성자가 먼저 호출됨
        System.out.println("1) 자식 클래스 B 생성자 호출");
    }

    @Override
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
        B objB = new B();
        System.out.println();

        System.out.println("=== 업캐스팅과 오버라이딩 ===");
        // 업캐스팅: 부모 타입 A 변수에 자식 객체 B를 할당
        A upcastedA = new B();
        // 업캐스팅 상태여도 실제 객체인 B의 오버라이딩된 메서드가 호출됨
        upcastedA.show();
        System.out.println();

        System.out.println("=== instanceof 검사 및 다운캐스팅 ===");
        // 현재 upcastedA는 A 타입이지만 실제 인스턴스는 B임
        if (upcastedA instanceof B) {
            System.out.println("검사 결과: upcastedA는 B의 인스턴스가 맞습니다.");

            // 다운캐스팅: 부모 타입을 다시 자식 타입으로 강제 변환
            B downcastedB = (B) upcastedA;

            // 이제 B 클래스에만 있는 메서드에 접근 가능
            downcastedB.onlyB();
        } else {
            System.out.println("검사 결과: B 타입으로 변환할 수 없습니다.");
        }
    }
}