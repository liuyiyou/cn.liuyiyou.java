package cn.liuyiyou.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Optional;

/***
 * @author: liuyiyou
 * @date: 2018/1/11
 */
public abstract class DataSourceUtils {

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


    public static void exexute() {

    }

    public static void select(String sql) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection connection = Optional.ofNullable(getConnection()).orElseThrow(() -> new RuntimeException("连接池异常"));
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    metaData.getColumnType(i);
                    String columnName = metaData.getColumnName(i);
                    resultSet.getString(i);
                    System.out.println("column:" + columnName + " value:" + resultSet.getString(i));
                }

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
}

