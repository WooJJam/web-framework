package ex01;

import java.lang.reflect.Member;
import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    static String jdbc_url="jdbc:mysql://localhost:3306/web-framework?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true";

    public void connect() {
        try{
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(jdbc_url,"root","jaemin5548");
        } catch (Exception e) {
            System.out.println("e="+e);
        }
    }
    public void disconnect() {
        if(pstmt != null) {
            try{
                pstmt.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        if(conn !=null) {
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<MemberVO> listMember() {
        connect();
        ArrayList<MemberVO> list = new ArrayList<>();
        String sql = "select * from member order by id";
        try{
            pstmt=conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                MemberVO member = new MemberVO();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setPassword(rs.getString("password"));
                member.setRegdate(rs.getString("regdate"));
                list.add(member);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnect();
        }
        return list;
    }

}
