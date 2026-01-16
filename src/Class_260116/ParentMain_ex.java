package Class_260116;

public class ParentMain_ex {
    public static void main(String[] args) {
        Child_ex child1 = new Child_ex();
        child1.hello();
        System.out.println("순서8,  자식 hello() 내용 호출 종료");
        System.out.println("순서9,  main() 호출 종료");

    }
}