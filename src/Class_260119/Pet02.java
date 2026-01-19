package Class_260119;

class Animal02 {
    public void sound() {
        System.out.println("동물 소리");
    }
}

class Cat extends Animal02 {
    @Override
    public void sound() {
        System.out.println("야옹~");
    }
}

public class Pet02 {
    public static void main(String[] args) {

        Cat cat1 = new Cat();
        System.out.print("cat1.sound(): ");
        cat1.sound();

        Animal02 cat2 = new Cat();
        System.out.print("cat2.sound(): ");
        cat2.sound();
    }
}