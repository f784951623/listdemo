package listDemo.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class test {
	
	@Test
	public void testSQL() throws Exception{
		//1.註冊驅動
				Class.forName("com.mysql.jdbc.Driver");
				//2.獲取數據庫連接對象
				Connection conn=
						DriverManager.getConnection("jdbc:mysql://localhost:3306/listdemo?serverTimezone=UTC", "root", "a123456");
				//3.創建sql執行對象
				Statement stat = conn.createStatement();
				//4.執行SQL 
				//執行DDL使用excute(),數據庫創建語言
				//執行DML使用executeUpdate(),資料更新語言
				//執行DQL使用executeQuery(),資料查找語言
				String sql ="insert into item values(null,'nike','褲子');";
				stat.executeUpdate(sql);
				System.out.println("語法通順");
				stat.close();
	}
}
