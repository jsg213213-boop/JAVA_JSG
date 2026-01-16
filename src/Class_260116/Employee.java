package Class_260116;

class Employee {
    protected String department; // 자식 클래스에게 접근 허용

    // 매개변수가 1개인 생성자
    public Employee(String department) {
        this.department = department;
    }
}

// 2. 자식 클래스: Manager
class Manager extends Employee { // 부모 클래스 상속

    // 자식 생성자: 매개변수 1개
    public Manager(String department) {
        // [주의] 부모 클래스 생성자를 반드시 먼저 호출해야 함
        super(department);
    }

    // 메서드: 부모의 protected 필드를 상속받아 출력
    public void printDept() {
        System.out.println("소속 부서 : " + this.department);
    }
}

// 3. 메인 클래스
class Main {
    public static void main(String[] args) {
        // Manager 객체 2개 생성
        Manager m1 = new Manager("개발팀");
        Manager m2 = new Manager("기획팀");

        System.out.println("=== 매니저 부서 정보 ===");
        m1.printDept();
        m2.printDept();
    }
}
