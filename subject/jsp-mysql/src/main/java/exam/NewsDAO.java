package exam;

import java.sql.*;
import java.util.ArrayList;

public class NewsDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    static String jdbc_url="jdbc:mysql://localhost:3306/web-framework";

    public void connect() {
        try{
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(jdbc_url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void disconnect() {
        if(pstmt != null) {
            try{
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
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

    public ArrayList<NewsVO> listNews() {
        connect();
        ArrayList<NewsVO> list = new ArrayList<>();
        String sql = "select * from news order by id";
        try{
            pstmt=conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                NewsVO news = new NewsVO();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setBody(rs.getString("body"));
                news.setWriter(rs.getString("writer"));
                news.setReadcnt(rs.getInt("readcnt"));
                news.setRegdate(rs.getString("regdate"));
                list.add(news);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnect();
        }
        return list;
    }

    public NewsBodyVO detailNews(int id) {
        connect();
        NewsBodyVO news = new NewsBodyVO();
        String sql = "select title,writer,body from news where id=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                news.setTitle(rs.getString("title"));
                news.setBody(rs.getString("body"));
                news.setWriter(rs.getString("writer"));
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnect();
        }
        return news;
    }

    public void updateReadCnt(int id) {
        connect();
        String sql = "update news set readcnt = readcnt + 1 where id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnect();
        }
    }

    public void updateNews(int id, NewsBodyVO news) {
        connect();
        String sql = "UPDATE news SET writer = ?, title = ?, body = ?, regdate = sysdate() WHERE id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, news.getWriter());
            pstmt.setString(2, news.getTitle());
            pstmt.setString(3, news.getBody());
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disconnect();
        }
    }
}
