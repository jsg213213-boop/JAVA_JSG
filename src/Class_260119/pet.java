package Class_260119;

abstract class Animal {
    public void sound() {
        System.out.println("동물 소리");
    }

    public void scratch() {
    }

}

class Cat01 extends Animal {
    @Override
    public void sound() {
        System.out.println("야옹~");
    }

    public void scratch() {
        System.out.println("할퀴기!");
    }


}

public class pet {
    public static void main(String[] args) {

        Animal cat = new Cat01();

        System.out.print("a.sound() 호출 결과: ");

        cat.sound();
        cat.scratch();


    }
}