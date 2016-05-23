package hello;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class MyBatisConfig {

	/**
	 *  定义数据源
	 *   选用druid数据库连接池
	 * @return
	 * @throws IOException 
	 */
	@Bean(initMethod="init", destroyMethod="close")
	public DataSource dataSource() throws IOException {
		DruidDataSource druidDataSource = new DruidDataSource();
		
		Resource resource = new ClassPathResource("application.properties");
		Properties props = PropertiesLoaderUtils.loadProperties(resource);
		
		// 配置druiddatasource
		druidDataSource.setDriverClassName(props.getProperty("datasource.driver"));
		druidDataSource.setUrl(props.getProperty("datasource.url"));
		druidDataSource.setUsername(props.getProperty("datasource.username"));
		druidDataSource.setPassword(props.getProperty("datasource.password"));
		
		return druidDataSource;
	}
	
	
	// 扫描resources下的mybatis目录，并创建sessionFactory
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
}
