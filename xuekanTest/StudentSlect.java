package tit.bd.xuekanTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class StudentSlect {

    public static void main(String[] args) throws Exception {
        //1、注册驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2、连接数据库
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xuekan?serverTimezone=UTC&useSSL=false","root","123456");
        System.out.println("连接成功 "+con);

        //3、创建 PreparedStatement对象
        String sql = "select * from students";
        PreparedStatement ps = con.prepareStatement(sql);

        //4、给占位符赋值

        //5、执行 sql语句
        ResultSet rs = ps.executeQuery();

        //6、处理结果
        while(rs.next()) {
            int sno = rs.getInt(1);//获取数据中的第一个字段
            String name = rs.getString(2);
            int age = rs.getInt(3);
            String sex = rs.getString(4);
            String grade = rs.getString(5);
            String dept = rs.getString(6);
            System.out.println("学号 "+sno+"\t 姓名 "+name+"\t 年龄"+age+"\t 性别 "+sex+"\t 年级 "+grade+"\t  "+" 系部 "+dept);
        }

        //7、关闭连接
        con.close();
        ps.close();
        rs.close();
    }
}



