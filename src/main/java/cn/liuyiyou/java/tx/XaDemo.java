package cn.liuyiyou.java.tx;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlXid;

import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.Statement;

/***
 * @author: liuyiyou
 * @date: 2018/1/11
 */
public class XaDemo {

    public static MysqlXADataSource getDataSource(String connStr, String user, String pwd) {

        try {

            MysqlXADataSource ds = new MysqlXADataSource();
            ds.setUrl(connStr);
            ds.setUser(user);
            ds.setPassword(pwd);

            return ds;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] arg) {
        String connStr1 = "jdbc:mysql://localhost:3306/test";
        String connStr2 = "jdbc:mysql://localhost:3306/test_2";

        try {
            //从不同数据库获取数据库数据源
            MysqlXADataSource ds1 = getDataSource(connStr1, "root", "123456");
            MysqlXADataSource ds2 = getDataSource(connStr2, "root", "123456");

            //数据库1获取连接
            XAConnection xaConnection1 = ds1.getXAConnection();


            XAResource xaResource1 = xaConnection1.getXAResource();

            Connection connection1 = xaConnection1.getConnection();
            Statement statement1 = connection1.createStatement();

            //数据库2获取连接
            XAConnection xaConnection2 = ds2.getXAConnection();
            XAResource xaResource2 = xaConnection2.getXAResource();


            Connection connection2 = xaConnection2.getConnection();
            Statement statement2 = connection2.createStatement();

            //
            //创建事务分支的xid
            // gtrid: 全局事务标识符(global transaction identifier)，最大不能超过64字节
            // bqual: 分支限定符(branch qualifier)，最大不能超过64字节
            // formatId:  而formatId的作用就是记录gtrid、bqual的格式，
            // 类似于memcached中flags字段的作用。XA规范中通过一个结构体约定了xid的组成部分，
            // 但是并没有规定data中存储的gtrid、bqual内容到底应该是什么格式。你可以选择使用数字，也可以选择使用字符串，到底选择什么由开发者自行决定，
            // 只要最终能保证data中的内容是全局唯一的即可。XA规范建议使用OSI CCR风格来组织xid的内容，此时formatId应该设置为0.
            Xid xid1 = new MysqlXid(new byte[]{0x01}, new byte[]{0x02}, 100);
            Xid xid2 = new MysqlXid(new byte[]{0x011}, new byte[]{0x012}, 100);

            try {
                //事务分支1关联分支事务sql语句
                xaResource1.start(xid1, XAResource.TMNOFLAGS);
                int update1Result = statement1.executeUpdate("update account_from set money=money - 50 where id=1");
                xaResource1.end(xid1, XAResource.TMSUCCESS);

                //事务分支2关联分支事务sql语句
                xaResource2.start(xid2, XAResource.TMNOFLAGS);
                int update2Result = statement2.executeUpdate("update account_to set money= money + 50 where id=1");
                xaResource2.end(xid2, XAResource.TMSUCCESS);

                // 两阶段提交协议第一阶段
                int ret1 = xaResource1.prepare(xid1);
                int ret2 = xaResource2.prepare(xid2);

                // 两阶段提交协议第二阶段
                if (XAResource.XA_OK == ret1 && XAResource.XA_OK == ret2) {
                    xaResource1.commit(xid1, false);
                    xaResource2.commit(xid2, false);

                    System.out.println("reslut1:" + update1Result + ", result2:" + update2Result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
