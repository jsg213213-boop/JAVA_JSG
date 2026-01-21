package Class_260121;
import java.util.ArrayList;
public class StudentManager {
    public static void main(String[] args) {

        ArrayList<String> studentList = new ArrayList<>();

        studentList.add("홍길동");
        studentList.add("이순신");
        studentList.add("강감찬");

        System.out.println("두 번째 학생: " + studentList.get(1));

        studentList.set(2, "을지문덕");

        studentList.remove("홍길동");

        System.out.println("리스트 크기: " + studentList.size());

        System.out.println("--- 남은 학생 명단 ---");
        for (String student : studentList) {
            System.out.println(student);
        }
    }
}