package Class_260119;


abstract class Vehicle {

    void fuel() {
        System.out.println("연료 충전");
    }
}

class Car extends Vehicle {
    void move() {
        System.out.println("자동차가 도로 위를 달립니다.");
    }
}

public class VehicleMain {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.fuel();
        myCar.move();
    }
}