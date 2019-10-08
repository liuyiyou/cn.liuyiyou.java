package cn.liuyiyou.java.jdbc;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * @author: liuyiyou
 * @date: 2018/1/11
 */
public class DataSourceJdbc {

    public static Connection getConnection() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/liuyiyou.cn_busi");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void select(String sql) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(4));
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (getConnection() != null) {
                getConnection().close();
            }
        }


    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DataSourceJdbc simpleJdbc = new DataSourceJdbc();
        simpleJdbc.select("select * from user");

    }
}
