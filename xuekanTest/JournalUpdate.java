package tit.bd.xuekanTest;

import java.sql.*;
import java.util.Scanner;

public class JournalUpdate {
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
        System.out.print("请输入需要修改记录的 ISSN：");
        String issn = scanner.nextLine();
        System.out.print("请输入期刊名称：");
        String name = scanner.nextLine();
        System.out.print("请输入出版社名称：");
        String publisher = scanner.nextLine();
        System.out.print("请输入索引词条：");
        String indexTerm = scanner.nextLine();
        System.out.print("请输入期刊简介：");
        String introduction = scanner.nextLine();

        // 执行 SQL 更新语句
        String sql = "UPDATE journals SET name=?, publisher=?, index_term=?, introduction=? WHERE issn=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, publisher);
        statement.setString(3, indexTerm);
        statement.setString(4, introduction);
        statement.setString(5, issn);

        // 执行 SQL 更新语句
        int affectedRows = statement.executeUpdate();

        // 处理执行结果
        if (affectedRows == 1) {
            System.out.println("成功更新一条期刊记录！");
        } else {
            System.out.println("更新期刊记录失败！");
        }

        // 关闭数据库连接
        statement.close();
        connection.close();
    }
}