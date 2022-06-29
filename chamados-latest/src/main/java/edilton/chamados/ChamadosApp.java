package edilton.chamados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ChamadosApp {

	public static void main(String[] args) {
		SpringApplication.run(ChamadosApp.class, args);
	}

}
