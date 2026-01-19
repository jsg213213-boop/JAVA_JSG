package Class_260119;

abstract class Machine {

    // 일반 메서드: 공통 기능 제공 가능
    void powerOn() {
        System.out.println("전원을 켭니다.");
    }
}

class Printer extends Machine {
    // 추상 메서드 오버라이딩 (구현)
    void operate() {
        System.out.println("프린터가 문서를 출력합니다.");
    }
}

class Main_Point {
    public static void main(String[] args) {
        // Machine m = new Machine(); // 에러: 추상 클래스는 인스턴스화할 수 없음

        // 자식 클래스 객체 생성
        Printer myPrinter = new Printer();

        myPrinter.powerOn();  // 부모로부터 물려받은 메서드
        myPrinter.operate();  // 직접 구현한 메서드
    }
}