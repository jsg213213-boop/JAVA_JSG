package Class_260116;

class Phone {
    private static String manufacturer = "애플";

    private final String model;
    private final String phoneNumber;
    private final String agency;

    public Phone(String model, String phoneNumber, String agency) {
        this.model = model;
        this.phoneNumber = phoneNumber;
        this.agency = agency;
    }

    public void printInfo() {
        System.out.println("[" + manufacturer + "] 모델명: " + model +
                " | 번호: " + phoneNumber +
                " | 통신사: " + agency);
    }

    public static void changeManufacturer(String newName) {
        manufacturer = newName;
        System.out.println("\n--- 제조사가 " + newName + "(으)로 변경되었습니다 ---\n");
    }
}

class EmployeeMain {
    public static void main(String[] args) {

        Phone p1 = new Phone("Galaxy S24", "010-3560-6307", "SKT");
        Phone p2 = new Phone("Galaxy Z Fold4", "010-7204-3009", "LG U+");
        Phone p3 = new Phone("Galaxy Z Fold4", "010-2036-8094", "LG U+");

        System.out.println("=== 초기 제품 정보 ===");
        p1.printInfo();
        p2.printInfo();
        p3.printInfo();

        Phone.changeManufacturer("삼성");

        System.out.println("=== 제조사 변경 후 정보 ===");
        p1.printInfo();
        p2.printInfo();
        p3.printInfo();
    }
}
