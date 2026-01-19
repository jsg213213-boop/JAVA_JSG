package Class_260119;

class Animal03 {
    public void speak() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Dog extends Animal03 {
    @Override
    public void speak() {
        System.out.println("멍멍! 강아지입니다.");
    }

    public void wagTail() {
        System.out.println("강아지가 꼬리를 흔듭니다.");
    }
}

class Cat04 extends Animal03 {
    @Override
    public void speak() {
        System.out.println("야옹~ 고양이입니다.");
    }

    public void scratch() {
        System.out.println("고양이가 발톱을 세웁니다.");
    }
}

public class Animal03_Main {
    public static void main(String[] args) {

        Animal03[] aniList = new Animal03[3];

        aniList[0] = new Dog();
        aniList[1] = new Cat04();
        aniList[2] = new Animal03();

        System.out.println("=== 동물 리스트 확인 ===");
        for (Animal03 ani : aniList) {

            if (ani instanceof Dog d) {

                d.speak();
                d.wagTail();
            }
            else if (ani instanceof Cat04 c) {

                c.speak();
                c.scratch();
            }
            else {

                ani.speak();
            }

            System.out.println("--------------------");
        }
    }
}