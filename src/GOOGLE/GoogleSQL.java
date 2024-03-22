package GOOGLE;

import NAVER.NaverMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoogleSQL {

   Connection con;
   PreparedStatement pstmt;
   ResultSet rs;

   public void connect(){
       con =DBC.DBConnect();
   }
   public void conClose(){
       try {
           con.close();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

    public void memberJoin(GoogleMember member) {
        try {
            String sql = "INSERT INTO GOOGLE VALUES(?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, member.getgId());
            pstmt.setString(2, member.getgPw());
            pstmt.setString(3, member.getgName());
            pstmt.setString(4, member.getgBirth());
            pstmt.setString(5, member.getgGender());
            pstmt.setString(6, member.getgPhone());

            int result = pstmt.executeUpdate();

            if(result > 0) {
                System.out.println("가입 성공!");

            } else {
                System.out.println("가입 실패!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void memberList() {
        try {
            String sql = "SELECT * FROM GOOGLE";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {

                System.out.print("| 아이디 : " + rs.getString(1));
                System.out.print("\t| 이름 : " + rs.getString(3));
                System.out.println("\t| 연락처 : " + rs.getString(6) + "\t|");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean memberLogin(String gId, String gPw) {
       boolean result = false;
        try {
            String sql = "SELECT * FROM GOOGLE WHERE GID = ? AND GPW = ? ";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, gId);
            pstmt.setString(2, gPw);

            rs = pstmt.executeQuery();

            result = rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }



    public void memberModify(GoogleMember member) {
        try {
            // (1) sql문 작성 : 입력할 데이터 대신 '?' 작성
            String sql = "UPDATE GOOGLE SET GPW=?, GNAME=?, GBIRTH=?, GGENDER=?, GPHONE=? WHERE GID=?";

            // (2) db 준비
            pstmt = con.prepareStatement(sql);

            // (3) sql문에서 '?' 데이터 처리

            // sql문의 1(첫번째) '?'에 member객체의 nId(getgId()로 불러온)값을 입력
            pstmt.setString(1, member.getgPw());
            pstmt.setString(2, member.getgName());
            pstmt.setString(3, member.getgBirth());
            pstmt.setString(4, member.getgGender());
            pstmt.setString(5, member.getgPhone());
            //기준이 되는 컬럼 GID 6번째 '?'
            pstmt.setString(6, member.getgId());
            // 물음표의 번호, getter로 받아오는 데이터(이름 꼭 확인)

            // (4) 실행 : insert, update, delete(int result), select(ResultSet rs)
            int result = pstmt.executeUpdate();

            // (5) 결과처리
            if (result > 0) {
                System.out.println("수정 성공!");
            } else {
                System.out.println("수정 실패!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void memberDelete(String gId) {
        try {
            //[1] sql문 작성
            String sql = "DELETE  FROM GOOGLE WHERE GID = ?";
            //[2] db준비
            pstmt = con.prepareStatement(sql);
            //[3] 데이터
            pstmt.setString(1, gId);
            //[4] 실행
            int result = pstmt.executeUpdate();
            //[5] 결과
            if (result > 0) {
                System.out.println("삭제 성공!");
            } else {
                System.out.println("삭제 실패!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void myInfo(String gId) {

        try {
            // (1) sql문 작성

            //String sql = "SELECT * FROM NAVER WHERE NID=?";
            String sql = "SELECT GID,GPW,GNAME,TO_CHAR(GBIRTH, 'YYYY-MM-DD'),GGENDER,GPHONE FROM GOOGLE WHERE GID=?";
            // (2) db 준비
            pstmt = con.prepareStatement(sql);
            // (3) 데이터 입력
            pstmt.setString(1, gId);

            // (4) 실행
            rs = pstmt.executeQuery();

            // (5) 결과
            if (rs.next()) {
                System.out.println("아이디 :" + rs.getString(1));
                System.out.println("비밀번호 :" + rs.getString(2));
                System.out.println("이  름 :" + rs.getString(3));
                System.out.println("생년월일 :" + rs.getString(4));
                System.out.println("성  별 :" + rs.getString(5));
                System.out.println("연락처 :" + rs.getString(6));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}





