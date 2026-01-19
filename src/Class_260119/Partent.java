package Class_260119;

class Parent {
    Parent() {
        System.out.println("부모 생성자 호출");
    }
}

class Child extends Parent {
    Child() {
        // 사실 이곳에는 super(); 가 생략되어 있습니다.
        System.out.println("자식 생성자 호출");
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("--- 객체 생성 시작 ---");
        Child child = new Child();
        System.out.println("--- 객체 생성 완료 ---");
    }
}