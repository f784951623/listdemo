package IDAO;

import java.sql.SQLException;
import java.util.List;

import bean.Item;

public interface IitemDAO {
	public List<Item> select(String input) throws SQLException, ClassNotFoundException;
	
	public List<Item> selectAll() throws ClassNotFoundException, SQLException;
}
