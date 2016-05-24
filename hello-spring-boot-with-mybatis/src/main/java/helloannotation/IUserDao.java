package helloannotation;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;


public interface IUserDao {

	@SelectProvider(method = "select", type = Sql.class)
	public User getUserByName(@Param("name") String name);
	
	@SelectProvider(method = "selectAll", type=Sql.class)
	public List<User> getAll();
	
	/**
	 *  这是实现sql语句的类
	 *  写成单独的类，可以便于复用和扩展
	 * @author huxia205906
	 */
	class Sql {
		
		private static final String TABLE = "user";
		
		public static String select(Map<String, Object> params) {
			SQL sql = new SQL();
			sql.SELECT("*").FROM(TABLE);
			sql.WHERE("name = #{name}");
			return sql.toString();
		}
		
		public static String selectAll() {
			SQL sql = new SQL();
			sql.SELECT("*").FROM(TABLE);
			return sql.toString();
		}
		
	}
	
}
