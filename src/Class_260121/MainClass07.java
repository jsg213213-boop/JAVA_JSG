package Class_260121;
import java.io.*;
import java.util.*;
public class MainClass07 {
    private static final String FILE_NAME = "members.txt";

    public static void main(String[] args) {
        // 배열 대신 Map 사용 (Key: 이메일, Value: 회원객체)
        Map<String, MemberBase> members = new HashMap<>();

        // 파일 데이터 로드
        loadMembers(members);

        MemberBase loggedInMember = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=============회원 관리 시스템 (Map 버전)=======");

            if(loggedInMember != null) {
                System.out.println("-------------------------------------------");
                System.out.println("로그인 한 유저 : " + loggedInMember.getEmail());
                System.out.println("-------------------------------------------");
            }

            System.out.println("1. 회원가입 2. 목록조회 3. 로그인 4. 로그아웃 5. 종료");
            System.out.print("메뉴 선택 >> ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
                continue;
            }

            switch (choice) {
                case 1: // 회원가입
                    System.out.print("이름: ");
                    String name = sc.nextLine();
                    System.out.print("이메일: ");
                    String email = sc.nextLine();
                    System.out.print("패스워드: ");
                    String password = sc.nextLine();
                    System.out.print("나이: ");
                    int age = Integer.parseInt(sc.nextLine());

                    // 중복 체크
                    if (members.containsKey(email)) {
                        System.out.println("이미 존재하는 이메일입니다.");
                    } else {
                        NormalMember newMember = new NormalMember(name, email, password, age);
                        members.put(email, newMember); // Map에 추가
                        newMember.join();
                        saveMembers(members); // 저장
                    }
                    break;

                case 2: // 목록조회
                    if (members.isEmpty()) {
                        System.out.println("가입된 회원이 없습니다. ");
                    } else {
                        System.out.println("\n 총회원수 : " + members.size() + "명입니다.");
                        for (MemberBase m : members.values()) {
                            m.showInfo();
                        }
                    }
                    break;

                case 3: // 로그인
                    System.out.println("\n====로그인===== ");
                    System.out.print("이메일 : ");
                    String inputEmail = sc.nextLine();
                    System.out.print("패스워드 : ");
                    String inputPassword = sc.nextLine();

                    // Map에서 바로 검색 (루프 필요 없음)
                    MemberBase member = members.get(inputEmail);

                    if (member != null && member.getPassword().equals(inputPassword)) {
                        System.out.println("로그인 성공!! 환영합니다, " + member.getName() + "님");
                        loggedInMember = member;
                    } else {
                        System.out.println("로그인 실패: 정보가 일치하지 않습니다. ");
                    }
                    break;

                case 4: // 로그아웃
                    loggedInMember = null;
                    System.out.println("로그아웃 되었습니다.");
                    break;

                case 5: // 종료
                    System.out.println("프로그램을 종료합니다. ");
                    sc.close();
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 파일 저장 로직 (Map 기반)
    public static void saveMembers(Map<String, MemberBase> members){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for(MemberBase m : members.values()) {
                String line = m.getName() + "," + m.getEmail() + "," + m.getPassword() + "," + m.getAge();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("데이터가 파일에 동기화되었습니다.");
        } catch (IOException e){
            System.out.println("저장 오류: " + e.getMessage());
        }
    }

    // 파일 로드 로직 (Map 기반)
    public static void loadMembers(Map<String, MemberBase> members){
        File file = new File(FILE_NAME);
        if(!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null ) {
                String[] data = line.split(",");
                if(data.length == 4) {
                    String name = data[0];
                    String email = data[1];
                    String password = data[2];
                    int age = Integer.parseInt(data[3]);
                    members.put(email, new NormalMember(name, email, password, age));
                }
            }
            System.out.println("파일 로드 완료: " + members.size() + "명");
        } catch (IOException e){
            System.out.println("로드 실패: " + e.getMessage());
        }
    }
}
