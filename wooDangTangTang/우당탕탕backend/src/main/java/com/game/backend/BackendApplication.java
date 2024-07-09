package com.game.backend;

import com.game.backend.user.users;
import com.game.backend.user.usersService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@ComponentScan(basePackages = {"com.game.backend"})
public class BackendApplication {
	@Autowired
	private  DataSource dataSource;
	@Autowired
	private usersService userService;



	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
//	//연결 테스트 코드
	@PostConstruct
	public void testDatabaseConnection() throws SQLException {
		System.out.println("여긴되긴하는거지2?");
		try (Connection connection = dataSource.getConnection()) {
			// 데이터베이스 연결이 성공적으로 이루어졌는지 확인
			if (connection != null) {
				System.out.println("성공했음----------------Database connection established successfully.");
			} else {
				System.out.println("실패했음----------------Failed to establish database connection.");
			}
		}
//		users user = new users("hi", "qwer", "my", "apple");
//		userService.save(user);
		System.out.println("User data saved successfully.");
	}
}
