package tit.bd.xuekanTest;

import java.sql.*;
import java.util.Scanner;

public class JournalDelete {
    public static void main(String[] args) throws Exception {
        // 注册 JDBC 驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 建立数据库连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/xuekan?serverTimezone=UTC&useSSL=false",
                "root",
                "123456"
        );
        System.out.println("连接成功");

        // 接受用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要删除记录的 ISSN：");
        String issn = scanner.nextLine();

        // 执行 SQL 删除语句
        String sql = "DELETE FROM journals WHERE issn=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, issn);

        // 执行 SQL 删除语句
        int affectedRows = statement.executeUpdate();

        // 处理执行结果
        if (affectedRows == 1) {
            System.out.println("成功删除一条期刊记录！");
        } else {
            System.out.println("删除期刊记录失败！");
        }

        // 关闭数据库连接
        statement.close();
        connection.close();
    }
}
