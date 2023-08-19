package tit.bd.xuekanTest;

import java.sql.*;

public class PaperQuery {
    public static void main(String[] args) throws Exception {
        // 注册 JDBC 驱动 (可以省略此步骤)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 建立数据库连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/xuekan?serverTimezone=UTC&useSSL=false",
                "root",
                "123456"
        );
        System.out.println("连接成功");

        // 获取查询结果集
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM papers";
        ResultSet resultSet = statement.executeQuery(sql);

        // 在控制台输出查询结果表格
        System.out.printf("%10s | %30s | %20s | %20s | %20s | %20s | %20s\n",
                "ID", "Title", "Author", "Supervisor", "Keywords", "Abstract", "Reference");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String supervisor = resultSet.getString("supervisor");
            String keywords = resultSet.getString("keywords");
            String summary = resultSet.getString("abstract");
            String reference = resultSet.getString("reference");

            System.out.printf("%10d | %30s | %20s | %20s | %20s | %20s | %20s\n",
                    id, title, author, supervisor, keywords, summary, reference);
            System.out.println("----------------------------------------------------------------------------------------------------------------");
        }

        // 关闭数据库连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
