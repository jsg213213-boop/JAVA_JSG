package Class_260119;

interface RemoteControl {
    void turnOn();  // 추상 메서드 (구현부가 없음)
    void turnOff(); // 추가 예시 메서드
}

class TV implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }
}

// 3. 또 다른 구현 클래스 (확장성 예시)
class Radio implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("라디오를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("라디오를 끕니다.");
    }
}

public class Inverter {
    public static void main(String[] args) {

        RemoteControl myTV = new TV();
        RemoteControl myRadio = new Radio();

        myTV.turnOn();
        myRadio.turnOn();
        myTV.turnOff();
    }
}