package Class_260119;

class Parent {
    Parent() {
        System.out.println("부모 생성자 호출");
    }
}

class Child extends Parent {
}

class Main {
    public static void main(String[] args) {
        System.out.println("--- 객체 생성 시작 ---");
        System.out.println("--- 객체 생성 완료 ---");
    }
}