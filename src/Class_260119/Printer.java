package Class_260119;

abstract class Machine {


    void powerOn() {
        System.out.println("전원을 켭니다.");
    }
}

class Printer extends Machine {

    void operate() {
        System.out.println("프린터가 문서를 출력합니다.");
    }
}

class Main_Point {
    public static void main(String[] args) {

        Printer myPrinter = new Printer();

        myPrinter.powerOn();
        myPrinter.operate();
    }
}