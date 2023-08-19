package tit.bd.xuekanTest;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

    /**
     * 修改 功能
     * @author Administrator
     *
     */
    public class StudentUptdate {
        public static void main(String[] args) throws Exception {
            //1、注册驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2、连接数据库
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xuekan?serverTimezone=UTC&useSSL=false","root","123456");
            System.out.println("连接成功 "+con);

            //3、创建 PreparedStatement对象
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你想修改学生的学号 ");
            int sno = sc.nextInt();
            System.out.println("请输入修改后的姓名");
            String name = sc.next();
            System.out.println("请输入修改后的年龄");
            int age = sc.nextInt();
            System.out.println("请输入修改后的年级");
            String grade = sc.next();
            System.out.println("请输入修改后的性别");
            String sex = sc.next();
            System.out.println("请输入修改后的系部");
            String dept = sc.next();

            String sql = "update students set name=?,age=?,grade=?,sex=?,dept=? where sno=?";
            PreparedStatement ps = con.prepareStatement(sql);

            //4、给占位符赋值
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3,grade);
            ps.setString(4, sex);
            ps.setString(5, dept);
            ps.setInt(6, sno);

            //5、执行 SQL语句
            int i = ps.executeUpdate();

            //6、处理结果
            if(i>0) {
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }

            //7、关闭连接
            con.close();
            ps.close();
        }

    }

