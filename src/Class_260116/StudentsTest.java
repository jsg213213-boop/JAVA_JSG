package Class_260116;

class StudentEx1 {
    String name;
    int score;


    public StudentEx1(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class StudentsTest {
    public static void main(String[] args) {

        StudentEx1[] students = createStudents();

        System.out.println("--- 성적이 90점 이상인 학생 목록 ---");

        for (StudentEx1 s : students) {
            if (s.score >= 90) {
                System.out.println("이름: " + s.name + ", 점수: " + s.score);
            }
        }
    }


    public static StudentEx1[] createStudents() {
        StudentEx1 s1 = new StudentEx1("김철수", 95);
        StudentEx1 s2 = new StudentEx1("이영희", 85);
        StudentEx1 s3 = new StudentEx1("박지성", 92);

        return new StudentEx1[]{s1, s2, s3};
    }
}