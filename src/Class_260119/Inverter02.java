package Class_260119;

interface Camera {
}

interface Phone {
}

class SmartPhone implements Camera, Phone {
    public void takePhoto() {
        System.out.println("사진을 찍습니다. (SmartPhone)");
    }

    public void makeCall() {
        System.out.println("전화를 겁니다. (SmartPhone)");
    }
}

public class Inverter02 {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone();

        myPhone.takePhoto();
        myPhone.makeCall();

        myPhone.takePhoto(); // 가능

    }
}