package cn.liuyiyou.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * @author: liuyiyou
 * @date: 2018/1/11
 */
public class SimpleJdbc {

    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/blog";
    private String username = "root";
    private String password = "123456";

    public void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);

    }

    public void select(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(4));
        }

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SimpleJdbc simpleJdbc = new SimpleJdbc();
        simpleJdbc.init();
        simpleJdbc.select("select * from t_area");
        simpleJdbc.init();
        simpleJdbc.select("select * from t_area");
    }
}
