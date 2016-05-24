package helloannotation;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("helloannotation")
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperConfig {
	
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		
		// 指定sqlsessionfactory
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		// 扫描package中的mapper接口。
		mapperScannerConfigurer.setBasePackage("helloannotation");
		
		return mapperScannerConfigurer;
	}

}
