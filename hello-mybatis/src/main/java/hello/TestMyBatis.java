package hello;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TestMyBatis {

	static SqlSessionFactory sqlSessionFactory = null;
	static {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	public static void main(String[] args) {
		// 插入数据
		testAdd();
		// 获取表内容
		getUser();
		getAll();
	}
	
	public static void testAdd() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User("google", new Integer(21));
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	public static void getUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User sogou = userMapper.getUser("sogou");
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println(sogou.getName() + ":  " + sogou.getAge());
	}
	
	public static void getAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.getAll();
		sqlSession.commit();
		sqlSession.close();
		
		for(User u : users) {
			System.out.println(u.getName() + ":  " + u.getAge());
		}
	}
	
}
