package Class_260119;

interface Camera {
    void takePhoto();
}

interface Phone {
    void makeCall();
}

class SmartPhone implements Camera, Phone {
    @Override
    public void takePhoto() {
        System.out.println("사진을 찍습니다. (SmartPhone)");
    }

    @Override
    public void makeCall() {
        System.out.println("전화를 겁니다. (SmartPhone)");
    }
}

public class Inverter02 {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone();

        myPhone.takePhoto();
        myPhone.makeCall();

        // 다형성을 활용한 참조
        Camera cameraRef = myPhone;
        cameraRef.takePhoto(); // 가능
        // cameraRef.makeCall(); // 불가능 (Camera 인터페이스에는 makeCall이 없음)
    }
}