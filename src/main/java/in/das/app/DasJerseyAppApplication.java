package in.das.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DasJerseyAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(DasJerseyAppApplication.class, args);
	}
}
