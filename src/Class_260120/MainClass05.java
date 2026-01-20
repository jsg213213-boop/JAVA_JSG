package Class_260120;

import java.io.*;
import java.util.Scanner;

public class MainClass05 {


    private static final String FILE_NAME = "members.txt";

    public static void main(String[] args) {

        MemberBase[] members = new MemberBase[5];
        int count = 0;

        count = loadMembers(members);

        MemberBase loggedInMember = null;


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=============회원 관리 시스템 ver 1.0=======");

            if(loggedInMember != null) {
                System.out.println("-------------------------------------------");
                System.out.println("로그인 한 유저 : " + loggedInMember.getEmail());
                System.out.println("-------------------------------------------");
            }

            System.out.println("1. 회원가입 2. 목록조회 3. 로그인 4. 종료");
            System.out.println("메뉴 선택 >>");

            int choice;
            try {

                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");

                continue;
            }

            switch (choice) {
                case 1:
                    if (count >= members.length) {
                        System.out.println("정원초과, 가입 불가입니다.");
                        break;
                    }
                    System.out.println("이름: ");
                    String name = sc.nextLine();

                    System.out.println("이메일: ");
                    String email = sc.nextLine();


                    System.out.println("패스워드: ");
                    String password = sc.nextLine();

                    System.out.println("나이: ");

                    int age = Integer.parseInt(sc.nextLine());


                    NormalMember newMember = new NormalMember(name, email, password, age);

                    members[count] = newMember;

                    newMember.join();

                    count++;

                    saveMembers(members, count);
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("가입된 회원이 없습니다. ");
                    } else {
                        System.out.println("\n 총회원수 : " + count + "명입니다.");
                        for (int i = 0; i < count; i++) {
                            members[i].showInfo();
                        }
                    }
                    break;

                case 3:

                    System.out.println("\n====로그인===== ");

                    System.out.println("이메일 : ");
                    String inputEmail = sc.nextLine();

                    System.out.println("패스워드 : ");
                    String inputPassword = sc.nextLine();


                    boolean isLogin = false;

                    for (int i = 0; i < count; i++) {

                        MemberBase member = members[i];

                        if(member.getEmail().equals(inputEmail) &&
                                member.getPassword().equals(inputPassword)
                        ) {
                            System.out.println("로그인 성공!! 환영합니다.~" + member.name+ "님");
                            isLogin = true;

                            loggedInMember = member;
                            break;
                        }
                    }
                    if(!isLogin) {
                        System.out.println("로그인 실패: 정보가 일치하지 않습니다. ");
                    }
                    break;

                case 4:
                    System.out.println("프로그램을 종료합니다. ");

                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");


            }


        }

    }
    public static void saveMembers(MemberBase[] members, int count){

        BufferedWriter bw = null;

        try {

            bw = new BufferedWriter(new FileWriter(FILE_NAME));


            for(int i = 0; i < count; i++) {
                MemberBase m = members[i];

                String line = m.getName()+","+m.getEmail()+","+m.getPassword()+","+m.getAge();

                bw.write(line);
                bw.newLine(); // 줄바꿈 함.
            }
            System.out.println("파일 저장 완료 " + FILE_NAME);

        } catch (IOException e){
            System.out.println("오류가 발생 했습니다. 원인: " + e.getMessage());
        }finally {

            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("오류 발생, 파일 닫기 실패. ");
                }
            }

        }
    }

    public static int loadMembers(MemberBase[] members){

        File file = new File(FILE_NAME);


        if(!file.exists()) {
            return 0;
        }

        int loadCount = 0;

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null ) {
                if(loadCount >= members.length) {
                    break;
                }
                String[] data = line.split(",");
                if( data.length == 4) {
                    String name = data[0];
                    String email = data[1];
                    String password = data[2];
                    int age = Integer.parseInt(data[3]);
                    members[loadCount] = new NormalMember(name,email,password,age);
                    loadCount++;

                }
            }
            System.out.println("파일 불러오기 완료 :" + loadCount + "명의 회원 정보를 불러옴.");
        }catch (IOException e){
            System.out.println("파일 불러오기 실패 원인 : " + e.getMessage());
        }finally {
            if( br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("파일 닫기 실패");
                }
            }
        }
        return loadCount;
    }

}
