package in.das.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan("in.das.app.mapper")
public class DasJerseyAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(DasJerseyAppApplication.class, args);
	}
}
