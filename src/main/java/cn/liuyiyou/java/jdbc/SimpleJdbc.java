package cn.liuyiyou.java.jdbc;

import cn.liuyiyou.service.SubsProdService;
import com.alibaba.druid.util.JdbcUtils;
import org.junit.Test;

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
    private String url = "jdbc:mysql://localhost:3306/liuyiyou.cn_user";
    private String username = "root";
    private String password = "123456";

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
    }

    public void select(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(4));
        }

    }

//    public static void main(String[] args) {
//        IntStream.range(1, 1000).forEach(i -> {
//            SimpleJdbc simpleJdbc = new SimpleJdbc();
//            simpleJdbc.init();
//        });
//    }

    @Test
    public void getSubsProds() throws SQLException {
        SubsProdService subsProdService = new SubsProdService();
        subsProdService.nullSubsProds();
    }
}
