package jcw.camo_server;

import jcw.camo_server.config.FileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(
		{FileProperties.class}
)
@SpringBootApplication
public class CamoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamoServerApplication.class, args);
	}

}
