package Class_260119;

abstract class Animal {
    public void sound() {
        System.out.println("동물 소리");
    }

    public abstract void speak();

    public void scratch() {
    }

}

class Cat01 extends Animal {
    @Override
    public void sound() {
        System.out.println("야옹~");
    }

    @Override
    public void speak() {

    }

    public void scratch() {
        System.out.println("할퀴기!");
    }


}

public class pet {
    public static void main(String[] args) {
        // 1. 업캐스팅 (Upcasting)
        // 부모 타입의 참조 변수 'a'로 자식 객체 'Cat'을 가리킴
        Animal cat = new Cat01();

        System.out.print("a.sound() 호출 결과: ");
        // 2. 오버라이딩된 메서드 호출
        // 타입은 Animal이지만, 실제 객체가 Cat이므로 Cat의 sound()가 실행됨
        cat.sound();
        cat.scratch();


        // 참고: 업캐스팅 상태에서는 Cat 클래스에만 있는 메서드는 호출할 수 없습니다.
        // a.scratch(); // 컴파일 에러 발생!
    }
}