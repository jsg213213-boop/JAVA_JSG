package Class_260120;
import java.util.Scanner;

interface Joinable {
}

abstract class MemberBase {
    protected String name;
    protected String email;
    protected String password;
    protected int age;

    public MemberBase(String name, String email, String password, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public abstract void showInfo();

    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public String getName() { return name;
    }

    public String getAge() {
        return String.valueOf(age);
    }

}

class NormalMember extends MemberBase implements Joinable {
    public NormalMember(String name, String email, String password, int age) {
        super(name, email, password, age);
    }

    public void join() {
        System.out.println("✅ " + name + "님 회원가입 완료.");
    }

    @Override
    public void showInfo() {
        System.out.println("[이름: " + name + " | 이메일: " + email + " | 나이: " + age + "]");
    }
}

public class MainClass03 {
    public static void main(String[] args) {
        MemberBase[] members = new MemberBase[5];
        int count = 0;

        MemberBase loginUser = null;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n============= 회원 관리 시스템 ver 1.2 =============");

            if (loginUser != null) {
                System.out.println("👤 로그인한 유저 : " + loginUser.getEmail());
            } else {
                System.out.println("👤 로그인 상태가 아닙니다.");
            }

            System.out.println("1. 회원가입  2. 목록조회  3. 로그인  4. 로그아웃  5. 종료");
            System.out.print("메뉴 선택 >> ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ 숫자만 입력해주세요.");
                continue;
            }

            switch(choice) {
                case 1:
                    if(count >= members.length) {
                        System.out.println("❌ 정원초과입니다.");
                        break;
                    }
                    System.out.print("이름: "); String name = sc.nextLine();
                    System.out.print("이메일: "); String email = sc.nextLine();
                    System.out.print("비밀번호: "); String password = sc.nextLine();
                    System.out.print("나이: "); int age = Integer.parseInt(sc.nextLine());

                    NormalMember newMember = new NormalMember(name, email, password, age);
                    members[count++] = newMember;
                    newMember.join();
                    break;

                case 2:
                    System.out.println("\n--- 전체 회원 목록 ---");
                    if(count == 0) System.out.println("가입된 회원이 없습니다.");
                    for(int i=0; i<count; i++) {
                        members[i].showInfo();
                    }
                    break;

                case 3:
                    System.out.print("이메일: "); String inputEmail = sc.nextLine();
                    System.out.print("비밀번호: "); String inputPw = sc.nextLine();

                    boolean isSuccess = false;
                    for(int i=0; i<count; i++) {
                        if(members[i].getEmail().equals(inputEmail) &&
                                members[i].getPassword().equals(inputPw)) {
                            loginUser = members[i]; // 로그인 성공 시 유저 정보 저장
                            System.out.println("🎉 로그인 성공! " + loginUser.name + "님 반갑습니다.");
                            isSuccess = true;
                            break;
                        }
                    }
                    if(!isSuccess) System.out.println("❌ 정보가 불일치해서 로그인 안됩니다.");
                    break;

                case 4:
                    if(loginUser != null) {
                        System.out.println("👋 " + loginUser.name + "님 로그아웃 되었습니다.");
                        loginUser = null;
                    } else {
                        System.out.println("이미 로그아웃 상태입니다.");
                    }
                    break;

                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("번호를 다시 확인해주세요.");
            }
        }
    }
}