package cn.liuyiyou.java.jdbc;

import cn.liuyiyou.utils.DataSourceUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * @author: liuyiyou
 * @date: 2018/1/11
 */
public class DataSourceJdbc {


    public static void select(String sql) throws SQLException {
        Connection connection = DataSourceUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
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
            if (connection != null) {
                connection.close();
            }
        }


    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        select("select * from user");

    }
}
