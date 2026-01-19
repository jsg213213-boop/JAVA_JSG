package Class_260119;

abstract class Shape {
    abstract void draw(); // 추상 메서드
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("원을 그립니다.");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("사각형을 그립니다.");
    }
}

class Oval extends Shape {
    @Override
    void draw() {
        System.out.println("타원을 그립니다.");
    }
}

public class ShapeMain {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rect = new Rectangle();
        Shape oval = new Oval();

        circle.draw();
        rect.draw();
        oval.draw();
    }
}