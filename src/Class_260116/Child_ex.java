package Class_260116;

public class Child_ex extends Parent_ex{

    @Override
    public void hello() {
        System.out.println("순서1, 자식 hello() 호출");

        System.out.println("순서2,  부모 super.hello() 호출 전");
        super.hello();
        System.out.println("순서5,  부모 super.hello() 호출 완료");
        System.out.println("순서6,  자식 hello() 내용 호출");
        System.out.println("안녕, 자식입니다.");
        System.out.println("순서7,  자식 hello() 내용 호출 완료");
    }
}
