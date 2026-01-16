package Class_260116;

public class StaticMain_ex {
    public static void main(String[] args) {
        Static_ex sample1 =
                new Static_ex();
        sample1.number = 100;
        System.out.println("sample1.number :" + sample1.number);

        Static_ex sample2 =
                new Static_ex();
        sample2.number = 200;
        System.out.println("sample2.number :" + sample2.number);

        Static_ex.increment();
        Static_ex.increment();

        System.out.println("공유 count 값 조회 : " + Static_ex.count);
    }
}
