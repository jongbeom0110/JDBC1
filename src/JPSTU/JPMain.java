package JPSTU;

import java.util.Scanner;

public class JPMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int menu = 0;

        // JPMember 객체
        JPMember member = new JPMember();

        // JPSQL 객체
        JPSQL sql = new JPSQL();

        while(run){
            System.out.println("====================================================");
            System.out.println("[1]DB접속\t\t[2]접속해제\t\t[3]학생등록\t\t[4]학생목록");
            System.out.println("[5]학생수정\t\t[6]학생삭제\t\t[7]종료");
            System.out.println("====================================================");
            System.out.print("메뉴선택 >>");
            menu = sc.nextInt();

            switch (menu){
                case 1:     // DB접속
                    sql.connect();
                    break;

                case 2:     // 접속해제
                    sql.conClose();
                    break;

                case 3:     // 학생등록
                    System.out.println("학생정보를 입력하세요");

                    System.out.print("학생번호 >>");
                    int jNum = sc.nextInt();

                    System.out.print("비밀번호 >> ");
                    String jPw = sc.next();

                    System.out.print("이름 >> ");
                    String jName = sc.next();

                    System.out.print("나이 >> ");
                    int jAge = sc.nextInt();

                    System.out.print("성별 >> ");
                    String jGender = sc.next();

                    System.out.print("이메일 >> ");
                    String jEmail = sc.next();

                    System.out.print("연락처 >> ");
                    String jPhone = sc.next();

                    member.setjNum(jNum);
                    member.setjPw(jPw);
                    member.setjName(jName);
                    member.setjAge(jAge);
                    member.setjGender(jGender);
                    member.setjEmail(jEmail);
                    member.setjPhone(jPhone);

                    sql.memberJoin(member);
                    break;

                case 4:     // 학생목록
                    sql.memberList();
                    break;

                case 5:     // 학생수정
                    System.out.println("수정할 학생번호 >>");
                    jNum = sc.nextInt();

                    System.out.println("수정할 비밀번호 >>");
                    jPw= sc.next(); //변경 전 비밀번호

                    //학생번호와 비밀번호가 일치하는지 확인
                    boolean checked = sql.idCheck(jNum, jPw);

                    if(checked) {
                        System.out.println("학생정보가 일치합니다.");
                        System.out.println("수정할 회원정보를 입력해주세요.");

                        System.out.print("비밀번호 >> ");
                        jPw = sc.next(); //변경 후 비밀번호

                        System.out.print("이름 >> ");
                        jName = sc.next();

                        System.out.print("나이 >> ");
                        jAge = sc.nextInt();

                        System.out.print("성별 >> ");
                       jGender = sc.next();

                        System.out.print("이메일 >> ");
                        jEmail = sc.next();

                        System.out.print("연락처 >> ");
                        jPhone = sc.next();

                        member.setjNum(jNum);
                        member.setjPw(jPw);
                        member.setjName(jName);
                        member.setjAge(jAge);
                        member.setjGender(jGender);
                        member.setjEmail(jEmail);
                        member.setjPhone(jPhone);

                        sql.memberModify(member);

                    } else {
                        System.out.println("학생정보가 일치하지 않습니다. ");
                    }
                    break;

                case 6:     // 학생삭제
                    System.out.println("삭제할 학생번호 >>");
                    jNum = sc.nextInt();

                    System.out.println("비밀번호 >>");
                    jPw = sc.next();
                    checked = sql.idCheck(jNum, jPw);

                    if(checked){
                        sql.memberDelete(jNum);
                    } else {
                        System.out.println("학생정보가 일치하지 않습니다");
                    }
                    break;

                case 7:     // 종료
                    run = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default:    // 그외에
                    System.out.println("다시 입력해주세요.");
                    break;
            }





        }










    }


}