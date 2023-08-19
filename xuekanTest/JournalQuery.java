package tit.bd.xuekanTest;

import java.sql.*;
import java.util.Scanner;

public class JournalQuery {
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
        System.out.print("请输入查询关键字：");
        String keyword = scanner.nextLine();

        // 执行 SQL 查询语句
        String sql = "SELECT * FROM journals WHERE name LIKE ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");
        ResultSet resultSet = statement.executeQuery();

        // 处理执行结果
        if (resultSet.next()) {
            resultSet.beforeFirst(); // 将光标移到第一条记录前面，以便下面的 while 循环能够获取到所有记录
            while (resultSet.next()) {
                String issn = resultSet.getString("issn");
                String name = resultSet.getString("name");
                String publisher = resultSet.getString("publisher");
                String indexTerm = resultSet.getString("index_term");
                String introduction = resultSet.getString("introduction");

                System.out.printf("ISSN: %s\n", issn);
                System.out.printf("名称: %s\n", name);
                System.out.printf("出版社: %s\n", publisher);
                System.out.printf("索引词条: %s\n", indexTerm);
                System.out.printf("简介: %s\n", introduction);
                System.out.println();
            }
        } else {
            System.out.println("没有找到相关期刊记录");
        }

        // 关闭数据库连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
