package WebServlet.OnlineTest;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class MysqlConnector {

    public boolean exeQuery(String userName,String userPassword){
        Connection conn=null;
        String url = "jdbc:mysql://localhost:3306/javaee?"
                + "user=root&password=&useUnicode=true&characterEncoding=UTF8";
        try {
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");

            conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from USER");
            System.out.println(rs);
                try {
                    while (rs.next()) {
                        System.out.println(rs.getString(2) + "\t" + rs.getString(3));
                        if(userName.equals(rs.getString(2))&&userPassword.equals(rs.getString(3))){
                            System.out.println("查找成功");
                            return true;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            return false;

        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean exeQueryUserName(String userName){
        Connection conn=null;
        String url = "jdbc:mysql://localhost:3306/javaee?"
                + "user=root&password=&useUnicode=true&characterEncoding=UTF8";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");

            conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from USER");
            System.out.println(rs);
            try {
                while (rs.next()) {
                    System.out.println(rs.getString(2) + "\t" + rs.getString(3));
                    if(userName.equals(rs.getString(2))){
                        System.out.println("查找成功");
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;

        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }


    public boolean exeInsert(String userName,String userPassword){
        Connection conn=null;
        String url = "jdbc:mysql://localhost:3306/javaee?"
                + "user=root&password=&useUnicode=true&characterEncoding=UTF8";
        String sql="insert into USER(USERNAME,USERPASSWORD) values('"+userName+"','"+userPassword+"')";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            int ans=stmt.executeUpdate(sql);
            if(ans==-1)
                return false;
            else
                return true;


        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }


}