package com.esolutions.trainings;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
@EnableConfigurationProperties(LiquibaseProperties.class)
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server(@Value("${h2.port}") String port) throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", port);
	}
}
