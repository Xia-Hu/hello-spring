package hello;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 *  此类用来扫描package下所有的mapper接口
 * @author huxia205906
 *
 */
@Configuration
@MapperScan("hello")
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScanConfig {

	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		
		// 指定sqlsessionfactory，和注入的xml
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		// 扫描mapper中的接口
		mapperScannerConfigurer.setBasePackage("hello");
		
		return mapperScannerConfigurer;
	}
}
