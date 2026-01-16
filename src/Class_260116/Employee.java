package Class_260116;

class Employee {
    protected String department;
    public Employee(String department) {
        this.department = department;
    }
}
class Manager extends Employee {
    public Manager(String department) {
        super(department);
    }
    public void printDept() {
        System.out.println("소속 부서 : " + this.department);
    }
}

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
