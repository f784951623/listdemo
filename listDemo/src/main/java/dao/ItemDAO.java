package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import IDAO.IitemDAO;
import bean.Item;

public class ItemDAO implements IitemDAO{

	//查詢全部資料
	public List<Item> selectAll() throws ClassNotFoundException, SQLException {
		List<Item> list=
				new ArrayList<Item>();
		Item item = null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		//1.註冊驅動
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			conn=
				DriverManager.getConnection("jdbc:mysql://localhost:3306/listdemo?serverTimezone=UTC", "root", "a123456");
			//3.創建sql執行對象
			String sql = "select type,name from item ;"; 
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				item = new Item();
				item.setType(rs.getString("type"));
				item.setName(rs.getString("name"));
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
			ps.close();
			rs.close();
		}
		return list;
	}
	
	//此方法為透過sql查詢後顯示給前端
	public List<Item> select(String input) throws SQLException, ClassNotFoundException {
		List<Item> list=
				new ArrayList<Item>();
		Item item = null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		
		//1.註冊驅動
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
		//2.獲取數據庫連接對象
			conn=
				DriverManager.getConnection("jdbc:mysql://localhost:3306/listdemo?serverTimezone=UTC", "root", "a123456");
		//3.創建sql執行對象
		String sql = "select type,name from item where type=?"; 
		ps=conn.prepareStatement(sql);
		ps.setString(1, input);
		rs=ps.executeQuery();
		
		while(rs.next()) {
			item = new Item();
			item.setType(rs.getString("type"));
			item.setName(rs.getString("name"));
			list.add(item);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			conn.close();
			ps.close();
			rs.close();
		}
		return list;
	}
}
