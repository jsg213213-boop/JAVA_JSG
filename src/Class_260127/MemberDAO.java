package Class_260127;
import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    // 11을 뺀 정확한 오라클 접속 주소입니다.
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "scott";
    private static final String PASSWORD = "tiger";

    // DB 연결 메서드
    public static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 1. 회원가입 (DB에 데이터 저장)
    public static void insertMember(MemberBase member) {
        String sql = "INSERT INTO members (name, email, password, age) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // ? 자리에 순서대로 데이터를 채웁니다.
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPassword());
            pstmt.setInt(4, member.getAge());

            pstmt.executeUpdate(); // 실행
            System.out.println("[DB 성공] " + member.getName() + "님 데이터 저장 완료!");

        } catch (Exception e) {
            System.err.println("[DB 에러] 회원가입 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    // 2. 전체 조회 (DB에서 싹 긁어오기)
    public static ArrayList<MemberBase> selectAll() {
        ArrayList<MemberBase> list = new ArrayList<>();
        String sql = "SELECT * FROM members ORDER BY name ASC"; // 이름순 정렬 추가

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new NormalMember(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("age")
                ));
            }
            System.out.println("[DB 조회 성공] 총 " + list.size() + "명의 데이터를 가져왔습니다.");
        } catch (Exception e) {
            System.err.println("[DB 조회 에러] 목록을 불러오지 못했습니다.");
            e.printStackTrace();
        }
        return list;
    }

    // 3. 회원 탈퇴 (DB에서 데이터 삭제)
    public static void deleteMember(String email) {
        String sql = "DELETE FROM members WHERE email = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            int result = pstmt.executeUpdate(); // 영향받은 행의 수 반환

            if (result > 0) {
                System.out.println("[DB 삭제 성공] 이메일: " + email);
            } else {
                System.out.println("[DB 안내] 삭제할 대상이 없습니다.");
            }

        } catch (Exception e) {
            System.err.println("[DB 에러] 삭제 처리 중 오류 발생!");
            e.printStackTrace();
        }
    }
}