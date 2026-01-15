package Class_260115;

public class Person_2_Point {
    String name;

    public Person_2_Point(String name) {
        this.name = name;
    }

    void sayHello() {
        System.out.println("안녕하세요, 제 이름은 " + name + "입니다.");
    }
}

class Main {
    public static void main(String[] args) {
        // 수정: 클래스 이름을 Person_2_Point로 일치시킴
        Person_2_Point p = new Person_2_Point("정성규");
        p.sayHello();
    }
}
